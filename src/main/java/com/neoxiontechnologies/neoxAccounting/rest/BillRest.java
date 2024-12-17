package com.neoxiontechnologies.neoxAccounting.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neoxiontechnologies.neoxAccounting.dto.BillDTO;
import com.neoxiontechnologies.neoxAccounting.services.BillService;
import com.neoxiontechnologies.neoxAccounting.services.impl.BillServiceImpl;
import com.neoxiontechnologies.neoxAccounting.utils.NeoxAccountingUtils;

@Controller
@RequestMapping(NeoxAccountingUtils.GENERAL_REST_URL + "/BillRest")
public class BillRest {
	public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

	private static final String BILLS = "Bills";
	@Autowired
	private BillService billService;
	static ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private Environment env;

	public static void main(String args[]) throws ParseException {
		Date parse = simpleDateFormat.parse("2023-01-03");
		System.out.println(parse);
	}

	@RequestMapping(value = "/downloadProof/{billId}", method = RequestMethod.POST)
	public void downloadProof(@PathVariable String billId, HttpServletResponse response) throws IOException {
		Object downloadProof = billService.downloadProof(billId);
		FileInputStream fileInputStream = new FileInputStream(new File(downloadProof.toString()));
		String extention = downloadProof.toString().substring(downloadProof.toString().length() - 3);
		switch (extention) {
		case "pdf":
			response.setContentType(MediaType.APPLICATION_PDF_VALUE);
			break;
		default:
			response.setContentType(MediaType.IMAGE_JPEG_VALUE);
			break;
		}
		IOUtils.copy(fileInputStream, response.getOutputStream());

	}

	@PostMapping(value = "/createBill") //
	@ResponseBody
	public ResponseEntity<String> createBill(@RequestParam(value = "data", required = false) String billDTOString,
			@RequestParam("fileToUpload") MultipartFile fileToUpload) throws IOException {
		String filesystemRoot = env.getProperty("filesystemRoot");
		BillDTO billDTO = mapper.readValue(billDTOString, BillDTO.class);
		String fileNameString = fileToUpload.getOriginalFilename();
		byte[] bytes = fileToUpload.getBytes();
		Calendar instance = Calendar.getInstance();
		instance.setTime(billDTO.getDateOfBill());
		int month = instance.get(Calendar.MONTH) + 1;
		String yearMonth = instance.get(Calendar.YEAR) + "-" + month;
		String fileFullPath1 = filesystemRoot + File.separatorChar + BILLS + File.separatorChar + yearMonth;

		String fileFullPath2 = fileFullPath1 + File.separatorChar + fileNameString;
		File file = new File(fileFullPath2);
		Path fp = Paths.get(fileFullPath2);
		Files.createDirectories(fp.getParent());
		if (file.exists()) {
			//return new ResponseEntity<String>("File already exists", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			Files.createFile(fp);
 
			Files.write(fp, bytes, StandardOpenOption.APPEND);
		}

		billDTO.setProofBlob(bytes);
		billDTO.setProofBlobFileName(fileNameString);
		billDTO.setInternalLocationToProof(fileFullPath2);
		String ipAddress = env.getProperty("ipAddress");
		String port = env.getProperty("server.port");
		String locationToProofUrl = ipAddress + ":" + port + "/" + NeoxAccountingUtils.FILE_STORE_REST_NAME + "/"
				+ BILLS + File.separatorChar + yearMonth + File.separatorChar + fileNameString;
		billDTO.setLocationToProofUrl(locationToProofUrl);
		String createBill = billService.createBill(billDTO);
		if (createBill.equals(BillServiceImpl.LIST_EXISTING_SAME_BILL_ENTITYIES_WITH_SAME_AMOUNT)) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws IOException {
		billService.deleteBill(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/listAllBillsByCriteria") //
	@ResponseBody
	public List<BillDTO> listAllBillsByCriteria(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) throws ParseException {
		return billService.listAllBills(simpleDateFormat.parse(fromDate), simpleDateFormat.parse(toDate));
	}

	@GetMapping(value = "/listAllBills") //
	@ResponseBody
	public List<BillDTO> listAllBills() {

		return billService.listAllBills();

	}
}
