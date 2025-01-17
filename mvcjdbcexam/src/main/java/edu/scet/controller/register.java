package edu.scet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.scet.dao.RegisterDAO;
import edu.scet.model.registerGUIBean;


@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		registerGUIBean reg = new registerGUIBean();
		reg.setName(request.getParameter("name"));
		reg.setEmail(request.getParameter("email"));
		reg.setPassword(request.getParameter("password"));
		reg.setAddress(request.getParameter("address"));
		
		RegisterDAO regdao = new RegisterDAO();
		try {
			boolean result = regdao.insertData(reg);
			if(result)
			{
				out.println("<html>Student registerd successfully<html>");
				RequestDispatcher rd = request.getRequestDispatcher("register.html");
				rd.include(request, response);
			}
			else
			{
				out.println("Student not registerd ! Something went wrong ");
				RequestDispatcher rd = request.getRequestDispatcher("register.html");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
