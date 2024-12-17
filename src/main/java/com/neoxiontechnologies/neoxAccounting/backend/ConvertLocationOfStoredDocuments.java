/**
 * Copyright (c) 2023, 2024 Neoxion Technologies and/or its affiliates. All rights reserved.
 */
package com.neoxiontechnologies.neoxAccounting.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConvertLocationOfStoredDocuments {
	private static final String url = "jdbc:postgresql://localhost:5432/neox_accounting_prod";
	private static final String user = "postgres";
	private static final String password = "postgres";

	public static void main(String[] args) throws SQLException {
		fixBills();
		fixInvoices();

	}

	private static void fixInvoices() throws SQLException {

		Connection connection = DriverManager.getConnection(url, user, password);
		Statement createStatement = connection.createStatement();
		ResultSet executeQuery = createStatement
				.executeQuery("select id,internal_location_to_proof from neox_accounting_prod.invoice_entity");
		while (executeQuery.next()) {
			Long id = executeQuery.getLong(1);
			String string = executeQuery.getString(2);

			// System.out.println(string);
			String replaceAll = string.replaceAll("E:\\\\Nizar", "D:\\\\");
			// System.out.println(replaceAll);
			Statement createStatement2 = connection.createStatement();
			String updateQuery = "update neox_accounting_prod.invoice_entity set internal_location_to_proof='" + replaceAll
					+ "' where id=" + id;
			System.out.println(updateQuery);
			int executeUpdate = createStatement2.executeUpdate(updateQuery);
			System.out.println(executeUpdate);

		}


		
	}

	private static void fixBills() throws SQLException {

		Connection connection = DriverManager.getConnection(url, user, password);
		Statement createStatement = connection.createStatement();
		ResultSet executeQuery = createStatement
				.executeQuery("select id,internal_location_to_proof from neox_accounting_prod.bill_entity");
		while (executeQuery.next()) {
			Long id = executeQuery.getLong(1);
			String string = executeQuery.getString(2);

			// System.out.println(string);
			String replaceAll = string.replaceAll("E:\\\\Nizar", "D:\\\\");
			// System.out.println(replaceAll);
			Statement createStatement2 = connection.createStatement();
			String updateQuery = "update neox_accounting_prod.bill_entity set internal_location_to_proof='" + replaceAll
					+ "' where id=" + id;
			System.out.println(updateQuery);
			int executeUpdate = createStatement2.executeUpdate(updateQuery);
			System.out.println(executeUpdate);

		}

	}

}
