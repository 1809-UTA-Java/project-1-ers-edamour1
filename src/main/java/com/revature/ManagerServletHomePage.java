package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.ErsUsers;

public class ManagerServletHomePage extends HttpServlet{

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
				
				"<title>Reimbursement Manager</title>\n" + 
				
				"</head>\n" + 
				
				"<body>\n" + 
				
				"<h1>Requests</h1>\n" + 
				
				"<h1>Menu</h1>\n" + 
				
				"<nav>\n" + 
				"<form action = \"ViewPend\" method = \"post\">\n" + 
				"<button type=\"submit\">Resolved</button>\n" +
				"</form>\n" + 
				
				"<form action = \"ViewResolve\" method = \"post\">\n" + 
				"<button action = \"Request Status\" type=\"submit\">Pending</button>\n" + 
				"</form>\n" + 
				
				"<form action = \"ViewResolve\" method = \"post\">\n" + 
				"<button action = \"Request Status\" type=\"submit\">Pending</button>\n" + 
				"</form>\n" + 
				
				"<button type=\"button\">logout</button>\n" + 	
				"</nav>\n" + 
				
				"</body>\n" + 
				
				"</html>");
		
		writer.close();
		
	}//end of doPost method
}
