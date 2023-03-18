package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your registered phone number: ");
		long phone = sc.nextLong();
		System.out.println("Enter your password: ");
		String ps=sc.next();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String qry ="select * from person where phone=? and password=?";
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","root");
	pst=con.prepareStatement(qry);
	pst.setLong(1, phone);
	pst.setString(2, ps);
	rs=pst.executeQuery();
	if (rs.next()) {
		System.out.println("Login Successfull");
		System.out.println("Id : "+rs.getInt(1));
		System.out.println("Name : "+rs.getString(2));
		System.out.println("Phone : "+rs.getLong(3));
		System.out.println("Age : "+rs.getInt(4));

	} else {
		System.out.println("Invalid phone number or password");
	}

	
} catch (Exception e) {
	
}
		
		
		
		
	}

}
