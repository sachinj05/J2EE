package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMultipleRecordsUsingPreparedStatement {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		String url, user, password;
		url= "jdbc:mysql://localhost:3306/jdbc_demo";
		user="root";
		password="root";
		String qry ="insert into user values(?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
			System.out.println("Connection Establish");
			pst=con.prepareStatement(qry);
			
			pst.setInt(1,6);
			pst.setString(2, "A");
			pst.setLong(3, 999);
			pst.executeUpdate();
			
			pst.setInt(1,7);
			pst.setString(2, "B");
			pst.setLong(3, 888);
			pst.executeUpdate();
			
			pst.setInt(1,8);
			pst.setString(2, "C");
			pst.setLong(3, 777);
			pst.executeUpdate();
			System.out.println("Records are Insearted Successfully");
			
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
