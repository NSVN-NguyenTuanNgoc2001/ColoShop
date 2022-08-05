package com.example.coloshop.service.Impl;

import com.example.coloshop.model.Receipt;
import com.example.coloshop.repository.ReceiptRepository;
import com.example.coloshop.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    @Autowired
    private ReceiptRepository repository;


    @Override
    public Iterable<Receipt> findAllCart(int id,int status) {
        return repository.findAllByUserIdAndStatus(id,status);
    }
}
