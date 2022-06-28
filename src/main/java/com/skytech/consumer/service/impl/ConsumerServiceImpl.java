package com.skytech.consumer.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.skytech.consumer.models.Employee;
import com.skytech.consumer.models.EmployeeResponse;
import com.skytech.consumer.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	RestTemplate template;

	@Override
	public Employee getEmployee(Integer id, String url) {
		Employee employee = null;
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("id", id);
			employee = template.getForObject(url, Employee.class, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee saveEmployee(String url, Employee employee) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Employee> entity = new HttpEntity<>(employee, headers);
		Employee emp = template.postForObject(url, entity, Employee.class);
		return emp;
	}

	@Override
	public EmployeeResponse getAllEmployees(String url) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity entity = new HttpEntity("params", headers);
		ResponseEntity<EmployeeResponse> response = template.exchange(url, HttpMethod.GET, entity, EmployeeResponse.class);
		
		return response.getBody();
	}

	@Override
	public Employee updateEmployee(Integer id, String url, Employee employee) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		template.put(url, employee, params);
		return getEmployee(id, url);
	}

	@Override
	public String deleteEmployee(Integer id, String url) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		template.delete(url, params);
		return "Employee deleted "+id;
	}
}
