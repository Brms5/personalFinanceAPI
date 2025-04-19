package com.github.brms5.personal_finance_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PersonalFinanceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalFinanceApiApplication.class, args);
	}

}
