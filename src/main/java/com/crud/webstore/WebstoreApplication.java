package com.crud.webstore;

import com.crud.webstore.security.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class WebstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebstoreApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringApplicationContext springApplicationContext() {
        return new SpringApplicationContext();
    }

    @Bean
    public AppProperties appProperties() {
        return new AppProperties();
    }
}
