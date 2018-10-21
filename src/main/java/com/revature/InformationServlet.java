package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.ErsUsers;

public class InformationServlet extends HttpServlet{
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ErsUsers user = (ErsUsers) getServletContext().getAttribute("user");
		
		PrintWriter writer = response.getWriter();
		
		writer.println("<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"<meta charset=\"UTF-8\">\n" + 
				"<title>register</title>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"<h1>Personal Information</h1>\n" + 
				"\n" + 
				"\n" + 
				"<form action = \"infoDao\" method = \"post\">\n" +  
				"  First name: <input type=\"text\" name=\"fname\" value=\""+user.getuFirstname()+"\"><br>\n" + 
				"  Last name: <input type=\"text\" name=\"lname\" value=\""+user.getuLastname()+"\"><br>\n" + 
				"  User name: <input type=\"text\" name=\"uname\" value=\""+user.getuUsername()+"\"><br>\n" + 
				"  Password: <input type=\"text\" name=\"pword\" value=\""+user.getuPassword()+"\"><br>\n" + 
				"  Email: <input type=\"text\" name=\"email\" value=\""+user.getuEmail()+"\"><br>\n" + 
				"<button type=\"submit\">Submit Changes</button>\n" +
				"</form>"+
				"\n" + 
				"\n" + 
				"\n" + 
				"</body>\n" + 
				"</html>");
		
		writer.close();
		
	}//end of doPost method

}
