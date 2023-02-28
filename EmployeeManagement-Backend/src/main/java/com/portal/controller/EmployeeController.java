package com.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.model.Employee;
import com.portal.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/portal/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	// build create Employee rest APi
	@PostMapping("/allEmp")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		return new ResponseEntity<Employee>(empService.saveEmployee(emp), HttpStatus.CREATED);
	}

	// build get all employees API
	@GetMapping("/allEmp")
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}

	// get Employee by id API
	// http://localhost:8080/portal/employee/allEmp/1
	@GetMapping("/allEmp/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int EmployeeID) {
		Employee e = empService.getEmployeeById(EmployeeID);
		System.err.println("combine table");
		System.out.println(e.getEmpName());
		System.out.println(e.geteAge());
		System.out.println(e.getEmpSalary());
	//	System.out.println(e.getDepartment().getDeptName());
		//System.out.println(e.getDepartment().getDeptType());
		return new ResponseEntity<Employee>(empService.getEmployeeById(EmployeeID), HttpStatus.OK);
	}

	// Update Employee Api
	// http://localhost:8080/portal/employee/allEmp/1
	@PutMapping("/allEmp/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee emp) {

		return new ResponseEntity<Employee>(empService.updateEmployee(emp, id), HttpStatus.OK);
	}

	// Delete Employee API
	// http://localhost:8080/portal/employee/1
	@DeleteMapping("/allEmp/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int empId) {
		empService.deleteEmployee(empId);
		return new ResponseEntity<>(HttpStatus.OK);
		//return new ResponseEntity<String>("Employee deleted successfully...", HttpStatus.OK);
	}
	
	//Employee With salary greater than 50k API
	@GetMapping("/salary")
	public List<Employee> getEmployeeWithSalaryGreaterThanFiftyK(){
		
		return empService.getEmployeeWithSalaryGreaterThanFiftyK();
	}
}
