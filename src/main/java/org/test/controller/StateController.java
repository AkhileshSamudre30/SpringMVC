package org.test.controller;

import org.springframework.stereotype.Controller;

@Controller
public class StateController implements PersonInterface {

	public StateController() {
		System.out.println("State Controller Object Is Creadted");
	}
	
}
