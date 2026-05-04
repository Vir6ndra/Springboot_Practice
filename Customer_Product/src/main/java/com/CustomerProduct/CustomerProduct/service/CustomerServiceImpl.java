package com.CustomerProduct.CustomerProduct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomerProduct.CustomerProduct.entity.Customer;
import com.CustomerProduct.CustomerProduct.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepo cusRepo;

    @Override
    public Customer SaveCustomer(Customer customer) {
        return cusRepo.save(customer);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        if(cusRepo.existsById(customerId)){
            return cusRepo.findById(customerId).get();
        }else{
            return null;
        }
        
    }

}




    // @Autowired
    // private CustomerRepo cusRepo;

    // @Override
    // public Customer getCustomerById(int customerId) {
    //     if(cusRepo.existsById(customerId)){
    //         return cusRepo.findById(customerId).get();
    //     }else{
    //         return null;
    //     }
    // }

    // @Override
    // public Customer saveCustomer(Customer customer) {
    //     return cusRepo.save(customer);
    // }



