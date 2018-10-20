package com.revature.model;

public class ErsReimbursementStatus {
	
	int rsId;
	
	String rsStatus; 
	
	public int getRsId() {
		return rsId;
	}

	public void setRsId(int rsId) {
		this.rsId = rsId;
	}

	public String getRsStatus() {
		return rsStatus;
	}

	public void setRsStatus(String rsStatus) {
		this.rsStatus = rsStatus;
	}

	@Override
	public String toString() {
		return "ErsReimbursementStatus [rsId=" + rsId + ", rsStatus=" + rsStatus + "]";
	}

	

}
