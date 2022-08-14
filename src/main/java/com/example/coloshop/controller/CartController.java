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

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/cart")
public class CartController {
    private static Logger logger=Logger.getLogger(CartController.class);
    @Autowired
    private CartService cartService;
    @Autowired
    private CartRepository cartRepository;
    //lấy ra sản phẩm của người dùng
    @GetMapping
    public ResponseEntity<Cart>findByProductId(@RequestParam int productId,@RequestParam int userId)
    {
        Cart cart=cartRepository.findByProductIdAndUserId(productId,userId);
        if(cart==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(cart,HttpStatus.OK);
    }
    @GetMapping("/id")
    public ResponseEntity<Cart>findByProductId(@RequestParam int id)
    {

            return new ResponseEntity<>(cartRepository.findById(id),HttpStatus.OK);
    }

    @PostMapping("/add-cart")
    public ResponseEntity findAllByStatus(@RequestBody Cart cart)
    {
        cartService.save(cart);
        logger.info("Save product to cart");
        return new ResponseEntity(cart, HttpStatus.OK);
    }
    @PutMapping("/save-number-product")
    public ResponseEntity insertProductNuber(@RequestParam int productId,@RequestParam int userId)
    {
        Cart cart=cartRepository.findByProductIdAndUserId(productId,userId);
        if(cart==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
        {
            cart.setNumber(cart.getNumber()+1);
            cartRepository.save(cart);
            logger.info("Insert successful!");
            return new ResponseEntity(HttpStatus.OK);
        }
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
    @GetMapping("/order")
    public ResponseEntity<Iterable<Cart>>listOrder(@RequestParam int userId,@RequestParam int status)
    {
        Iterable<Cart> carts=cartService.listUserOrder(userId,status);
        if(carts==null)
        {
            logger.info("not found list user order");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else
        {
            logger.info("get list user order successfull!");
            return new ResponseEntity(carts,HttpStatus.OK);
        }
    }
    @PutMapping("/change-status")
    public ResponseEntity changeStatus(@RequestParam int userId)
    {
        //đặt hàng thì tự nhảy vào đây
        Iterable<Cart> carts=cartService.findAllUserId(userId);
        for (Cart i:carts) {
            i.setStatus(2);
            cartRepository.save(i);
        }
        return new ResponseEntity(carts,HttpStatus.OK);

    }
    @PutMapping("/confirm")
    public ResponseEntity confirmOrder(@RequestParam int id)
    {
        Cart carts=cartService.findById(id);
        //nếu đã thêm vào giỏ thì chuyển thành đặt hàng
        //còn k thì chuyển thành xác nhận đơn hàng
        carts.setStatus(carts.getStatus()==1?2:3);
        cartRepository.save(carts);
        return new ResponseEntity(HttpStatus.OK);
    }

}
