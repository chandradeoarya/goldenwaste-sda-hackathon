package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoldenWasteddApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();
        System.setProperty("GOLDEN_DB_URL", dotenv.get("GOLDEN_DB_URL"));
        System.setProperty("GOLDEN_DB_PORT", dotenv.get("GOLDEN_DB_PORT"));
        System.setProperty("GOLDEN_DB_NAME", dotenv.get("GOLDEN_DB_NAME"));
        System.setProperty("GOLDEN_DB_USERNAME", dotenv.get("GOLDEN_DB_USERNAME"));
        System.setProperty("GOLDEN_DB_PASSWORD", dotenv.get("GOLDEN_DB_PASSWORD"));


		SpringApplication.run(GoldenWasteddApplication.class, args);
	}

}
