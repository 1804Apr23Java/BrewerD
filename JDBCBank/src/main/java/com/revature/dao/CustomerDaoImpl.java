package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Customer;
import com.revature.util.ConnectionUtil;

public class CustomerDaoImpl implements CustomerDao {
	
	private String filename = "connection.properties";

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customerList = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// using a Statement - beware SQL injection
			String sql = "SELECT * FROM CUSTOMER";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			System.out.println("Made connection");

			// move through result set
			while (resultSet.next()) {
				System.out.println("In while loop");
				int id = resultSet.getInt("CUSTOMER_ID");
				String username = resultSet.getString("USERNAME");
				String password = resultSet.getString("CUSTOMER_PASSWORD");
				boolean admin = resultSet.getBoolean("CUSTOMER_ADMIN");
				System.out.println(username);
				customerList.add(new Customer(id, username, password, admin));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return customerList;
	}
	
	@Override
	public boolean deleteCustomer(int customerId) {
		
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			
			
			String sql = "DELETE FROM CUSTOMER WHERE CUSTOMER_ID = ?";
			
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, customerId);
			statement.executeQuery();

			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(getCustomerById(customerId) == null) {
			return true;
		}
			return false;
	}

	@Override
	public Customer getCustomerById(int id) {
		
		Customer c = null;
		
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet resultSet = pstmt.executeQuery();

			// do something with result
			if (resultSet.next()) {
				int customerId = resultSet.getInt("CUSTOMER_ID");
				String username = resultSet.getString("USERNAME");
				String password = resultSet.getString("CUSTOMER_PASSWORD");
				boolean admin = resultSet.getBoolean("ADMIN");
				c = new Customer(customerId, username, password, admin);
			}

		con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	return c;
	}

	@Override
	public int getCustomerId(String username, String password) {
		
		PreparedStatement pstmt = null;
		int customerId;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "SELECT CUSTOMER_ID FROM CUSTOMER WHERE USERNAME = ? AND CUSTOMER_PASSWORD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet resultSet = pstmt.executeQuery();

			// do something with result
			if (resultSet.next()) {
				customerId = resultSet.getInt("CUSTOMER_ID");
				return customerId;
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
	public boolean checkCustomerPassword(String username, String password) {
		
		int customerId = 0;
		
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "SELECT CUSTOMER_ID FROM CUSTOMER WHERE USERNAME = ? AND CUSTOMER_PASSWORD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet resultSet = pstmt.executeQuery();

			// do something with result
			if (resultSet.next()) {
				customerId = resultSet.getInt("CUSTOMER_ID");
			}

		con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	if (customerId != 0)
		return true;
		
		return false;
	}

	@Override
	public boolean checkAdmin(int customerId) {
		
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "SELECT CUSTOMER_ADMIN FROM CUSTOMER WHERE CUSTOMER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, customerId);
			ResultSet resultSet = pstmt.executeQuery();
			
			if (resultSet.next()) {
				boolean admin = resultSet.getBoolean("CUSTOMER_ADMIN");
				return admin;
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			return false;	
	}

	@Override
	public boolean updateCustomerPassword(int customerId, String newPass) {
		
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "UPDATE CUSTOMER SET CUSTOMER_PASSWORD = ? WHERE CUSTOMER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(2, customerId);
			pstmt.setString(1, newPass);
			pstmt.execute();
			
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			return true;
	}

	@Override
	public boolean insertCustomer(String username, String password) {
		
try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			
			// using a Statement - beware SQL injection
			String sql = "INSERT INTO CUSTOMER (CUSTOMER_PASSWORD, CUSTOMER_ADMIN, USERNAME) VALUES (?,?,?)";
			
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, password);
			statement.setBoolean(2, false);
			statement.setString(3, username);
			statement.executeQuery();

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
