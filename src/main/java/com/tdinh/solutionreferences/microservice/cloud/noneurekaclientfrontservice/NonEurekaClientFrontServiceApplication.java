package com.tdinh.solutionreferences.microservice.cloud.noneurekaclientfrontservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
public class NonEurekaClientFrontServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NonEurekaClientFrontServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
