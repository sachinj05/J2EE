package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeletUser {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		String url,user,password,qry;
		url="jdbc:mysql://localhost:3306/jdbc_demo";
		user="root";
		password="root";
		qry="delete from user where id=3";		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			int x = st.executeUpdate(qry);
			System.out.println(x+" rows are deleted");
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
