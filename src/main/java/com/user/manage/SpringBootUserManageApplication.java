package com.user.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootUserManageApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootUserManageApplication.class, args);
	}
}
