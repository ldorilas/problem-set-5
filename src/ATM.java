/**
 * Just like last time, the ATM class is responsible for managing all
 * of the user interaction. This means login procedures, displaying the
 * menu, and responding to menu selections. In the enhanced version, the
 * ATM class will have the added responsibility of interfacing with the
 * Database class to write and read information to and from the database.
 * 
 * Most of the functionality for this class should have already been
 * implemented last time. You can always reference my Github repository
 * for inspiration (https://github.com/rwilson-ucvts/java-sample-atm).
 */

import java.util.Scanner;
public class ATM extends BankAccount {
    Scanner in = new Scanner(System.in);
    private BankAccount account;
    
    public ATM(BankAccount account, float balance, String accountOwner, long accountNumber, double withdraw, double deposit, String firstName, int pin) {
        super(balance, accountNumber, accountOwner, deposit, withdraw, firstName, pin);
    }
    
    public BankAccount getAccount() {
    	return account;
    }
    
    
    
    public static void menu() {
        User.getFirstName();
    	System.out.println("Hello, " + User.getFirstName() + ". " + "Press i to edit account information, b to see balance, w to withdraw, d to deposit, and e to exit.");
        char option = in.nextChar();
        //if (BankAccount.getAccountNumber() ) {
            User.getPin();
            while (option != 'e') {
                if (User.getPin() == true) {
                    if (option == 'd') {
                        BankAccount.setDeposit();
                    }
                    else if (option == 'w') {
                        BankAccount.setWithdraw();
                    }
                    else if (option == 'b') {
                        BankAccount.setBalance();
                    }
                    else if (option == 'i') {
                    	System.out.println("What information would you like to edit? Press a for address and p for pin");
                    }
                    else {
                        System.out.println("Not valid command.");
                    }
                }
                if (option == 'e') {
                    System.out.println("Thank you and have a good day, " + User.getFirstName());
                }
                else {
                System.out.println("Enter correct pin.");
                }
            }        
        }
    }
}
