package com.example.coloshop.service.Impl;

import com.example.coloshop.model.Cart;
import com.example.coloshop.repository.CartRepository;
import com.example.coloshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public Iterable<Cart> getNumberCart(int id,int status) {
        return cartRepository.findAllByUserIdAndStatus(id,status);
    }

    @Override
    public void deleteCart(int id) {
        cartRepository.deleteById(id);
    }
}
