package com.neoxiontechnologies.neoxAccounting.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neoxiontechnologies.neoxAccounting.entities.InvoiceEntity;

@Repository
public interface InvoiceDao extends JpaRepository<InvoiceEntity, Long> {
	@Query("Select c from InvoiceEntity c where c.dateOfInvoice >?1 and  c.dateOfInvoice <?2  ")

	List<InvoiceEntity> findDuringPeriod(Date fromDate, Date toDate);

}
