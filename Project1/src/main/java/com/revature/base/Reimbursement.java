package com.revature.base;

import java.sql.Blob;

public class Reimbursement {
	
	public int getReim_id() {
		return reim_id;
	}
	public void setReim_id(int reim_id) {
		this.reim_id = reim_id;
	}
	@Override
	public String toString() {
		return "Reimbursement " + "Reim ID: " + reim_id + " Description: " + req + " Picture: " + blob + " Status: " + status
				+ " Manager ID: " + man_id + " Emp ID: " + emp_id + " Amount: $" + amt + " ";
	}
	public String getReq() {
		return req;
	}
	public void setReq(String req) {
		this.req = req;
	}
	public Blob getBlob() {
		return blob;
	}
	public void setBlob(Blob blob) {
		this.blob = blob;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getMan_id() {
		return man_id;
	}
	public void setMan_id(int man_id) {
		this.man_id = man_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	
	public Reimbursement(int reim_id, String req, Blob blob, String status, int man_id, int emp_id, double amt) {
		super();
		this.reim_id = reim_id;
		this.req = req;
		this.blob = blob;
		this.status = status;
		this.man_id = man_id;
		this.emp_id = emp_id;
		this.amt = amt;
	}
	
//	public Reimbursement(String req, Blob b, String string3) {
//		super();
//		this.req = req;
//		this.blob = b;
//		
//	}

	public Reimbursement(String req, Blob b, int emp_id, double amt) {
		super();
		this.req = req;
		this.blob = b;
		this.emp_id = emp_id;
		this.amt = amt;
	}

	public Reimbursement(String req, int emp_id, double amt) {
		super();
		this.req = req;
		this.emp_id = emp_id;
		this.amt = amt;
	}

	int reim_id;
	String req;
	Blob blob = null;
	String status;
	int man_id;
	int emp_id;
	double amt;
}
