package com.neoxiontechnologies.neoxAccounting.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neoxiontechnologies.neoxAccounting.dto.BillDTO;
import com.neoxiontechnologies.neoxAccounting.dto.CurrencyDTO;
import com.neoxiontechnologies.neoxAccounting.services.BillService;
import com.neoxiontechnologies.neoxAccounting.services.CurrencyService;
import com.neoxiontechnologies.neoxAccounting.utils.NeoxAccountingUtils;
@Controller
@RequestMapping(NeoxAccountingUtils.GENERAL_REST_URL + "/CurrencyRest")
public class CurrencyRest {
	@Autowired
	private CurrencyService  currencyService;
	@GetMapping(value = "/listAllCurrencies") //
	@ResponseBody
	public List<CurrencyDTO> listAllCurrencies() {

		return currencyService.listAllCurrencies();

	}
}
