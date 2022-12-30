package com.neoxiontechnologies.neoxAccounting.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class CurrencyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currency_entity_seq")
	@SequenceGenerator(name = "currency_entity_seq")
	private Long id;
	private String name;
	private String code;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
