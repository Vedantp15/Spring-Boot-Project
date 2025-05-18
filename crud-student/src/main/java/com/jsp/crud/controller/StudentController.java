package com.jsp.crud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.crud.dao.StudentDao;
import com.jsp.crud.entity.ResponseStructure;
import com.jsp.crud.entity.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentDao studentDao;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student) {
		Student std = studentDao.saveStudent(student);
		ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
		responseStructure.setStatusCode(200);
		responseStructure.setMessage("Successfully Inserted");
		responseStructure.setT(std);
		return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Student>> getById(@PathVariable int id) {
		Optional<Student> optional = studentDao.getStudent(id);
		if(optional.isPresent()) {
			Student student = optional.get();
			ResponseStructure<Student> responseStructure = new ResponseStructure<Student>(200, "Successfully Fetched", student);
			return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.OK);
		}
		ResponseStructure<Student> responseStructure = new ResponseStructure<Student>(404, "not found", null);
		return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping
	public Student updateStudent(@RequestBody Student student) {
		return studentDao.updateStudent(student);
	}
	
	@DeleteMapping
	public void deleteStudent(@PathVariable int id) {
		studentDao.deleteStudent(id);
	}
	
}
