package com.jsp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReqHeader {
	
	@PostMapping("/stdImp")
	public String studentInfo(@RequestHeader("id") int id) {
		return "Student Id Is: "+id;
	}
}
