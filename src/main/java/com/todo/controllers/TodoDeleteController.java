package com.todo.controllers;

import java.io.IOException;

import com.todo.service.TodoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodoDeleteController
 */
@WebServlet("/delete")
public class TodoDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TodoService todoService = new TodoService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		if(todoService.deleteTodo(id)) {
			request.getRequestDispatcher("todos").forward(request, response);
		} else {
			request.setAttribute("error", true);
			request.getRequestDispatcher("todos").forward(request, response);
		}
	}


}
