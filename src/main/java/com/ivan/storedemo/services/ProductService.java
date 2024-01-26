package com.ivan.storedemo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ivan.storedemo.models.Product;
import com.ivan.storedemo.repositories.ProductRepository;

import jakarta.annotation.PostConstruct;


@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

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
    // products.add(new Product("huevos", 100));
    // products.add(new Product("leche", 50));
    // products.add(new Product("cereal", 60));
    // products.add(new Product(productName, Double.parseDouble(productPrice)));
  }

  public List<Product> getAllProducts() {
    List<Product> products = productRepository.findAll();
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

  public List<Product> getProductsByName(String name){
    //test with criteria builder with JPASpecificationExecutor
    List<Product> products = productRepository.findAll((product, cq, cb) -> cb.equal(product.get("name"), name));
    return products;
  }

}
