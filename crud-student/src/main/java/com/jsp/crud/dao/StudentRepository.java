package com.jsp.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.crud.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
