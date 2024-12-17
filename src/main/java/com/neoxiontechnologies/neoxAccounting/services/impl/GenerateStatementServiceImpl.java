package com.neoxiontechnologies.neoxAccounting.services.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neoxiontechnologies.neoxAccounting.dao.BillDao;
import com.neoxiontechnologies.neoxAccounting.dao.InvoiceDao;
import com.neoxiontechnologies.neoxAccounting.dto.GenerateStatementRequestDTO;
import com.neoxiontechnologies.neoxAccounting.entities.BillEntity;
import com.neoxiontechnologies.neoxAccounting.entities.InvoiceEntity;
import com.neoxiontechnologies.neoxAccounting.services.GenerateStatementService;

@Service
public class GenerateStatementServiceImpl implements GenerateStatementService {
	public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
	@Autowired
	private BillDao billDao;
	@Autowired
	private InvoiceDao invoiceDao;

	public static void main(String args[]) {
		String format = simpleDateFormat.format(new Date());
		System.out.println(format);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void generateStatement(GenerateStatementRequestDTO generateStatementRequestDTO) throws IOException {
		List<InvoiceEntity> findDuringPeriod = invoiceDao.findDuringPeriod(generateStatementRequestDTO.getFromDate(),
				generateStatementRequestDTO.getToDate());
		String format = simpleDateFormat.format(new Date());
		String invoiceFolder = generateStatementRequestDTO.getLocationToPutStatement() + File.separatorChar
				+ "Invoices_" + format;
		Path fp = Paths.get(invoiceFolder);
		Files.createDirectories(fp.getParent());
		for (InvoiceEntity invoiceEntity : findDuringPeriod) {
			String internalLocationToProof = invoiceEntity.getInternalLocationToProof();
			File file = new File(internalLocationToProof);
			FileUtils.copyFileToDirectory(file, new File(invoiceFolder));
		}
		List<BillEntity> findDuringPeriod2 = billDao.findDuringPeriod(generateStatementRequestDTO.getFromDate(),
				generateStatementRequestDTO.getToDate());
		String billFolder = generateStatementRequestDTO.getLocationToPutStatement() + File.separatorChar + "Bills_"
				+ format;
		Path fpBills = Paths.get(billFolder);
		Files.createDirectories(fpBills.getParent());
		for (BillEntity billEntity : findDuringPeriod2) {
			String internalLocationToProof = billEntity.getInternalLocationToProof();
			File file = new File(internalLocationToProof);
			FileUtils.copyFileToDirectory(file, new File(billFolder));
		}
	}

}
