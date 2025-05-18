package com.jsp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.jsp.entity.Category;
import com.jsp.repositories.CategoryRepository;

@Repository
public class CategoryDao {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Optional<Category> getCategoryById(int id) {
		return categoryRepository.findById(id);
	}
	
	public List<Category> getAllCategory(Pageable pageable) {
		return categoryRepository.findAll(pageable).getContent();
	}
	
	public Category deleteCategoryById(Category category) {
		categoryRepository.delete(category);
		return category;
	}
}
