package org.ty.App;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class Operation extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String a1 = req.getParameter("a");
		int a = Integer.parseInt(a1);
		String b1 = req.getParameter("b");

		int b = Integer.parseInt(b1);

		int c = a + b;
		PrintWriter output = resp.getWriter();
		output.print("<html><body bcolor='ORANGE'><h1>Addition : " + c + "</h1><body><html>");
	
		int d = a - b;
		output.print("<html><body bcolor='ORANGE'><h1>subtraction : " + d + "</h1><body><html>");
		
		int e = a * b;
		output.print("<html><body bcolor='ORANGE'><h1>Multiplication : " + e + "</h1><body><html>");
		
		int f = a / b;
		output.print("<html><body bcolor='ORANGE'><h1>division : " + f + "</h1><body><html>");
	}
}
