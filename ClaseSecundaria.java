package com.example.BS3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClaseSecundaria {
    @Bean
    CommandLineRunner ejecutate2(){
        return p -> System.out.println("Hola desde la segunda clase");
    }
}
