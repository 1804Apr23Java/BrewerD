
public class User {
	

	String userName;
	String password;
	int bankAccountID;
	Float balance;
	
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public void setPassword(String password) { //to change password
		this.password = password;
	}


	public Float getBalance() {
		return balance;
	}


	public void setBalance(Float balance) { //to change balance
		this.balance = balance;
	}
	
	public void withdraw(Float withdrawAmount) {
		balance =- withdrawAmount;
		System.out.println("Withdrew: " + withdrawAmount + "\nNew Balance: " + balance);
		
	}
	
	public void deposit(Float depositAmount) {
		balance =+ depositAmount;
		System.out.println("Deposited: " + depositAmount + "\nNew Balance: " + balance);
	}


	public int getBankAccountID() {
		return bankAccountID;
	}


	public void setBankAccountID(int bankAccountID, Float balance) { //change to different bank account and its balance
		this.bankAccountID = bankAccountID;
		this.balance = balance;
	}
	
	
}
