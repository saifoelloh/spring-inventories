package com.example.demo.service.impl;

import com.example.demo.entity.Bucket;

import java.util.List;
import java.util.Optional;

public interface InterfaceBucket {
    List<Bucket> findAll();
    Optional<Bucket> findById(String id);
    boolean addBucket(Bucket bucket);
    boolean deleteById(String id);
}
