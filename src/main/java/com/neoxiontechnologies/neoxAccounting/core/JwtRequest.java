package com.neoxiontechnologies.neoxAccounting.core;

import java.io.Serializable;

public class JwtRequest implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;

	private String email;
	private String password;
	private String selectedLoginType;

	// default constructor for JSON Parsing
	public JwtRequest() {
	}

	public String getPassword() {
		return this.password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSelectedLoginType() {
		return selectedLoginType;
	}

	public void setSelectedLoginType(String selectedLoginType) {
		this.selectedLoginType = selectedLoginType;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
