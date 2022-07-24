package com.journaldev.spring;

import org.springframework.boot.SpringApplication;
import org.hibernate.dialect.Oracle10gDialect;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplication.class, args);
	}
}
