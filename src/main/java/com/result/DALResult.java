package com.result;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dbconnection.DBConnection;
import com.questions.Questions;

public class DALResult {
	
	public ArrayList<Result> getAllResult() throws SQLException {
		
		String query="select * from user_result";
		DBConnection db = new DBConnection();
		Statement s = db.connection().createStatement();
		ResultSet rs=s.executeQuery(query);

		ArrayList<Result> al = new ArrayList<>();
	
		while(rs.next()) {
			int id = rs.getInt("id");
			String userid = rs.getString("userid");
			String score = rs.getString("score");
		
			Result u = new Result(id,userid,score);
			al.add(u);
		}
		System.out.println(al);
		db.close();
		return al;
	}
	
public ArrayList<Result> getAllResultByUserId(String userid) throws SQLException {
		
		String query="select * from user_result where userid='" + userid + "'";
		DBConnection db = new DBConnection();
		Statement s = db.connection().createStatement();
		ResultSet rs=s.executeQuery(query);

		ArrayList<Result> al = new ArrayList<>();
	
		while(rs.next()) {
			int id = rs.getInt("id");
			String uid = rs.getString("userid");
			String score = rs.getString("score");
		
			Result u = new Result(id,uid,score);
			al.add(u);
		}
		System.out.println(al);
		db.close();
		return al;
	}
	public boolean addResult(Result r) throws SQLException {
		
		//Questions que = new Questions();
		
		//int id = 5;//que.getId();
		
		
		String query="insert into user_result (userid,score)" + " values(?,?)" ;
		//+ "VALUES (4,'Q','a','b','c','d','asd')";
		//id,question,option1,option2,option3,option4,answer)";

		DBConnection db = new DBConnection();
		PreparedStatement s = db.connection().prepareStatement(query);
		//s.setInt (1, id);
		s.setString (1, r.getUserid());
		s.setString (2, r.getScore());
		

		System.out.println(query);
		System.out.println(s);
		boolean res = s.execute();
			      
		//DBConnection db = new DBConnection();
		//Statement s = db.connection().createStatement();
		//s.executeUpdate(query);
 
		db.close();
		return res;
	}
	
}
