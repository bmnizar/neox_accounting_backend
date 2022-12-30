package com.neoxiontechnologies.neoxAccounting.core;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UserAuthenticationToken extends UsernamePasswordAuthenticationToken {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String selectedLoginType;

	public UserAuthenticationToken(Object principal, Object credentials) {
		super(principal, credentials);

	}

	public String getSelectedLoginType() {
		return selectedLoginType;
	}

	public void setSelectedLoginType(String selectedLoginType) {
		this.selectedLoginType = selectedLoginType;
	}

}
