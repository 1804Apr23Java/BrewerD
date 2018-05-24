package com.revature.Dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.base.Employee;
import com.revature.base.Reimbursement;

public interface ReimbursementDao {
	
	public List<Reimbursement> getAllReimbursements() throws IOException, SQLException;
	public Reimbursement getReimbursement(int reim_id) throws IOException, SQLException;
	public boolean insertReimbursement(String req, String img, int emp_id, double amt) throws IOException, SQLException;
	public boolean denyReimbursement(Reimbursement r, int man_id) throws IOException, SQLException;
	public List<Reimbursement> getReimForEmp(Employee e) throws IOException, SQLException;
	public int getReimbursementId(Reimbursement r) throws IOException, SQLException;
	public String getReimbursementStatus(Reimbursement r) throws IOException, SQLException;
	public List<Reimbursement> getDeniedReimbursements() throws IOException, SQLException;
	public List<Reimbursement> getApprovedReimbursements() throws IOException, SQLException;
	public List<Reimbursement> getPendingReimbursements() throws IOException, SQLException;
	boolean approveReimbursement(Reimbursement r, int man_id) throws IOException, SQLException;
	
}
