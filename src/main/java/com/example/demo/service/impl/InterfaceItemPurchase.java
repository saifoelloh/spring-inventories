package com.example.demo.service.impl;

import com.example.demo.entity.ItemPurchase;

import java.util.List;
import java.util.Optional;

public interface InterfaceItemPurchase {
    List<ItemPurchase> findAll();
    Optional<ItemPurchase> findById(String id);
    boolean addBucket(ItemPurchase itemPurchase);
    boolean deleteById(String id);
}
