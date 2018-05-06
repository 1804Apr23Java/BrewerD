package com.revature.dao;

import java.util.List;

import com.revature.domain.BankAccount;

public interface BankAccountDao {
	
	public boolean insertBankAccount(String type);
	public boolean deleteBankAccount(int bankAccountId);
	public boolean SuperUserDeleteBankAccount(int bankAccountId);
	public boolean updateBankAccount(int bankAccountId, float difference);
	public List<BankAccount> getBankAccounts();
	//public List<BankAccount> getBankAccountsByUserAccount(int accountId);
	public BankAccount getBankAccountById(int bankAccountId);
	public float getBankAccountBalance(int bankAccountId);
}
