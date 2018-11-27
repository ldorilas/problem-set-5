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
    private static Scanner input;
    
    public ATM(float balance, long accountNumber, double deposit, double withdraw, int pin, int phone, String firstName, String lastName, int ssn, String birthdate, String address) {
        super(balance, accountNumber, deposit, withdraw, firstName, lastName, pin, phone, ssn, birthdate, address);
    }
    
    Scanner input1 = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
        input.close();
    }
    
    public static void menu() {
        User.getFirstName();
    	System.out.println("Hello, " + User.getFirstName() + "." + "\nPress d to deposit, w to withdraw, b to show balance, and e to exit your account.");
        char option = input.nextChar();
            if (BankAccount.getAccountNumber() == true) {
            User.getPin();
            while (option != 'e') {
                if (User.getPin() == true) {
                    if (option = 'd') {
                        BankAccount.setDeposit();
                    }
                    else if (option = 'w') {
                        BankAccount.setWithdraw();
                    }
                    else if (option = 'b') {
                        BankAccount.setBalance();
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
