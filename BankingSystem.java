interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class BankAccount implements Loanable {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    protected void setBalance(double balance) { this.balance = balance; }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(holderName + " deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(holderName + " withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance for " + holderName);
        }
    }

    public abstract double calculateInterest();

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
        System.out.println("Interest: " + calculateInterest());
        System.out.println("----------------------------");
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accNum, String name, double bal) {
        super(accNum, name, bal);
    }

    public double calculateInterest() {
        return getBalance() * 0.04;
    }

    public void applyForLoan(double amount) {
        System.out.println(getHolderName() + " applied for a loan of " + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() > 5000;
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String accNum, String name, double bal) {
        super(accNum, name, bal);
    }

    public double calculateInterest() {
        return getBalance() * 0.02;
    }

    public void applyForLoan(double amount) {
        System.out.println(getHolderName() + " applied for a loan of " + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() > 10000;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount("SAV101", "Alice", 8000);
        BankAccount acc2 = new CurrentAccount("CUR202", "Bob", 15000);

        acc1.deposit(2000);
        acc2.withdraw(3000);

        BankAccount[] accounts = {acc1, acc2};
        for (BankAccount acc : accounts) {
            acc.displayAccountDetails();
            acc.applyForLoan(5000);
            System.out.println("Loan Eligibility: " + acc.calculateLoanEligibility());
            System.out.println();
        }
    }
}
