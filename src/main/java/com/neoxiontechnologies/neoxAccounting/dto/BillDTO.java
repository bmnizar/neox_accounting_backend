package com.neoxiontechnologies.neoxAccounting.dto;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.neoxiontechnologies.neoxAccounting.entities.CurrencyEntity;
import com.neoxiontechnologies.neoxAccounting.entities.CustomerEntity;
import com.neoxiontechnologies.neoxAccounting.entities.ModeOfPayment;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BillDTO {
	private Long id;
	private Date dateOfBill;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private CurrencyDTO currencyDTO;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private CustomerDTO customerDTO;
	private String internalLocationToProof;
	private File documentToUpload;
	private String comment;
	private BigDecimal amount;
	private String modeOfPayment;
	private byte[] proofBlob;
	private String proofBlobFileName;
	private String locationToProofUrl;
	private BigDecimal vatAmount;
	private String billId;
	
	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public BigDecimal getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(BigDecimal vatAmount) {
		this.vatAmount = vatAmount;
	}

	public String getLocationToProofUrl() {
		return locationToProofUrl;
	}

	public void setLocationToProofUrl(String locationToProofUrl) {
		this.locationToProofUrl = locationToProofUrl;
	}

	public byte[] getProofBlob() {
		return proofBlob;
	}

	public void setProofBlob(byte[] proofBlob) {
		this.proofBlob = proofBlob;
	}

	public String getProofBlobFileName() {
		return proofBlobFileName;
	}

	public void setProofBlobFileName(String proofBlobFileName) {
		this.proofBlobFileName = proofBlobFileName;
	}

	public File getDocumentToUpload() {
		return documentToUpload;
	}

	public void setDocumentToUpload(File documentToUpload) {
		this.documentToUpload = documentToUpload;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public CurrencyDTO getCurrencyDTO() {
		return currencyDTO;
	}

	public void setCurrencyDTO(CurrencyDTO currencyDTO) {
		this.currencyDTO = currencyDTO;
	}

	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}

	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}
 
	public String getInternalLocationToProof() {
		return internalLocationToProof;
	}

	public void setInternalLocationToProof(String internalLocationToProof) {
		this.internalLocationToProof = internalLocationToProof;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateOfBill() {
		return dateOfBill;
	}

	public void setDateOfBill(Date dateOfBill) {
		this.dateOfBill = dateOfBill;
	}

}
