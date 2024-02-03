public class Bank {
    private IAccount[] accounts;
    private int numberOfAccounts; // To keep track of the number of accounts currently stored

    public Bank(int size) {
        this.accounts = new IAccount[size];
        this.numberOfAccounts = 0;
    }

    public void openAccount(IAccount account) {
        // Check if we have space to add a new account
        if (numberOfAccounts < accounts.length) {
            // Check for unique account number
            for (int i = 0; i < numberOfAccounts; i++) {
                if (accounts[i].getAccountNumber() == account.getAccountNumber()) {
                    System.out.println("Account with number " + account.getAccountNumber() + " already exists.");
                    return;
                }
            }
            accounts[numberOfAccounts++] = account;
        } else {
            System.out.println("Bank is at full capacity, cannot open new accounts.");
        }
    }

    public boolean closeAccount(int accountNumber) {
        for (int i = 0; i < numberOfAccounts; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                if (accounts[i].getCurrentBalance() >= 0) {
                    // Move the last account in the list to the current position
                    accounts[i] = accounts[numberOfAccounts - 1];
                    accounts[numberOfAccounts - 1] = null; // Nullify the reference of the moved account
                    numberOfAccounts--; // Decrease the count of accounts
                    return true;
                } else {
                    System.out.println("Cannot close account in debt.");
                    return false;
                }
            }
        }
        System.out.println("Account number " + accountNumber + " not found.");
        return false;
    }

    public IAccount[] getAllAccounts() {
        // Return a copy of the accounts array with only the active accounts
        IAccount[] activeAccounts = new IAccount[numberOfAccounts];
        System.arraycopy(accounts, 0, activeAccounts, 0, numberOfAccounts);
        return activeAccounts;
    }

    public IAccount[] getAllAccountsInDebt() {
        int count = 0;
        for (IAccount account : accounts) {
            if (account != null && account.getCurrentBalance() < 0) {
                count++;
            }
        }

        IAccount[] accountsInDebt = new IAccount[count];
        int index = 0;
        for (IAccount account : accounts) {
            if (account != null && account.getCurrentBalance() < 0) {
                accountsInDebt[index++] = account;
            }
        }
        return accountsInDebt;
    }

    public IAccount[] getAllAccountsWithBalance(double amount) {
        int count = 0;
        for (IAccount account : accounts) {
            if (account != null && account.getCurrentBalance() >= amount) {
                count++;
            }
        }

        IAccount[] accountsWithBalance = new IAccount[count];
        int index = 0;
        for (IAccount account : accounts) {
            if (account != null && account.getCurrentBalance() >= amount) {
                accountsWithBalance[index++] = account;
            }
        }
        return accountsWithBalance;
    }
}
