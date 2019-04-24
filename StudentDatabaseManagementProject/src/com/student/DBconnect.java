package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
	
	public Connection dbconnect() {
		Connection con=null;
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String username="hr";
		String password="hr";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("driver loaded");
		try {
			con=DriverManager.getConnection(url,username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		//System.out.println("connection established");
		return con;
	}
	
	

}
