package com.example.demo.service;

import com.example.demo.entity.Purchase;
import com.example.demo.repository.PurchaseRepository;
import com.example.demo.service.impl.InterfacePurchase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PurchaseService implements InterfacePurchase {

    @Autowired
    private PurchaseRepository repository;

    @Override
    public List<Purchase> findAll() {
        return (List<Purchase>) repository.findAll();
    }

    @Override
    public Optional<Purchase> findById(String id) {
        return (Optional<Purchase>) repository.findById(id);
    }

    @Override
    public boolean addPurchase(Purchase purchase) {
        try {
            repository.save(purchase);
            return true;
        } catch (Exception error) {
            throw error;
        }
    }

    @Override
    public boolean removePurchase(String id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception error) {
            throw error;
        }
    }
}
