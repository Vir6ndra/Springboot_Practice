package com.CustomerProduct.CustomerProduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CustomerProduct.CustomerProduct.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
