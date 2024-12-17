package com.neoxiontechnologies.neoxAccounting.dto;

import java.math.BigDecimal;
import java.util.Date;

public class WithdrawalDto {
	private Long id;
	private BigDecimal amount;
	private Date date;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
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
