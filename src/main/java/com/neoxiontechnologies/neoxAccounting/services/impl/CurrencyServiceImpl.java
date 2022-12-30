package com.neoxiontechnologies.neoxAccounting.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoxiontechnologies.neoxAccounting.dao.CurrencyDao;
import com.neoxiontechnologies.neoxAccounting.dto.CurrencyDTO;
import com.neoxiontechnologies.neoxAccounting.entities.CurrencyEntity;
import com.neoxiontechnologies.neoxAccounting.services.CurrencyService;
import com.neoxiontechnologies.neoxAccounting.utils.CurrencyMappingUtility;

@Service
public class CurrencyServiceImpl implements CurrencyService {
	@Autowired
	private CurrencyDao currencyDao;

	@Override
	public List<CurrencyDTO> listAllCurrencies() {
		List<CurrencyEntity> findAll = currencyDao.findAll();
		return CurrencyMappingUtility.convertListCurrencyEntityToDto(findAll);
	}

}
