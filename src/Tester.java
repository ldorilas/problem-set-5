/**
 * This class has only one responsibility: start the ATM program!
 */

public class Tester {
	
	/**
	 * Main method.
	 * 
	 * @param args
	 */
	
	public Tester(String[] accounts, FileReader fr, BufferedReader br, BufferedWriter write, float balance, long accountNum, float withdraw, float deposit, int pin, String birthdate, int phoneNum, String firstName, String lName, String address, String city, String state, int zipCode) {
		super(accounts, fr, br, write, balance, accountNumber, withdraw, deposit, pin, birthdate, phone, firstName, lastName, address, city, state, zip);
	}
	public static void main(String[] args) {
		ATM.menu();
		/*
		 * Rather than hard coding one or more BankAccount objects, you'll need to read them in
		 * from our very primitive database (i.e., a flat-file). After making changes, of course,
		 * you'll need to update the database accordingly.
		 */
	}
}
