package com.jsp.crud.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.crud.entity.Student;

@Repository
public class StudentDao {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student) ;
	}
	
	public Optional<Student> getStudent(int id) {
		Optional<Student> optional = studentRepository.findById(id);
		return optional;
	}
	
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}
}
