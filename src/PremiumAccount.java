public class PremiumAccount implements IAccount {
    private int accountNumber;
    private double balance;

    public PremiumAccount(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0; // Premium accounts start with a balance of 0
    }

    // Adds an amount to the account balance
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            // Handle error: deposit amount must be positive
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    // Withdraws an amount from the account if there are sufficient funds
    @Override
    public void withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
        } else if (amount <= 0) {
            // Handle error: withdraw amount must be positive
            throw new IllegalArgumentException("Withdraw amount must be positive.");
        } else {
            // Handle error: insufficient funds
            throw new IllegalArgumentException("Insufficient funds for withdrawal.");
        }
    }

    // Returns the current account balance
    @Override
    public double getCurrentBalance() {
        return balance;
    }

    // Returns the account number
    @Override
    public int getAccountNumber() {
        return accountNumber;
    }


}
