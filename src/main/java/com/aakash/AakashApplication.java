package com.aakash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AakashApplication {

	public static void main(String[] args) {
		SpringApplication.run(AakashApplication.class, args);
	}

}
