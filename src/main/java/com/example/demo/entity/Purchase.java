package com.example.demo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @CreationTimestamp
    @UpdateTimestamp
    private String id;
    private Float discount;

    @ManyToOne
    @JoinColumn
    private Customer customer;

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }
}
