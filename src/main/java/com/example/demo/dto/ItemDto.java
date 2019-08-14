package com.example.demo.dto;

import com.example.demo.entity.Customer;
import org.hibernate.mapping.Any;

import java.util.List;

public class ItemDto {
    private boolean success;
    private int code;
    private String message;
    private List<Any> data;

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

    public List<Any> getData() {
        return data;
    }

    public void setData(List<Any> data) {
        this.data = data;
    }
}
