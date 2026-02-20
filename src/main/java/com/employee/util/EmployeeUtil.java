package com.employee.util;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.employee.dto.EmployeeDto;

@Component
public class EmployeeUtil {

	private final RestTemplate restTemplate;

	public EmployeeUtil(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String addEmployee(EmployeeDto employeeDto) {
		String url = "http://employee-backend:9000/employee/add";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<EmployeeDto> request = new HttpEntity<>(employeeDto, headers);

		ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

		return response.getBody();
	}

	public List<EmployeeDto> getEmployees() {
		String url = "http://employee-backend:9000/employee/get";

		ResponseEntity<List<EmployeeDto>> response =
	            restTemplate.exchange(
	                    url,
	                    HttpMethod.GET,
	                    null,
	                    new ParameterizedTypeReference<List<EmployeeDto>>() {}
	            );

	    return response.getBody();
	}
}
