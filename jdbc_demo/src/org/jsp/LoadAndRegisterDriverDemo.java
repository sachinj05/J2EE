package org.jsp;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoadAndRegisterDriverDemo {
	public static void main(String[] args) {
		try {
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			System.out.println("Driver is loaded and register successfully.");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
