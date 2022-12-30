package com.neoxiontechnologies.neoxAccounting.dto;

import java.math.BigDecimal;

public class WithdrawalDto {
	private Long id;
	private BigDecimal amount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}
