package com.neoxiontechnologies.neoxAccounting.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neoxiontechnologies.neoxAccounting.dto.WithdrawalDto;
import com.neoxiontechnologies.neoxAccounting.services.WithdrawalService;

public class WithdrawalRest {
	@Autowired
	private WithdrawalService withdrawalService;

	@PostMapping(value = "/createWithdrawal") //
	@ResponseBody
	public void createWithdrawal(@RequestBody WithdrawalDto withdrawalDto) {

		withdrawalService.createWithdrawal(withdrawalDto);

	}

	@GetMapping(value = "/getListOfWithdrawal") //
	@ResponseBody
	public List<WithdrawalDto> getListOfWithdrawal() {

		return withdrawalService.getListOfWithdrawal();

	}
}
