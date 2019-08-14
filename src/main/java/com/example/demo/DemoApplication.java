package com.example.demo;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;
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
            Scanner input = new Scanner(System.in);
            Scanner input2 = new Scanner(System.in);
            System.out.print("Masukan banyak item yg ingin di-input:\t");

            int limit = input.nextInt();

            for (int i = 0; i < limit; i++) {
                Item item = new Item();
                System.out.println("Item ke-"+(i+1));
                System.out.print("Masukan nama produk:\t");
                item.setName(input2.nextLine());
                System.out.print("Mauskan harga beli:\t\t");
                item.setPurchasePrice(input.nextFloat());
                System.out.print("Masukan harga jual:\t\t");
                item.setSellingPrice(input.nextFloat());
                System.out.print("Masukan jumlah stock:\t");
                item.setStock(input.nextInt());
                System.out.print("Masukan jumlah terbeli:\t");
                item.setSold(input.nextInt());
                System.out.println();
                repository.save(item);
            }

            System.out.println("--------------------------------------------");
            System.out.println("Ini hasil bro!");
            System.out.println("--------------------------------------------");
            for (Item item: repository.findAll()) {
                System.out.println(item.toString());
            }
        };
    }
}
