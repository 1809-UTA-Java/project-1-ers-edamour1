package com.revature.model;

public class ErsReimbursementType {
	
	int rtId;
	
	String rtType;
	
	public int getRtId() {
		return rtId;
	}
	public void setRtId(int rtId) {
		this.rtId = rtId;
	}
	public String getRtType() {
		return rtType;
	}
	public void setRtType(String rtType) {
		this.rtType = rtType;
	}
	@Override
	public String toString() {
		return "ErsReimbursementType [rtId=" + rtId + ", rtType=" + rtType + "]";
	}

}
