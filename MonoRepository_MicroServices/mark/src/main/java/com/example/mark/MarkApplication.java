package com.example.mark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MarkApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarkApplication.class, args);
	}

}
