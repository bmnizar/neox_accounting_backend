package com.neoxiontechnologies.neoxAccounting.utils;

import java.util.ArrayList;
import java.util.List;

import com.neoxiontechnologies.neoxAccounting.dto.CustomerDTO;
import com.neoxiontechnologies.neoxAccounting.entities.CustomerEntity;

public class CustomerMappingUtility {

	public static CustomerEntity convertCustomerDTOToEntity(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setName(customerDTO.getName());
		customerEntity.setVat(customerDTO.getVat());
		customerEntity.setAddress(customerDTO.getAddress());
		return customerEntity;
	}

	public static List<CustomerDTO> convertListCustomerEntitiesToDTO(List<CustomerEntity> findAll) {
		List<CustomerDTO> ret = new ArrayList<>();
		for (CustomerEntity customerEntity : findAll) {
			ret.add(CustomerMappingUtility.convertCustomerEntityToDTO(customerEntity));

		}
		return ret;
	}

	public static CustomerDTO convertCustomerEntityToDTO(CustomerEntity customerEntity) {
		CustomerDTO customerDTO =new CustomerDTO();
		customerDTO.setAddress(customerEntity.getAddress());
		customerDTO.setName(customerEntity.getName());
		customerDTO.setVat(customerEntity.getVat());   
		customerDTO.setId(customerEntity.getId());
		return customerDTO;
	}

}
