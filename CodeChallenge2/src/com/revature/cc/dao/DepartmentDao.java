package com.revature.cc.dao;

import java.util.List;

import com.revature.cc.domain.Department;

public interface DepartmentDao {
	
	public List<Department> getDepartments();
	
	public void getDeptAvgSalary();

}
