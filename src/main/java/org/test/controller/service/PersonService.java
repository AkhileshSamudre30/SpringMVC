package org.test.controller.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.hql.ast.tree.BooleanLiteralNode;
import org.springframework.stereotype.Service;
import org.test.controller.PersonInterface;
import org.test.model.Persons;

@Service
public class PersonService implements PersonInterface {
	
	public PersonService() {
		
		System.out.println("Person Service Object Creted ");
		
	}

	
	public boolean  savePerson( Persons person ) {
		
		try {
			 
        	Session ses= sessionFactory.openSession();
        	ses.beginTransaction();
        	ses.save(person);
        	ses.getTransaction().commit();
        	
			return true ;
			
		} catch (Exception e) {
			
			return false ; 
			
		}
	}	
	
public boolean  updatePerson( Persons person ) {
		
		try {
			 
        	Session ses= sessionFactory.openSession();
        	ses.beginTransaction();
        	ses.update(person);
        	ses.getTransaction().commit();
        	
			return true ;
			
		} catch (Exception e) {
			
			return false ; 
			
		}
	}	
	public List<Persons>  getPerson() {
		
		try {
			 
        	Session ses= sessionFactory.openSession();
        	ses.beginTransaction();
        	Query query  = ses.createQuery("from Persons where status=1");
        	
        	List<Persons> personList = query.list();
        	ses.getTransaction().commit();
        	
			return personList ;
			
		} catch (Exception e) {
			
			return null ; 
			
		}
		
		
		
	}
	public Persons  getPerson(int id ) {
		
		try {
			 
        	Session ses= sessionFactory.openSession();
        	ses.beginTransaction();
        	Persons persons =(Persons) ses.get(Persons.class, id);
        	ses.getTransaction().commit();
        	
			return persons ;
			
		} catch (Exception e) {
			
			return null ; 
			
		}
		
		
		
	}
}
