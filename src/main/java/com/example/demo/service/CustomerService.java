package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.impl.InterfaceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements InterfaceCustomer {

    @Autowired
    private CustomerRepository repository;

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) repository.findAll();
    }

    @Override
    public Optional<Customer> findById(String id) {
        return (Optional<Customer>) repository.findById(id);
    }

    @Override
    public boolean addCustomer(Customer customer) {
        try {
            repository.save(customer);
            return true;
        } catch (Exception error) {
            throw error;
        }
    }

    @Override
    public boolean removeCustomer(String id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception error) {
            throw error;
        }
    }
}
