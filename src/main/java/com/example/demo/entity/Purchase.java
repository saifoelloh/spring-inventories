package com.example.demo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private float discount;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    @ManyToOne
    @JoinColumn
    private Customer customer;

    @OneToMany
    @JoinColumn
    private Bucket bucket;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Bucket.class, mappedBy = "item", cascade = CascadeType.ALL)
    @JoinColumn
    private List<Item> items;

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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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
