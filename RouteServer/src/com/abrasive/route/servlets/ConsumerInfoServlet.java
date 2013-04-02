package com.abrasive.route.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abrasive.route.controllers.ConsumerRequestController;

/**
 * Servlet implementation class ConsumerInfoServlet
 */
@WebServlet("/ConsumerInfo")
public class ConsumerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String stationID = req.getParameter("StationID");
		String routeID = req.getParameter("RouteID");
				
		resp.getWriter().write(
				ConsumerRequestController.getNearestProviders(stationID, routeID));
	}
}
