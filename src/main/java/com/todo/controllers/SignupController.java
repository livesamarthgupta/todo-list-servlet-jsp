package com.todo.controllers;

import java.io.IOException;

import com.todo.service.SignupService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SignupService signupService = new SignupService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("username") != null) {
			request.getRequestDispatcher("todos").forward(request, response);
		}
		request.getRequestDispatcher("signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean isSignupSuccess = signupService.signUp(username, password);
		
		if(!isSignupSuccess) {
			
			request.setAttribute("error", true);
			request.getRequestDispatcher("signup.jsp").forward(request, response);
			
		} else {
			
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			request.setAttribute("freshUser", true);
			request.getRequestDispatcher("todos").forward(request, response);
			
		}
		
	}

}
