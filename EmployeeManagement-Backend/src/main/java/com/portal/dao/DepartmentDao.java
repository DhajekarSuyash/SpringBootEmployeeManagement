package com.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.model.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer>
{

}
