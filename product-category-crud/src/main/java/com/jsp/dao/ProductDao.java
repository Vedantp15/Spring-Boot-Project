package com.jsp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.jsp.entity.Product;
import com.jsp.repositories.ProductRepository;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepository productRepository;

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Optional<Product> getProductById(int id) {
		return productRepository.findById(id);
	}
	
	public List<Product> getAllProducts(Pageable pageable) {
		 return productRepository.findAll(pageable).getContent();
	}
	
	public void deleteProductById(Product product) {
		productRepository.delete(product);
	}

}