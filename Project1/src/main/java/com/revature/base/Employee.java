package com.revature.base;

public class Employee {
	
	int emp_id;
	String un;
	String fn;
	String ln;
	String pw;
	int ism;
	String em;
	
	public Employee() {
		super();
	}
	
	public Employee(int emp_id, String un, String fn, String ln, String pw, int ism, String em) {
		super();
		this.emp_id = emp_id;
		this.un = un;
		this.fn = fn;
		this.ln = ln;
		this.pw = pw;
		this.ism = ism;
		this.em = em;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", un=" + un + ", fn=" + fn + ", ln=" + ln + ", pw=" + pw + ", ism=" + ism
				+ ", em=" + em + "]";
	}

	public Employee(String un, String fn, String ln, String pw, int ism, String em) {
		super();
		this.un = un;
		this.fn = fn;
		this.ln = ln;
		this.pw = pw;
		this.ism = ism;
		this.em = em;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getUn() {
		return un;
	}
	public void setUn(String un) {
		this.un = un;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getIsm() {
		return ism;
	}
	public void setIsm(int ism) {
		this.ism = ism;
	}
	public String getEm() {
		return em;
	}
	public void setEm(String em) {
		this.em = em;
	}
	
}