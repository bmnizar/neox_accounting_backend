package com.neoxiontechnologies.neoxAccounting.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class WithdrawalEntity extends AbstractAuditingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "withdraw_entity_seq")
	@SequenceGenerator(name = "withdraw_entity_seq")
	private Long id;
	@Column(precision = 30, scale = 3)
	private BigDecimal amount;
	@Temporal(TemporalType.TIMESTAMP)
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
