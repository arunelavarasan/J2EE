package org.ty.App;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/validate")
public class Validation extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String un = req.getParameter("un");
		String ps = req.getParameter("ps");
		String name = null;
		String psd = null;		
			PrintWriter output = resp.getWriter();
			if(ps.equals("root"))
			{
				RequestDispatcher rd = req.getRequestDispatcher("/welcome");
				rd.forward(req, resp);
			}
			else {
				output.print("<html><body><p style='color:red;'>Sorry Username and Password is incorrect!!<p><body><html>");
				RequestDispatcher rd = req.getRequestDispatcher("Valid.html");
				rd.include(req, resp);
			}
      }
}