package com.CustomerProduct.CustomerProduct.service;

import com.CustomerProduct.CustomerProduct.entity.Customer;

public interface CustomerService {
    Customer SaveCustomer(Customer customer);
    Customer getCustomerById(int customerId);
}




