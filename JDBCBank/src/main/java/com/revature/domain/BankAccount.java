package com.revature.domain;

public class BankAccount {
	
	int accountNumber;
	float accountBalance;
	String accountType;
	
	public BankAccount() {
		super();
	}
	public BankAccount(float accountBalance, String accountType) {
		super();
		this.accountBalance = accountBalance;
		this.accountType = accountType;
	}

	public BankAccount(int accountNumber, float accountBalance, String accountType) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.accountNumber = accountNumber;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}
