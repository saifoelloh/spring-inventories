package com.example.demo;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Item;
import com.example.demo.entity.Purchase;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.PurchaseRepository;
import com.example.demo.service.CustomerService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.logging.Logger;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired private ItemRepository itemRepository;
    @Autowired private CustomerRepository customerRepository;
    @Autowired private PurchaseRepository purchaseRepository;
    @Autowired private CustomerService customerService;

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            Scanner input = new Scanner(System.in);

            Item item = new Item("sepatu baru", 20, 40, 20, 10);
            itemRepository.save(item);

            Customer customer = new Customer("joko", "joko@mail.co", "0888", "jl sesama", 10, new Purchase(10), new Purchase(20), new Purchase(2));
            customerRepository.save(customer);

            System.out.println("Ini hasil bro!");
            System.out.println("--------------------------------------------");
            for (Item barang: itemRepository.findAll()) {
                System.out.println(barang.toString());
            }
            System.out.println("--------------------------------------------");
            for (Customer pelanggan: customerRepository.findAll()) {
                System.out.println(pelanggan.toString());
                for (Purchase purchase: pelanggan.getPurchases()) {
                    System.out.println(purchase.toString());
                }
            }
        };
    }
}
