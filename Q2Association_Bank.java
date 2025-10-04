import java.util.ArrayList;

// Account class: links Customer and Bank
class Account {
    private String accountNumber;
    private double balance;
    private Bank bank;

    public Account(String accountNumber, double initialBalance, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.bank = bank;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Bank getBank() {
        return bank;
    }
}

// Customer class: can have multiple accounts
class Customer {
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (Account acc : accounts) {
            System.out.println("Account: " + acc.getAccountNumber() +
                               " | Bank: " + acc.getBank().getBankName() +
                               " | Balance: ₹" + acc.getBalance());
        }
    }
}

// Bank class: opens accounts for customers
class Bank {
    private String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public Account openAccount(Customer customer, String accountNumber, double initialDeposit) {
        Account newAccount = new Account(accountNumber, initialDeposit, this);
        customer.addAccount(newAccount);
        return newAccount;
    }
}

// Main class to demonstrate association
public class Q2Association_Bank {
    public static void main(String[] args) {
        // Create banks
        Bank sbi = new Bank("State Bank of India");
        Bank hdfc = new Bank("HDFC Bank");

        // Create customers
        Customer dhruv = new Customer("Dhruv Jain");
        Customer rhea = new Customer("Rhea Kapoor");

        // Open accounts
        sbi.openAccount(dhruv, "SBI123", 5000);
        hdfc.openAccount(dhruv, "HDFC456", 10000);
        hdfc.openAccount(rhea, "HDFC789", 7500);

        // View balances
        dhruv.viewBalance();
        System.out.println();
        rhea.viewBalance();
    }
}
