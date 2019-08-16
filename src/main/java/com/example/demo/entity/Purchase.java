package com.example.demo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private float discount;

    @ManyToOne
    @JoinColumn
    private Customer customer;

    @OneToMany(mappedBy = "purchase")
    List<ItemPurchase> itemPurchases;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    public Purchase() {    }

    public Purchase(float discount) {
        this.discount = discount;
    }

    public Purchase(float discount, Customer customer) {
        this.discount = discount;
        this.customer = customer;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id='" + id + '\'' +
                ", discount=" + discount +
                ", customer=" + customer.getName() +
                '}';
    }
}
