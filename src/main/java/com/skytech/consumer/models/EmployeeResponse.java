package com.skytech.consumer.models;

import java.util.List;

import lombok.Data;

@Data
public class EmployeeResponse {
	private List<Employee> empList;
}
