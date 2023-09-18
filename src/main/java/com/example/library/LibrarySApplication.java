package com.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LibrarySApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibrarySApplication.class, args);
    }

}
