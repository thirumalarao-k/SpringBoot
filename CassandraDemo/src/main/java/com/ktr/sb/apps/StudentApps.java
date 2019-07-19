package com.ktr.sb.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@ComponentScan("com.ktr.sb")
@EnableCassandraRepositories("com.ktr.sb.repos")
public class StudentApps {

		public static void main(String[] args) {
			SpringApplication.run(StudentApps.class, args);
		}

	}