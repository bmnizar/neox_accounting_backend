package com.neoxiontechnologies.neoxAccounting.utils;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import com.neoxiontechnologies.neoxAccounting.dto.CurrencyDTO;
import com.neoxiontechnologies.neoxAccounting.entities.CurrencyEntity;

public class CurrencyMappingUtility {

	public static List<CurrencyDTO> convertListCurrencyEntityToDto(List<CurrencyEntity> findAll) {
		List<CurrencyDTO> ret =new ArrayList<>();
		for (CurrencyEntity currency : findAll) {
			CurrencyDTO currencyDTO=new CurrencyDTO();
			currencyDTO.setCode(currency.getCode());
			currencyDTO.setName(currency.getName());
			ret.add(currencyDTO);
		}
		return ret;
	}

	public static CurrencyDTO convertCurrencyEntityToDto(CurrencyEntity currencyEntity) {
		CurrencyDTO currencyDTO =new CurrencyDTO();
		currencyDTO.setCode(currencyEntity.getCode());
		currencyEntity.setName(currencyEntity.getName());
		return currencyDTO;
	}

}
