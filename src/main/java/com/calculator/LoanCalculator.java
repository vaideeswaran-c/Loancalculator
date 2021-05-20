package com.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.calculator.model"})
@ComponentScan("com.calculator.controller")
@EnableJpaRepositories("com.calculator.repository")
public class LoanCalculator {

	public static void main(String[] args) {
		SpringApplication.run(LoanCalculator.class, args);
	}

}
