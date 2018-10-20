package com.revature;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.revature.model.userRoles;
import com.revature.util.HibernateUtil;

/**
 * Servlet implementation class ersServlet
 */
@WebServlet("/servlet/*")
public class ersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ersServlet() {
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String username, password;
		
		username = request.getParameter("username");
		password = request.getParameter("password");
		
		PrintWriter writer = response.getWriter();
		userRoles u = null;
		
		Session session = HibernateUtil.getSession();
		
		u = (userRoles) session.get(userRoles.class, 1);
		
		if(username.equals(u.getUrRole()) && password.equals("work")) {
		
			writer.println("Welcome");
			request.setAttribute("name", u.getUrRole());
			
			RequestDispatcher rd = request.getRequestDispatcher("home");
			
			rd.forward(request, response);
		}else{
			writer.println("Invalid username or passeword");
		}//end of else statement
				
	}//end of doPost method
	
}//end of ersServlet class 
