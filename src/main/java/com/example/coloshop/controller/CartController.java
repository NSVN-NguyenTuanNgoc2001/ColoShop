package com.example.coloshop.controller;

import com.example.coloshop.model.Cart;
import com.example.coloshop.repository.CartRepository;
import com.example.coloshop.service.CartService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/cart")
public class CartController {
    private static Logger logger=Logger.getLogger(CartController.class);
    @Autowired
    private CartService cartService;
    @Autowired
    private CartRepository cartRepository;
    @PostMapping("/add-cart")
    public ResponseEntity findAllByStatus(@RequestBody Cart cart)
    {
        cartService.save(cart);
        logger.info("Add product cart");
        return new ResponseEntity(cart, HttpStatus.OK);
    }
    @GetMapping("/search-by-status")
    public ResponseEntity<Iterable<Cart>> findAllByStatus(@RequestParam int id, @RequestParam int status)
    {
        Iterable<Cart> carts=cartService.getNumberCart(id,status);
        if(carts==null)
            return new ResponseEntity<>(carts, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCart(@PathVariable int id)
    {
        boolean check= cartRepository.existsById(id);//kiểm tra xem id này có không
        if(check){
            cartService.deleteCart(id);
            logger.info("delete cart by id");
            return new ResponseEntity(HttpStatus.OK);
        }
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
