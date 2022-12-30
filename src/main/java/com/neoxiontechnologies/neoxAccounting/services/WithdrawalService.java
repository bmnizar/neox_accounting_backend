package com.neoxiontechnologies.neoxAccounting.services;

import java.util.List;

import com.neoxiontechnologies.neoxAccounting.dto.WithdrawalDto;

public interface WithdrawalService {

	List<WithdrawalDto> getListOfWithdrawal();

	void createWithdrawal(WithdrawalDto withdrawalDto);

}
