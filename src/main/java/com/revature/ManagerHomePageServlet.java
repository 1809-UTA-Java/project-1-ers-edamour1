package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.ErsUsers;

public class ManagerHomePageServlet extends HttpServlet{
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ErsUsers k = (ErsUsers) request.getAttribute("name");
		//ErsUsers j = (ErsUsers) getServletContext().getAttribute("user");
		PrintWriter writer = response.getWriter();
	
		writer.println("<!DOCTYPE html>\n" + 
				"<html>\n" + 
				
				"<head>\n" + 
				
				"<meta charset=\"UTF-8\">\n" + 
				
				"<title></title>\n" + 
				
				"</head>\n" + 
				
				"<body>\n" + 
				
				"<h1>Manager Homepage</h1>\n" + 
				
				"<h1>Menu</h1>\n" + 
				
				"<nav>\n" + 
				"<form action = \"ManagerViewReso\" method = \"post\">\n" + 
				"<button type=\"submit\">View Resolved</button>\n" +
				"</form>\n" + 
				
				"<form action = \"AcceptDeny\" method = \"post\">\n" + 
				"<button type=\"submit\">View Pending</button>\n" +
				"</form>\n" + 
				
				"</nav>\n" + 
				
				"</body>\n" + 
				
				"</html>");
		
		writer.close();
		
	}//end of doPost method

}
