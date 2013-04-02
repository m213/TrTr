package com.abrasive.route.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abrasive.route.controllers.ProviderRequestController;

/**
 * Servlet implementation class ProviderAuthorizationServlet
 */
@WebServlet("/ProviderLogin")
public class ProviderLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("Login");
		String password = req.getParameter("Password");
				
		resp.getWriter().write(
				ProviderRequestController.login(login, password));
	}
}
