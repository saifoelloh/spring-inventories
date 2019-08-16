package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ItemPurchaseKey implements Serializable {
    @Column(name = "item_id")
    private String itemId;

    @Column(name = "purchase_id")
    private String purchaseId;

    public ItemPurchaseKey() {
    }

    public ItemPurchaseKey(String itemId, String purchaseId) {
        this.itemId = itemId;
        this.purchaseId = purchaseId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }
}
