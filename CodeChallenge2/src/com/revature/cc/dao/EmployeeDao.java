package com.revature.cc.dao;

import java.util.List;

import com.revature.cc.domain.Employee;

public interface EmployeeDao {
	
	public float getEmployeeSalary(int empId);
	
	public List<Employee> getEmployees();
}
