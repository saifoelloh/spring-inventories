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

import java.util.*;
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

            System.out.print("Masukan banyak barang\t: ");
            int limit = Integer.parseInt(input.nextLine());
            for (int i = 0; i < limit; i++) {
                Item item = new Item();
                System.out.println("Item ke-"+(i+1));
                System.out.print("Masukan nama barang\t\t\t: ");
                item.setName(input.nextLine());
                System.out.print("Masukan harga beli barang\t: ");
                item.setPurchasePrice(input.nextFloat());
                System.out.print("Masukan harga jual barang\t: ");
                item.setSellingPrice(input.nextFloat());
                System.out.print("Masukan stock barang\t\t: ");
                item.setStock(input.nextInt());
                System.out.print("Masukan sold barang\t\t\t: ");
                item.setSold(input.nextInt());
                itemRepository.save(item);
                System.out.println();
            }

            System.out.println("\n\nItem");
            System.out.println("--------------------------------------------");
            for (Item barang: itemRepository.findAll()) {
                System.out.println(barang.toString());
            }

            System.out.print("\nMasukan banyak customer\t: ");
            limit = Integer.parseInt(input.nextLine());

            for (int i = 0; i < limit; i++) {
                Customer customer = new Customer();
                System.out.println("Customer ke-"+(i+1));
                System.out.print("Masukan nama customer\t: ");
                customer.setName(input.nextLine());
                System.out.print("Masukan email\t\t\t: ");
                customer.setEmail(input.nextLine());
                System.out.print("Masukan phone\t\t\t: ");
                customer.setPhone(input.nextLine());
                System.out.print("Masukan address\t\t\t: ");
                customer.setAddress(input.nextLine());
                System.out.print("Masukan discount\t\t: ");
                customer.setDiscount(input.nextFloat());
                customerRepository.save(customer);
            }

            System.out.println("\n\nCustomer");
            System.out.println("--------------------------------------------");
            for (Customer customer: customerRepository.findAll()) {
                System.out.println(customer.toString());
                System.out.print("Apkah ia membeli barang ? ");
                boolean b = input.nextBoolean();
                if (b) {
                    System.out.print("Masukan harga\t\t: ");
                    Purchase purchase = new Purchase(input.nextFloat(), customer);
                    purchaseRepository.save(purchase);
                }
                System.out.println("Purchase "+customer.getName());
                System.out.println("--------------------------------------------");
                for (Purchase purchase: customer.getPurchases()) {
                    System.out.println(purchase.toString());
                }
                System.out.println();
            }

//            System.out.println("\n\nPurchase");
//            System.out.println("--------------------------------------------");
//            for (Purchase purchase: purchaseRepository.findAll()) {
//                System.out.println(purchase.toString());
//            }
        };
    }
}
