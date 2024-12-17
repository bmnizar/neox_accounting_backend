package com.neoxiontechnologies.neoxAccounting.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class InvoiceEntity extends AbstractAuditingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_entity_seq")
	@SequenceGenerator(name = "invoice_entity_seq")
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfInvoice;
	@ManyToOne(fetch = FetchType.LAZY)
	private CustomerEntity customerEntity;
	@OneToMany(cascade = CascadeType.ALL)
	private List<InvoiceLineEntity> invoiceLInes;
	@Column(length = 4000)
	private String invoiceId;
	private byte[] proofBlob;
	private String proofBlobFileName;
	private String locationToProofUrl;
	private String comment;
	private String internalLocationToProof;
	@Column(precision = 30, scale = 3)
	private BigDecimal totalVatAmount=new BigDecimal(0D);
	
	@Column(precision = 30, scale = 3)
	private BigDecimal totalAmount;
	@ManyToOne(fetch = FetchType.LAZY)
	private CurrencyEntity currency;

	public BigDecimal getTotalVatAmount() {
		return totalVatAmount;
	}

	public void setTotalVatAmount(BigDecimal totalVatAmount) {
		this.totalVatAmount = totalVatAmount;
	}

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

	public CurrencyEntity getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyEntity currency) {
		this.currency = currency;
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

	public String getInternalLocationToProof() {
		return internalLocationToProof;
	}

	public void setInternalLocationToProof(String internalLocationToProof) {
		this.internalLocationToProof = internalLocationToProof;
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

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	public List<InvoiceLineEntity> getInvoiceLInes() {
		return invoiceLInes;
	}

	public void setInvoiceLInes(List<InvoiceLineEntity> invoiceLInes) {
		this.invoiceLInes = invoiceLInes;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

}
