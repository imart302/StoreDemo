package com.ivan.storedemo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ivan.storedemo.models.Product;
import com.ivan.storedemo.services.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/api/v1/store")
public class StoreController {

  @Autowired
  private ProductService productService;

  @GetMapping("/")
  public String helloWorld(){
    return "Hello World";
  }

  @GetMapping("/product")
  public List<Product> getProducts(){
    return productService.getAllProducts();    
  }

  @GetMapping("/product/{name}")
  public Product getProduct(@PathVariable String name){
    Product product = productService.getProduct(name);
    return product;
  }

}
