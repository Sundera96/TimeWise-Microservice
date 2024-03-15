package com.sundera.timewisemediastorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.sundera.timewise")
@EnableJpaRepositories(basePackages = "com.sundera.timewise.repository")
@EntityScan(basePackages="com.sundera.timewise.entity")
public class TimewiseMediastorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimewiseMediastorageApplication.class, args);
	}

}
