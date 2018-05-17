package com.revature.Util;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.Dao.EmployeeDao;
import com.revature.Dao.EmployeeDaoImpl;
import com.revature.base.Employee;

public class Driver {

	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
		EmployeeDao ed = new EmployeeDaoImpl();
		
		Employee emp;
		
		String un = "test1";
		String fn = "test2";
		String ln = "test3";
		String pw = "test4";
		int ism   = 0;
		String em = "test5";
		
		
		//ed.insertEmployee(un, fn, ln, pw, ism, em);
		
		emp = ed.getEmployee("test1", "test4");
		
		System.out.println(emp);
		
	}

}
