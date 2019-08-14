package com.example.demo.entity;

import jdk.jfr.Timestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Timestamp
    private String id;
    private Float discount;

    @ManyToOne
    @JoinColumn
    private Customer customer;

    public Purchase(Float discount) {
        this.discount = discount;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }
}
