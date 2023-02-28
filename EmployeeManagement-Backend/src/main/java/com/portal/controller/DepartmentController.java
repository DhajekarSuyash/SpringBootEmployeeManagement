package com.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.model.Department;
import com.portal.service.DepartmentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/portal/department")
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;

	//Add Department API
	@PostMapping("/add")
	public ResponseEntity<Department> addDepartment(@RequestBody Department dept) {
		return new ResponseEntity<Department>(deptService.addDepartment(dept), HttpStatus.CREATED);
	}
	
	@GetMapping("/getDept")
	public List<Department> getAllDepartment(){
		List<Department> deptList = deptService.detAllDepartment();
		return deptList;
		
	}
}
