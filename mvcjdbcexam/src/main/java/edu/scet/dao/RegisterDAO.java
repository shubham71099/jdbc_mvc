package edu.scet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.scet.model.registerGUIBean;
import edu.scet.model.studentBean;

public class RegisterDAO {
	public boolean insertData(registerGUIBean regdao) throws ClassNotFoundException, SQLException
	{
		try {
			String name=regdao.getName();
			String email=regdao.getEmail();
			String password=regdao.getPassword();
			String address=regdao.getAddress();
			Connection con = myConnection.getConnection();
			Statement stm = con.createStatement();
			String query = "insert into student values('"+name+"','"+email+"','"+password+"','"+address+"')";
			stm.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean login(String email,String password)
	{
		studentBean sb = null;
		try {
			Connection con = myConnection.getConnection();
			Statement stm = con.createStatement();
			String query = "select * from student where email='"+email+"' and password='"+password+"' ";
			ResultSet rs= stm.executeQuery(query);
			if(rs.next())
			{
				sb = new studentBean();
				sb.setName(rs.getString("name"));
				sb.setEmail(rs.getString("email"));
				sb.setAddress(rs.getString("address"));
				return true;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
