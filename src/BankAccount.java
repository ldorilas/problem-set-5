/**
 * Just like last time, the BankAccount class is primarily responsible
 * for depositing and withdrawing money. In the enhanced version, there
 * will be the added requirement of transferring funds between accounts.
 * 
 * Most of the functionality for this class should have already been
 * implemented last time. You can always reference my Github repository
 * for inspiration (https://github.com/rwilson-ucvts/java-sample-atm).
 */

public class BankAccount extends User {
	private static long generatedAccountNumber = 100000001L;
	private float balance;
    private long accountNumber;
    private String accountOwner;
    private double withdraw;
    private double deposit;
    
    public BankAccount (float balance, long accountNumber, String accountOwner, double withdraw, double deposit, double transfer, String firstName, String lastName, int pin, int phone, String birthdate, int ssn, String address) {
        super(firstName, lastName, pin, phone, birthdate, ssn, address);
        this.balance = balance;
        this.accountNumber = BankAccount.generatedAccountNumber++;
        this.withdraw = withdraw;
        this.deposit = deposit;
    }

	public float getBalance() {
        return balance;
    }
    
    public long getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountOwner() {
        return accountOwner;
    }
    
    public double getWithdraw() {
        return withdraw;
    }
    
    public double getDeposit() {
        return deposit;
    }
    
    public void setBalance(float balance) {
        this.balance = balance;
    }
    
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }
    
    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }
    
    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }
    
    public float deposit(double amount) {
        if (amount <= 0) {
            return 0;
        }
        
        else {
            balance = (float) (balance + amount);
            return 1;
        }
    }
    
    public float withdraw(double amount) {
        if (amount > balance) {
            return 0;
        }
        
        else if (amount <= 0) {
            return 1;
        }
        
        else {
            balance = (float) (balance - amount);
            return 2;
        }
    }
    
    public float transfer(double amount) {
    	if (amount > balance) {
    		return 0;
    	}
    	
    	else if (amount <= 0) {
    		return 1;
    	}
	else if (accountNumber == null) {
		return 2;
	}
	else {
		balance = (float) (balanace - amount);
	}
    }
}
