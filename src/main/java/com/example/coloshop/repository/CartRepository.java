package com.example.coloshop.repository;

import com.example.coloshop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    Iterable<Cart>findAllByUserIdAndStatus(int id,int status);
    void deleteById(int id);
}
