package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class CodeChallengeApp {

	
	public static void main(String[] args) {

		SpringApplication.run(CodeChallengeApp.class,  args);

	}

}
