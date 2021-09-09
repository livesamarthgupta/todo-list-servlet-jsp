package com.todo.controllers;

import java.io.IOException;

import com.todo.service.TodoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class TodoCreateController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private TodoService service = new TodoService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("createTodo.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String todoDescription = request.getParameter("desc");
		boolean isCompleted = request.getParameter("isCompleted") != null;
		String username = (String) request.getSession().getAttribute("username");
		
		if(service.addTodo(username, todoDescription, isCompleted)) {
			request.getRequestDispatcher("todos").forward(request, response);
		} else {
			request.setAttribute("error", true);
			request.getRequestDispatcher("createTodo.jsp").forward(request, response);
		}
		
	}

}
