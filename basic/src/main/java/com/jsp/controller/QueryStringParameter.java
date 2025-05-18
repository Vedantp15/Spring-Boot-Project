package com.jsp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryStringParameter {

	@PostMapping("/stdinfo")
	public String displayStdInfo(@RequestParam(name="id") int sid, @RequestParam(name="sname") String name) {
		return "Student Id Is: "+sid+" Student Name Is: "+name;
	}
}
