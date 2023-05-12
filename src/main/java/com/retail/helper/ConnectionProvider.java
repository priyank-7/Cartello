package com.retail.helper;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

@Component
public class ConnectionProvider {

	private static Connection con;

	public static Connection getConnection() {
		
		if(con == null) {
			try{          
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/retailwebapp","root","qwertyuiop");            
            }
			catch(Exception e){
	            e.printStackTrace();
	        }
        }        
        return con;
	}
}
