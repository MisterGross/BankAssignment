public class BasicAccount implements IAccount {
    private int accountNumber;
    private double balance;
    private double withdrawalLimit;

    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        this.balance = 0; // Basic accounts start with a balance of 0
        this.withdrawalLimit = withdrawalLimit;
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
        if (amount > 0 && amount <= withdrawalLimit && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Invalid withdrawal attempt. " +
                    "Check if the amount exceeds the withdrawal limit or if sufficient funds are available.");
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
}
