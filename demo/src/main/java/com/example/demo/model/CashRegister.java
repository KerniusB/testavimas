package com.example.demo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "CashRegister")
public class CashRegister implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String shopName;

    @OneToMany(mappedBy = "cashRegister", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Action> action;

    // standard constructors / setters / getters / toString

    public CashRegister() {
    }

    public CashRegister(long id, String shopName, List<Action> action) {
        this.id = id;
        this.shopName = shopName;
        this.action = action;
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

    public List<Action> getAction() {
        return action;
    }

    public void setAction(List<Action> action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "CashRegister{" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", actions=" + action +
                '}';
    }
}
