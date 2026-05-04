package com.CustomerProduct.CustomerProduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerProduct.CustomerProduct.entity.Product;
import com.CustomerProduct.CustomerProduct.service.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl proService;

    // POST - "/product/customer/{customerId}" - Returns response status 201 with a product object on successfully mapping the product to the customerId or else 500.


    @PostMapping("/customer/{customerId}")
    public ResponseEntity<Product> addProductToCustomer(@RequestBody Product product, @PathVariable int customerId){
        Product product2 = proService.assignProductToCustomerId(product, customerId);
        if(product2 != null){
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // // Delete - "/product/{productId}  -  Returns response status 200 with String "Product deleted successfully" on successful deletion or else "Product not found with ID "+productId. 

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> RemoveProduct(@PathVariable int productId){
        if(proService.deleteProduct(productId)){
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Product not found with ID "+ productId, HttpStatus.OK);
        }
    }

}




//     @Autowired
//     private ProductServiceImpl proService;

//     @PostMapping("/customer/{customerId}")
//     public ResponseEntity<Product> assignProduct(@PathVariable int customerId, @RequestBody Product product){
//         Product product2 =  proService.assignProductToCustomer(product, customerId);
//         if(product2 != null){
//             return new ResponseEntity<>(product2, HttpStatus.CREATED);
//         }else{
//             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//         }
//     }

// // POST - "/product/customer/{customerId}" - Returns response status 201 with a product object on successfully mapping the product to the customerId or else 500.
//     @DeleteMapping("/{productId}")
//     public ResponseEntity<String> deleteProduct(@PathVariable int productId){
//         boolean deleted = proService.deleteProduct(productId);
//         if(deleted){
//             return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
//         }else{
//             return new ResponseEntity("Product not found with ID "+productId, HttpStatus.OK);
//         }
//     }

// // Delete - "/product/{productId}  -  Returns response status 200 with String "Product deleted successfully" on successful deletion or else "Product not found with ID "+productId. 

