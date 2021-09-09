package com.todo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.todo.dao.DBConnection;
import com.todo.model.TodoItem;

public class TodoService {

	public boolean addTodo(String username, String todoDescription, boolean isCompleted) {
		Connection connection = DBConnection.getConnection();
		boolean isTodoAdded = false;
		
		try {
			String sql = "INSERT INTO todo (username, description, completed) VALUES (?, ?, ?);";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, todoDescription);
			statement.setBoolean(3, isCompleted);
			
			statement.execute();
			isTodoAdded = true;
		} catch(Exception e) {
			System.out.println("Error while adding todo!");
			e.printStackTrace();
			isTodoAdded = false;
		}
		
		return isTodoAdded;
	}
	
	public ArrayList<TodoItem> getTodos(String username) {
		Connection connection = DBConnection.getConnection();
		ArrayList<TodoItem> todoList = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM todo WHERE username=?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				TodoItem todo = new TodoItem(result.getInt("id"), result.getString("description"), result.getBoolean("completed"));
				todoList.add(todo);
			}
		} catch(Exception e) {
			System.out.println("Error fetching todos!");
			e.printStackTrace();
		}
		
		return todoList;
	}

	public TodoItem getTodo(int id) {
		Connection connection = DBConnection.getConnection();
		TodoItem todo = new TodoItem();
		try {
			String sql = "SELECT * FROM todo WHERE id=?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet result = statement.executeQuery();
			if(result.next()) {				
				todo.setId(id);
				todo.setTodoDesc(result.getString("description"));
				todo.setCompleted(result.getBoolean("completed"));
			}
			
		} catch(Exception e) {
			System.out.println("Error fetching todo with id!");
			e.printStackTrace();
		}
		
		return todo;
	}

	public boolean editTodo(int id, String todoDescription, boolean isCompleted) {
		Connection connection = DBConnection.getConnection();
		boolean isTodoEdited = false;
		try {
			String sql = "UPDATE todo SET description=?, completed=? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, todoDescription);
			statement.setBoolean(2, isCompleted);
			statement.setInt(3, id);
			
			statement.execute();
			isTodoEdited = true;
		} catch(Exception e) {
			System.out.println("Error editing todo!");
			e.printStackTrace();
			isTodoEdited = false;
		}
		
		return isTodoEdited;
	}

	public boolean deleteTodo(int id) {
		Connection connection = DBConnection.getConnection();
		boolean isTodoDeleted = false;
		
		try {
			String sql = "DELETE FROM todo WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
			isTodoDeleted = true;
		} catch(Exception e) {
			System.out.println("Error deleting todo!");
			e.printStackTrace();
			isTodoDeleted = false;
		}
		
		return isTodoDeleted;
	}

	public void toggleTodo(int id) {
		Connection connection = DBConnection.getConnection();
		
		try {
			String fetchSql = "SELECT completed FROM todo WHERE id=?";
			String toggleSql = "UPDATE todo SET completed=? WHERE id=?";
			
			PreparedStatement fetchStatement = connection.prepareStatement(fetchSql);
			fetchStatement.setInt(1, id);
			
			ResultSet result = fetchStatement.executeQuery();
			if(result.next()) {
				boolean toggle = result.getBoolean("completed");
				
				PreparedStatement toggleStatement = connection.prepareStatement(toggleSql);
				toggleStatement.setBoolean(1, !toggle);
				toggleStatement.setInt(2, id);
				
				toggleStatement.execute();				
			}
		} catch(Exception e) {
			System.out.println("Error toggling todo!");
			e.printStackTrace();
		}
		
	}
}
