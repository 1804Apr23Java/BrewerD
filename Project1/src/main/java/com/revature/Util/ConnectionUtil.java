package com.revature.Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	//this is terrible! don't do it this way! 
	/*public static Connection getConnection() throws SQLException {
		String url = "";
		String username = "";
		String password = "";
		return DriverManager.getConnection(url,username,password);
	}
	
*/	
	
	//better
	public static Connection getConnectionFromFile(String filename) throws IOException, SQLException {
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		
		//System.out.println("Connecting in ConnectionUtil");
		
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream(filename));
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}

}
