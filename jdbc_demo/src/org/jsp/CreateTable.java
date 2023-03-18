package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		String url, user, password;
		url = "jdbc:mysql://localhost:3306/jdbc_demo";
		user = "root";
		password = "root";
		String query = "create table user(id int not null,name varchar(40) null,phone_no bigint null, primary key(id))";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			boolean res = st.execute(query);
			System.out.println(res + " is the returned value and table is created");

		} catch (SQLException | ClassNotFoundException e) {
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
			if (st != null) {
				try {
					st.close();
					System.out.println("Statement is closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
