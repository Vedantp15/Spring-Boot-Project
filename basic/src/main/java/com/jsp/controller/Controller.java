package com.jsp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //annotation is used to create RESTful web services. It is a specialized
				 // version of @Controller that simplifies the development of REST APIs by combining @Controller and @ResponseBody.
public class Controller {
	
	@GetMapping("/info")
	public String info() {
		return "The First program using spring boot app.";
	}
	
}
