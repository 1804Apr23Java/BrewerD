package com.revature.cc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.cc.domain.Employee;
import com.revature.cc.util.ConnectionUtil;


public class EmployeeDaoImpl implements EmployeeDao {
	
	private String filename = "connection.properties";

	@Override
	public float getEmployeeSalary(int empId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<Employee> getEmployees() {
		
		List<Employee> employeeList = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql1 = "SELECT * FROM EMPLOYEE";
			PreparedStatement statement = con.prepareStatement(sql1);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				int empId = resultSet.getInt("EMPLOYEE_ID");
				String firstName = resultSet.getString("EMP_FIRSTNAME");
				String lastName = resultSet.getString("EMP_LASTNAME");
				int depId = resultSet.getInt("DEPARTMENT_ID");
				float salary = resultSet.getFloat("SALARY");
				String email = resultSet.getString("EMP_EMAIL");
				employeeList.add(new Employee(empId, firstName, lastName, depId, salary, email));
			}

			return employeeList;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
