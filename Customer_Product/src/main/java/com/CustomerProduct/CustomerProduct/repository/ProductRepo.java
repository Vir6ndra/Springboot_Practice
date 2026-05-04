package com.CustomerProduct.CustomerProduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CustomerProduct.CustomerProduct.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
