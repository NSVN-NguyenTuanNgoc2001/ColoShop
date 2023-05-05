package com.example.coloshop.controller;

import com.example.coloshop.model.Product;
import com.example.coloshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    /**
     * get all product
     */
    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll(@PageableDefault(size =12) Pageable pageable)
    {
        Iterable<Product> products=productService.findAll(pageable);
        if(products==null)
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * tìm kiểm theo loại sản phẩm
     */
    @GetMapping("/search-by-cateId")
    public ResponseEntity<Iterable<Product>> findAllByCateId(@PageableDefault(size =12)Pageable pageable,@RequestParam int id) {
        Iterable<Product> products=productService.findAllByCategoryId(pageable,id);
        if(products==null)
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * tìm kiểm theo khoảng giá
     */

    @GetMapping("/price-between")
    public ResponseEntity<Iterable<Product>>findAllByPriceBetween(@RequestParam float from,@RequestParam float to)
    {
        Iterable<Product> products=productService.findAllByPriceBetween(from,to);
        if(products==null)
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    //bet sale tất cả những sản phẩm đc sale thì cho vào best sale
    @GetMapping("/sale-between")
    public ResponseEntity<Iterable<Product>>findAllBySaleBetween(@RequestParam float from,@RequestParam float to)
    {
        Iterable<Product> products=productService.findAllBySaleBetween(from,to);
        if(products==null)
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //search theo tên
    @GetMapping("/name-between")
    public ResponseEntity<Iterable<Product>>searchByName(@RequestParam String name)
    {
//        Iterable<Product> products=productService.findAllBySaleBetween(from,to);
//        if(products==null)
//            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(products, HttpStatus.OK);
        return null;
    }

    //admin
    //thêm sản phẩm
    @PostMapping("/add-product")
    public void addProduct(@RequestParam Product product)
    {
//        Iterable<Product> products=productService.findAllBySaleBetween(from,to);
//        if(products==null)
//            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(products, HttpStatus.OK);
//        return null;
    }

    //admin
    //xóa sản phẩm(thay đổi trạng thái của sản phẩm)
    public void deleteProduct(@RequestParam Long productId)
    {
//        Iterable<Product> products=productService.findAllBySaleBetween(from,to);
//        if(products==null)
//            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(products, HttpStatus.OK);
//        return null;
    }

    //admin vs user
    //search sản phẩm bán chạy
    @GetMapping
    public ResponseEntity<Iterable<Product>> searchProductSelling (@PageableDefault(size =12) Pageable pageable)
    {
        return null;
    }


}
