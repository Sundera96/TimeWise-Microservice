package com.sundera.timewisesecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.sundera.timewise")
@EnableJpaRepositories(basePackages = "com.sundera.timewise.repos")
@EntityScan(basePackages="com.sundera.timewise.entity")
public class TimewiseSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimewiseSecurityApplication.class, args);
	}

}
