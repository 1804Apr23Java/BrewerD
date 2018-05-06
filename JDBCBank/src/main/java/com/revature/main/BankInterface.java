package com.revature.main;

import java.util.List;
import java.util.Scanner;

import com.revature.domain.BankAccount;
import com.revature.domain.Customer;
import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.dao.TransactionDao;
import com.revature.dao.TransactionDaoImpl;

public class BankInterface {

	public static void main(String[] args) {

		BankAccountDao bad = new BankAccountDaoImpl();
		CustomerDao cd = new CustomerDaoImpl();
		TransactionDao td = new TransactionDaoImpl();

		String s = new String();
		String pass = new String();
		String user = new String();

		start: while (running) {

			clearScreen();
			System.out.println(wMsg);
			System.out.print(loginMsg);
			user = keyboard.next();

			if (user.equals("exit")) { // If user inputs "exit", then quit
				clearScreen();
				System.out.println("Thank you for using JDBC Bank. Have a nice day.");
				System.exit(0);
			}

			if (user.equals("new")) { // If user inputs "new" then create a new user
				clearScreen();
				System.out.print(newUserNamePrompt);
				s = keyboard.next();
				user = s;
				System.out.print(newPasswordPrompt);
				s = keyboard.next();
				pass = s;
				if (!cd.checkCustomerPassword(user, pass)) {
					cd.insertCustomer(user, pass);
					System.out.println("New user created. Press any key to continue.");
					s = keyboard.next();
					continue start;

				} else {
					System.out.println("Sorry, that user already exists. Press any key to continue.");
					s = keyboard.next();
					continue start;
				}
			}

			clearScreen();
			System.out.print(passwdPrompt);
			pass = keyboard.next();

			if (cd.checkCustomerPassword(user, pass)) { // CHECK FOR PASSWORD MATCH

				clearScreen();
				System.out.println("Login Successful. \n");

				loggedIn = true;

				logged: while (loggedIn) {

					List<BankAccount> bal = bad.getBankAccountsByUserAccount(cd.getCustomerId(user, pass));
					for (BankAccount b : bal) {
						System.out.println(b.toString());
					}
					System.out.println();

					if (cd.checkAdmin(cd.getCustomerId(user, pass))) {
						System.out.println("Welcome back Admin Select an option below: ");
						System.out.println("users      - View all users.");
						System.out.println("accounts   - View all bank accounts.");
						System.out.println("logout     - Sign out of superuser account.");
						
						s = keyboard.next();
						
						if(s.equals("users")){
							clearScreen();
							
							List<Customer> culist = cd.getCustomers();
							
									
							for (Customer c : culist) {
								System.out.println(c);
							}

							System.out.println("List of registered usernames above. There are " + culist.size() + " registered accounts. Enter any value to continue.");
							
							s = keyboard.next();
							
							continue logged;
							
							
						} else if(s.equals("accounts")) {
							
							clearScreen();
							List<BankAccount> balist = bad.getBankAccounts();
							for (BankAccount b : balist) {
								System.out.println(b);
							}
							
							System.out.println("List of bank accounts above. There are " + balist.size() + " bank accounts. Enter any value to continue.");

							s = keyboard.next();
							
							continue logged;
							
						} else if(s.equals("logout")) {
							clearScreen();
							loggedIn = false;
							break;
						}
						
						loggedIn = false;

					} else {

						System.out.print(userMenu);
						System.out.println(registeredUserMenu);
						s = keyboard.next();
						s = s.toLowerCase();

						if (s.equals("withdrawal")) {
							System.out.println(withdrawalMenu);

							for (BankAccount b : bal) {
								System.out.println(b.toString());
							}
							System.out.print(selectAccount);

							s = keyboard.next();
							Integer accountChoice = Integer.decode(s);

							if (cd.getCustomerId(user, pass) == bad.getBankAccountOwner(accountChoice)) {
								clearScreen();
								System.out.println("That is a valid account choice.");
								System.out.println("How much would you like to withdrawal?");
								s = keyboard.next();
								Float val = Float.parseFloat(s);
								if (val < 0) {
									clearScreen();
									System.out.println("Sorry, user must input a positive value.");
									continue logged;
								}
								if (val > bad.getBankAccountBalance(accountChoice)) {
									clearScreen();
									System.out.println("Sorry, there are not enough funds for that withdrawal.");
									continue logged;
								}
								if (bad.updateBankAccount(accountChoice, -val)) {	
								clearScreen();
								System.out.println("$" + val + " has been successfully withdrawn from your account.");
								continue logged;
								}
							} else {
								clearScreen();
								System.out.println("Returning...");
								continue logged;
							}

						} else if (s.equals("deposit")) { ////////////////////////////

							System.out.println(depositMenu);

							for (BankAccount b : bal) {
								System.out.println(b.toString());
							}
							System.out.print(selectAccount);

							s = keyboard.next();
							Integer accountChoice = Integer.decode(s);

							if (cd.getCustomerId(user, pass) == bad.getBankAccountOwner(accountChoice)) {
								clearScreen();
								System.out.println("That is a valid account choice.");
								System.out.println("How much would you like to deposit?");
								s = keyboard.next();
								Float val = Float.parseFloat(s);
								if (val < 0) {
									clearScreen();
									System.out.println("Sorry, user must input a positive value.");
									continue logged;
								}

								if (bad.updateBankAccount(accountChoice, val)) {
									clearScreen();
									System.out.println("$" + val + " successfully deposited to your account.");
								}
								continue logged;
							}
						} else if (s.equals("history")) {
							System.out.println(viewAccounts);
							for (BankAccount b : bal) {
								System.out.println(b.toString());
							}
							System.out.println(selectAccount);
							s = keyboard.next();
							Integer accountChoice = Integer.decode(s);
							if (cd.getCustomerId(user, pass) == bad.getBankAccountOwner(accountChoice)) {
								clearScreen();
								System.out.println(
										"That is a valid account choice. Here is the transaction history for the account: ");
								s = keyboard.next();
							}

						} else if (s.equals("logout")) {
							// LOGOUT
							loggedIn = false;
						} else {
							// UNRECOGNIZED SELECTION
							continue logged;
						}

					}
				}
			} else {
				System.out.println(failedToLogin);
				// continue start;
				s = keyboard.next();
			}
		}
	}

	private static final int PAGE_SIZE = 100;

	private static void clearScreen() {
		for (int i = 0; i < PAGE_SIZE; i++)
			System.out.println();
	}

	public static String failedToLogin = new String("Sorry that username and password was not accepted.");
	public static String userMenu = new String("Welcome back! Please view your options below and make a selection. ");
	public static String wMsg = new String("Welcome to JDBC Bank.");
	public static String loginMsg = new String(
			"Please enter your username, type 'new' to register an account, or 'exit' to exit: ");
	public static String superUserMenu = new String(
			"Type any command on the left side to access the corresponding menu."
					+ "users    - Access the users menu.\n" + "accounts - Access the accounts menu.\n"
					+ "trans    - Access the transactions menu .\n");
	public static String registeredUserMenu = new String(
			"Type any command on the left side to access the corresponding menu."
					+ "\nhistory    - View your accounts and their history."
					+ "\ndeposit    - Make a deposit to one of your accounts."
					+ "\nwithdrawal - Withdraw money from an account"
					+ "\nlogout     - Logout from the current session.");
	public static String passwdPrompt = new String("Please enter your password: ");
	public static String newUserNamePrompt = new String("Please enter a new username: ");
	public static String newPasswordPrompt = new String("Please enter a new password: ");
	public static String viewAccounts = new String("Your account information is as follows: ");
	public static String selectAccount = new String("Select an account number or type anything else to return: ");
	public static String depositMenu = new String("Select an account for a deposit: ");
	public static String withdrawalMenu = new String("Select an account for a withdrawal");

	static boolean running = true;
	static boolean superUser = true;
	static boolean registeredUser = true;
	static boolean loggedIn = true;
	static boolean userFound = true;
	static boolean passwordMatches = true;
	int entry;

	// static String s = new String;
	static Scanner keyboard = new Scanner(System.in);
}
