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

public class ViewRequestResolvedDaoServlet extends HttpServlet{
	
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
		ArrayList<ErsUsers> listResolvers;
		Session session = HibernateUtil.getSession();
	    
        String queryString = "from ErsUsers";
        
        ErsUsers user = (ErsUsers) getServletContext().getAttribute("user");
          
        ErsReimbursement resolvedInfo; 
        ErsReimbursementStatus status;
        ErsReimbursementType type;
    
        listRimburse  = (ArrayList<ErsReimbursement>) session.createQuery("from ErsReimbursement where uIdAuthor = :uVar").setString("uVar",user.getuId()+"").list();
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
			
			status = listStatus.get(0);
			type = listType.get(0);
	
			
			if(accepted.getRtStatus() == 0) {
			writer.println("<h2>"+status.getRsStatus()+"</h2>");
			writer.println("<p> Type: "+type.getRtType()+"</p>");
			writer.println("<p> Amount: $"+accepted.getrAmount()+"</p>");
			writer.println("<p> Description: "+accepted.getrDescription()+"</p>");
			writer.println("<p> Date Submitted: "+accepted.getrSubmmitted().toString()+"</p>");
	
			}//end of if statement 
		}//end of for each loop
		writer.println(				
				"</body>\n" + 
				
				"</html>");
		
		writer.close();
		
	}//end of doPost method

}
