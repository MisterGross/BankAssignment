public class StandardAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double creditLimit;

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        this.balance = 0; // Standard accounts start with a balance of 0
        this.creditLimit = creditLimit;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance + creditLimit >= amount) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Cannot withdraw amount. " +
                    "The requested amount exceeds your available credit limit.");
        }
    }

    @Override
    public double getCurrentBalance() {
        return balance;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    // Method to get the credit limit of the account
    public double getCreditLimit() {
        return creditLimit;
    }
}
