package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.ErsUsers;
import com.revature.util.HibernateUtil;

public class RegisterDaoServelet extends HttpServlet{
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		
		int uId, urId;
		
	    ArrayList<ErsUsers> l;
		
		String uUsername, uPassword, uFirstname, uLastname, uEmail;
		
        Session session = HibernateUtil.getSession();
    
        String queryString = "from ErsUsers";
        
        l = (ArrayList<ErsUsers>) session.createQuery(queryString).list();
        
		
		Transaction tx = session.beginTransaction();
		uUsername = request.getParameter("username");
		uPassword  = request.getParameter("password");
		uFirstname = request.getParameter("firstname");
		uLastname = request.getParameter("lastname");  
		uEmail = request.getParameter("email");
		ErsUsers newUser = new ErsUsers();
		
		newUser.setuUsername(uUsername);
		newUser.setuPassword(uPassword);
		newUser.setuFirstname(uFirstname);
		newUser.setuLastname(uLastname);
		newUser.setuEmail(uEmail);
		newUser.setUrId(l.size()+2);
		newUser.setuId(l.size()+1);
		
		session.save(newUser);
		
		tx.commit();
		
	
	}//end of doPost method

}
