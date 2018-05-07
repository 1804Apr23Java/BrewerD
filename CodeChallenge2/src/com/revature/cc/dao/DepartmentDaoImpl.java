package com.revature.cc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.cc.domain.Department;
import com.revature.cc.domain.Employee;
import com.revature.cc.util.ConnectionUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	private String filename = "connection.properties";

	@Override
	public List<Department> getDepartments() {

		List<Department> depList = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql1 = "SELECT * FROM DEPARTMENT";
			PreparedStatement statement = con.prepareStatement(sql1);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				int depId = resultSet.getInt("EMPLOYEE_ID");
				String depName = resultSet.getString("EMP_FIRSTNAME");
				depList.add(new Department(depId, depName));
			}

			return depList;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void getDeptAvgSalary() {
		
		EmployeeDao e = new EmployeeDaoImpl();
		
		List <Employee> eList = new ArrayList<>();
		
		eList = e.getEmployees();
		
		for (Employee x : eList) {
			System.out.println(x);
			}
		
		return;
	}
}
