package com.example.coloshop.repository;

import com.example.coloshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findAll(Pageable pageable);
    Page<Product>findAllByCategoryId(Pageable pageable,int id);
    Iterable<Product>findAllByPriceBetween(float from,float to);
    Iterable<Product>findAllBySaleBetween(float from,float to);
}
