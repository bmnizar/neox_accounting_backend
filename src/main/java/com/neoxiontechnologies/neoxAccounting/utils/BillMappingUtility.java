package com.neoxiontechnologies.neoxAccounting.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.neoxiontechnologies.neoxAccounting.dao.CurrencyDao;
import com.neoxiontechnologies.neoxAccounting.dao.CustomerDao;
import com.neoxiontechnologies.neoxAccounting.dto.BillDTO;
import com.neoxiontechnologies.neoxAccounting.dto.CurrencyDTO;
import com.neoxiontechnologies.neoxAccounting.dto.CustomerDTO;
import com.neoxiontechnologies.neoxAccounting.entities.BillEntity;
import com.neoxiontechnologies.neoxAccounting.entities.CurrencyEntity;
import com.neoxiontechnologies.neoxAccounting.entities.CustomerEntity;
import com.neoxiontechnologies.neoxAccounting.entities.ModeOfPayment;

public class BillMappingUtility {

	public static BillEntity convertBillDTOToEntities(BillDTO billDTO, CustomerDao customerDao,
			CurrencyDao currencyDao) {
		BillEntity billEntity = new BillEntity();
		billEntity.setId(billDTO.getId());
		billEntity.setAmount(billDTO.getAmount());
		billEntity.setComment(billDTO.getComment());
		CustomerDTO customerDTO = billDTO.getCustomerDTO();
		Long customerId = customerDTO.getId();
		CustomerEntity customerEntity = customerDao.findById(customerId).get();
		billEntity.setCustomerEntity(customerEntity);
		CurrencyDTO currencyDTO = billDTO.getCurrencyDTO();
		String currencyCode = currencyDTO.getCode();
		Optional<CurrencyEntity> findById = currencyDao.findByCode(currencyCode);
		billEntity.setCurrencyEntity(findById.get());
		billEntity.setVatAmount(billDTO.getVatAmount());
		billEntity.setInternalLocationToProof(billDTO.getInternalLocationToProof());
		billEntity.setProofBlob(billDTO.getProofBlob());
		billEntity.setProofBlobFileName(billDTO.getProofBlobFileName());
		billEntity.setLocationToProofUrl(billDTO.getLocationToProofUrl());
		billEntity.setBillId(billDTO.getBillId());
		billEntity.setDateOfBill(billDTO.getDateOfBill());
		billEntity.setModeOfPayment(ModeOfPayment.valueOf(billDTO.getModeOfPayment()));
		return billEntity;
	}

	public static List<BillDTO> convertListBillEntityToDto(List<BillEntity> findAll) {
		List<BillDTO> ret = new ArrayList();
		for (BillEntity billEntity : findAll) {
			ret.add(convertBillEntityToDto(billEntity));
		}
		return ret;
	}

	public static BillDTO convertBillEntityToDto(BillEntity billEntity) {
		BillDTO billDTO = new BillDTO();
		billDTO.setComment(billEntity.getComment());
		billDTO.setId(billEntity.getId());
		billDTO.setBillId(billEntity.getBillId());
		billDTO.setVatAmount(billEntity.getVatAmount());
		billDTO.setCurrencyDTO(CurrencyMappingUtility.convertCurrencyEntityToDto(billEntity.getCurrencyEntity()));
		billDTO.setLocationToProofUrl(billEntity.getLocationToProofUrl());
		billDTO.setCustomerDTO(CustomerMappingUtility.convertCustomerEntityToDTO(billEntity.getCustomerEntity()));
		billDTO.setDateOfBill(billEntity.getDateOfBill());
		billDTO.setInternalLocationToProof(billEntity.getInternalLocationToProof());
		billDTO.setModeOfPayment(billEntity.getModeOfPayment().toString());
		billDTO.setAmount(billEntity.getAmount());
		billDTO.setProofBlob(billEntity.getProofBlob());
		billDTO.setProofBlobFileName(billEntity.getProofBlobFileName());
		return billDTO; 
	}

}
