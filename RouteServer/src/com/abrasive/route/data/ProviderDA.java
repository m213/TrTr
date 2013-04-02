package com.abrasive.route.data;

import com.abrasive.route.data.entities.Provider;

public class ProviderDA {
	
	public static Provider getProvider(String login, String password) {
		// TODO: stub implementation, replace with DB call
		Provider provider = null;
		if ("test".equals(login) && "test".equals(password)) {
			provider = new Provider();
			provider.ID = 1; 
			provider.Login = "test";
			provider.Password = "test";
			provider.RouteID = 1;
		}
		return provider;
	}
}
