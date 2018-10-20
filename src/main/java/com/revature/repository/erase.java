package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import org.hibernate.Transaction;

import org.hibernate.Session;

import com.revature.ersServlet;
import com.revature.model.ErsReimbursementStatus;
import com.revature.model.ErsReimbursementType;
import com.revature.model.ErsUsers;
import com.revature.model.userRoles;
import com.revature.util.HibernateUtil;

public class erase {

	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		
		ErsReimbursementStatus u = null;
		
		Session session = HibernateUtil.getSession();
		
		Transaction tx = session.beginTransaction();
		int count;
			ArrayList<ErsUsers> l;
	        String queryString = "from ErsUsers";
	        l = (ArrayList<ErsUsers>) session.createQuery(queryString).list();
	        
	        
System.out.println(l.size());
		
	
		
		

		//session.save(g);
		
		//tx.commit();
		
	//	System.out.println("h = "+g.getuFirstname());
	
		
		//	u = (ErsReimbursementStatus) session.get(ErsReimbursementStatus.class, 0);
		/*	List l = null;
			ErsDao e = new ErsDao();
			l = e.getUserRoles();
			
			u = (userRoles)l.get(1);
			*/
			
		//	System.out.println(u.toString());
	}

}
