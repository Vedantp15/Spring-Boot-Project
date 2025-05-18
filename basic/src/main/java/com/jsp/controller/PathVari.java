package com.jsp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVari {

	@PutMapping("/stdAddress/stdId/{sid}/address/{city}")
	public String displayStdAddress(@PathVariable int sid, @PathVariable String city) {
		return "Student Id Is: "+sid +" He/She Is From: "+city;
	}
}
