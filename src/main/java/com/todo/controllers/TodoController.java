package com.todo.controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.todo.model.TodoItem;
import com.todo.service.TodoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/todos")
public class TodoController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	TodoService todoService = new TodoService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		if(username != null) {
			ArrayList<TodoItem> todoList = todoService.getTodos(username);
			request.setAttribute("todos", todoList);
			request.getRequestDispatcher("todo.jsp").forward(request, response);						
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);			
		}
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		boolean freshUser = request.getAttribute("freshUser") != null;
		if(!freshUser) {
			ArrayList<TodoItem> todoList = todoService.getTodos(username);
			request.setAttribute("todos", todoList);
		}
		request.getRequestDispatcher("todo.jsp").forward(request, response);			
	}
}
