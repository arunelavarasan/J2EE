package org.ty.App;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;


public class Employe extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Connection con = null;
		PreparedStatement pstmt= null;
		String i = req.getParameter("pid");
		int id = Integer.parseInt(i);
		String nm = null;
		String qty = null;
		String price = null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt = con.prepareStatement("SELECT * FROM product.`product` WHERE pid = ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			PrintWriter out = resp.getWriter();
			if(rs.next())
			{
				id = rs.getInt(1);
				nm = rs.getString(2);
				qty = rs.getString(3);
				price = rs.getString(4);
				out.print("<html><body bgcolor='cyan'><h1>Details are :- <h1><h2>"+id+"</h2><h2>"+nm+"</h2><h2>"+qty+"</h2><h2>"+price+"<body></html>");
			}
			else {
				out.print("<html><body bgcolor='orange'><h1>ID is not found in database</h1></body></html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
