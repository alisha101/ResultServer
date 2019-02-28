package com.dbconnection;

import java.sql.*;  

public class DBConnection {
	Connection con;
	//Connection built and return connection
	public Connection connection() {
		try{  
			Class.forName("com.mysql.jdbc.Driver").newInstance();  
			con=DriverManager.getConnection( "jdbc:mysql://mydatabase.cqs57mhpwmsm.us-west-2.rds.amazonaws.com:3306/result","admin","admin123");
//			con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/result","root","root");
			System.out.println(con);
			return con;
			
		}catch(Exception e){ 
			e.printStackTrace();
			return null;
		}  
	}
	
	public void close() throws SQLException {
		con.close();
	}

	public Statement createStatement() {
		return null;
	}
}