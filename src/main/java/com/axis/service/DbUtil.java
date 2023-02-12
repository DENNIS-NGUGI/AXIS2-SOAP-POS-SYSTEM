package com.axis.service;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

public class DbUtil {

	public static void close(ResultSet resultSet) {
		if(resultSet != null) {
			try {
				resultSet.close();
			}catch(SQLException e) {}
		}
	}
}