package com.sundera.timewise.timewiseapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sundera.timewise")
public class TimewiseApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimewiseApiGatewayApplication.class, args);
	}

}
