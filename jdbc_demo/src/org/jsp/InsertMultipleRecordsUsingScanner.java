package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMultipleRecordsUsingScanner {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		String url, user, password;
		url= "jdbc:mysql://localhost:3306/jdbc_demo";
		user="root";
		password="root";
		String qry ="insert into user values(?,?,?)";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id, name & phone number: ");
		int id = sc.nextInt();
		String name = sc.next();
		long phone = sc.nextLong();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
			System.out.println("Connection Establish");
			pst=con.prepareStatement(qry);
			
			pst.setInt(1,id);
			pst.setString(2, name);
			pst.setLong(3, phone);
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
