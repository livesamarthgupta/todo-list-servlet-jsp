package com.todo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.todo.dao.DBConnection;

public class SignupService {
	
	public boolean signUp(String username, String password) {
		
		boolean isSignupSuccess = false;
		
		Connection connection = DBConnection.getConnection();
		
		try {
			String sql = "INSERT INTO login(username, password) values(?, ?);";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			
			statement.execute();
			isSignupSuccess = true;
			
		} catch(Exception e) {
			e.printStackTrace();
			isSignupSuccess = false;
		}
		
		return isSignupSuccess;
	}
}
