package com.ktr.sb.ProductJDBCService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ktr.sb")
public class ProductJdbcServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductJdbcServiceApplication.class, args);
	}

}

