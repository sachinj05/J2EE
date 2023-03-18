package com.jsp.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/ps")
public class PrintDetails extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("nm");
		Long phone = Long.parseLong(req.getParameter("ph"));
		String state = req.getParameter("st");
		String country = req.getParameter("ct");
		System.out.println("Name: "+name +"\n"+"Phone: "+ phone+"\n" +"State: " +state+"\n" +"Country: "+country);

		PrintWriter writer = resp.getWriter();
		writer.write("<html> <body> <h1> Your Details: </h1>");
		writer.write("<h2> Name: "+name+"</h2>");
		writer.write("<h2> Phone Number: "+phone+"</h2>");
		writer.write("<h2> State: "+state+"</h2>");
		writer.write("<h2> Country: "+country+"</h2></body></html>");


	}
}
