package com.portal.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dao.EmployeeDao;
import com.portal.exception.ResourceNotFoundException;
import com.portal.model.Employee;
import com.portal.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao empdao;

	@Override
	public Employee saveEmployee(Employee emp) {
		return empdao.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {

		return empdao.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		/*
		 * Optional<Employee> emp = empdao.findById(id); if(emp.isPresent()) { return
		 * emp.get(); } else { throw new ResourceNotFoundException("Employee", "id",
		 * id); }
		 */
		return empdao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
	}

	@Override
	public Employee updateEmployee(Employee emp, int id) {
		// check given id employee exists or not
		Employee existingEmp = empdao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		existingEmp.setEmpName(emp.getEmpName());
		existingEmp.setEmpSalary(emp.getEmpSalary());
		existingEmp.seteAge(emp.geteAge());
		// save existing user to db
		empdao.save(existingEmp);
		return existingEmp;
	}

	@Override
	public void deleteEmployee(int id) {
		// check iemployee exist or not
		empdao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		empdao.deleteById(id);

	}

	@Override
	public List<Employee> getEmployeeWithSalaryGreaterThanFiftyK() {
		return empdao.getEmployeeWithSalaryGreaterThanFiftyK();
	}
}
