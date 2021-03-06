package com.revature.base;

public class Reimbursement {
	
	public int getReim_id() {
		return reim_id;
	}
	public void setReim_id(int reim_id) {
		this.reim_id = reim_id;
	}
	@Override
	public String toString() {
		return "Reimbursement " + reim_id + "|" + req + "|" + img + "|" + status
				+ "|" + man_id + "|" + emp_id + "|$" + amt;
	}
	public String getReq() {
		return req;
	}
	public void setReq(String req) {
		this.req = req;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	
	public Reimbursement(int reim_id, String req, String b, String status, int man_id, int emp_id, double amt) {
		super();
		this.reim_id = reim_id;
		this.req = req;
		this.img = b;
		this.status = status;
		this.man_id = man_id;
		this.emp_id = emp_id;
		this.amt = amt;
	}
	
//	public Reimbursement(String req, String b, String string3) {
//		super();
//		this.req = req;
//		this.String = b;
//		
//	}

	public Reimbursement(String req, String b, int emp_id, double amt) {
		super();
		this.req = req;
		this.img = b;
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
	String img;
	String status;
	int man_id;
	int emp_id;
	double amt;
}
