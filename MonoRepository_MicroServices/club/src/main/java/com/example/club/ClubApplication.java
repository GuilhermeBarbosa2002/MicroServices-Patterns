package com.example.club;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient

public class ClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClubApplication.class, args);
	}

}
