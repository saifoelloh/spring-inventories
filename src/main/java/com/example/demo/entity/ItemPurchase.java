package com.example.demo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Embeddable
public class ItemPurchase {

    @EmbeddedId
    ItemPurchaseKey id;

    @ManyToOne
    @MapsId("item_id")
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @MapsId("purchase_id")
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    @CreationTimestamp
    private LocalDateTime created_at;
}
