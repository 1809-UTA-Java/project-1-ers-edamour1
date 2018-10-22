package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.ErsReimbursement;
import com.revature.model.ErsUsers;
import com.revature.util.HibernateUtil;

public class pendingDaoServlet extends HttpServlet{
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		PrintWriter writer = response.getWriter();
		
		ArrayList<ErsReimbursement> listRimburse;
		Session session = HibernateUtil.getSession();
		String id, choice;
		int idNum, choiceNum;
		ErsUsers manager = (ErsUsers) getServletContext().getAttribute("user");

		
		id = request.getParameter("id");
		idNum = Integer.parseInt(id);
		choice = request.getParameter("choice");
		choiceNum = Integer.parseInt(choice);
		
		listRimburse = (ArrayList<ErsReimbursement>) session.createQuery("from ErsReimbursement").list();
		
		Transaction tx = session.beginTransaction();
		
		for(ErsReimbursement e: listRimburse) {
			if(e.getrId() == idNum){
				e.setRtStatus(choiceNum);
				e.setuIdResolver(manager.getuId());
				session.update(e);
				session.getTransaction();
			}
		}
		
		tx.commit();
		
		writer.println("Request Status upadated");

	}//end of doPost method

}
