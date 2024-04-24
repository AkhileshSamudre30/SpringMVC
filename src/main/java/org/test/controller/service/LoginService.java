package org.test.controller.service;

import java.util.List;

import org.apache.catalina.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.test.controller.PersonInterface;
import org.test.model.Users;

@Service
public class LoginService  implements PersonInterface{
	
	public Users getUser ( String username , String password) {
		
		
		Session session = sessionFactory.openSession();
   	    session.beginTransaction();
   	
		
   	    Query query = session.createQuery("from Users where status=1 and email='"+username+"' and password='"+password+"'");
   	    
   	    session.getTransaction().commit();
		
   	    List<Users> userList = query.list(); 	
   	    
   	    if (!userList.isEmpty()) {
   	    	
   	    	return userList.get(0);
			
		} else {
             return null;
		}
	}
}
