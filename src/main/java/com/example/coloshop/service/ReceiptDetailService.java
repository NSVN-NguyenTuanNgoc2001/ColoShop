package com.example.coloshop.service;

import com.example.coloshop.model.ReceiptDetail;

public interface ReceiptDetailService {
    void save(ReceiptDetail receiptDetail);
    Iterable<ReceiptDetail>findAllByReceiptId(int id);
}
