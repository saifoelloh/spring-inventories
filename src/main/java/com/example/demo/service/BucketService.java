package com.example.demo.service;

import com.example.demo.entity.Bucket;
import com.example.demo.repository.BucketRepository;
import com.example.demo.service.impl.InterfaceBucket;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BucketService implements InterfaceBucket {

    @Autowired
    private BucketRepository repository;

    @Override
    public List<Bucket> findAll() {
        return (List<Bucket>) repository.findAll();
    }

    @Override
    public Optional<Bucket> findById(String id) {
        return (Optional<Bucket>) repository.findById(id);
    }

    @Override
    public boolean addBucket(Bucket bucket) {
        try {
            repository.save(bucket);
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
