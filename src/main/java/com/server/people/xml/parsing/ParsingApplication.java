package com.server.people.xml.parsing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ParsingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParsingApplication.class, args);
    }

}
