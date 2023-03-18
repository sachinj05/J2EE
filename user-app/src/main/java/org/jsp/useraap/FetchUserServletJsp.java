package org.jsp.useraap;

import java.io.IOException; 
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fetchjsp")
public class FetchUserServletJsp extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String qry = "select * from user where id=?";
		try {
			Class.forName(UserUtility.driver);
			con = DriverManager.getConnection(UserUtility.url, UserUtility.user, UserUtility.password);
			pst = con.prepareStatement(qry);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			PrintWriter writer = resp.getWriter();
			RequestDispatcher dispatcher = null;
			if (rs.next()) {
				dispatcher = req.getRequestDispatcher("print.jsp");
				req.setAttribute("id", rs.getInt("id"));
				req.setAttribute("name", rs.getString("name"));
				req.setAttribute("age", rs.getInt("age"));
				req.setAttribute("phone", rs.getLong("phone"));
				dispatcher.forward(req, resp);

			} else {
				writer.write("<html><body><h1> Entered Id is invalid(Jsp)</h1></body></html>");

			}
		}
		catch (SQLException | ClassNotFoundException e) {
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
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
