import java.util.Scanner;

// Base Account class
class Account {
    String customerName;
    int accountNumber;
    String accountType;
    double balance;

    public Account(String customerName, int accountNumber, String accountType, double balance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Accept deposit from customer and update the balance
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    // Display the balance
    public void displayBalance() {
        System.out.println("Balance: " + balance);
    }

    // Permit withdrawal and update the balance
    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
        return true;
    }
}

// Derived class for Current Account
class CurAcct extends Account {
    double minimumBalance;
    double penalty;

    public CurAcct(String customerName, int accountNumber, double balance, double minimumBalance, double penalty) {
        super(customerName, accountNumber, "Current", balance);
        this.minimumBalance = minimumBalance;
        this.penalty = penalty;
    }

    // Check for the minimum balance, impose penalty if necessary
    public void checkMinimumBalance() {
        if (balance < minimumBalance) {
            balance -= penalty;
            System.out.println("Minimum balance not maintained. Penalty of " + penalty + " imposed.");
        }
    }
}

// Derived class for Savings Account
class SavAcct extends Account {
    double interestRate;

    public SavAcct(String customerName, int accountNumber, double balance, double interestRate) {
        super(customerName, accountNumber, "Savings", balance);
        this.interestRate = interestRate;
    }

    // Compute and deposit interest
    public void computeAndDepositInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest of " + interest + " has been added.");
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a savings account and a current account
        SavAcct savAccount = new SavAcct("Abhay ", 1001, 1000, 5); // 5% interest rate
        CurAcct curAccount = new CurAcct("Koala", 2001, 2000, 1000, 50); // Min balance = 1000, Penalty = 50

        // Interact with savings account
        System.out.println("Savings Account:");
        savAccount.displayBalance();
        savAccount.deposit(500); // Deposit 500
        savAccount.displayBalance();
        savAccount.computeAndDepositInterest(); // Compute interest
        savAccount.displayBalance();
        savAccount.withdraw(300); // Withdraw 300
        savAccount.displayBalance();

        // Interact with current account
        System.out.println("\nCurrent Account:");
        curAccount.displayBalance();
        curAccount.deposit(200); // Deposit 200
        curAccount.displayBalance();
        curAccount.withdraw(1500); // Withdraw 1500 (more than balance)
        curAccount.displayBalance();
        curAccount.checkMinimumBalance(); // Check for minimum balance and apply penalty
        curAccount.displayBalance();

        System.out.println("ABHAY NY");
        System.out.println("24BECS404");
    }
}
