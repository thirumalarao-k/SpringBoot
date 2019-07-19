package com.ktr.sb.SSLDemoService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ktr.sb")
public class SslDemoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslDemoServiceApplication.class, args);
	}

}

