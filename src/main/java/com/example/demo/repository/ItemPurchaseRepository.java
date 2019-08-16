package com.example.demo.repository;

import com.example.demo.entity.ItemPurchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPurchaseRepository extends CrudRepository<ItemPurchase, String> {
}
