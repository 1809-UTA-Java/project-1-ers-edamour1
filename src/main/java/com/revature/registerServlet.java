package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register/*")
public class registerServlet extends HttpServlet{
	
	
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
				"<title>register</title>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"<h1>Register</h1>\n" + 
				"\n" + 
				"\n" + 
				"<form action = \"regDao\" method = \"post\">\n" + 
				"Username <input type = \"text\" name = \"username\" /><br/>\n" + 
				"Username <input type = \"text\" name = \"verifyusername\" /><br/>\n" + 
				"Password <input type = \"text\" name = \"password\" /><br/>\n" + 
				"Password <input type = \"text\" name = \"verifypassword\" /><br/>\n" +
				"Firstname <input type = \"text\" name = \"firstname\" /><br/>\n" + 
				"Lastname <input type = \"text\" name = \"lastname\" /><br/>\n" + 
				"Email <input type = \"text\" name = \"email\" /><br/>\n" + 
				"<button type = \"submit\"> submit </button> \n" + 
				"</form>\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"</body>\n" + 
				"</html>");
		
		writer.close();
		
	}//end of doPost method
	

}
