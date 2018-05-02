
public class BankInterface {
	
	public static void main(String[] args) {
		
		boolean running = true;
		boolean superUser = true;
		boolean registeredUser = true;
		boolean loggedIn = true;
		
		while(running) {
			
			System.out.println(wMsg + "\n" + loginMsg);
			
			
			if(superUser) { //should be if(superUser());
				while(loggedIn) {
					
					System.out.println(superUserMenu);
					
					
					running = false;
					loggedIn = false;
					
					//superuser menu
				}
			
				
			} else if (registeredUser) {
				while(loggedIn) {
					//regular user menu
				}
				
			} else {
				
				//create account menu
			}
		}
	}
	
	public static String wMsg = new String("Welcome to JDBC Bank.");
	public static String loginMsg = new String("Please enter your username and password to login.");
	public static String superUserMenu = new String("Type any command on the left side to access the corresponding menu.\n" +
	"users    - Access the users menu.\n" +
	"accounts - Access the accounts menu.\n" +
	"trans    - Access the transactions menu.\n");
	public static String registeredUserMenu = new String("Type any command on the left side to access the corresponding menu.\n" +
	"balance  - View your accounts and their balances." +
	"deposit  - Make a deposit to one of your accounts." +
	"withdraw - Withdraw money from an account.");
}
