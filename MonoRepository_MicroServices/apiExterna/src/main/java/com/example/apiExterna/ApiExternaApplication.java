package com.example.apiExterna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiExternaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiExternaApplication.class, args);
	}

}
