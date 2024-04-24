package org.test.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.test.model.Persons;

@Controller
public class PersonController extends ParentController implements PersonInterface {

	public PersonController() {
		System.out.println("controller Is Created");
	}
	
	   
	
//	@RequestMapping(value = "/" , method = RequestMethod.GET)
//	public ModelAndView home (HttpServletRequest req , HttpServletResponse res) {
//         Map m = new HashMap();
//		 
//        // System.out.println("Autowired Object Is created"+personService);
//         
//         
//		 m.put("ActionValue","./submitperson");
//		 m.put("ButtonValue","SUBMIT");
//		 m.put("PersonList", personService.getPerson());
//		 System.out.println("Home Method Exicute ");
//		
//		return  new ModelAndView("index",m);
//	}
	
	@RequestMapping(value = "/submitperson", method = RequestMethod.POST)
	public ModelAndView submitPerson (HttpServletRequest req , HttpServletResponse res) {
		
		 Map m = new HashMap();
		 
		 m.put("ActionValue","./submitperson");
		 m.put("ButtonValue","SUBMIT");
		 
		 String name = req.getParameter("name");
		 String age = req.getParameter("age");
		 String phone = req.getParameter("phone");
		 
		 m.put("NameValue",name);
		 m.put("AgeValue", age);
		 m.put("PhoneValue", phone);
		 
		 if(name.isEmpty()) {
			 
			 m.put("ErrorValue","OOPSS.......Please Enter Name");
			 
		 }
		 else if(age.isEmpty()) {
			 
			 m.put("ErrorValue","OOPSS.......Please Enter Age");
			 
		 }
         else if(phone.isEmpty()) {
			 
			 m.put("ErrorValue","OOPSS.......Please Enter Phone");
			 
		 }
         else {
        	 
        	 
        	 Persons person  = new Persons();
        	 person.setName(name);
        	 person.setAge(Integer.parseInt(age));
        	 person.setPhone(Long.parseLong(phone));
        	 person.setCreated(new Date());
        	 person.setModified(new Date());
        	 person.setStatus(1);
        	 
        	  
        	 
        	  boolean result = personService.savePerson(person);
      
        	if (result) {
        		 m.put("SuccessValue","Person Added SuccessFully");	
	           	 m.put("NameValue","");
	       		 m.put("AgeValue", "");
	       		 m.put("PhoneValue", "");
				
			} else {
				 m.put("ErrorValue","Sorry....Record Not Submmited");
				

			}
        	
        	 
        	 
         }
		
		 System.out.println("SubmitPerson Method Exicute ");
		 m.put("PersonList", personService.getPerson());
		return  new ModelAndView("index",m);
	}
	
	
	  @RequestMapping(value = "/getupdateperson", method = RequestMethod.GET)
	  public ModelAndView getUpdatePerson(HttpServletRequest req , HttpServletResponse res) {
		   
		    Map  m = new HashMap<>();
		    String id = req.getParameter("id");
		    
		    Persons persons = personService.getPerson(Integer.parseInt(id));
		     m.put("IdValue",persons.getId());
		     m.put("NameValue",persons.getName());
			 m.put("AgeValue", persons.getAge());
			 m.put("PhoneValue", persons.getPhone());
			 m.put("PersonList", personService.getPerson());
		    
			 
			 m.put("ActionValue","./updateperson");
			 m.put("ButtonValue","UPDATE");
		  
		  return  new ModelAndView("index",m);
		  
	  }
	  @RequestMapping(value = "/getdeleteperson", method = RequestMethod.GET)
	  public ModelAndView getDeletePerson(HttpServletRequest req , HttpServletResponse res) {
		   
		    Map  m = new HashMap<>();
		    String id = req.getParameter("id");
		    
		    Persons persons = personService.getPerson(Integer.parseInt(id));
		     m.put("IdValue",persons.getId());
		     m.put("NameValue",persons.getName());
			 m.put("AgeValue", persons.getAge());
			 m.put("PhoneValue", persons.getPhone());
			 m.put("PersonList", personService.getPerson());
		    
			 
			 m.put("ActionValue","./deleteperson");
			 m.put("ButtonValue","DELETE");
		  
		  return  new ModelAndView("index",m);
		  
	  }
	
	  @RequestMapping(value = "/updateperson", method = RequestMethod.POST)
		public ModelAndView updatePerson(HttpServletRequest req , HttpServletResponse res) {
			
			 Map m = new HashMap();
			 String name = req.getParameter("name");
			 String age = req.getParameter("age");
			 String phone = req.getParameter("phone");
			 
			
			 m.put("NameValue",name);
			 m.put("AgeValue", age);
			 m.put("PhoneValue", phone);
			 
			 if(name.isEmpty()) {
				 
				 m.put("ErrorValue","OOPSS.......Please Enter Name");
				 
			 }
			 else if(age.isEmpty()) {
				 
				 m.put("ErrorValue","OOPSS.......Please Enter Age");
				 
			 }
	         else if(phone.isEmpty()) {
				 
				 m.put("ErrorValue","OOPSS.......Please Enter Phone");
				 
			 }
	         else {
	        	 
	        	 
	        	  
	        	 String id = req.getParameter("id");
	        	 
	        	 Persons person = personService.getPerson(Integer.parseInt(id));
	        	 
	        	 person.setName(name);
	        	 person.setAge(Integer.parseInt(age));
	        	 person.setPhone(Long.parseLong(phone));
	        	 person.setModified(new Date());
	        	 
	        	  
	        	 
	        	  boolean result = personService.updatePerson(person);
	      
	        	if (result) {
	        		 m.put("SuccessValue","Person Updated SuccessFully");	
		           	 m.put("NameValue","");
		       		 m.put("AgeValue", "");
		       		 m.put("PhoneValue", "");
					
				} else {
					 m.put("ErrorValue","Sorry....Record Not Updated");
					

				}
	        	
	        	 
	        	 
	         }
			
			 
			 m.put("ActionValue","./submitperson");
			 m.put("ButtonValue","SUBMIT");
			 m.put("PersonList", personService.getPerson());
			 
			return  new ModelAndView("index",m);
		}
	
	  @RequestMapping(value = "/deleteperson", method = RequestMethod.POST)
		public ModelAndView deletePerson(HttpServletRequest req , HttpServletResponse res) {
			 
		         Map m = new HashMap();
	        	 
	        	  
	        	 String id = req.getParameter("id");
	        	 
	        	 Persons person = personService.getPerson(Integer.parseInt(id));
	        	 
	        	 person.setStatus(0);
	        	 person.setModified(new Date());
	        	 
	        	  
	        	 
	        	  boolean result = personService.updatePerson(person);
	      
	        	if (result) {
	        		 m.put("SuccessValue","Person Deleted SuccessFully");	
		           	 m.put("NameValue","");
		       		 m.put("AgeValue", "");
		       		 m.put("PhoneValue", "");
					
				} else {
					 m.put("ErrorValue","Sorry....Record Not Deleted");
					

				}
	        	
			 m.put("ActionValue","./submitperson");
			 m.put("ButtonValue","SUBMIT");
			 m.put("PersonList", personService.getPerson());
			 
			return  new ModelAndView("index",m);
		}
}
