package com.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.dao.CategoryDao;
import com.jsp.dto.ResponseStructure;
import com.jsp.entity.Category;
import com.jsp.exception.DoesNotExistException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	public ResponseEntity<ResponseStructure<Category>> saveCategory(Category category) {
		Category cat = categoryDao.addCategory(category);
		ResponseStructure<Category> responseStructure = new ResponseStructure<Category>(HttpStatus.CREATED.value(), "success", cat);
		return new ResponseEntity<ResponseStructure<Category>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Category>> getCategoryById(int id) {
		Optional<Category> optional = categoryDao.getCategoryById(id);
		if(optional.isPresent()) {
			Category category = optional.get();
			ResponseStructure<Category> responseStructure = new ResponseStructure<Category>(HttpStatus.OK.value(), "success", category);
			return new ResponseEntity<ResponseStructure<Category>>(responseStructure, HttpStatus.OK);
		}
		throw new DoesNotExistException("Category With The Id: "+id+" Does Not Exist.");
	}
	
	public ResponseEntity<ResponseStructure<List<Category>>> getAllCategory(Pageable pageable){
		List<Category> list = categoryDao.getAllCategory(pageable);
		if (!(list.isEmpty())) {
			ResponseStructure<List<Category>> responseStructure = new ResponseStructure<List<Category>>(HttpStatus.OK.value(), "success", list);
			return new ResponseEntity<ResponseStructure<List<Category>>>(responseStructure, HttpStatus.OK);
		}
		throw new DoesNotExistException("None of The Category Exists.");
		
	}
	
	public ResponseEntity<ResponseStructure<Category>> updateCategoryById(int id, Category category){
		Optional<Category> optional = categoryDao.getCategoryById(id);
		if(optional.isPresent()) {
			category.setId(id);
			Category cat = categoryDao.addCategory(category);
			ResponseStructure<Category> responseStructure = new ResponseStructure<Category>(HttpStatus.OK.value(), "success", cat);
			return new ResponseEntity<ResponseStructure<Category>>(responseStructure, HttpStatus.OK);
		}
		throw new DoesNotExistException("Category With The Id: "+id+" Does Not Exist.");
	}
	
	public ResponseEntity<ResponseStructure<Category>> deleteCategoryById(int id){
		Optional<Category> optional = categoryDao.getCategoryById(id);
		if(optional.isPresent()) {
			Category category = optional.get();
			categoryDao.deleteCategoryById(category);
			ResponseStructure<Category> responseStructure = new ResponseStructure<Category>(HttpStatus.OK.value(), "success", category);
			return new ResponseEntity<ResponseStructure<Category>>(responseStructure, HttpStatus.OK);
		}
		throw new DoesNotExistException("Category With The Id: "+id+" Does Not Exist.");
	}
	
}
