package com.example.BS3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Bs3Application {
	

	public static void main(String[] args) {
		SpringApplication.run(Bs3Application.class, args);
	}
	@Bean
	CommandLineRunner ejecutate2(){
		return p -> System.out.println("Hola desde la segunda clase");
	}
	@Bean
	CommandLineRunner ejecutate3(){
		return p -> System.out.println("Soy la tercera clase");
	}
	@PostConstruct
	void ejecutate(){
		System.out.println("Hola desde clase inicial");}

}
