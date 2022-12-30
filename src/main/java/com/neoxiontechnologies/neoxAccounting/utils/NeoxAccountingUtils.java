package com.neoxiontechnologies.neoxAccounting.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 ** @BMN 2021
 **
 **/
public class NeoxAccountingUtils {
	public static final String GENERAL_REST_URL = "neoxAccounting";
	public static final String FILE_STORE_REST_NAME="FileStore";
	 
	public static MessageDigest SHA256_HASH;
	static {
		try {
			SHA256_HASH = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
	}



 

}
