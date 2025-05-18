package com.jsp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
