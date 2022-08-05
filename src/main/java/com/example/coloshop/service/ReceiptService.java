package com.example.coloshop.service;

import com.example.coloshop.model.Receipt;

public interface ReceiptService {
    Iterable<Receipt>findAllCart(int id,int status);
}
