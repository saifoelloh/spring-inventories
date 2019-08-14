package com.example.demo;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired private ItemRepository repository;

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            repository.save(new Item("Sepatu Adidas", 20, 30, 10, 0));
            repository.save(new Item("Sepatu Puma", 30, 40, 12, 0));
            repository.save(new Item("Sepatu", 10, 100, 90, 0));
            repository.save(new Item("Sepatu", 80, 120, 20, 0));
            for (Item item: repository.findAll()) {
                System.out.println(item.toString());
            }
        };
    }
}
