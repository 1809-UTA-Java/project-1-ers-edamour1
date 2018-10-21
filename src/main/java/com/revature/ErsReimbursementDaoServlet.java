package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*; 
import java.time.LocalDateTime;
import com.revature.model.ErsReimbursement;
import com.revature.model.ErsUsers;
import com.revature.util.HibernateUtil;

public class ErsReimbursementDaoServlet extends HttpServlet{
	
	int rId, rAmount, uIdAuthor, uIdResolver,rtType,rtStatus;

	String rDescription;

	Timestamp rSubmmitted, r_resolved;

	Blob R_RECEIPT;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		ErsReimbursement reimburementRequest = new ErsReimbursement();
		
		ArrayList<ErsReimbursement> l;
		   
		String queryString = "from ErsUsers";
		   
		Session session = HibernateUtil.getSession();
	        
	    l = (ArrayList<ErsReimbursement>) session.createQuery(queryString).list();
		
		LocalDateTime dateTime = LocalDateTime.now();
		
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		String description =request.getParameter("Description");
		
		ErsUsers currentUser = (ErsUsers) getServletContext().getAttribute("user");
		
		System.out.println(request.getParameter("travel"));
		
		reimburementRequest.setrId(l.size()+1);
		reimburementRequest.setrAmount(amount);
		reimburementRequest.setrDescription(description);
		reimburementRequest.setRtStatus(1);
		reimburementRequest.setuIdAuthor(currentUser.getuId());
		reimburementRequest.setrSubmmitted(java.sql.Timestamp.valueOf(dateTime));
		//reimburementRequest.set
		
		
		Transaction tx = session.beginTransaction();
		
	session.save(reimburementRequest);
		
		tx.commit();
		
		
		//PrintWriter writer = response.getWriter();
		
		//writer.println(amount + 10);
		
		//writer.close();
	
	}//end of doPost method

}
