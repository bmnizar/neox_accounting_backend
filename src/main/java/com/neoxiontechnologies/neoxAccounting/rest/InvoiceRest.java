package com.neoxiontechnologies.neoxAccounting.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neoxiontechnologies.neoxAccounting.dto.BillDTO;
import com.neoxiontechnologies.neoxAccounting.dto.InvoiceDTO;
import com.neoxiontechnologies.neoxAccounting.services.InvoiceService;
import com.neoxiontechnologies.neoxAccounting.utils.NeoxAccountingUtils;

@Controller
@RequestMapping(NeoxAccountingUtils.GENERAL_REST_URL + "/InvoiceRest")
public class InvoiceRest {
	@Autowired
	private InvoiceService invoiceService;
	static ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private Environment env;

	@RequestMapping(value = "/downloadProof/{invoiceId}", method = RequestMethod.POST)
	public void downloadProof(@PathVariable String invoiceId, HttpServletResponse response) throws IOException {
		Object downloadProof = invoiceService.downloadProof(invoiceId);
		FileInputStream fileInputStream = new FileInputStream(new File(downloadProof.toString()));
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		IOUtils.copy(fileInputStream, response.getOutputStream());

	}

	@PostMapping(value = "/createInvoice") //
	@ResponseBody
	public ResponseEntity<String> createInvoice(@RequestParam(value = "data", required = false) String invoiceDTOString,
			@RequestParam("fileToUpload") MultipartFile fileToUpload) throws IOException {
		String filesystemRoot = env.getProperty("filesystemRoot");
		InvoiceDTO invoiceDTO = mapper.readValue(invoiceDTOString, InvoiceDTO.class);
		String fileNameString = fileToUpload.getOriginalFilename();
		byte[] bytes = fileToUpload.getBytes();
		Calendar instance = Calendar.getInstance();
		int month = instance.get(Calendar.MONTH) + 1;
		String yearMonth = instance.get(Calendar.YEAR) + "-" + month;
		String fileFullPath1 = filesystemRoot + File.separatorChar + "Invoices" + File.separatorChar + yearMonth;

		String fileFullPath2 = fileFullPath1 + File.separatorChar + fileNameString;
		File file = new File(fileFullPath2);
		Path fp = Paths.get(fileFullPath2);
		if (file.exists()) {
			return new ResponseEntity<String>("File already exists", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		Files.createDirectories(fp.getParent());
		Files.createFile(fp);

		Files.write(fp, bytes, StandardOpenOption.APPEND);
		invoiceDTO.setProofBlob(bytes);
		invoiceDTO.setProofBlobFileName(fileNameString);
		invoiceDTO.setInternalLocationToProof(fileFullPath2);
		String ipAddress = env.getProperty("ipAddress");
		String port = env.getProperty("server.port");
		String locationToProofUrl = ipAddress + ":" + port + "/" + NeoxAccountingUtils.FILE_STORE_REST_NAME + "/"
				+ "Invoices" + File.separatorChar + yearMonth + File.separatorChar + fileNameString;
		invoiceDTO.setLocationToProofUrl(locationToProofUrl); 

		invoiceService.createInvoice(invoiceDTO);
		return new ResponseEntity<String>(HttpStatus.OK);

	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws IOException {
		invoiceService.deleteInvoice(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/listInvoices") //
	@ResponseBody
	public List<InvoiceDTO> listInvoices() {

		return invoiceService.listInvoices();

	}

}
