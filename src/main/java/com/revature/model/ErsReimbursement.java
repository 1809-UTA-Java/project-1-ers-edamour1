package com.revature.model;


import java.sql.Blob;
import java.sql.Timestamp;


//@Entity
//@Table(name = "ERS_REIMBURSEMENTS")
public class ErsReimbursement {

//@Id
//@Column(name = "R_ID")	
int rId;

//@Column(name = "R_AMOUNT")	
int rAmount;

//@Column(name = "U_ID_AUTHOR")	
int uIdAuthor;

//@Column(name = "U_ID_RESOLVER")	
int uIdResolver;

//@Column(name = "RT_TYPE")	
int rtType;

//@Column(name = "RT_STATUS")	
int rtStatus;

//@Column(name = "R_DESCRIPTION")	
String rDescription;

//@Temporal(value = TemporalType.TIMESTAMP)
//@Column(name = "R_SUBMITTED")
Timestamp rSubmmitted;

//@Temporal(value = TemporalType.TIMESTAMP)
//@Column(name = "R_RESOLVED")	
Timestamp r_resolved;


//@Column(name = "R_RECEIPT")	
Blob R_RECEIPT;


public int getrId() {
	return rId;
}


public void setrId(int rId) {
	this.rId = rId;
}


public int getrAmount() {
	return rAmount;
}


public void setrAmount(int rAmount) {
	this.rAmount = rAmount;
}


public int getuIdAuthor() {
	return uIdAuthor;
}


public void setuIdAuthor(int uIdAuthor) {
	this.uIdAuthor = uIdAuthor;
}


public int getuIdResolver() {
	return uIdResolver;
}


public void setuIdResolver(int uIdResolver) {
	this.uIdResolver = uIdResolver;
}


public int getRtType() {
	return rtType;
}


public void setRtType(int rtType) {
	this.rtType = rtType;
}


public int getRtStatus() {
	return rtStatus;
}


public void setRtStatus(int rtStatus) {
	this.rtStatus = rtStatus;
}


public String getrDescription() {
	return rDescription;
}


public void setrDescription(String rDescription) {
	this.rDescription = rDescription;
}


public Timestamp getrSubmmitted() {
	return rSubmmitted;
}


public void setrSubmmitted(Timestamp rSubmmitted) {
	this.rSubmmitted = rSubmmitted;
}


public Timestamp getR_resolved() {
	return r_resolved;
}


public void setR_resolved(Timestamp r_resolved) {
	this.r_resolved = r_resolved;
}


public Blob getR_RECEIPT() {
	return R_RECEIPT;
}


public void setR_RECEIPT(Blob r_RECEIPT) {
	R_RECEIPT = r_RECEIPT;
}


@Override
public String toString() {
	return "ErsReimbursement [rId=" + rId + ", rAmount=" + rAmount + ", uIdAuthor=" + uIdAuthor + ", uIdResolver="
			+ uIdResolver + ", rtType=" + rtType + ", rtStatus=" + rtStatus + ", rDescription=" + rDescription
			+ ", rSubmmitted=" + rSubmmitted + ", r_resolved=" + r_resolved + ", R_RECEIPT=" + R_RECEIPT + "]";
}















}
