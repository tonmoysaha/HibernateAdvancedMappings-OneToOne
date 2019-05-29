package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcURL = "jdbc:mysql://localhost:3306/one-to-one-uni?useSSL=false";
		String uname = "hbstudent";
		String password = "hbstudent";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, uname, password);
			System.out.println("connection successfully");
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
