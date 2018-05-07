package com.revature.cc.domain;

public class Department {
	
	int depId;
	String depName;
	
	public Department() {
		super();
	}
	
	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Department(int depId, String depName) {
		super();
		this.depId = depId;
		this.depName = depName;
	}

}
