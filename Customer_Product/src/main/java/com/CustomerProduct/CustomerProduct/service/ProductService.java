package com.CustomerProduct.CustomerProduct.service;

import com.CustomerProduct.CustomerProduct.entity.Customer;
import com.CustomerProduct.CustomerProduct.entity.Product;

public interface ProductService {
    Product assignProductToCustomerId( Product product, int customerId);
    boolean deleteProduct(int productId);
}
