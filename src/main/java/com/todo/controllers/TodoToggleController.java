package com.todo.controllers;

import java.io.IOException;

import com.todo.service.TodoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodoToggleController
 */
@WebServlet("/toggle")
public class TodoToggleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TodoService todoService = new TodoService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		todoService.toggleTodo(id);
	}

}
