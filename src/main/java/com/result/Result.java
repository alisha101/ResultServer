package com.result;

public class Result {
	
	int id;
	String userid,score;
	
	public Result() { }
	
	public Result(int id, String userid, String score) {
		super();
		this.id = id;
		this.userid = userid;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", userid=" + userid + ", score=" + score + "]";
	}
	
}
