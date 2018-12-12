/**
 * This class will serve as the intermediary between our ATM program and
 * the database of BankAccounts. It'll be responsible for fetching accounts
 * when users try to login, as well as updating those accounts after any
 * changes are made.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Database extends BankAccount {
	
	private String path;
	private String[] accounts;
	private static FileReader fr;
	private static BufferedReader br;
	private static BufferedWriter write;
	
	public Database(String[] accounts, FileReader freader, BufferedReader breader, BufferedWriter write, String path, float balance, long accountNumber, String accountOwner, double withdraw, double deposit, double transfer, String firstName, String lastName, int pin, int phone, String birthdate, int ssn, String address) throws FileNotFoundException, IOException {
		super(balance, accountNumber, accountOwner, withdraw, deposit, transfer, firstName, lastName, pin, phone, birthdate, ssn, address);
		this.path = path;
		this.accounts = getAllAccounts();
		this.freader = freader;
		this.breader = breader;
	}

	/**
	 * Initializes the database with all accounts.
	 * 
	 * @return an array of all accounts
	 */
	
	public String[] getAllAccounts() throws FileNotFoundException, IOException {
		int count = 0;
		String[] accounts = new String[10];
		
		FileReader altered = null;
		InputStreamReader original = null;
		try {
			altered = new FileReader(System.getProperty("user.dir") + File.separator + path);			
		} catch (FileNotFoundException e) {
			original = new InputStreamReader(getClass().getResourceAsStream(path));
		}
		
		try (BufferedReader br = new BufferedReader(original != null ? original : altered)) {
			String line;
			
			while ((line = br.readLine()) != null) {
				if (count >= accounts.length) {
					accounts = Arrays.copyOf(accounts, accounts.length + 10);
				}
				accounts[count++] = line;
			}
		}
		
		return Arrays.copyOf(accounts, count);
	}
	
	/**
	 * Retrieves an account by account number.
	 * 
	 * @param accountNumber the account number of the account to retrieve
	 * @return a BankAccount
	 */
	
	public BankAccount getAccount(long accountNumber) {
		for (String account : accounts) {
			if (account.startsWith(String.valueOf(accountNumber)) && account.endsWith("Y")) {
				return new BankAccount(account);
			}
		}
		
		return null;
	}
	
	/**
	 * Updates a BankAccount.
	 * 
	 * @param account the primary account being updated
	 * @param destination the secondary account being updated
	 * @throws IOException 
	 */
	
	public static void deactivate() {
		System.out.println("Are you sure you want to deactivate your account? Enter 'y' or 'n'.");
		String temp = in.nextLine();
		char choice = temp.charAt(0);
		switch (choice) {
		case 'no':
			break;
		case 'yes':
			try {
				freader = new FileReader("src\\accounts-db.txt");
				breader = new BufferedReader(freader);
				String line;
				for (int i = 0; i < accounts.length; i++) {
					line = breader.readLine();
					if (line.contains(User.getLastName())) {
						accounts[i] = line.substring(0, 145) + "N";
					}
				}
				writer = new BufferedWriter(new FileWriter("src\\accounts-db.txt"));
				for(int i = 0; i < accounts.length; i++) {
					if (i == (accounts.length - 1)) {
						write.write(accounts[i]);
					}
					else {
						write.write(accounts[i]);
						write.newLine();
					}
				}
				write.flush();
				write.close();
			}
			catch (FileNotFoundException e) {
				System.out.println("File not found.");
			}
			catch (IOException e) {
				System.out.println("Cannot read file!");
			}
			finally {
				if (breader != null) {
					try {
						breader.close();
					}
					catch (IOException e) { 
						/* ensure close */ 
					}
				}
				if (freader != null) {
					try {
						freader.close();
					}
					catch (IOException e) { 
						/* ensure close */ 
					}
				}
				if (write != null) {
					try {
						write.close();
					}
					catch (IOException e) { 
						/* ensure close */ 
					}
				}
			}
			System.out.println("Account deactivated.");
		}
	}
	public void updateAccount(BankAccount account, BankAccount destination) throws IOException {
		boolean newAccount = true;
		
		public static void updatePin() {
			System.out.println("Current pin: ");
			int tempPin = in.nextInt();
			boolean isCorrect = Database.setPin();
			if (isCorrect == true) {
				System.out.println("New pin: ");
				newPin = in.nextInt();
				if (User.setPin(newPin) == true) {
					
				}
			}
		}
		
		for (int i = 0; i < accounts.length; i++) {			
			if (accounts[i].startsWith(String.valueOf(BankAccount.getAccountNumber()))) {
				accounts[i] = account.toString();
				newAccount = false;
			}
			
			if (destination != null) {
				if (accounts[i].startsWith(String.valueOf(BankAccount.getAccountNumber()))) {
					accounts[i] = destination.toString();
				}
			}
		}
		
		if (newAccount) {
			accounts = Arrays.copyOf(accounts, accounts.length + 1);
			accounts[accounts.length - 1] = account.toString();
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + File.separator + path))) {
			for (String acct : accounts) {
				bw.write(acct);
				bw.newLine();
			}
		}
	}
	
	public static void createAccount() {
		long temporaryAcctnum = 100000001;
		while (checkAccountNumber(temporaryAcctnum) == true) {
			temporaryAcctnum++;
		}
		String Acctnum = Long.toString(temporaryAcctnum);
		System.out.println("Enter the pin you want: ");
		int newPin = in.nextInt();
		if (String.valueOf(newPin).length() == 4) {
			String pin = String.valueOf(newPin);
			in.nextLine();
			System.out.println("Enter year of birth: ");
			String year = in.nextLine();
			if (year.length() == 4) {
				System.out.println("Enter month of birth: ");
				String month = in.nextLine();
				if (month.length() == 2) {
					System.out.println("Enter day of birth: ");
					String day = in.nextLine();
					String newbirthdate = year + month + day;
					System.out.println("\nEnter phone number: ");
					String newphone= in.nextLine();
					if (newphone.length() == 10) {
						System.out.println("Please enter street address: ");
						String newstreet= in.nextLine();
						System.out.println("\nPlease enter city.");
						String newcity = in.nextLine();
						System.out.println("\nPlease enter state abbreviation.");
						String newstate = in.nextLine();
						System.out.println("\nPlease enter zip code.");
						String newzip = in.nextLine();
						while (newstreet.length() != 30) {
							newstreet = newstreet + " ";
						}
						while (newcity.length() != 30) {
							newcity = newcity + " ";
						}
						String newaddress = newsteret + newcity + newstate + newzipcode;
						String newname = User.getLastName() + ", " + User.getFirstName();
						while (newname.length() != 32) {
							newname = newname + " ";
						}
						try {
							freader = new FileReader("src\\accounts-db.txt");
							breader = new BufferedReader(freader);
							writer = new BufferedWriter(new FileWriter("src\\accounts-db.txt"));
							String out = Acctnum + newpin + "0.00           " + newname + newbirthdate + newphone + newaddress + "Y";
							for(int i = 0; i < (accounts.length + 1); i++) {
								if (i == (accounts.length)) {
									write.write(output);
								}
								else {
									write.write(accounts[i]);
									write.newLine();
								}
							}
							write.flush();
							write.close();
						}
						catch (FileNotFoundException e) {
							System.out.println("Could not find");
						}
						catch (IOException e) {
							System.out.println("Error");
						}
						finally {
							if (breader != null) {
								try {
									breader.close();
								}
								catch (IOException e) { 
									/* ensure close */ 
								}
							}
							if (freader != null) {
								try {
									freader.close();
								}
								catch (IOException e) { 
									
								}
							}
							if (write != null) {
								try {
									write.close();
								}
								catch (IOException e) { 
								
								}
							}
						}
						System.out.println("New account successfully cerated.");
					}
					else {
						System.out.println("Invalid phone number.");
					}
				}
				else {
					System.out.println("Invalid month.");
				}
			}
			else {
				System.out.println("Invalid year.");
			}
		}
		else {
			System.out.println("Invalid pin.");
		}
	}
	
	/**
	 * Retrieves the largest account number in the database.
	 * 
	 * @return the largest account number
	 */
	
	public long getMaxAccountNumber() {
		long max = -1L;
		
		for (String account : accounts) {
			long accountNumber = Long.parseLong(account.substring(0, 9));
			
			if (accountNumber > max) {
				max = accountNumber;
			}
		}
		return max;
	}
}
