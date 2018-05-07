package com.revature.cc.domain;

public class Employee {

	int employeeId;
	String firstName;
	String lastName;
	int depId;
	float salary;
	String email;


	public Employee(int employeeId, String firstName, String lastName, int depId, float salary, String email) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.depId = depId;
		this.salary = salary;
		this.email = email;
	}

	public Employee() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", depId="
				+ depId + ", salary=" + salary + ", email=" + email + "]";
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

	