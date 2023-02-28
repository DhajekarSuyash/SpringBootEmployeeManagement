package com.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.portal.controller.EmployeeController;
import com.portal.model.Employee;

@SpringBootApplication
public class EmployeeManagementBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementBackendApplication.class, args);
		
		System.out.println("application has started...");
	}

}
