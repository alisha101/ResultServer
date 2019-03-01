package com.user;

import com.dbconnection.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DALUser {
    
   public ArrayList<User> getAllUsers() throws SQLException {
       ArrayList<User> al = new ArrayList<>();
       
       String query = "select * from user where role='ROLE_USER'";
       DBConnection db = new DBConnection();
       Statement s = db.connection().createStatement();
       ResultSet rs = s.executeQuery(query);
       while(rs.next()) {
           int id = rs.getInt("id");
           String name = rs.getString("name");
           String username = rs.getString("username");
           String pwd = rs.getString("password");
           String role  = rs.getString("role");
           
           User u = new User(id,name,username,pwd,role);
           al.add(u);
       }
       System.out.println(al);
       db.close();
       return al;
   }
    
   public User login(User u) throws SQLException
   {
	   String query = "select * from user where username='" + u.getUsername() + "' and password='" + u.getPassword() + "'";
	   System.out.println(query);
	   DBConnection db = new DBConnection();
       Statement s = db.connection().createStatement();
       ResultSet rs = s.executeQuery(query);
       
       while(rs.next())
       {
    	   User u1 = new User();
    	   u1.setId(rs.getInt("id"));
    	   u1.setName(rs.getString("name"));
    	   u1.setPassword(rs.getString("password"));
    	   u1.setRole(rs.getString("role"));
    	   return u1;
       }
       return null;
   }
	public boolean registerUsers(User user) throws SQLException {
	
//		User user = new User();
	
		
		String name = user.getName();
		String username = user.getUsername();
		String password = user.getPassword();
		String role = user.getRole();	
		
		String query="insert into user (name,username,password,role)" + "values(?,?,?,?)" ;

		DBConnection db = new DBConnection();
		PreparedStatement s = db.connection().prepareStatement(query);
		
		s.setString (1, name);
		s.setString (2, username);
		s.setString (3, password);
		s.setString (4, role);

		boolean res = s.execute();

//		String query="insert into user values (id,name,username,pwd,role)";
//		DBConnection db = new DBConnection();
//		Statement s = db.connection().createStatement();
//		s.executeQuery(query);
	
		db.close();
		return res;
	}
}