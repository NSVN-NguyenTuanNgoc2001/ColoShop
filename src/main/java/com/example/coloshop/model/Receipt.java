package com.example.coloshop.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Receipt {
    //khi người dùng đặt hàng sẽ vào bảng này
    //status bawnfg2 là ng bán đã xác nhận đơn hàng
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receipt_id")
    private User user;
    //mã hóa đơn nếu ng dùng thanh toán
    //còn k có thì nó chỉ là cart mà thôi

    private String sdt;

    private int status;
    private int number;

    @OneToMany(mappedBy = "receipt",cascade = CascadeType.ALL,orphanRemoval = true)
    private Collection<ReceiptDetail> receiptDetailSet;

    public Receipt() {
    }

    public Receipt(int id, User user, String sdt, int status, int number, Collection<ReceiptDetail> receiptDetailSet) {
        this.id = id;
        this.user = user;
        this.sdt = sdt;
        this.status = status;
        this.number = number;
        this.receiptDetailSet = receiptDetailSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Collection<ReceiptDetail> getReceiptDetailSet() {
        return receiptDetailSet;
    }

    public void setReceiptDetailSet(Collection<ReceiptDetail> receiptDetailSet) {
        this.receiptDetailSet = receiptDetailSet;
    }
}
