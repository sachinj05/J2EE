package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchWithStatement {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "root");
			st = con.createStatement();
			st.addBatch("delete from user where phone_no = 777");
		st.addBatch("update user set name='rtx',phone_no=12345 where id = 6   ");
			st.addBatch("insert into user values(10,'sachin',8457814339)");

			int[] arr = st.executeBatch();

			for (int i : arr) {
				System.out.println(i + " row affected");
			}

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
