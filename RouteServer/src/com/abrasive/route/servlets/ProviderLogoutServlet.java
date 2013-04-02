package com.abrasive.route.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abrasive.route.controllers.ProviderRequestController;

/**
 * Servlet implementation class ProviderLogoutServlet
 */
@WebServlet("/ProviderLogout")
public class ProviderLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sessionID = req.getParameter("SessionID");
				
		resp.getWriter().write(
				ProviderRequestController.logout(sessionID));
	}
}
