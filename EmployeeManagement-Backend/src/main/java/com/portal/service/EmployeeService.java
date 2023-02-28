package com.portal.service;

import java.util.List;

import com.portal.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee emp);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(int id);

	Employee updateEmployee(Employee emp, int id);

	void deleteEmployee(int id);
	
	List<Employee> getEmployeeWithSalaryGreaterThanFiftyK();
}
