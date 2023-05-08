package com.example.coloshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "userTable")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String confirmPassword;
    private boolean enabled = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;

    private String name;

    private String address;

    private String sdt;

    //ảnh
    private String image;

    //ngày sinh
    private Date date;

    private Date dateWorking;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Collection<Comment>comments;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Collection<ProductType>productTypes;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Collection<Receipt> receipts;

    public User(int id, String username, String password, String confirmPassword, boolean enabled, Set<Role> roles, String name, String address, String sdt, String image, Date date, Date dateWorking, Collection<Comment> comments, Collection<ProductType> productTypes, Collection<Receipt> receipts) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.enabled = enabled;
        this.roles = roles;
        this.name = name;
        this.address = address;
        this.sdt = sdt;
        this.image = image;
        this.date = date;
        this.dateWorking = dateWorking;
        this.comments = comments;
        this.productTypes = productTypes;
        this.receipts = receipts;
    }

    public User() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDateWorking() {
        return dateWorking;
    }

    public void setDateWorking(Date dateWorking) {
        this.dateWorking = dateWorking;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public Collection<ProductType> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(Collection<ProductType> productTypes) {
        this.productTypes = productTypes;
    }

    public Collection<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(Collection<Receipt> receipts) {
        this.receipts = receipts;
    }
}
