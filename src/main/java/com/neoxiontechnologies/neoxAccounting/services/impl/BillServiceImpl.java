package com.neoxiontechnologies.neoxAccounting.services.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neoxiontechnologies.neoxAccounting.dao.BillDao;
import com.neoxiontechnologies.neoxAccounting.dao.CurrencyDao;
import com.neoxiontechnologies.neoxAccounting.dao.CustomerDao;
import com.neoxiontechnologies.neoxAccounting.dto.BillDTO;
import com.neoxiontechnologies.neoxAccounting.entities.BillEntity;
import com.neoxiontechnologies.neoxAccounting.services.BillService;
import com.neoxiontechnologies.neoxAccounting.utils.BillMappingUtility;

@Service
public class BillServiceImpl implements BillService {
	@Autowired
	private BillDao billDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private CurrencyDao currencyDao;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void createBill(BillDTO billDTO) {
		BillEntity billEntity = BillMappingUtility.convertBillDTOToEntities(billDTO, customerDao, currencyDao);
		billDao.save(billEntity);

	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<BillDTO> listAllBills() {
		List<BillEntity> findAll = billDao.findAll();
		return BillMappingUtility.convertListBillEntityToDto(findAll);
	}
	@Override
	public void deleteBill(Long id) throws IOException {
		String internalLocationToProof = billDao.findById(id).get().getInternalLocationToProof();
		FileUtils.forceDelete(new File(internalLocationToProof));
		billDao.deleteById(id);
		
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public String downloadProof(String billId) {
		BillEntity billEntity = billDao.findById(Long.valueOf(billId)).get();
		return billEntity.getInternalLocationToProof();
	}

}
