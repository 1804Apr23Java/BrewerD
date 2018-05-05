package com.revature.dao;

import java.util.List;

import com.revature.domain.BankAccount;

public interface BankAccountDao {
	
	public boolean insertBankAccount(int customerId, String type);
	public boolean deleteBankAccount(int accountId);
	public float updateBankAccount(int accountId, float difference);
	public List<BankAccount> getBankAccounts(int customerId);
	public BankAccount getBankAccountById(int accountId);
	public float getBankAccountBalance(int accountId);
}
