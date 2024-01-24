package com.ivan.storedemo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ivan.storedemo.models.Product;

import jakarta.annotation.PostConstruct;


@Service
public class ProductService {
  private static final ArrayList<Product> products = new  ArrayList<>();

  // static {
  //   products.add(new Product("huevos", 100));
  //   products.add(new Product("leche", 50));
  //   products.add(new Product("cereal", 60));
  // }

  @Value("${com.ivan.storedemo.product.name}")
  private String productName;
  @Value("${com.ivan.storedemo.product.price}")
  private String productPrice;

  @PostConstruct
  public void init(){
    products.add(new Product("huevos", 100));
    products.add(new Product("leche", 50));
    products.add(new Product("cereal", 60));
    products.add(new Product(productName, Double.parseDouble(productPrice)));
  }

  public ArrayList<Product> getAllProducts() {
    return products;
  }

  public Product getProduct(String name) {
    Product productMatch = products
      .stream()
      .filter( 
        (product) -> product.getName().equals(name))
      .findFirst()
      .get();
    return productMatch;
  }

}
