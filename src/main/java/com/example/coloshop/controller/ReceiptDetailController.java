package com.example.coloshop.controller;

import com.example.coloshop.model.Receipt;
import com.example.coloshop.model.ReceiptDetail;
import com.example.coloshop.service.ReceiptDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/receipt-details")
public class ReceiptDetailController {
    @Autowired
    private ReceiptDetailService receiptDetail;
    @GetMapping
    public ResponseEntity<Iterable<ReceiptDetail>> findAllByStatus(@RequestParam int id)
    {
        Iterable<ReceiptDetail> receipts=receiptDetail.findAllByReceiptId(id);
        if(receipts==null)
            return new ResponseEntity<>(receipts, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(receipts, HttpStatus.OK);
    }
    @PostMapping("/add-cart")
    public ResponseEntity findAllByStatus(@RequestBody ReceiptDetail receipt)
    {
        receiptDetail.save(receipt);
        return new ResponseEntity(receipt,HttpStatus.OK);
    }
}
