package com.tdinh.solutionreferences.microservice.cloud.noneurekaclientfrontservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ComputationServiceImpl implements ComputationService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public String intensivemultiplyTwo(Integer n1, Integer n2) {
		
		String multiplyServiceUri = "http://localhost:8787/intense"; // hardcode, since not using discovery service

		StringBuilder endpointSb = new StringBuilder(multiplyServiceUri);
		return getReponse(n1, n2, endpointSb);
	}
	
	private String getReponse(Integer n1, Integer n2, StringBuilder endpointSb) {
		String endpoint = endpointSb.append("?value1=").append(n1).append("&value2=").append(n2).toString();
		String response = restTemplate
				.exchange(endpoint, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				}).getBody();
		return response;
	}


}
