package com.ivan.storedemo.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ivan.storedemo.models.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class CustomProductRepository {

  private EntityManager em;

  public List<Product> searchProduct(Optional<Float> price, Optional<String> name){
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Product> cq = cb.createQuery(Product.class);
    Root<Product> from = cq.from(Product.class);
    
    ArrayList<Predicate> predicates = new ArrayList<>();
    if(price.isPresent()){
      Predicate pricePredicate = cb.equal(from.get("price"), price.get());
      predicates.add(pricePredicate);
    }
    if(name.isPresent()){
      Predicate namePredicate = cb.equal(from.get("name"), name.get());
      predicates.add(namePredicate);
    }

    cq.select(from).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
    List<Product> products = em.createQuery(cq).getResultList();
  
    return products;
  }

}
