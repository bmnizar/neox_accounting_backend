package com.neoxiontechnologies.neoxAccounting.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MigrationUtils {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test", "postgres", "password");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("");
		// Extract data from result set
		while (rs.next()) {
			// Retrieve by column name
			System.out.print("ID: " + rs.getInt("id"));
			System.out.print(", Age: " + rs.getInt("age"));
			System.out.print(", First: " + rs.getString("first"));
			System.out.println(", Last: " + rs.getString("last"));
		}

	}

}
