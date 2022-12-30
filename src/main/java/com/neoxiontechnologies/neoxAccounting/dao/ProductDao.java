package com.neoxiontechnologies.neoxAccounting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neoxiontechnologies.neoxAccounting.entities.InvoiceEntity;
import com.neoxiontechnologies.neoxAccounting.entities.ProductEntity;
@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Long> {

}
