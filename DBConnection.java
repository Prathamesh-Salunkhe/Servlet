package com.mouritech;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DBConnection {
	static Connection con; // = null;
	static Statement stmt; // = null;

	public static Connection getDBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// step 2 => Establish the connection to DB
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/task", "root", "Salunkhe-123");

		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return con;
	}
}
