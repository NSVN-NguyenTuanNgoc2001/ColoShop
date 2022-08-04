package com.example.coloshop.model;

import javax.persistence.*;

@Entity
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private User user;
    //mã hóa đơn nếu ng dùng thanh toán
    //còn k có thì nó chỉ là cart mà thôi
    private String name;
    private String sdt;
    private float money;
    private String status;
    private int number;

    public Receipt() {
    }

    public Receipt(int id, User user, String name, String sdt, float money, String status, int number) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.sdt = sdt;
        this.money = money;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
