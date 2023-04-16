package com.sparta.springjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringjpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringjpaApplication.class, args);
    }

}
