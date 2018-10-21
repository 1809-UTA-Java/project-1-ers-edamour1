package com.revature;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Session;

import com.revature.model.ErsUsers;
import com.revature.util.HibernateUtil;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

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
		boolean canLogin = false;
		username = request.getParameter("username");
		password = request.getParameter("password");
		
		PrintWriter writer = response.getWriter();
		ArrayList<ErsUsers> userInfo;
		ErsUsers current;
		Session session = HibernateUtil.getSession();
		
		canLogin = verified(username, password, session);
		
		if(canLogin) {
			userInfo = (ArrayList<ErsUsers>) session.createQuery("from ErsUsers where uUsername = :uVar and uPassword = :pVar").setString("uVar",username).setString("pVar", password).list();
			current = userInfo.get(0);
		
			writer.println(userInfo.size());
			RequestDispatcher rd = request.getRequestDispatcher("home");		
			request.setAttribute("name", userInfo.get(0));
			
			getServletContext().setAttribute("user",userInfo.get(0));
	
			rd.forward(request, response);
		}else{
			writer.println("Invalid username or passeword");
		}//end of else statement
				
	}//end of doPost method
	
	protected static boolean verified(String username, String password, Session session) {
		ArrayList<ErsUsers> usernames;
		usernames = (ArrayList<ErsUsers>) session.createQuery("from ErsUsers").list();
		ErsUsers currentInfo;
		
		for(ErsUsers loginInfo: usernames) {
	
			if(loginInfo.getuUsername().equals(username) && loginInfo.getuPassword().equals(password)) {
			
				return true;
			}//end of if statement
		}//end of for loop 
		return false;
	}//end of verified statement 
	

	
}//end of ersServlet class 
