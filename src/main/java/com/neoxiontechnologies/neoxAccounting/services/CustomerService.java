package com.neoxiontechnologies.neoxAccounting.services;

import java.util.List;

import com.neoxiontechnologies.neoxAccounting.dto.CustomerDTO;
import com.neoxiontechnologies.neoxAccounting.dto.InvoiceDTO;

public interface CustomerService {

	void createCustomer(CustomerDTO invoiceDTO);

	List<CustomerDTO> listCustomers();

}
