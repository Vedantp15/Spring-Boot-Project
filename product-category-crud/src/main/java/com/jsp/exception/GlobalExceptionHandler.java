package com.jsp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jsp.dto.ResponseStructure;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleDoesNotExistException(DoesNotExistException doesNotExistException){
		ResponseStructure<String> responseStructure = new ResponseStructure<>(HttpStatus.NOT_FOUND.value(), "not found", doesNotExistException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
}
