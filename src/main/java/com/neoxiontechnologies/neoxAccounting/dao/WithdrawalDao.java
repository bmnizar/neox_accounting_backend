package com.neoxiontechnologies.neoxAccounting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neoxiontechnologies.neoxAccounting.entities.CurrencyEntity;
import com.neoxiontechnologies.neoxAccounting.entities.WithdrawalEntity;
@Repository
public interface WithdrawalDao extends JpaRepository<WithdrawalEntity, Long> {

}
