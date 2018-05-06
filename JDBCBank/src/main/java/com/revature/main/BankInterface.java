package com.revature.main;

import java.util.Scanner;

import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;

public class BankInterface {

	public static void main(String[] args) {

		String s = new String();
		String pass = new String();
		String user = new String();

		CustomerDao cd = new CustomerDaoImpl();
		start: while (running) {

			clearScreen();
			System.out.println(wMsg);
			System.out.print(loginMsg);
			s = keyboard.next();
			user = s;

			if (s.equals("exit")) { // If user inputs "exit", then quit
				clearScreen();
				System.out.println("Thank you for using JDBC Bank. Have a nice day.");
				System.exit(0);
			}

			if (s.equals("new")) { // If user inputs "new" then create a new user
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
			s = keyboard.next();
			pass = s;

			if (cd.checkCustomerPassword(user, pass)) { // CHECK FOR PASSWORD MATCH

				loggedIn = true;

				logged: while (loggedIn) {

					clearScreen();
					System.out.println("Login Successful.");

					if (cd.checkAdmin(cd.getCustomerId(user, pass))) {
						System.out.println("Welcome back Mr. Bond. Select an option below: ");
						System.out.println("nuke   - Destroy the world.");
						System.out.println("cat    - Feed Mr. Bigglesworth.");
						System.out.println("drop   - Drop all tables from the database.");
						s = keyboard.next();
						loggedIn = false;

					} else {

						System.out.println(cd.checkAdmin(cd.getCustomerId(user, pass)));

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
					+ "\nbalance    - View your accounts and their balances."
					+ "\ndeposit    - Make a deposit to one of your accounts."
					+ "\nwithdrawal - Withdraw money from an account"
					+ "\nlogout     - Logout from the current session.");
	public static String passwdPrompt = new String("Please enter your password: ");
	public static String newUserNamePrompt = new String("Please enter a new username: ");
	public static String newPasswordPrompt = new String("Please enter a new password: ");
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

	// static String s = new String;
	static Scanner keyboard = new Scanner(System.in);
}