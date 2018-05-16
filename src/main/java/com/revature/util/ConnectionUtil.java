package com.revature.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	private ConnectionUtil() {}
	
	public static Connection getConnection() {
		try (InputStream in = ConnectionUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
			// Get a reference to our Properties file
			Properties props = new Properties();
			props.load(in);
			
			// Specify the driver for Tomcat
			Class.forName("oracle.jdbc.OracleDriver");
			
			return DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.err.println(cnfe.getMessage());
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

}
