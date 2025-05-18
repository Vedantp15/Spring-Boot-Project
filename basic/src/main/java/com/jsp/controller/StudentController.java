package com.jsp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.entity.Student;

@RestController
public class StudentController {

	@PostMapping("/std")
	public String studentInfo(@RequestBody Student student) {
		return "Student Id Is: "+student.getId()+" Student Name Is: "+student.getName()+" Student Age Is: "+student.getAge();
	}
}
