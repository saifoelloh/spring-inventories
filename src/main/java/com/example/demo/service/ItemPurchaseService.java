package com.example.demo.service;

import com.example.demo.entity.ItemPurchase;
import com.example.demo.repository.ItemPurchaseRepository;
import com.example.demo.service.impl.InterfaceItemPurchase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ItemPurchaseService implements InterfaceItemPurchase {

    @Autowired
    private ItemPurchaseRepository repository;

    @Override
    public List<ItemPurchase> findAll() {
        return (List<ItemPurchase>) repository.findAll();
    }

    @Override
    public Optional<ItemPurchase> findById(String id) {
        return (Optional<ItemPurchase>) repository.findById(id);
    }

    @Override
    public boolean addBucket(ItemPurchase itemPurchase) {
        try {
            repository.save(itemPurchase);
            return true;
        } catch (Exception error) {
            throw error;
        }
    }

    @Override
    public boolean deleteById(String id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception error) {
            throw error;
        }
    }
}
