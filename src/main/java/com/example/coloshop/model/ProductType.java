package com.example.coloshop.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class ProductType {
    //bảng nhà cung cấp của sản phẩm
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private int status;

    @OneToMany(mappedBy = "productType",cascade = CascadeType.ALL,orphanRemoval = true)
    private Collection<Product> products;

    public ProductType() {
    }

    public ProductType(int id, String name, User user, int status, Collection<Product> products) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.status = status;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
