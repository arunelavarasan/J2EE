package org.ty.App;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class Product extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		String pi = req.getParameter("pid");
		int pid = Integer.parseInt(pi);
		String nm = req.getParameter("pname");
		String price = req.getParameter("pprice");
		String qty = req.getParameter("pqty");
		try {
			String inQry = "insert into product.product values(?,?,?,?)";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt = con.prepareStatement(inQry);
			pstmt.setInt(1, pid);
			pstmt.setString(2, nm);
			pstmt.setString(3, price);
			pstmt.setString(4, qty);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter output = resp.getWriter();
		output.print("<html><body bgcolor='cyan'>" + "<h1>Successfully Stored into Database!!!" + "</h1>" + "<h2>Details are:-</h2>" + "<h4>Id="
				+ pid + "</h4>" + "<h4>Product=" + nm + "</h4>" + "<h4>Quality=" + qty + "</h4>" +"<h4>Price=" + price + "" + "</h4></body></html>");
	}
}
