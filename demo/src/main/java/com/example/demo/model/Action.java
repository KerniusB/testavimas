package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "Action")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Action implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long inOut;
    private String date;
    private long amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cashRegisterId")
    private CashRegister cashRegister;

    // standard constructors / setters / getters / toString

    public Action() {
    }

    public Action(long id, long inOut, String date, long amount, CashRegister cashRegister) {
        this.id = id;
        this.inOut = inOut;
        this.date = date;
        this.amount = amount;
        this.cashRegister = cashRegister;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getInOut() {
        return inOut;
    }

    public void setInOut(long inOut) {
        this.inOut = inOut;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public CashRegister getCashRegister() {
        return cashRegister;
    }

    public void setCashRegister(CashRegister cashRegister) {
        this.cashRegister = cashRegister;
    }

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", inOut=" + inOut +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                ", cashRegister=" + cashRegister +
                '}';
    }
}
