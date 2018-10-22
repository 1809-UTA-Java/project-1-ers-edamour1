package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.revature.model.ErsReimbursement;
import com.revature.model.ErsReimbursementStatus;
import com.revature.model.ErsReimbursementType;
import com.revature.model.ErsUsers;
import com.revature.util.HibernateUtil;

public class AcceptOrDenyServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ErsUsers k = (ErsUsers) request.getAttribute("name");
		//ErsUsers j = (ErsUsers) getServletContext().getAttribute("user");
		PrintWriter writer = response.getWriter();
		
		ArrayList<ErsReimbursement> listRimburse;
		ArrayList<ErsReimbursementStatus> listStatus;
		ArrayList<ErsReimbursementType> listType;
		ArrayList<ErsUsers> listUsers;
		Session session = HibernateUtil.getSession();
	    
        String queryString = "from ErsUsers";
        
        ErsUsers user = (ErsUsers) getServletContext().getAttribute("user");
          
        ErsReimbursement resolvedInfo; 
        ErsReimbursementStatus status;
        ErsReimbursementType type;
        
        listRimburse  = (ArrayList<ErsReimbursement>) session.createQuery("from ErsReimbursement").list();
		writer.println("<!DOCTYPE html>\n" + 
				"<html>\n" + 
				
				"<head>\n" + 
				 
				"<meta charset=\"UTF-8\">\n" + 
				
				"<title>Pending</title>\n" + 
				
				"</head>\n" + 
				
				"<body>\n" + 
				
				"<h1>Pending</h1>\n");
		
		//listStatus = (ArrayList<ErsReimbursementStatus>) session.createQuery("from ErsReimbursementStatus where rsId = :sVar").setString("sVar","1").list();
		
		for(ErsReimbursement accepted: listRimburse) {
			listStatus = (ArrayList<ErsReimbursementStatus>) session.createQuery("from ErsReimbursementStatus where rsId = :sVar").setString("sVar",accepted.getRtStatus()+"").list();
			listType = (ArrayList<ErsReimbursementType>) session.createQuery("from ErsReimbursementType where rtId = :sVar").setString("sVar",accepted.getRtType()+"").list();
			listUsers = (ArrayList<ErsUsers>) session.createQuery("from ErsUsers where uId = :sVar").setString("sVar",accepted.getuIdAuthor()+"").list();
			user = listUsers.get(0);
			status = listStatus.get(0);
			type = listType.get(0);
	
			
			if(accepted.getRtStatus() == 0) {
			writer.println("<h2>"+status.getRsStatus()+"</h2>");
			writer.println("<p> Type: "+type.getRtType()+"</p>");
			writer.println("<p> Amount: $"+accepted.getrAmount()+"</p>");
			writer.println("<p> Description: "+accepted.getrDescription()+"</p>");
			writer.println("<p> Requested By: "+user.toString()+"</p>");
			writer.println("<p> Date Submitted: "+accepted.getrSubmmitted().toString()+"</p>");
			writer.println("<P>Enter 1 to Accept or 2 to Deny</P>");
			
			writer.println(
			"<form action = \"AcceptDenyPending\" method = \"post\">\n" + 
			"Request Id: <input type=\"text\" name=\"id\" value=\""+accepted.getrId()+"\"><br>\n" + 
			"<input type=\"text\" name=\"choice\"><br>\n" + 
			"<button type=\"submit\">Commit</button>\n" +
			"</form>");
	
			}//end of if statement 
		}//end of for each loop
		writer.println(				
				"</body>\n" + 
				
				"</html>");
		
		writer.close();
		
	}//end of doPost method
	
}
