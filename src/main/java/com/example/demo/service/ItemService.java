package com.example.demo.service;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.impl.InterfaceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements InterfaceItem {

    @Autowired
    private ItemRepository repository;

    @Override
    public List<Item> findAll() {
        return (List<Item>) repository.findAll();
    }

    @Override
    public Optional<Item> findById(String id) {
        return (Optional<Item>) repository.findById(id);
    }

    @Override
    public boolean addItem(Item item) {
        try {
            repository.save(item);
            return true;
        } catch (Exception err) {
            throw err;
        }
    }

    @Override
    public boolean removeItem(String id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception err) {
            throw err;
        }
    }
}
