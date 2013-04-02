package com.abrasive.route.controllers;

import com.abrasive.route.data.LocationDA;
import com.abrasive.route.data.ProviderDA;
import com.abrasive.route.data.SessionDA;
import com.abrasive.route.data.entities.Provider;
import com.abrasive.route.data.entities.Session;
import com.google.gson.JsonObject;

public class ProviderRequestController {
	
	public static String login(String login, String password) {
		JsonObject response = new JsonObject();

		// Mandatory parameters
		if ((login == null) || (password == null)) {
			response.addProperty("Error", "Parameter(s) missing");
		} else {
			// Parameters are Ok				
			Provider provider = ProviderDA.getProvider(login, password);
			if (provider == null) {
				// Login / password is incorrect
				response.addProperty("Error", "Login or password is incorrect");
			} else {
				// Login is Ok
				Session session = SessionDA.getSession(provider);			
				response.addProperty("SessionID", session.ExternalID);
			}
		}
		return response.toString();
	}

	public static String updateLocation(String sessionID, String altitude, String latitude, String speed) {
		JsonObject response = new JsonObject();
		
		if ((sessionID == null) || (altitude == null) || (latitude == null) || (speed == null)) {
			response.addProperty("Error", "Parameter(s) missing");
		} else {
			// Parameters are Ok				
			Session session = SessionDA.getSession(sessionID);
			if (session == null) {
				// Session is not valid
				response.addProperty("Error", "Session is not valid");
			} else {
				// Session is Ok
				long altitudeVal = Long.parseLong(altitude);
				long latitudeVal = Long.parseLong(latitude);
				long speedVal = Long.parseLong(speed);
				LocationDA.addLocation(session.ProviderID, altitudeVal, latitudeVal, speedVal);
			}
		}
		return response.toString();
	}

	public static String logout(String sessionID) {
		JsonObject response = new JsonObject();
		if (sessionID == null) {
			response.addProperty("Error", "Parameter(s) missing");
		} else {
			// Parameters are Ok				
			Session session = SessionDA.getSession(sessionID);
			if (session == null) {
				// Session is not valid
				response.addProperty("Error", "Session is not valid");
			} else {
				// Session is Ok
				SessionDA.removeSession(session.ID);			
			}
		}
		return response.toString();
	}
}
