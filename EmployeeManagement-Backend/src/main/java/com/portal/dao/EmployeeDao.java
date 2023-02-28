package com.portal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.portal.model.Employee;

/*no need to add repository annotation using JPA. 
As jpa Inbuilt uses repository annotation
*/

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
	@Query(value = "select e FROM Employee e WHERE e.empSalary>50000")
	List<Employee> getEmployeeWithSalaryGreaterThanFiftyK();

}
