import java.util.Scanner;

public class BankInterface {

	
	public static void main(String[] args) {
		
		
		Scanner keyboard = new Scanner(System.in);
		int entry;
		String s;
		
		boolean running = true;
		boolean superUser = true;
		boolean registeredUser = true;
		boolean loggedIn = true;
		boolean userFound = true;
		boolean passwordMatches = true;
		
		start:
		while(running) {
			
			System.out.println(wMsg);System.out.println(loginMsg);
			s = keyboard.next();
			
			if(userFound) { // CHECK DB FOR USERNAME
				System.out.println(passwdPrompt);
				s = keyboard.next();
				
			} else {
			
				System.out.print(newUserPrompt);
				s = keyboard.next();
				s.toLowerCase();
				if(s.equals("yes")) {
					// MAKE A NEW USER
					continue start;
				}
				
				if(passwordMatches) { // CHECK FOR PASSWORD MATCH
					logged:
					while(loggedIn) {
					System.out.print(userMenu); System.out.println(registeredUserMenu);
					s = keyboard.next();
					s = s.toLowerCase();
					
					if(s.equals("withdrawal")) {
						//WITHDRAWAL MENU
					} else if(s.equals("deposit")) {
						//DEPOSIT MENU
					} else if(s.equals("balance")) {
						//BALANCE MENU
					} else if(s.equals("logout")){
						//LOGOUT
						loggedIn = false;
					} else { 
						//UNRECOGNIZED SELECTION
						continue logged;
					}
					
					}
				} else {
					System.out.println(failedToLogin);
					continue start;
				}
			} keyboard.close();
		}
	}
	
	public static String failedToLogin = new String ("Sorry that username and password was not accepted.");
	public static String userMenu = new String("Welcome back! Please view your options below and make a selection: ");
	public static String wMsg = new String("Welcome to JDBC Bank.");
	public static String loginMsg = new String("Please enter your username or type 'new' to register");
	public static String superUserMenu = new String("Type any command on the left side to access the corresponding menu.\n" +
	"users    - Access the users menu.\n" +
	"accounts - Access the accounts menu.\n" +
	"trans    - Access the transactions menu .\n");
	public static String registeredUserMenu = new String("Type any command on the left side to access the corresponding menu.\n" +
	"balance  - View your accounts and their balances." +
	"deposit  - Make a deposit to one of your accounts." +
	"withdrawal - Withdraw money from an account.");
	public static String passwdPrompt = new String("Please enter your password: ");
	public static String newUserPrompt = new String ("Would you like to create a new account? yes/no:");
}
