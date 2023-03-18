package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = request.getParameter("ps");
		Long phone = Long.parseLong(request.getParameter("ph"));
		PrintWriter writer = response.getWriter();
		RequestDispatcher dispatcher = null;
		if (phone == 123456789 && password.equals("@123")) {
			dispatcher = request.getRequestDispatcher("home.html");
			dispatcher.forward(request, response);
		} else {
			dispatcher = request.getRequestDispatcher("login.html");
			writer.write("<html><body><h1>invalid email or password</h1></body></html>");
			dispatcher.include(request, response);
		}

	}

}
