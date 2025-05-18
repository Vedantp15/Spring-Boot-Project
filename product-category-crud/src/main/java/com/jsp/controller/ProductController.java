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
import com.jsp.entity.Product;
import com.jsp.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts(@RequestParam int page) {
		return productService.getAllProducts(PageRequest.of(page-1, 2));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> updateProductById(@PathVariable int id, @RequestBody Product product) {
		return productService.updateProductById(id, product);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> deleteProductById(@PathVariable int id) {
		return productService.deleteProductById(id);
	}

}
