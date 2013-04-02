package com.abrasive.route.data;

import java.util.*;

import com.abrasive.route.data.entities.Provider;
import com.abrasive.route.data.entities.Session;

public class SessionDA {
	private static List<Session> sessionList = new ArrayList<Session>(); 

	public static Session getSession(Provider provider) {
		// TODO: stub implementation, replace with DB call
		for (Session session : sessionList) {
			if (session.ProviderID == provider.ID) {
				return session;
			}
		}
		Session session = new Session();
		session.ID = sessionList.size();
		session.ExternalID = UUID.randomUUID().toString();
		session.ProviderID = provider.ID;
		sessionList.add(session);
		return session;
	}

	public static Session getSession(String sessionID) {
		// TODO: stub implementation, replace with DB call
		for (Session session : sessionList) {
			if (session.ExternalID.equals(sessionID)) {
				return session;
			}
		}
		return null;
	}

	public static void removeSession(long sessionID) {
		// TODO: stub implementation, replace with DB call
		for (Session session : sessionList) {
			if (session.ID == sessionID) {
				sessionList.remove(session);
				break;
			}
		}
	}

}
