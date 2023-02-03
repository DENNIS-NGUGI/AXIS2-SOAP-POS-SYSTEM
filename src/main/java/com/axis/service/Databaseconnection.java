package com.axis.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class Databaseconnection {
    static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/supermart";
	static final String DB_USERNAME = "root1";
	static final String DB_PASSWORD = "root";
	
	static Connection connection = null;
	
	public static Connection connectDB() {
		try {
			Class.forName(DB_DRIVER);
			Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			return connection;
		}catch(Exception e) {
			System.out.println(e);
			return connection;
		}
	}
	
}

