package com.example.BS4_2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@Configuration
@PropertySource("miconfiguracion.properties")
public class Configuracion {
    @Value("${valor1:no tiene valor}")
    String valor1;
    @Value("${valor2: no tiene valor}")
    String valor2;
    @Bean
    CommandLineRunner ejecutame() {
        return p -> { System.out.println("Valor1: "+valor1+","+"valor2: "+valor2); };
    }
    

}
