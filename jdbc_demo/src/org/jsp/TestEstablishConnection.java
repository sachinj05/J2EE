package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestEstablishConnection {
	public static void main(String[] args) {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded and Register properly");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			System.out.println("Connection has been Establish");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
					System.out.println("Connection is closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
