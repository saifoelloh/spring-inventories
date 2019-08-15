package com.example.demo.repository;

import com.example.demo.entity.Bucket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BucketRepository extends CrudRepository<Bucket, String> {
}
