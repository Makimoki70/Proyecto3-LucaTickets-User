package com.proyecto.spring.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LucaTicketsUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(LucaTicketsUserApplication.class, args);
	}
}