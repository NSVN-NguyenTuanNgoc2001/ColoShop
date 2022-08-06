package com.example.coloshop.service.Impl;

import com.example.coloshop.model.ReceiptDetail;
import com.example.coloshop.repository.ReceiptDetailRepository;
import com.example.coloshop.service.ReceiptDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptDetailServiceImpl implements ReceiptDetailService {
    @Autowired
    private ReceiptDetailRepository receiptDetailRepository;
    @Override
    public void save(ReceiptDetail receiptDetail) {
        receiptDetailRepository.save(receiptDetail);
    }

    @Override
    public Iterable<ReceiptDetail> findAllByReceiptId(int id) {
        return receiptDetailRepository.findAllByReceipt_Id(id);
    }
}
