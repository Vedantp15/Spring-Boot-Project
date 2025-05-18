package com.jsp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.entity.Car;

@RestController
public class CarController {

	@PostMapping("/carInfo")
	public Car carInfo(@RequestBody Car car) {
		return car;
	}
}