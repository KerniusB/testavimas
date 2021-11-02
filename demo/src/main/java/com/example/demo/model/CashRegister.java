package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "CashRegister")
public class CashRegister implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;
    @Column(nullable = false)
    private String shopName;

    // standard constructors / setters / getters / toString

    public CashRegister() {
    }

    public CashRegister(String shopName) {
        this.shopName = shopName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public String toString() {
        return "CashRegister{" +
                "id=" + id +
                ", name='" + shopName + '\'' +
                '}';
    }
}
