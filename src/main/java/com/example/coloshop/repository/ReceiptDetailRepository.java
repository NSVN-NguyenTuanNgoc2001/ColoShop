package com.example.coloshop.repository;

import com.example.coloshop.model.ReceiptDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptDetailRepository extends JpaRepository<ReceiptDetail, Integer> {
    Iterable<ReceiptDetail>findAllByReceipt_Id(int id);
    Iterable<ReceiptDetail>findAllByProduct_ProductTypeUserId(int userId);
}
