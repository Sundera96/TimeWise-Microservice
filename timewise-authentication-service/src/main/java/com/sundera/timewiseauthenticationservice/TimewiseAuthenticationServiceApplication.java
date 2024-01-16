package com.sundera.timewiseauthenticationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.sundera.timeswise")
@EnableJpaRepositories(basePackages = "com.sundera.timeswise.repository")
@EntityScan(basePackages="com.sundera.timeswise.entity")
public class TimewiseAuthenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimewiseAuthenticationServiceApplication.class, args);
	}

}