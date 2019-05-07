package com.tdinh.solutionreferences.microservice.cloud.noneurekaclientfrontservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tdinh.solutionreferences.microservice.cloud.noneurekaclientfrontservice.service.ComputationService;

@RestController
public class ComputeController {

	@Autowired
	private ComputationService computationService;

	@HystrixCommand(fallbackMethod = "failingMessage")
	@GetMapping(value = "intensivemultiply")
	public ResponseEntity<String> intensivemultiply(@RequestParam("value1") Integer n1,
			@RequestParam("value2") Integer n2) {
		return ResponseEntity.ok(computationService.intensivemultiplyTwo(n1, n2));
	}

	public ResponseEntity<String> failingMessage(Integer value1, Integer value2) {
		return ResponseEntity.ok("Can't perform such an intensive computation");
	}
}
