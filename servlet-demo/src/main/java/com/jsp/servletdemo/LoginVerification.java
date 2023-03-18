package com.jsp.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginVerification extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email = req.getParameter("em");
	String password = req.getParameter("ps");
	PrintWriter writer = resp.getWriter();
	if (email.equals("123@gmail.com")&&password.equals("123") ) {
		writer.write("<html><body><h1>Login Successfull</h1></body></html>");
	} else {
		writer.write("<html><body><h1>invalid email or password</h1></body></html>");
	}
 }
}
