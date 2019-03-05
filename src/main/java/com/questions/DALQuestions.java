package com.questions;

import java.sql.*;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dbconnection.DBConnection;

public class DALQuestions {
	
	public ArrayList<Questions> getAllQuestions() throws SQLException {
		
		String query="select * from questions";
		DBConnection db = new DBConnection();
		Statement s = db.connection().createStatement();
		ResultSet rs=s.executeQuery(query);

		ArrayList<Questions> al = new ArrayList<>();

		while(rs.next()) {
			 int id = rs.getInt("id");
			 String question = rs.getString("question");
			 String option1 = rs.getString("option1");
			 String option2 = rs.getString("option2");
			 String option3 = rs.getString("option3");
			 String option4 = rs.getString("option4");
			 String answer = rs.getString("answer");
			 
			 Questions que = new Questions(id,question,option1,option2,option3,option4,answer);
			 al.add(que); 
		}
		System.out.println(al);
		db.close();
		return al;
	}
	
	public boolean addQuestion(Questions que) throws SQLException {
		
		//Questions que = new Questions();
		
		//int id = 5;//que.getId();
		String question = que.getQuestion();
		String option1 = que.getOption1();
		String option2 = que.getOption2();
		String option3 = que.getOption3();
		String option4 = que.getOption4();
		String answer = que.getAnswer();
		
		String query="insert into questions (question,option1,option2,option3,option4,answer)" + " values(?,?,?,?,?,?)" ;
		//+ "VALUES (4,'Q','a','b','c','d','asd')";
		//id,question,option1,option2,option3,option4,answer)";

		DBConnection db = new DBConnection();
		PreparedStatement s = db.connection().prepareStatement(query);
		//s.setInt (1, id);
		s.setString (1, question);
		s.setString (2, option1);
		s.setString (3, option2);
		s.setString (4, option3);
		s.setString (5, option4);
		s.setString (6, answer);

		System.out.println(query);
		System.out.println(s);
		boolean res = s.execute();
			      
		//DBConnection db = new DBConnection();
		//Statement s = db.connection().createStatement();
		//s.executeUpdate(query);
 
		db.close();
		return res;
	}
	
	public ArrayList<Questions> getQuestionById() throws SQLException {
		
		Questions que = new Questions();
		
		int selectedId = que.getId();
		
		String query="select * from questions where id = 1";
		DBConnection db = new DBConnection();
		Statement s = db.connection().createStatement();
		ResultSet rs=s.executeQuery(query);

		ArrayList<Questions> al = new ArrayList<>();

		while(rs.next()) {
			 int id = rs.getInt("id");
			 String question = rs.getString("question");
			 String option1 = rs.getString("option1");
			 String option2 = rs.getString("option2");
			 String option3 = rs.getString("option3");
			 String option4 = rs.getString("option4");
			 String answer = rs.getString("answer");
			 
			 Questions que1 = new Questions(id,question,option1,option2,option3,option4,answer);
			 al.add(que1); 
		}
		System.out.println(al);
		db.close();
		return al;
	}
	
	public boolean deleteQuestionById(int id) throws SQLException {
		
		Questions que = new Questions();
		
		int selectedId = que.getId();
		
		String query="delete from questions where id = " + id;
		System.out.println(query);
		DBConnection db = new DBConnection();
		Statement s = db.connection().createStatement();
		s.executeUpdate(query);
 
		db.close();
		return true;
	}
	
}
