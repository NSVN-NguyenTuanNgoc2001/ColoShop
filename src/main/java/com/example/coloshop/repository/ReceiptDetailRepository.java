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
//    @Modifying
//    @Query(value = "select receipt.id,money,number, product_id from receipt join receipt_detail rd on receipt.id = rd.receipt_id join user_table on user_table.id\n" +
//            "=receipt.user_id where receipt.status=1 and user_table.id=:id", nativeQuery = true)
//    Iterable<ReceiptDetail>cart(@Param("id") Long id);
}
