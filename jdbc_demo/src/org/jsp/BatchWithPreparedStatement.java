package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchWithPreparedStatement {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "root");
			pst = con.prepareStatement("insert into user values(?,?,?)");
			
			pst.setInt(1, 8);
			pst.setString(2, "tata");
			pst.setLong(3, 888);
			pst.addBatch();
			
			pst.setInt(1, 4);
			pst.setString(2, "tcs");
			pst.setLong(3, 0123);
			pst.addBatch();
			
			pst.setInt(1, 6);
			pst.setString(2, "hcl");
			pst.setLong(3, 1230);
			pst.addBatch();
			
			
			int[] arr = pst.executeBatch();

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
