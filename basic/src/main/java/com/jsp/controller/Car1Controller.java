package com.jsp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.entity.Car1;

@RestController
public class Car1Controller {
	
	@PostMapping("/carImp")
	public Car1 carImp(@RequestBody Car1 car1) {
		return car1;
	}
}
