package com.ktr.sb.ProductJPAService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.ktr.sb")
@EnableJpaRepositories(basePackages = "com.ktr.sb.db.daos")
@EntityScan("com.ktr.sb.pojos")
public class ProductJpaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductJpaServiceApplication.class, args);
	}

}

