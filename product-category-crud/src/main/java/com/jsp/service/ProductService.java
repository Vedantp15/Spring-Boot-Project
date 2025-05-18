package com.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.dao.CategoryDao;
import com.jsp.dao.ProductDao;
import com.jsp.dto.ResponseStructure;
import com.jsp.entity.Category;
import com.jsp.entity.Product;
import com.jsp.exception.DoesNotExistException;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private CategoryDao categoryDao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		Optional<Category> optional = categoryDao.getCategoryById(product.getCategoryId());
		if (optional.isPresent()) {
			product.setCategory(optional.get());
			Product prod = productDao.saveProduct(product);
			ResponseStructure<Product> responseStructure = new ResponseStructure<Product>(HttpStatus.CREATED.value(),"success", prod);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.CREATED);
		}
		throw new DoesNotExistException("Category With The Id: " + product.getCategoryId() + " :Does not Exists");

	}

	public ResponseEntity<ResponseStructure<Product>> getProductById(int id) {
		Optional<Product> optional = productDao.getProductById(id);
		if (optional.isPresent()) {
			Product product = optional.get();
			ResponseStructure<Product> responseStructure = new ResponseStructure<Product>(HttpStatus.OK.value(),"success", product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		}
		throw new DoesNotExistException("Product With The Id: " + id + " Does Not Exist");
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts(Pageable pageable){
		List<Product> list =  productDao.getAllProducts(pageable);
		if(!(list.isEmpty())) {
			
			ResponseStructure<List<Product>> responseStructure = new ResponseStructure<List<Product>>(HttpStatus.OK.value(), "success", list);
			return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure, HttpStatus.OK);
		}
		throw new DoesNotExistException("Product With The Does Not Exist");
	}
	
	public ResponseEntity<ResponseStructure<Product>> updateProductById(int id, Product product){
		Optional<Product> optional = productDao.getProductById(id);
		if(optional.isPresent()) {
			Optional<Category> optional2 = categoryDao.getCategoryById(product.getCategoryId());
			
			if(optional2.isPresent()) {
				product.setCategory(optional2.get());
				product.setId(id);
				Product prod = productDao.saveProduct(product);
				ResponseStructure<Product> responseStructure = new ResponseStructure<Product>(HttpStatus.OK.value(),"success", prod);
				return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
			}
			throw new DoesNotExistException("Category With The Id: " + product.getCategoryId() + " :Does not Exists");
		}
		throw new DoesNotExistException("Product With The Does Not Exist");
	}
	
	public ResponseEntity<ResponseStructure<Product>> deleteProductById(int id){
		Optional<Product> optional = productDao.getProductById(id);
			if(optional.isPresent()) {
				Product product = optional.get();
				productDao.deleteProductById(product);
				ResponseStructure<Product> responseStructure = new ResponseStructure<Product>(HttpStatus.OK.value(),"success", product);
				return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
			}
		throw new DoesNotExistException("Product With The Does Not Exist");
	}

}