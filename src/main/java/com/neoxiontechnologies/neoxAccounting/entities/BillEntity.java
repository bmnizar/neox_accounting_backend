package com.neoxiontechnologies.neoxAccounting.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class BillEntity extends AbstractAuditingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_entity_seq")
	@SequenceGenerator(name = "bill_entity_seq")
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfBill;
	@ManyToOne(fetch = FetchType.LAZY)
	private CurrencyEntity currencyEntity;
	@ManyToOne(fetch = FetchType.LAZY)
	private CustomerEntity customerEntity;
	private String internalLocationToProof;
	@Lob
	private byte[] proofBlob;
	private String proofBlobFileName;
	private String comment;
	@Enumerated(EnumType.STRING)
	private ModeOfPayment modeOfPayment;
	private BigDecimal amount;
	private String locationToProofUrl;
	
	public String getLocationToProofUrl() {
		return locationToProofUrl;
	}

	public void setLocationToProofUrl(String locationToProofUrl) {
		this.locationToProofUrl = locationToProofUrl;
	}
	public String getProofBlobFileName() {
		return proofBlobFileName;
	}

	public void setProofBlobFileName(String proofBlobFileName) {
		this.proofBlobFileName = proofBlobFileName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public ModeOfPayment getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(ModeOfPayment modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public CurrencyEntity getCurrencyEntity() {
		return currencyEntity;
	}

	public void setCurrencyEntity(CurrencyEntity currencyEntity) {
		this.currencyEntity = currencyEntity;
	}

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	 

	public String getInternalLocationToProof() {
		return internalLocationToProof;
	}

	public void setInternalLocationToProof(String internalLocationToProof) {
		this.internalLocationToProof = internalLocationToProof;
	}

	public byte[] getProofBlob() {
		return proofBlob;
	}

	public void setProofBlob(byte[] proofBlob) {
		this.proofBlob = proofBlob;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDateOfBill() {
		return dateOfBill;
	}

	public void setDateOfBill(Date dateOfBill) {
		this.dateOfBill = dateOfBill;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
