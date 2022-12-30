package com.neoxiontechnologies.neoxAccounting.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neoxiontechnologies.neoxAccounting.dao.CustomerDao;
import com.neoxiontechnologies.neoxAccounting.dto.CustomerDTO;
import com.neoxiontechnologies.neoxAccounting.dto.InvoiceDTO;
import com.neoxiontechnologies.neoxAccounting.entities.CustomerEntity;
import com.neoxiontechnologies.neoxAccounting.services.CustomerService;
import com.neoxiontechnologies.neoxAccounting.utils.CustomerMappingUtility;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void createCustomer(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = CustomerMappingUtility.convertCustomerDTOToEntity(customerDTO);
		customerDao.save(customerEntity);
	}

	@Override
	public List<CustomerDTO> listCustomers() {
		List<CustomerEntity> findAll = customerDao.findAll();
		return CustomerMappingUtility.convertListCustomerEntitiesToDTO(findAll);

	}

}
