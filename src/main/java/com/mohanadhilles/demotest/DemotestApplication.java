package com.mohanadhilles.demotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @EnableJpaRepositories(basePackages = "com.mohanadhilles.demotest.Repositories")
// @EntityScan(basePackages = "com.mohanadhilles.demotest.Security")
@SpringBootApplication
public class DemotestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemotestApplication.class, args);
	}

}
