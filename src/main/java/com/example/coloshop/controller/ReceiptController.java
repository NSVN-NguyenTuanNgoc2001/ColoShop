package com.example.coloshop.controller;

import com.example.coloshop.model.Product;
import com.example.coloshop.model.Receipt;
import com.example.coloshop.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/receipt")
public class ReceiptController {
    @Autowired
    private ReceiptService receiptService;
    @GetMapping("/search-by-status")
    public ResponseEntity<Iterable<Receipt>> findAllByStatus(@RequestParam int id,@RequestParam int status)
    {
        Iterable<Receipt> receipts=receiptService.findAllCart(id,status);
        if(receipts==null)
            return new ResponseEntity<>(receipts, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(receipts, HttpStatus.OK);
    }
    @PostMapping("/add-cart")
    public ResponseEntity findAllByStatus(@RequestBody Receipt receipt)
    {
        receiptService.save(receipt);
        return new ResponseEntity(receipt,HttpStatus.OK);
    }
}
