package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveUser {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		String url, user, password;
		url= "jdbc:mysql://localhost:3306/jdbc_demo";
		user="root";
		password="root";
		String qry ="insert into user values(3, 'Smruti',9938615288)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
			System.out.println("Connection Establish");
			st=con.createStatement();
			int x = st.executeUpdate(qry);
			System.out.println(x+" row affected and Value is Insearted");
			
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
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}