package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;
import java.sql.Blob;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*; 

import com.revature.model.ErsReimbursement;

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
		Date date = new Date();
		int amount = Integer.parseInt(request.getParameter("amount"));
		String description =request.getParameter("Description");
		
		reimburementRequest.setrAmount(amount);
		reimburementRequest.setrDescription(description);
		reimburementRequest.setRtStatus(3);
		//reimburementRequest.set
		
		PrintWriter writer = response.getWriter();
		
		writer.println(amount + 10);
		
		writer.close();
	
	}//end of doPost method

}
