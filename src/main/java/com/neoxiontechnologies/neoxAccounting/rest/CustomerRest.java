package com.neoxiontechnologies.neoxAccounting.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neoxiontechnologies.neoxAccounting.dto.CustomerDTO;
import com.neoxiontechnologies.neoxAccounting.services.CustomerService;
import com.neoxiontechnologies.neoxAccounting.utils.NeoxAccountingUtils;

@Controller
@RequestMapping(NeoxAccountingUtils.GENERAL_REST_URL + "/CustomerRest")
public class CustomerRest {
	@Autowired
	private CustomerService customerService;

	@PostMapping(value = "/createCustomer") //
	@ResponseBody
	public void createCustomer(@RequestBody CustomerDTO invoiceDTO) {

		customerService.createCustomer(invoiceDTO);

	}

	@GetMapping(value = "/listCustomers") //
	@ResponseBody
	public List<CustomerDTO> listCustomers() {

		return customerService.listCustomers();

	}

}