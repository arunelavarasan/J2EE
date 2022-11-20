package org.ty.App;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class Saving extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException {
		String sid =req.getParameter("id");
		int id = Integer.parseInt(sid);
		
		String name = req.getParameter("nm");
		
		String place = req.getParameter("pl");

		PrintWriter output = resp.getWriter();
		
		output.print("<html><body bgcolor='YELLOW'><h1>Successfully Submit!!<h1><body><html>");
		
		try {
			String inQry = "insert into student.student values(?,?,?)";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement pstmt = con.prepareStatement(inQry);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, place);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
