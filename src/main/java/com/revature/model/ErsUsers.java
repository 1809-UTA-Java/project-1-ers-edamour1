package com.revature.model;

public class ErsUsers {
	
	int uId, urId;
	
	String uUsername, uPassword, uFirstname, uLastname, uEmail;
	
	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getUrId() {
		return urId;
	}

	public void setUrId(int urId) {
		this.urId = urId;
	}

	public String getuUsername() {
		return uUsername;
	}

	public void setuUsername(String uUsername) {
		this.uUsername = uUsername;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuFirstname() {
		return uFirstname;
	}

	public void setuFirstname(String uFirstname) {
		this.uFirstname = uFirstname;
	}

	public String getuLastname() {
		return uLastname;
	}

	public void setuLastname(String uLastname) {
		this.uLastname = uLastname;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	@Override
	public String toString() {
		return "ErsUsers [uId=" + uId + ", urId=" + urId + ", uUsername=" + uUsername + ", uPassword=" + uPassword
				+ ", uFirstname=" + uFirstname + ", uLastname=" + uLastname + ", uEmail=" + uEmail + "]";
	}


}
