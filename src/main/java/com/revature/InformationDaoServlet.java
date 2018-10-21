package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.ErsUsers;
import com.revature.util.HibernateUtil;

public class InformationDaoServlet extends HttpServlet{

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		
		Transaction tx = session.beginTransaction();
		
		ErsUsers user = (ErsUsers) getServletContext().getAttribute("user");
		
		PrintWriter writer = response.getWriter();
		String uUsername, uPassword, uFirstname, uLastname, uEmail;
		
		uUsername = request.getParameter("fname");
		uPassword = request.getParameter("lname");
		uFirstname = request.getParameter("uname");
		uLastname = request.getParameter("pword");
		uEmail = request.getParameter("email");
		
		user.setuUsername(uUsername);
		user.setuPassword(uPassword);
		user.setuFirstname(uFirstname);
		user.setuLastname(uLastname);
		user.setuEmail(uEmail);
		
		session.update(user);
		session.getTransaction();
		
		tx.commit();
		
		writer.println("Changes Made!");
		
		writer.close();
		
	}//end of doPost method
}
