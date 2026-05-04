package com.CustomerProduct.CustomerProduct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomerProduct.CustomerProduct.entity.Customer;
import com.CustomerProduct.CustomerProduct.entity.Product;
import com.CustomerProduct.CustomerProduct.repository.CustomerRepo;
import com.CustomerProduct.CustomerProduct.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepo proRepo;

    @Autowired
    private CustomerRepo cusRepo;

    @Override
    public Product assignProductToCustomerId(Product product, int customerId) {
        if(cusRepo.existsById(customerId)){
            Customer cust = cusRepo.findById(customerId).get();
            product.setCustomer(cust);
            return proRepo.save(product);
        }else{
            return null;
        }
        
    }

    @Override
    public boolean deleteProduct(int productId) {
        if(proRepo.existsById(productId)){
            proRepo.deleteById(productId);
            return true;
        }
        return false;
    }
    
}




    // @Autowired
    // private ProductRepo proRepo;

    // @Autowired
    // private CustomerRepo cusRepo;

    // @Override
    // public Product assignProductToCustomer(Product product, int customerId) {
    //     if(cusRepo.existsById(customerId)){
    //         Customer cust = cusRepo.findById(customerId).get();
    //         product.setCustomer(cust);
    //         return proRepo.save(product);
    //     }
    //     return null;
    // }

    // @Override
    // public boolean deleteProduct(int productId) {
    //     if(proRepo.existsById(productId)){
    //         proRepo.deleteById(productId);
    //         return true;
    //     }
    //     return false;

    // }

