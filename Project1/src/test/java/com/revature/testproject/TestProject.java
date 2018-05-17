package com.revature.testproject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotEquals;
import com.revature.Dao.EmployeeDao;
import com.revature.Dao.EmployeeDaoImpl;
import com.revature.Dao.ReimbursementDao;
import com.revature.Dao.ReimbursementDaoImpl;
import com.revature.base.Employee;
import com.revature.base.Reimbursement;

public class TestProject {

	private EmployeeDao ed = new EmployeeDaoImpl();
	private ReimbursementDao rd = new ReimbursementDaoImpl();

	Employee e;
	Employee manager;
	Reimbursement r;

	@Before
	public void makeEmployee() {
		this.e = new Employee("username", "first", "last", "pass123", 0, "g@mail.com");
	}
	
	@Before
	public void makeManager() throws IOException, SQLException {
		this.manager = ed.getEmployee("bossman", "admin");
	}
	
	@Before
	public void makeReimbursement() {
		this.r = new Reimbursement("Florida trip.", 29, 150.50);
	}
	
	
	@Test
	public void testInsertReimbursement() throws IOException, SQLException
	{
		boolean test = rd.insertReimbursement("Florida Trip", null, 29, 554.29);
		assertEquals(true, test);
	}
	
	@Test
	public void testInsertEmployee() throws IOException, SQLException
	{
		boolean test = ed.insertEmployee(e.getUn(), e.getFn(), e.getLn(), e.getPw(), e.getIsm(), e.getEm());
		assertEquals(true, test);
		//ed.deleteEmployee(ed.getEmployeeId(e));
	}
	
	@Test
	public void testGetEmployee() throws IOException, SQLException
	{
		
		Employee b = ed.getEmployee("test1", "test4");
		assertTrue(b instanceof Employee);
	}
	
	@Test
	public void testGetEmployeeId() throws IOException, SQLException
	{
		int test = ed.getEmployeeId(e);
		assertEquals(ed.getEmployeeId(e), test);
	}
	
	@Test
	public void testDeleteEmployee() throws IOException, SQLException
	{
		boolean test = ed.deleteEmployee(ed.getEmployeeId(e));
		assertEquals(true, test);
	}
	
	@Test
	public void testisManagerEmployee0() throws IOException, SQLException
	{
		boolean test = ed.isManagerEmployee(40);
		assertEquals(true, test);
	}
	
	@Test
	public void testisManagerEmployee1() throws IOException, SQLException
	{
		boolean test = ed.isManagerEmployee(manager);
		assertEquals(true, test);
	}
	
	@Test
	public void testGetAllReimbursements() throws IOException, SQLException
	{
		List<Reimbursement> rl = new LinkedList<Reimbursement>();
		
		rl = rd.getAllReimbursements();
		assertNotEquals(0, rl.size());
	}
	
	@Test
	public void testGetReimbursement() throws IOException, SQLException
	{
		Reimbursement re = rd.getReimbursement(10);
		assertTrue(re instanceof Reimbursement);
	}
	@Test
	public void testGetReimForEmp() throws IOException, SQLException
	{
		List<Reimbursement> rl = new LinkedList<Reimbursement>();
		Employee test = ed.getEmployee("test1",  "test4");
		rl = rd.getReimForEmp(test);
		assertNotEquals(rl.size(), 0);
	}
	
	@Test
	public void testGetPendingReimbursements() throws IOException, SQLException
	{
		List<Reimbursement> rl = new LinkedList<Reimbursement>();
		
		rl = rd.getPendingReimbursements();
		assertNotEquals(0, rl.size());
	}
	
	@Test
	public void testGetApprovedReimbursements() throws IOException, SQLException
	{
		List<Reimbursement> rl = new LinkedList<Reimbursement>();
		
		rl = rd.getApprovedReimbursements();
		assertNotEquals(0, rl.size());
	}
	
	@Test
	public void testGetDeniedReimbursements() throws IOException, SQLException
	{
		List<Reimbursement> rl = new LinkedList<Reimbursement>();
		
		rl = rd.getDeniedReimbursements();
		assertNotEquals(0, rl.size());
	}
	
	@Test
	public void testApproveReimbursement() throws IOException, SQLException
	{
		Reimbursement re = rd.getReimbursement(6);
		String before = "PENDING";
		rd.approveReimbursement(re, 40);
		re = rd.getReimbursement(6);
		String after = re.getStatus();
		assertNotEquals(before, after);
	}
	
	@Test
	public void testDenyReimbursement() throws IOException, SQLException
	{
		Reimbursement re = rd.getReimbursement(7);
		String before = "PENDING";
		rd.denyReimbursement(re, 40);
		re = rd.getReimbursement(7);
		String after = re.getStatus();
		assertNotEquals(before, after);
	}
}