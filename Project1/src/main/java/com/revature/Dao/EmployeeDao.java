package com.revature.Dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.base.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees() throws IOException, SQLException;
	public boolean insertEmployee(String un, String fn, String ln, String pw, int ism, String em) throws IOException, SQLException;
	public boolean loginEmployee(String un, String pw) throws IOException, SQLException;
	public boolean isManagerEmployee(int emp_id) throws IOException, SQLException;
	public boolean isManagerEmployee(Employee e) throws IOException, SQLException;
	public Employee getEmployee(String un, String pw) throws IOException, SQLException;
	public int getEmployeeId(Employee e) throws IOException, SQLException;
	//public boolean deleteEmployee(Employee e) throws IOException, SQLException;
	public boolean deleteEmployee(int id) throws IOException, SQLException;
	public boolean isEmployee(String un, String pw) throws IOException, SQLException;
	public Employee getEmployee(String un) throws IOException, SQLException;
	public boolean updateEmployee(String un, String fn, String ln, String pw, String em) throws IOException, SQLException;
}
