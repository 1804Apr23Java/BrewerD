package com.revature.dao;

import java.util.List;

import com.revature.domain.Transaction;

public interface TransactionDao {

	public boolean insertTransaction(int bankAccountId, float difference);
	public boolean deleteTransaction(int transactionId);
	public boolean updateTransactionDifference(int transactionId, float newDifference);
	public Transaction getTransactionById(int transactionId);
	public float getTransactionDifference(int transactionId);
	public List<Transaction> getAllTransactionsByAccount(int bankaccountId);
}
