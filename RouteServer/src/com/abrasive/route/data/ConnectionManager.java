package com.abrasive.route.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
    private static volatile Connection connection = null; 
    
    public static Connection getConnection() {
        if (connection == null) {
            synchronized (ConnectionManager.class) {
                if (connection == null) {
                	connection = initConnection();
                }
            }
        }
        return connection;    	
    }
    
    private static Connection initConnection() {
    	try {
    		// TODO: read from configuration
		    String driver = "org.postgresql.Driver";
		    String url = "jdbc:postgresql://localhost:5432/database";
		    String username = "postgres";
		    String password = "123456";
	
		    Class.forName(driver);	// Initialize static content of PostgreSQL driver 
		    return DriverManager.getConnection(url, username, password);
    	} catch (Exception ex) {
    		ex.printStackTrace();
    		// TODO: add logging here
    	}    	
    	return null;
    }    
}