package com.todo.controllers;

import java.io.IOException;

import com.todo.service.LoginService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LoginService loginService = new LoginService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("username") != null) {
			request.getRequestDispatcher("todos").forward(request, response);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
			
		if(loginService.validate(username, password)) {
	
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
				
			request.getRequestDispatcher("todos").forward(request, response);
				
		} else {
				
			request.setAttribute("error", true);
			request.getRequestDispatcher("index.jsp").forward(request, response);
				
		}
	} 

}
