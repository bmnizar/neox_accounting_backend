package com.neoxiontechnologies.neoxAccounting.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neoxiontechnologies.neoxAccounting.entities.CurrencyEntity;

public interface CurrencyDao extends JpaRepository<CurrencyEntity, Long> {

	Optional<CurrencyEntity> findByCode(String currencyCode);

}
