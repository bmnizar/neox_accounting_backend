package com.neoxiontechnologies.neoxAccounting.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class CustomerEntity extends AbstractAuditingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_entity_seq")
	@SequenceGenerator(name = "customer_entity_seq")
	private Long id;
	private String name;
	private String address;
	private String vat;
	private String email;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVat() {
		return vat;
	}
	public void setVat(String vat) {
		this.vat = vat;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	 
}
