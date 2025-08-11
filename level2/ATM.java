// Program to Simulate an ATM

class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

    // Constructor to initialize account details
    BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to deposit money
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money (with balance check)
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to display current balance
    void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class ATM {
    public static void main(String[] args) {
        // Create a bank account
        BankAccount account = new BankAccount("Ravi Kumar", "1234567890", 5000);

        // Display initial balance
        account.displayBalance();

        System.out.println("\nDepositing ₹2000...");
        account.deposit(2000);

        System.out.println("\nWithdrawing ₹1500...");
        account.withdraw(1500);

        System.out.println("\nTrying to withdraw ₹7000...");
        account.withdraw(7000);

        // Final balance
        System.out.println("\nFinal Account Details:");
        account.displayBalance();
    }
}
