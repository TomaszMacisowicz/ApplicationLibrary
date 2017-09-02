package com.example.demo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootConfiguration
@Configuration
@ComponentScan(basePackages = "com.example.demo")

public class ApplicationLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationLibraryApplication.class, args);
               
	}
}
