package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private List<Action> actions;

    // standard constructors / setters / getters / toString

    public CashRegister() {
    }

    public CashRegister(long id, String shopName, List<Action> actions) {
        this.id = id;
        this.shopName = shopName;
        this.actions = actions;
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

    @JsonManagedReference
    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "CashRegister{" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", actions=" + actions +
                '}';
    }
}
