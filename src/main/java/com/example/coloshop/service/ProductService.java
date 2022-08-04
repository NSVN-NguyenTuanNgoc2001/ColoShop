package com.example.coloshop.service;

import com.example.coloshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);
    void save(Product product);
    Iterable<Product>findAllByCategoryId(int id);
    Iterable<Product>findAllByPriceBetween(float from,float to);
    Iterable<Product>findAllBySaleBetween(float from,float to);
}
