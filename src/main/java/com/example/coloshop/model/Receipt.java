package com.example.coloshop.model;

import javax.persistence.*;

@Entity
public class Receipt {
    //khi người dùng đặt hàng sẽ vào bảng này
    //status bawnfg2 là ng bán đã xác nhận đơn hàng
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private User user;
    //mã hóa đơn nếu ng dùng thanh toán
    //còn k có thì nó chỉ là cart mà thôi

    private String sdt;

    private int status;
    private int number;

    public Receipt() {
    }

    public Receipt(int id, User user, String sdt, int status, int number) {
        this.id = id;
        this.user = user;

        this.sdt = sdt;

        this.status = status;
        this.number = number;
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
}
