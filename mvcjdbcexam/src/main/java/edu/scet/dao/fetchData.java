package edu.scet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.scet.model.studentBean;

public class fetchData {
	
	public studentBean getData(String email)
	{
		studentBean sb = null;
		try {
			Connection con = myConnection.getConnection();
			Statement stm = con.createStatement();
			String query = "select * from student where email='"+email+"' ";
			ResultSet rs= stm.executeQuery(query);
			if(rs.next())
			{
				sb = new studentBean();
				sb.setName(rs.getString("name"));
				sb.setAddress(rs.getString("address"));
				sb.setEmail(rs.getString("email"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return sb;
	}

}