package com.example.demo.service.impl;

import com.example.demo.entity.Customer;

import java.util.List;
import java.util.Optional;

public class InterfaceCustomer {
    private boolean success;
    private int code;
    private String message;
    private List<Customer> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Customer> getData() {
        return data;
    }

    public void setData(List<Customer> data) {
        this.data = data;
    }
}
