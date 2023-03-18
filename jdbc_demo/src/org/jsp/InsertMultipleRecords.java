package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMultipleRecords {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		String url, user, password;
		url= "jdbc:mysql://localhost:3306/jdbc_demo";
		user="root";
		password="root";
		String qry1 ="insert into user values(3, 'ABC',999)";
		String qry2="insert into user values(4, 'XYZ',777)";
		String qry3 ="insert into user values(5, 'PQR',888)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
			System.out.println("Connection Establish");
			st=con.createStatement();
			st.executeUpdate(qry1);
			st.executeUpdate(qry2);
			st.executeUpdate(qry3);
			System.out.println("Records Insearted Successfully");
			
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
