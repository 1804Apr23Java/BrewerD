package com.revature.main;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.domain.Customer;

public class BankInterface {

	public static void main(String[] args) {
		
		CustomerDao cd = new CustomerDaoImpl();
		
		//cd.insertCustomer("daveboy", "lesssecurepassword");
		
		if(cd.checkCustomerPassword("daveboy", "lessecurepassword")) {
			System.out.println("Customer found.");
		} else {
			System.out.println("Not found");
		}
		
		
		
		
		/*List<Customer> customers = cd.getCustomers();
		
		for (Customer c : customers) {
			System.out.println(c.toString());
			System.out.println("loopin");
		}*/
	}
}	/*//Customer
		BeehiveDao bd = new BeehiveDaoImpl();
		List<Beehive> beehives = bd.getBeehives();
		
		for (Beehive b : beehives) {
			System.out.println(b.toString());
		}


		String s = new String();

		start: while (running) {

			clearScreen();
			System.out.println(wMsg);
			System.out.print(loginMsg);
			s = keyboard.next();
			s = s.toLowerCase();

			if (s.equals("exit"))
				System.exit(0);

			if (userFound) { // CHECK DB FOR USERNAME
				clearScreen();
				System.out.print(passwdPrompt);
				s = keyboard.next();

			} else {
				clearScreen();
				System.out.print(newUserPrompt);
				s = keyboard.next();
				s.toLowerCase();
				if (s.equals("yes")) {
					// MAKE A NEW USER
					continue start;
				}
			}

			if (passwordMatches) { // CHECK FOR PASSWORD MATCH

				loggedIn = true;
				logged: while (loggedIn) {
					clearScreen();
					System.out.print(userMenu);
					System.out.println(registeredUserMenu);
					s = keyboard.next();
					s = s.toLowerCase();

					if (s.equals("withdrawal")) {
						System.out.println(withdrawalMenu);
						s = keyboard.next();
					} else if (s.equals("deposit")) {
						System.out.println(depositMenu);
						s = keyboard.next();
					} else if (s.equals("balance")) {
						System.out.println(viewAccounts);
						s = keyboard.next();
					} else if (s.equals("logout")) {
						// LOGOUT
						loggedIn = false;
					} else {
						// UNRECOGNIZED SELECTION
						continue logged;
					}

				}
			} else {
				System.out.println(failedToLogin);
				continue start;
			}

		}
		keyboard.close();
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
					+ "\nbalance    - View your accounts and their balances."
					+ "\ndeposit    - Make a deposit to one of your accounts."
					+ "\nwithdrawal - Withdraw money from an account"
					+ "\nlogout     - Logout from the current session.");
	public static String passwdPrompt = new String("Please enter your password: ");
	public static String newUserPrompt = new String("Would you like to create a new account? yes/no: ");
	public static String viewAccounts = new String("Your account information is as follows: ");
	public static String depositMenu = new String("Select an account for a deposit: ");
	public static String withdrawalMenu = new String("Select an account for a withdrawal");

	static boolean running = true;
	static boolean superUser = true;
	static boolean registeredUser = true;
	static boolean loggedIn = true;
	static boolean userFound = true;
	static boolean passwordMatches = true;
	int entry;

	static String s;
	static Scanner keyboard = new Scanner(System.in);
}
*/