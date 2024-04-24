package org.test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	public HomeController() {
	   System.out.println("The HomeController Created Object");
	}
	
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public ModelAndView home (HttpServletRequest req , HttpServletResponse res) {
         Map m = new HashMap();
		 
        // System.out.println("Autowired Object Is created"+personService);
         
         
		// m.put("ActionValue","./submitperson");
		// m.put("ButtonValue","SUBMIT");
		// m.put("PersonList", personService.getPerson());
		 System.out.println("Home Method Exicute ");
		
		return  new ModelAndView("login",m);
	}
}
