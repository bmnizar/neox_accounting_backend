package com.neoxiontechnologies.neoxAccounting.dto;

import java.util.Date;

public class GenerateStatementRequestDTO {
	private Date fromDate;
	private Date toDate;
	private String locationToPutStatement;

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getLocationToPutStatement() {
		return locationToPutStatement;
	}

	public void setLocationToPutStatement(String locationToPutStatement) {
		this.locationToPutStatement = locationToPutStatement;
	}

}
