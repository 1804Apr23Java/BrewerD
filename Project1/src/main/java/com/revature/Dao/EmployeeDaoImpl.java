package com.revature.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.base.Employee;
import com.revature.Util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	private String filename = "connection.properties";
	
	public static EmployeeDao employee = new EmployeeDaoImpl();

	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insertEmployee(String un, String fn, String ln, String pw, int ism, String em)
			throws IOException, SQLException {

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql = "INSERT INTO EMP (EMP_UN, EMP_FN, EMP_LN, EMP_PW, EMP_IS_M, EMP_EM) VALUES (?,?,?,?,?,?)";

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, un);
			statement.setString(2, fn);
			statement.setString(3, ln);
			statement.setString(4, pw);
			statement.setInt(5, ism);
			statement.setString(6, em);
			statement.executeQuery();
			con.close();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean loginEmployee(String un, String pw) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isManagerEmployee(int emp_id) {
try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			
			String sql = "SELECT EMP_IS_M FROM EMP WHERE EMP_ID = ?";
			int ism;

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setInt(1, emp_id);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				
				ism = resultSet.getInt("EMP_IS_M");
			
				if(ism == 0) {
					return false;
				} else if (ism == 1) {
					return true;
				}
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;

	}

	public boolean isManagerEmployee(Employee emp) {
try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			
			String sql = "SELECT EMP_IS_M FROM EMP WHERE EMP_ID = ?";
			int ism;

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setInt(1, emp.getEmp_id());

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				
				ism = resultSet.getInt("EMP_IS_M");
			
				if(ism == 0) {
					return false;
				} else if (ism == 1) {
					return true;
				}
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	public Employee getEmployee(String un, String pw) {
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			
			String sql = "SELECT * FROM EMP WHERE EMP_UN = ? AND EMP_PW = ?";

			Employee emp;
			
			int emp_id;
			String username;
			String fn;
			String ln;
			String password;
			int ism;
			String em;

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, un);
			statement.setString(2, pw);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				
				emp_id = resultSet.getInt("EMP_ID");
				username = resultSet.getString("EMP_UN");
				fn = resultSet.getString("EMP_FN");
				ln = resultSet.getString("EMP_LN");
				password = resultSet.getString("EMP_PW");
				ism = resultSet.getInt("EMP_IS_M");
				em = resultSet.getString("EMP_EM");
			
				emp = new Employee(emp_id, username, fn, ln, password, ism, em);
				
				return emp;
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

	public int getEmployeeId(Employee emp) {

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql = "SELECT EMP_ID FROM EMP WHERE EMP_UN = ?";
			int emp_id;

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, emp.getUn());

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				emp_id = resultSet.getInt("EMP_ID");
				return emp_id;
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public boolean deleteEmployee(int id) throws IOException, SQLException {

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql = "DELETE FROM EMP WHERE EMP_ID = ?";

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setInt(1, id);
			statement.executeQuery();

			con.close();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
