package com.example.coloshop.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float price;
    private String imageRoot;
    private String imageFirst;
    private String imageSecond;
    private int number;
    private String description;
    private String title;
    private Date date;
    //trạng thái sản phẩm này còn hay không
    private int status;
    private float sale;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private Collection<Cart> cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
    private Collection<Comment> comments;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
    private Collection<ReceiptDetail>receiptDetails;

    public Product() {
    }

    public Product(int id, float price, String imageRoot, String imageFirst, String imageSecond, int number, String description, String title, Date date, int status, float sale, Collection<Cart> cart, Category category, ProductType productType, Collection<Comment> comments, Collection<ReceiptDetail> receiptDetails) {
        this.id = id;
        this.price = price;
        this.imageRoot = imageRoot;
        this.imageFirst = imageFirst;
        this.imageSecond = imageSecond;
        this.number = number;
        this.description = description;
        this.title = title;
        this.date = date;
        this.status = status;
        this.sale = sale;
        this.cart = cart;
        this.category = category;
        this.productType = productType;
        this.comments = comments;
        this.receiptDetails = receiptDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImageRoot() {
        return imageRoot;
    }

    public void setImageRoot(String imageRoot) {
        this.imageRoot = imageRoot;
    }

    public String getImageFirst() {
        return imageFirst;
    }

    public void setImageFirst(String imageFirst) {
        this.imageFirst = imageFirst;
    }

    public String getImageSecond() {
        return imageSecond;
    }

    public void setImageSecond(String imageSecond) {
        this.imageSecond = imageSecond;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Collection<Cart> getCart() {
        return cart;
    }

    public void setCart(Collection<Cart> cart) {
        this.cart = cart;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public Collection<ReceiptDetail> getReceiptDetails() {
        return receiptDetails;
    }

    public void setReceiptDetails(Collection<ReceiptDetail> receiptDetails) {
        this.receiptDetails = receiptDetails;
    }
}
