package com.revature.cc.main;

import com.revature.cc.dao.DepartmentDao;
import com.revature.cc.dao.DepartmentDaoImpl;

public class Driver {
	
	public static void main(String[] args) {
		
		DepartmentDao d = new DepartmentDaoImpl();
		
		d.getDeptAvgSalary();
		
	}
}
