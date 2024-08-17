package com.example.BookStore.BookStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BookStoreApplication {

	//main method for the Spring Boot Application
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
}
