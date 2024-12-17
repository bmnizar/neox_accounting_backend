package com.neoxiontechnologies.neoxAccounting.utils;

import java.util.ArrayList;
import java.util.List;

import com.neoxiontechnologies.neoxAccounting.dto.WithdrawalDto;
import com.neoxiontechnologies.neoxAccounting.entities.WithdrawalEntity;

public class WithdrawalMappingUtility {

	public static WithdrawalEntity convertWithdrawalDtoToEntity(WithdrawalDto withdrawalDto) {
		WithdrawalEntity withdrawalEntity = new WithdrawalEntity();
		withdrawalEntity.setAmount(withdrawalDto.getAmount());
		withdrawalEntity.setDate(withdrawalDto.getDate());
		return withdrawalEntity;
	}

	public static WithdrawalDto convertWithdrawalEntityToDto(WithdrawalEntity withdrawalEntity) {
		WithdrawalDto withdrawalDto = new WithdrawalDto();
		withdrawalDto.setAmount(withdrawalEntity.getAmount());
		withdrawalDto.setDate(withdrawalEntity.getDate());
		return withdrawalDto;
	}

	public static List<WithdrawalDto> convertListWithdrawalEntityToDto(List<WithdrawalEntity> findAll) {
		List<WithdrawalDto> ret = new ArrayList();
		for (WithdrawalEntity withdrawalDto : findAll) {
			ret.add(convertWithdrawalEntityToDto(withdrawalDto));
		}
		return ret;
	}

}
