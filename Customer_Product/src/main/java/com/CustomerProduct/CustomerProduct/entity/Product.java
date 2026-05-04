// productId  - int(auto-generated primary key)
// productName - String
// price - double
// customer - Customer(ManyToOne, JsonBackReference)
// Implement getters, setters, and constructors for the Team and Player entities.
package com.CustomerProduct.CustomerProduct.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Integer productId;

    private String productName;
    private double price;

    @ManyToOne
    @JsonBackReference
    private Customer customer;

    public Product() {
    }

    public Product(Integer productId, String productName, double price, Customer customer) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.customer = customer;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    



}



    // @Id
    // @GeneratedValue
    // private Integer productId;

    // private String productName;

    // private double price;

    // @ManyToOne
    // @JsonBackReference
    // private Customer customer;

    // public Product() {
    // }

    // public Product(Integer productId, String productName, double price, Customer customer) {
    //     this.productId = productId;
    //     this.productName = productName;
    //     this.price = price;
    //     this.customer = customer;
    // }

    // public Integer getProductId() {
    //     return productId;
    // }

    // public void setProductId(Integer productId) {
    //     this.productId = productId;
    // }

    // public String getProductName() {
    //     return productName;
    // }

    // public void setProductName(String productName) {
    //     this.productName = productName;
    // }

    // public double getPrice() {
    //     return price;
    // }

    // public void setPrice(double price) {
    //     this.price = price;
    // }

    // public Customer getCustomer() {
    //     return customer;
    // }

    // public void setCustomer(Customer customer) {
    //     this.customer = customer;
    // }
