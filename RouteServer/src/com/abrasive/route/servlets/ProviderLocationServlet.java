package com.abrasive.route.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abrasive.route.controllers.ProviderRequestController;

/**
 * Servlet implementation class ProviderLocationServlet
 */
@WebServlet("/ProviderLocation")
public class ProviderLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sessionID = req.getParameter("SessionID");
		String altitude = req.getParameter("Altitude");
		String latitude = req.getParameter("Latitude");
		String speed = req.getParameter("Speed");
				
		resp.getWriter().write(
				ProviderRequestController.updateLocation(sessionID, altitude, latitude, speed));
	}
}
