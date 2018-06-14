package com.aspire.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Application is a starter class to start the spring boot application. This
 * class will deploy and start tomcat server.
 * 
 * @author faizal.arafath
 *
 */
@SpringBootApplication(scanBasePackages = "com.aspire")
@EntityScan("com.aspire.entity")
@EnableJpaRepositories(value = "com.aspire.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}