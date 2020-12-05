package com.walmart.offersservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@SpringBootApplication
public class OffersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OffersServiceApplication.class, args);
	}

}
