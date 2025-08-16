package JavaConstructors.AccessModifiers;

import java.util.Scanner;

class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void display() {
        System.out.println("Account Number: " + accountNumber + ", Holder: " + accountHolder);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account number: ");
        String accNum = sc.nextLine();
        System.out.print("Enter account holder name: ");
        String holder = sc.nextLine();
        System.out.print("Enter initial balance: ");
        double bal = sc.nextDouble();

        SavingsAccount sa = new SavingsAccount(accNum, holder, bal);
        sa.display();
        System.out.println("Balance: ₹" + sa.getBalance());
        System.out.print("Enter deposit amount: ");
        double deposit = sc.nextDouble();
        sa.deposit(deposit);
        System.out.println("Updated Balance: ₹" + sa.getBalance());
    }
}
