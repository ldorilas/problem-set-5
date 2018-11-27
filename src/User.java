/**
 * Just like last time, the User class is responsible for retrieving
 * (i.e., getting), and updating (i.e., setting) user information.
 * This time, though, you'll need to add the ability to update user
 * information and display that information in a formatted manner.
 * 
 * Most of the functionality for this class should have already been
 * implemented last time. You can always reference my Github repository
 * for inspiration (https://github.com/rwilson-ucvts/java-sample-atm).
 */

import java.util.Scanner;
public class User {
	Scanner in = new Scanner(System.in);
	private static String firstName;
	private static String lastName;
	private int pin;
	private String birthdate;
	private int phone;
	private int ssn;
	private String address;
	
	public User (String firstName, String lastName, int pin, int phone, String birthdate, int ssn, String address) {
	
	}
	
	public int getPhone() {
	    return phone;
	}
	
	public static String getFirstName() {
	    return firstName;
	}
	
	public static String getLastName() {
		return lastName;
	}
	
	public String getBirthdate() {
	    return birthdate;
	}
	
	public int getSsn() {
	    return ssn;
	}
	
	public String getAddress() {
	    return address;
	}
	
	public int setPin() {
	    System.out.println("Enter pin: ");
	    pin = in.nextInt();
	    while (Integer.toString(pin).length() == 4) {
	    	if (Integer.toString(pin).length() != 4) {
	    		System.out.println("Pin must be 4 digits long.");
	    	}
	    	else if (Integer.toString(pin).length() == 0) {
		    	System.out.println("Enter a pin number.");
	    	}
	    	else if (pin != setPin()) {
	    		System.out.println("Incorrect pin.");	
	    	}
	    }
	    return pin;
	}
	
	public void updatePin() {
		System.out.println("Current pin: ");
		int reset = in.nextInt();
		while (reset != pin) {
			System.out.println("New pin: ");
			pin = in.nextInt();
		}
	}
	
	public void setPhone(int phone) {
	    this.phone = phone;
	}
	
	public void setFirstName(String firstName) {
		System.out.println("Enter first name: ");
		firstName = in.nextLine();
	}
	
	public void setLastName(String lastName) {
		System.out.println("Enter last name: ");
		lastName = in.nextLine();
	}
	
	public void setBirthdate(String birthdate) {
	    this.birthdate = birthdate;
	}
	
	public void setSsn(int ssn) {
	    this.ssn = ssn;
	}
	
	public void setAddress(String address) {
	    this.address = address;
	}
}
