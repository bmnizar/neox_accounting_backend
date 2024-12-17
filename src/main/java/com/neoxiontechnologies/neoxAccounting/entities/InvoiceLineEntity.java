package com.neoxiontechnologies.neoxAccounting.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class InvoiceLineEntity extends AbstractAuditingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_line_entity_seq")
	@SequenceGenerator(name = "invoice_line_entity_seq")
	private Long id;
	@OneToOne
	private ProductEntity productEntity;
	private String label;
	private Long quantity;
	@Column(precision = 30, scale = 3)
	private BigDecimal unitPrice;
	@OneToOne
	private CurrencyEntity currencyEntity;
	private BigDecimal vatRate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public CurrencyEntity getCurrencyEntity() {
		return currencyEntity;
	}

	public void setCurrencyEntity(CurrencyEntity currencyEntity) {
		this.currencyEntity = currencyEntity;
	}

	public BigDecimal getVatRate() {
		return vatRate;
	}

	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}

}
