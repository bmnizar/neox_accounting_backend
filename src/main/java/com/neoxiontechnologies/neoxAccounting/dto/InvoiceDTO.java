package com.neoxiontechnologies.neoxAccounting.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.neoxiontechnologies.neoxAccounting.entities.CurrencyEntity;
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceDTO {
	private Long id;
	private CustomerDTO customerDTO;
	private List<InvoiceLineDTO> invoiceLInes;
	private String invoiceId;
	private Date dateOfInvoice;
	private byte[] proofBlob;
	private String proofBlobFileName;
	private String locationToProofUrl;
	private BigDecimal totalAmount;
	private String comment;
	private CurrencyDTO currencyDTO;
	private String internalLocationToProof;
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

 
 

	public CurrencyDTO getCurrencyDTO() {
		return currencyDTO;
	}

	public void setCurrencyDTO(CurrencyDTO currencyDTO) {
		this.currencyDTO = currencyDTO;
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

	public String getProofBlobFileName() {
		return proofBlobFileName;
	}

	public void setProofBlobFileName(String proofBlobFileName) {
		this.proofBlobFileName = proofBlobFileName;
	}

	public String getLocationToProofUrl() {
		return locationToProofUrl;
	}

	public void setLocationToProofUrl(String locationToProofUrl) {
		this.locationToProofUrl = locationToProofUrl;
	}

	public Date getDateOfInvoice() {
		return dateOfInvoice;
	}

	public void setDateOfInvoice(Date dateOfInvoice) {
		this.dateOfInvoice = dateOfInvoice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}

	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}

	public List<InvoiceLineDTO> getInvoiceLInes() {
		return invoiceLInes;
	}

	public void setInvoiceLInes(List<InvoiceLineDTO> invoiceLInes) {
		this.invoiceLInes = invoiceLInes;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

}
