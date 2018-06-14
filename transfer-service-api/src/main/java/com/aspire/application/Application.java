package com.aspire.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.aspire")
@EntityScan("com.aspire.entity")
@EnableJpaRepositories(value = "com.aspire.repository")
public class Application {  
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
    }       
}            