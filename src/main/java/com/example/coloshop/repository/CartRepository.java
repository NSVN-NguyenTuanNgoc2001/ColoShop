package com.example.coloshop.repository;

import com.example.coloshop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    Iterable<Cart>findAllByUserIdAndStatus(int id,int status);
    Iterable<Cart>findAllByUserId(int userId);
    void deleteById(int id);
    Cart findByProductIdAndUserId(int productId,int userId);
    Cart findById(int id);
    Iterable<Cart>findAllByProduct_ProductTypeUserIdAndStatus(int userId,int status);

    List<Cart> findAllByProductId(int id);
}
