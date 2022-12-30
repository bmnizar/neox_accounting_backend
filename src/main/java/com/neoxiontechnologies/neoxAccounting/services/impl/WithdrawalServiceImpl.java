package com.neoxiontechnologies.neoxAccounting.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoxiontechnologies.neoxAccounting.dao.WithdrawalDao;
import com.neoxiontechnologies.neoxAccounting.dto.WithdrawalDto;
import com.neoxiontechnologies.neoxAccounting.services.WithdrawalService;

@Service
public class WithdrawalServiceImpl implements WithdrawalService {
	@Autowired
	private WithdrawalDao withdrawalDao;

	@Override
	public List<WithdrawalDto> getListOfWithdrawal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createWithdrawal(WithdrawalDto withdrawalDto) {
		// TODO Auto-generated method stub

	}

}
