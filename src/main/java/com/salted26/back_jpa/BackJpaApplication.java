package com.salted26.back_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BackJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackJpaApplication.class, args);
    }

}
