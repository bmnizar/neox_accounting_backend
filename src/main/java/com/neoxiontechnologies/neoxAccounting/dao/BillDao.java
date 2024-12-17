package com.neoxiontechnologies.neoxAccounting.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neoxiontechnologies.neoxAccounting.entities.BillEntity;

@Repository
public interface BillDao extends JpaRepository<BillEntity, Long> {
	@Query("Select c from BillEntity c where c.dateOfBill >?1 and  c.dateOfBill <?2  ")
	List<BillEntity> findDuringPeriod(Date fromDate, Date toDate);
	@Query("Select c from BillEntity c where c.amount=?1")
	List<BillEntity> findByAmount(BigDecimal amount);

}
