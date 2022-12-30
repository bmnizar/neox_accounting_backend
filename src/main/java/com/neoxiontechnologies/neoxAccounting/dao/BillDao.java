package com.neoxiontechnologies.neoxAccounting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neoxiontechnologies.neoxAccounting.entities.BillEntity;

@Repository
public interface BillDao extends JpaRepository<BillEntity, Long> {

}
