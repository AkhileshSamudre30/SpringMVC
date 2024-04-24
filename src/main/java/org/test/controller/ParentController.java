package org.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.test.controller.service.LoginService;
import org.test.controller.service.PersonService;

public class ParentController {
	
	
	@Autowired
	public PersonService personService; 
	
	
	@Autowired
	public LoginService  loginService;

}
