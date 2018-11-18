package com.crud.webstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class WebstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebstoreApplication.class, args);
    }
}
