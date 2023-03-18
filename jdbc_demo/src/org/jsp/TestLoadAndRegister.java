package org.jsp;

public class TestLoadAndRegister {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded and register successfully.");
		} catch (ClassNotFoundException e) {
			System.out.println("Invalid driver class name");
			e.printStackTrace();
		}
	}

}