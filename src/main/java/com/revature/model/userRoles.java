package com.revature.model;

public class userRoles {
	
	public userRoles() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int userId;
	
	private String urRole;
	
	public userRoles(int userId, String urRole) {
		super();
		this.userId = userId;
		this.urRole = urRole;
	}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUrRole() {
		return urRole;
	}

	public void setUrRole(String urRole) {
		this.urRole = urRole;
	}
	
	@Override
	public String toString() {
		return "userRoles [userId=" + userId + ", urRole=" + urRole + "]";
	}


}
