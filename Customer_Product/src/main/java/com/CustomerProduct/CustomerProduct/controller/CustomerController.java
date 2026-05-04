package com.CustomerProduct.CustomerProduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerProduct.CustomerProduct.entity.Customer;
import com.CustomerProduct.CustomerProduct.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl custService;

    @PostMapping
    public ResponseEntity<Customer> CreateCustomer(@RequestBody Customer customer){
        Customer customer2 = custService.SaveCustomer(customer);
        if(customer2 != null){
            return new ResponseEntity<>(customer, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

// // GET - "/customer/{customerId}" - Returns response status 200 with customer object, which includes details of the product on successful retrieval or else 404.

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int customerId){
        Customer customer = custService.getCustomerById(customerId);

        if(customer != null){
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    


}





    // @Autowired
    // private CustomerServiceImpl cusService;

    // // POST - "/customer" - Returns response status 201 with customer object on successful creation or else 500.

    // @PostMapping
    // public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
    //     customer = cusService.saveCustomer(customer);
    //     if(customer != null){
    //         return new ResponseEntity<>(customer, HttpStatus.CREATED);
    //     }else{
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }

    // }


    // // GET - "/customer/{customerId}" - Returns response status 200 with customer object, which includes details of the product on successful retrieval or else 404.

    // @GetMapping("/{customerId}")
    // public ResponseEntity<Customer> getCustomer(@PathVariable int customerId){
    //     Customer customer = cusService.getCustomerById(customerId);
    //     if(customer!=null){
    //         return new ResponseEntity(customer,HttpStatus.OK);
    //     }else{
    //         return new ResponseEntity(HttpStatus.NOT_FOUND);
    //     }

    // }


