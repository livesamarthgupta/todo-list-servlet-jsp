package com.todo.controllers;

import java.io.IOException;

import com.todo.model.TodoItem;
import com.todo.service.TodoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodoEditController
 */
@WebServlet("/edit")
public class TodoEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TodoService todoService = new TodoService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		TodoItem todo = todoService.getTodo(id);
		request.setAttribute("todo", todo);
		request.getRequestDispatcher("editTodo.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String todoDescription = (String) request.getParameter("desc");
		boolean isCompleted = request.getParameter("isCompleted") != null;
		
		if(todoService.editTodo(id, todoDescription, isCompleted)) {
			request.getRequestDispatcher("todos").forward(request, response);
		} else {
			request.setAttribute("error", true);
			request.getRequestDispatcher("editTodo.jsp").forward(request, response);
		}
	}

}
