package com.example.town;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class TownApplication {

	public static void main(String[] args) {
		SpringApplication.run(TownApplication.class, args);
	}

}
