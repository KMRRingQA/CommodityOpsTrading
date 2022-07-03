package com.opstrader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.opstrader.repos")
public class OpstraderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpstraderApplication.class, args);
	}

}
