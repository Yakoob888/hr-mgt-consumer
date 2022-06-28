package com.skytech.consumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skytech.consumer.models.Employee;
import com.skytech.consumer.models.EmployeeResponse;
import com.skytech.consumer.service.ConsumerService;


@RestController
@RequestMapping("/consumer")
public class ConsumerController {

	@Value("${hrm.producer.uri}")
	public String baseUrl;

	@Value("${eureka.instance.instance-id}")
	public String instanceId;
	
	@Autowired
	ConsumerService service;

	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		System.out.println("Consumer InstanceId is :: "+instanceId);
		String url = baseUrl + "/" + id;
		System.out.println("Url is " + url);
		return service.getEmployee(id, url);
	}

	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		String url = baseUrl;
		return service.saveEmployee(url, employee);
	}
	
	@GetMapping("/employees")
	public EmployeeResponse getAllEmployees() {
		String url = baseUrl+"s";
		return service.getAllEmployees(url);
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmloyee(@RequestBody Employee employee, @PathVariable Integer id) {
		String url = baseUrl+"/"+id;
		return service.updateEmployee(id, url, employee);
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		String url = baseUrl+"/"+id;
		return service.deleteEmployee(id, url);
	}
	@GetMapping("/hi")
	public String hi() {
		return baseUrl;
	}
}
