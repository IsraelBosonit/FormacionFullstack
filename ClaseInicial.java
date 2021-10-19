package com.example.BS3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public class ClaseInicial{

    @PostConstruct
    CommandLineRunner ejecutate(){
        return p->System.out.println("Hola desde clase inicial");
    }
}
