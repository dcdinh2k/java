package com.luv2code.springdemo.mvc;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWordController {
	//	need a controller method to show the initial HTML FORM
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloword-form";
	}
	//	need a controller method to process the HTML Form	
	@RequestMapping("/processForm")
	public String showProcessForm() {
		return "helloword";
	}
	
	// new a controller method to read form data and add data to model
	@RequestMapping("/processFormV2")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// read the request parameter from the HTML Form
		String theName = request.getParameter("studentName");
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Hello " + theName;
		
		// add message to model		
		model.addAttribute("message", result);
		
		return "helloword";
	}
	
	@RequestMapping("/processFormV3")
	public String processFormV3(@RequestParam("studentName") String theName,
			Model model) {
		

		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Hello From V3! " + theName;
		
		// add message to model		
		model.addAttribute("message", result);
		
		return "helloword";
	}
}
