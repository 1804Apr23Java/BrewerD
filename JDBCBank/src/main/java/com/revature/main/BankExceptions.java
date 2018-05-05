package com.revature.main;

public class BankExceptions extends Exception {
	/*
	 * wrong password
	 * new username already exist
	 * closing a non 0 account
	 * balance in negative
	 * taking out of savings account
	 */
	BankExceptions (String s) {	
		super(s);
	}
	
	static void passwordError(String userName, String enteredPassword) throws BankExceptions 
	{
		String storedPassword = "";
		//jdbc check Username, return storedPassword password
		if (storedPassword != enteredPassword)
		{
			throw new BankExceptions("Wrong Password");
		}
	}
	static void existingUsernameError(String userName) throws BankExceptions 
	{
		//jdbc check Username, check for any matches
		if (true) // if username already exists
		{
			throw new BankExceptions("Username already exists");
		}
	}
	
	static void negativeBalanceError(int accNumber, Float withdrawAmount) throws BankExceptions 
	{
		//jdbc return balance via looking up accNumber
		Float jdbc = (float) 0.0; //remove later
		Float newBalance = jdbc - withdrawAmount;
		if (newBalance < 0)
		{
			throw new BankExceptions("Balance in the negative");
		}	
	}
	
	static void closeBalanceError(int accNumber) throws BankExceptions 
	{
		//jdbc return balance via looking up accNumber
		Float balance = (float) 0.0; //remove later
		if (balance != 0)
		{
			throw new BankExceptions("Cannot close bank account, Balance remaining is: " + balance);
		}
	}
	
	static void withdrawSavingsError(int accNumber) throws BankExceptions
	{
		//jdbc use accNumber to look up account type
		String invalidType = ""; //change later
		if (invalidType == "Savings")
		{
			throw new BankExceptions("Cannot withdrawl from Savings Account");
		}
	}
}
