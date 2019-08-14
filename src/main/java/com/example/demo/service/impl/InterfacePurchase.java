package com.example.demo.service.impl;

import com.example.demo.entity.Purchase;

import java.util.List;
import java.util.Optional;

public interface InterfacePurchase {

    List<Purchase> findAll();
    Optional<Purchase> findById(String id);
    boolean addPurchase(Purchase purchase);
    boolean removePurchase(String id);
}
