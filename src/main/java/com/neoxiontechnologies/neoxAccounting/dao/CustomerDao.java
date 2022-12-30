package com.neoxiontechnologies.neoxAccounting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neoxiontechnologies.neoxAccounting.entities.CustomerEntity;
import com.neoxiontechnologies.neoxAccounting.entities.InvoiceEntity;

@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity, Long> {

}
