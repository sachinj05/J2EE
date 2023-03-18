package org.jsp.useraap;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("nm");
		int age = Integer.parseInt(request.getParameter("age"));
		Long phone = Long.parseLong(request.getParameter("ph"));
		String password = request.getParameter("ps");
		Connection con = null;
		PreparedStatement pst = null;
		String qry = "insert into user values(?,?,?,?,?)";
		try {
			Class.forName(UserUtility.driver);
			con = DriverManager.getConnection(UserUtility.url, UserUtility.user, UserUtility.password);
			pst = con.prepareStatement(qry);
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setInt(3, age);
			pst.setLong(4, phone);
			pst.setString(5, password);
			pst.executeUpdate();
			PrintWriter writer = response.getWriter();
			writer.write("<html><body><h1>Your Record Are Registered Successfully</h1></body></html>");

		} catch (SQLException|ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
