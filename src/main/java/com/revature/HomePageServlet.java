package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.revature.model.ErsUsers;
import com.revature.model.userRoles;
import com.revature.util.HibernateUtil;

/**
 * Servlet implementation class ersServlet
 */
@WebServlet("/home/*")
public class HomePageServlet extends HttpServlet {
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
				
				"<h1>Employee Homepage</h1>\n" + 
				
				"<h1>Menu</h1>\n" + 
				
				"<nav>\n" + 
				"<form action = \"reimburse\" method = \"post\">\n" + 
				"<button type=\"submit\">reimbursement requests</button>\n" +
				"</form>\n" + 
				
				
				"<form action = \"info\" method = \"post\">\n" + 
				"<button action = \"information\" type=\"submit\">View Information</button>\n" + 
				"</form>\n" + 
				
				"<button type=\"button\">logout</button>\n" + 	
				"</nav>\n" + 
				
				"</body>\n" + 
				
				"</html>");
		
		writer.close();
		
	}//end of doPost method
	
	
	
}//end of InformationServlet class
