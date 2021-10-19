package com.example.BS3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TerceraClase {
    @Autowired
    ClaseInicial claseInicial;
    @Autowired
    ClaseSecundaria claseSecundaria;
    public void main(){
        claseInicial.ejecutate();
        claseSecundaria.ejecutate2();
        System.out.println("Soy la tercera clase");
    }

}
