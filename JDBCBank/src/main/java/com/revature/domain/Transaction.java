package com.revature.domain;

public class Transaction {
	
	int transactionId;
	float difference;
	int accountNum;

	public Transaction() {
		super();
	}
	public Transaction(float difference) {
		super();
		this.difference = difference;
	}
	public Transaction(int transactionId, float difference) {
		super();
		this.transactionId = transactionId;
		this.difference = difference;
	}
	public Transaction(int transactionId, float difference, int accountNum) {
		super();
		this.transactionId = transactionId;
		this.difference = difference;
		this.accountNum = accountNum;
	}
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public float getDifference() {
		return difference;
	}
	public void setDifference(float difference) {
		this.difference = difference;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", difference=" + difference + "]";
	}
	
	
}




