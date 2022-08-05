package com.example.coloshop.service.Impl;

import com.example.coloshop.model.ReceiptDetail;
import com.example.coloshop.repository.ReceiptDetailRepository;
import com.example.coloshop.service.ReceiptDetailService;
import org.springframework.beans.factory.annotation.Autowired;

public class ReceiptDetailServiceImpl implements ReceiptDetailService {
    @Autowired
    private ReceiptDetailRepository receiptDetailRepository;
    @Override
    public void save(ReceiptDetail receiptDetail) {
        receiptDetailRepository.save(receiptDetail);
    }
}
