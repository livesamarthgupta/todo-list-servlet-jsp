package com.todo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.todo.dao.DBConnection;

public class LoginService {
	
	public boolean validate(String username, String password) {
		Connection connection = DBConnection.getConnection();
		
		try {
			String sql = "SELECT * FROM login WHERE username=? AND password=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				return true;
			} 
			
		} catch (SQLException e) {
			System.out.println("Error while fetching login details!");
			e.printStackTrace();
		}
		
		return false;
	}
}
