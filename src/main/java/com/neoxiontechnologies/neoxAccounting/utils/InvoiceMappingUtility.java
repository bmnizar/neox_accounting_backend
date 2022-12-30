package com.neoxiontechnologies.neoxAccounting.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.neoxiontechnologies.neoxAccounting.dao.CurrencyDao;
import com.neoxiontechnologies.neoxAccounting.dao.CustomerDao;
import com.neoxiontechnologies.neoxAccounting.dto.CurrencyDTO;
import com.neoxiontechnologies.neoxAccounting.dto.CustomerDTO;
import com.neoxiontechnologies.neoxAccounting.dto.InvoiceDTO;
import com.neoxiontechnologies.neoxAccounting.dto.InvoiceLineDTO;
import com.neoxiontechnologies.neoxAccounting.entities.CurrencyEntity;
import com.neoxiontechnologies.neoxAccounting.entities.CustomerEntity;
import com.neoxiontechnologies.neoxAccounting.entities.InvoiceEntity;
import com.neoxiontechnologies.neoxAccounting.entities.InvoiceLineEntity;

public class InvoiceMappingUtility {

	public static InvoiceEntity convertInvoiceDTOToEntity(InvoiceDTO invoiceDTO, CustomerDao customerDao,
			CurrencyDao currencyDao) {
		InvoiceEntity invoiceEntity = new InvoiceEntity();
		invoiceEntity.setDateOfInvoice(invoiceDTO.getDateOfInvoice());
		invoiceEntity.setComment(invoiceDTO.getComment());
		CurrencyDTO currencyDTO = invoiceDTO.getCurrencyDTO();
		String currencyCode = currencyDTO.getCode();
		Optional<CurrencyEntity> findById = currencyDao.findByCode(currencyCode);
		invoiceEntity.setCurrency(findById.get()); 
		invoiceEntity.setTotalAmount(invoiceDTO.getTotalAmount());
		invoiceEntity.setInvoiceId(invoiceDTO.getInvoiceId());
		invoiceEntity.setInternalLocationToProof(invoiceDTO.getInternalLocationToProof());
		invoiceEntity.setProofBlob(invoiceDTO.getProofBlob());
		invoiceEntity.setProofBlobFileName(invoiceDTO.getProofBlobFileName());
		invoiceEntity.setLocationToProofUrl(invoiceDTO.getLocationToProofUrl());
		CustomerDTO customerDTO = invoiceDTO.getCustomerDTO();
		Long customerId = customerDTO.getId();
		CustomerEntity customerEntity = customerDao.findById(customerId).get();
		invoiceEntity.setCustomerEntity(customerEntity);

		invoiceEntity.setInvoiceLInes(convertListOfInvoiceLinesDTOToEntity(invoiceDTO.getInvoiceLInes()));
		return invoiceEntity;
	}

	public static List<InvoiceLineEntity> convertListOfInvoiceLinesDTOToEntity(List<InvoiceLineDTO> invoiceLInes) {
		List<InvoiceLineEntity> ret = new ArrayList<>();
		if (invoiceLInes == null) {
			return null;
		}
		for (InvoiceLineDTO invoiceLineDTO : invoiceLInes) {
			InvoiceLineEntity invoiceLineEntity = convertInvoiceLineDTOToEntity(invoiceLineDTO);
			ret.add(invoiceLineEntity);
		}
		return ret;
	}

	private static InvoiceLineEntity convertInvoiceLineDTOToEntity(InvoiceLineDTO invoiceLineDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<InvoiceDTO> convertListOfInvoiceEntityToDto(List<InvoiceEntity> findAll) {
		List<InvoiceDTO> ret = new ArrayList<>();
		for (InvoiceEntity invoiceEntity : findAll) {
			ret.add(convertInvoiceEntityToDto(invoiceEntity));
		}
		return ret;
	}

	public static InvoiceDTO convertInvoiceEntityToDto(InvoiceEntity invoiceEntity) {
		InvoiceDTO invoiceDTO = new InvoiceDTO();
		invoiceDTO.setId(invoiceEntity.getId());  
		invoiceDTO.setComment(invoiceEntity.getComment());
		invoiceDTO.setDateOfInvoice(invoiceEntity.getDateOfInvoice());
		invoiceDTO.setInternalLocationToProof(invoiceEntity.getInternalLocationToProof());
		invoiceDTO.setInvoiceId(invoiceEntity.getInvoiceId());
		invoiceDTO.setLocationToProofUrl(invoiceEntity.getLocationToProofUrl());
		invoiceDTO.setProofBlob(invoiceEntity.getProofBlob());  
		invoiceDTO.setProofBlobFileName(invoiceEntity.getProofBlobFileName());
		invoiceDTO.setLocationToProofUrl(invoiceEntity.getLocationToProofUrl());
		invoiceDTO.setTotalAmount(invoiceEntity.getTotalAmount());
		invoiceDTO.setCurrencyDTO(CurrencyMappingUtility.convertCurrencyEntityToDto(invoiceEntity.getCurrency()));
		invoiceDTO.setCustomerDTO(CustomerMappingUtility.convertCustomerEntityToDTO(invoiceEntity.getCustomerEntity()));
		return invoiceDTO;
	}

}
