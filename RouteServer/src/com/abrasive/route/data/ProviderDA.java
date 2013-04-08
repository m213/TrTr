package com.abrasive.route.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public static Provider getProvider(String login, String password, int stub) {
		// TODO: replace with stored procedure call
		Provider provider = null;
		String sql = "select * from Providers where Login=? and Password=?";		
		try {
			PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(sql);
			statement.setString(1, login);
			statement.setString(2, login);
			ResultSet resultSet = statement.executeQuery();
			
			// If something is found
			if (resultSet.next()) {				
				provider = new Provider();
				provider.ID = resultSet.getLong("ID"); 
				provider.Login = resultSet.getString("Login");
				provider.Password = resultSet.getString("Password");
				provider.RouteID = resultSet.getLong("RouteID");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// TODO: implement logging
		}
		return provider;
	}
}
