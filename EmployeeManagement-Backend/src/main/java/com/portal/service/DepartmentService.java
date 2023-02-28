package com.portal.service;

import java.util.List;

import com.portal.model.Department;

public interface DepartmentService {
	
	public Department addDepartment(Department dept);
	
	List<Department> detAllDepartment();

}
