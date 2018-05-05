package com.revature.dao;

import java.util.List;
import com.revature.domain.Customer;

public interface CustomerDao {
	
	public boolean insertCustomer(String username, String password);
	
	public boolean deleteCustomer(int customerId);
	
	public List<Customer> getCustomers();
	
	public Customer getCustomerById(int id);
	
	public int getCustomerId();
	
	public boolean checkCustomerPassword(String username, String password);
	
	public boolean checkAdmin(int customerId);

}
