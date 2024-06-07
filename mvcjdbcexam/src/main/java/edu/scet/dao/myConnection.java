package edu.scet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myConnection {
	private static Connection con = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(con==null)
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaexammain","root","shubham");
		}
		return con;
	}
}
