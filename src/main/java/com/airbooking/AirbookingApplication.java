package com.airbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AirbookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirbookingApplication.class, args);
	}

}
