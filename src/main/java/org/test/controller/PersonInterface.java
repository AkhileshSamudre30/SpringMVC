package org.test.controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public interface PersonInterface {
	
	
	public  static SessionFactory sessionFactory = getSessionFactory();
	
	public static SessionFactory getSessionFactory() {
		
		SessionFactory	sf =new  Configuration().configure("org/test/controller/hibernate.cfg.xml").buildSessionFactory();
		
	      return sf;
	}

}
