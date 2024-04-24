package org.test.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.test.model.Persons;
import org.test.model.Users;

@Controller
public class LoginController extends ParentController implements PersonInterface {
	
	
	public LoginController() {
		System.out.println("LoginController Object Created");
	}

	
	
	@RequestMapping(value = "/validatelogin", method = RequestMethod.POST)
	public ModelAndView validateLogin(HttpServletRequest req , HttpServletResponse res) {
		 
	         Map m = new HashMap();
	         
	         String username = req.getParameter("username");
	         String password = req.getParameter("password");
	         HttpSession httpsession = req.getSession();
	         
	         
	         Users user = loginService.getUser(username, password);
        	  
	         
	         
	         
        	System.out.println("Validate Method Exicute");
        	
        	if (user!=null) {
        		httpsession.setAttribute("LoginUserName", user.getName());
        		httpsession.setAttribute("LoginUserId", user.getId());
        		
        		 m.put("ActionValue","./submitperson");
        		 m.put("ButtonValue","SUBMIT");
        		 m.put("PersonList", personService.getPerson());
        		 System.out.println("Home Method Exicute ");
				
        		return  new ModelAndView("index",m);
        		
			} else {
				
				m.put("ErrorMessage", "Invalid username and password! try again.....");
				
				return  new ModelAndView("login",m);

			}
		
	}
	
}
