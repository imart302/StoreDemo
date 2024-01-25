package com.ivan.storedemo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

  @Column
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  @Column
  private String name;
  
  @Column
  private double price;
  
  public Product(){

  }
  
  public Product(long id, String name, double price) {
    
    this.id = id;
    this.name = name;
    this.price = price;

  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public double getPrice() {
    return price;
  }
  public void setPrice(double price) {
    this.price = price;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

}
