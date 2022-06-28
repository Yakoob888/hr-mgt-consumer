package com.skytech.consumer.service;

import com.skytech.consumer.models.Employee;
import com.skytech.consumer.models.EmployeeResponse;

public interface ConsumerService {

	Employee getEmployee(Integer id, String url);

	Employee saveEmployee(String url, Employee employee);

	EmployeeResponse getAllEmployees(String url);

	Employee updateEmployee(Integer id, String url, Employee employee);

	String deleteEmployee(Integer id, String url);

}
