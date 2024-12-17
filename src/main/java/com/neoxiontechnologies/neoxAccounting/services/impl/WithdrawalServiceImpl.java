package com.neoxiontechnologies.neoxAccounting.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neoxiontechnologies.neoxAccounting.dao.WithdrawalDao;
import com.neoxiontechnologies.neoxAccounting.dto.WithdrawalDto;
import com.neoxiontechnologies.neoxAccounting.entities.WithdrawalEntity;
import com.neoxiontechnologies.neoxAccounting.services.WithdrawalService;
import com.neoxiontechnologies.neoxAccounting.utils.WithdrawalMappingUtility;

@Service
public class WithdrawalServiceImpl implements WithdrawalService {
	@Autowired
	private WithdrawalDao withdrawalDao;

	@Override
	public List<WithdrawalDto> getListOfWithdrawal() {
		List<WithdrawalEntity> findAll = withdrawalDao.findAll();
		return WithdrawalMappingUtility.convertListWithdrawalEntityToDto(findAll);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void createWithdrawal(WithdrawalDto withdrawalDto) {
		WithdrawalEntity withdrawalEntity = WithdrawalMappingUtility.convertWithdrawalDtoToEntity(withdrawalDto);
		withdrawalDao.save(withdrawalEntity);
	}

}
