package com.neoxiontechnologies.neoxAccounting.services.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neoxiontechnologies.neoxAccounting.dao.CurrencyDao;
import com.neoxiontechnologies.neoxAccounting.dao.CustomerDao;
import com.neoxiontechnologies.neoxAccounting.dao.InvoiceDao;
import com.neoxiontechnologies.neoxAccounting.dto.InvoiceDTO;
import com.neoxiontechnologies.neoxAccounting.entities.BillEntity;
import com.neoxiontechnologies.neoxAccounting.entities.InvoiceEntity;
import com.neoxiontechnologies.neoxAccounting.services.InvoiceService;
import com.neoxiontechnologies.neoxAccounting.utils.InvoiceMappingUtility;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	private Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);
	@Autowired
	private InvoiceDao invoiceDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private CurrencyDao currencyDao;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void createInvoice(InvoiceDTO invoiceDTO) {
		InvoiceEntity invoiceEntity = InvoiceMappingUtility.convertInvoiceDTOToEntity(invoiceDTO, customerDao,
				currencyDao);
		invoiceDao.save(invoiceEntity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<InvoiceDTO> listInvoices() {  
		List<InvoiceEntity> findAll = invoiceDao.findAll(Sort.by("dateOfInvoice").descending());
		return InvoiceMappingUtility.convertListOfInvoiceEntityToDto(findAll);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void deleteInvoice(Long id) throws IOException {
		InvoiceEntity invoiceEntity = invoiceDao.findById(id).get();
		String internalLocationToProof = invoiceEntity.getInternalLocationToProof();
		FileUtils.forceDelete(new File(internalLocationToProof));
		invoiceDao.deleteById(id);

	}

	@Override
	public Object downloadProof(String invoiceId) {
		InvoiceEntity billEntity = invoiceDao.findById(Long.valueOf(invoiceId)).get();
		return billEntity.getInternalLocationToProof();
	}

}
