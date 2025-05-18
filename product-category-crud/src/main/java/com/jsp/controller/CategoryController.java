package com.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.dto.ResponseStructure;
import com.jsp.entity.Category;
import com.jsp.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Category>> saveCategory(@RequestBody Category category) {
		return categoryService.saveCategory(category);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Category>> getCategoryById(@PathVariable int id) {
		return categoryService.getCategoryById(id);
	}

	@GetMapping()
	public ResponseEntity<ResponseStructure<List<Category>>> getAllCategory(@RequestParam int page) {
		return categoryService.getAllCategory(PageRequest.of(page-1, 2));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<Category>> updateCategoryById(@PathVariable int id, @RequestBody Category category) {
		return categoryService.updateCategoryById(id, category);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Category>> deleteCategoryById(@PathVariable int id){
		return categoryService.deleteCategoryById(id);
	}
}
