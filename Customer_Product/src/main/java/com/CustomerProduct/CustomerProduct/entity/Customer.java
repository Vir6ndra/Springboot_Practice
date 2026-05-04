
// customerId  - int(auto-generated primary key)
// customerName - String
// address - String
// products - List<Product> (OneToMany, mappedBy = "customer", JsonManagedReference)
// Create another class named "Product" with the following attributes:

package com.CustomerProduct.CustomerProduct.entity;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String customerName;
    private String address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Product> products;

    public Customer() {
    }

    public Customer(Integer customerId, String customerName, String address, List<Product> products) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.products = products;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    
}





    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Integer customerId;

    // private String customerName;

    // private String address;

    // @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    // @JsonManagedReference
    // private List<Product> product;


    // public Customer() {
    // }

    // public Customer(Integer customerId, String customerName, String address, List<Product> product) {
    //     this.customerId = customerId;
    //     this.customerName = customerName;
    //     this.address = address;
    //     this.product = product;
    // }

    // public Integer getCustomerId() {
    //     return customerId;
    // }

    // public void setCustomerId(Integer customerId) {
    //     this.customerId = customerId;
    // }

    // public String getCustomerName() {
    //     return customerName;
    // }

    // public void setCustomerName(String customerName) {
    //     this.customerName = customerName;
    // }

    // public String getAddress() {
    //     return address;
    // }

    // public void setAddress(String address) {
    //     this.address = address;
    // }

    // public List<Product> getProduct() {
    //     return product;
    // }

    // public void setProduct(List<Product> product) {
    //     this.product = product;
    // }
