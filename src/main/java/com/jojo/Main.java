package com.jojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/customers")
public class Main {

    private final Customer_Repository customerRepository;
    public Main(Customer_Repository customerRepository){
        this.customerRepository = customerRepository;
    }

    public static void main(String []args){
        SpringApplication.run(Main.class,args);
    }

    }
    

