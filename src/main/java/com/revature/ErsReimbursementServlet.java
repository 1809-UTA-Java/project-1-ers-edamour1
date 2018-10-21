package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class ErsReimbursementServlet extends HttpServlet {
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		
		writer.println("<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"<meta charset=\"UTF-8\">\n" + 
				"<title>reimbursement</title>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"<h1>File For Reimbursement</h1>\n" + 
				"\n" + 
				"\n" + 
				"<form action = \"reimburseDao\" method = \"post\">\n" + 
				"Amount <input type = \"text\" name = \"amount\" /><br/>\n" + 
				"Description <textarea rows=\"4\" cols=\"50\" name = \"Description\">\n" +
				"</textarea>\n" +
				"<select id=\"mySelect\">\n" + 
				"  <option name = \"travel\" value=\"0\">travel</option>\n" + 
				"  <option name = \"meal\" value=\"1\">meal</option>\n" +  
				"</select>"+
				"<button type=\"submit\">Submit Request</button>\n" + 
				"</form>\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"</body>\n" + 
				"</html>");
		writer.close();
	
	}//end of doPost method
}

