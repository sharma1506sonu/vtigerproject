package com.comcast.crm.generic.databaseutility;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtility {
	Connection conn;
	
	public void getDBConnection(String url, String username, String password) throws SQLException {
		try {
		Driver driver=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(url,username,password);
		}catch (Exception e) {
			
		}
	}
	
	public void getDBConnection() throws SQLException {
		try {
		Driver driver=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection("localhost","root","root");
		}catch (Exception e) {
			
		}
	}
	public void closeDataBaseConnection() throws SQLException {
		try {
			conn.close();
		} catch (Exception e) {
			
		}
	}
	
	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result=null;
		Statement state = conn.createStatement();
	    result = state.executeQuery(query);
	 return result;
	}
	
	public int executeNonSelectQuery(String query) {
		int result=0;
		try {
			Statement state = conn.createStatement();
		 result = state.executeUpdate(query);
		} catch ( Exception e) {
			
		}
		return result;
	}
}
