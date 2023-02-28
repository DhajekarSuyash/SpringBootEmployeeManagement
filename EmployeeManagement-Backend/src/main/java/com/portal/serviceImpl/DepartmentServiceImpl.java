package com.portal.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dao.DepartmentDao;
import com.portal.model.Department;
import com.portal.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
	
	@Autowired
	private DepartmentDao deptDao;

	@Override
	public Department addDepartment(Department dept) {
		return deptDao.save(dept);
	}

	@Override
	public List<Department> detAllDepartment() {
		
		return deptDao.findAll();
	}
}
