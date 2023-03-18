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
@WebServlet("/edit")
public class EditUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("nm");
		int age = Integer.parseInt(req.getParameter("age"));
		Long phone = Long.parseLong(req.getParameter("ph"));
		String password = req.getParameter("ps");

		Connection con = null;
		PreparedStatement pst = null;
		String qry = "update user set name=?, phone=?, age=?, password=?; where id=?";

		try {
			Class.forName(UserUtility.driver);
			con = DriverManager.getConnection(UserUtility.url, UserUtility.user, UserUtility.password);
			pst = con.prepareStatement(qry);
			pst.setString(1, name);
			pst.setLong(2, phone);
			pst.setInt(3, age);
			pst.setString(4, password);
			pst.setInt(5, id);
			PrintWriter writer = resp.getWriter();
			writer.write("<html><body><h1>User Details Updated Successfully</h1></body></html>");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
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
