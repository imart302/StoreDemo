package com.ivan.storedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivan.storedemo.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
  
}
