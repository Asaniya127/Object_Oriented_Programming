class BankAccount {
 	private static String bankName = "Central Bank";
 	private static int totalAccounts = 0;
 	private final int accountNumber; 
 	private String accountHolderName;
 	private double balance;
  
 	public BankAccount(int accountNumber, String accountHolderName, double balance) {
     	this.accountNumber = accountNumber;
     	this.accountHolderName = accountHolderName;
   	  this.balance = balance;
     	totalAccounts++; 
 	}

 	public void displayAccountDetails() {
     	if (this instanceof BankAccount ) { 
         	System.out.println("Bank Name: " + bankName);
         	System.out.println("Account Number: " + accountNumber);
         	System.out.println("Account Holder: " + accountHolderName);
         	System.out.println("Balance: $" + balance);
     	}
 	}

 	public static void getTotalAccounts() {
     	System.out.println("Total Bank Accounts: " + totalAccounts);
 	}
 }
 public class Q1BankAccountSystem {
 	public static void main(String[] args) {
     	BankAccount acc1 = new BankAccount(101, "Aman", 500000);
     	BankAccount acc2 = new BankAccount(102, "Adarsh", 300000);

     	acc1.displayAccountDetails();
     	acc2.displayAccountDetails();
     	BankAccount.getTotalAccounts();
 	}
}
