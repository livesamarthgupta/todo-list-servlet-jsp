package com.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		if(conn != null)
			return conn;
		else
			return getConnectionToDatabase();
	}
	
	private static Connection getConnectionToDatabase() {
		try {
			
			Class.forName("org.postgresql.Driver");
			String URL = "jdbc:postgresql://localhost/samarth";
			Properties props = new Properties();
			props.setProperty("user", "samarth");
			
			conn = DriverManager.getConnection(URL, props);
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Driver not found!");
			e.printStackTrace();
			
		} catch(SQLException e) {
			
			System.out.println("Connection Failed!");
			e.printStackTrace();
			
		}
		
		if(conn != null) {
			System.out.println("Connection Successful!");
		}
		
		return conn;
	}

}
