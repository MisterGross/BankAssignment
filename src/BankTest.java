public class BankTest {
    public static void main(String[] args) {
        // Create a bank with a maximum of 10 accounts
        Bank bank = new Bank(10);

        // Test opening accounts
        IAccount account1 = new BasicAccount(111111, 300.00);
        IAccount account2 = new StandardAccount(222222, 500.00);
        IAccount account3 = new PremiumAccount(333333);

        bank.openAccount(account1);
        System.out.println("Opened account 111111");
        bank.openAccount(account2);
        System.out.println("Opened account 222222");
        bank.openAccount(account3);
        System.out.println("Opened account 333333");

        // Make a deposit into one of the accounts
        account2.deposit(200.00);
        System.out.println("Deposited 200.00 into account 222222");

        // Try to open a duplicate account
        bank.openAccount(account1); // Should not be allowed

        // Test closing accounts
        boolean closed = bank.closeAccount(111111); // Should be successful if balance is non-negative
        System.out.println("Account 111111 closed: " + closed);

        closed = bank.closeAccount(444444); // Should fail, account does not exist
        System.out.println("Account 444444 closed: " + closed);

        // Test retrieving all accounts
        IAccount[] allAccounts = bank.getAllAccounts();
        System.out.println("All accounts: " + allAccounts.length);

        // Test accounts in debt
        IAccount[] accountsInDebt = bank.getAllAccountsInDebt();
        System.out.println("Accounts in debt: " + accountsInDebt.length);

        // Test accounts with a specific minimum balance
        IAccount[] accountsWithBalance = bank.getAllAccountsWithBalance(100.00);
        System.out.println("Accounts with minimum balance of 100: " + accountsWithBalance.length);

        // Test bank full capacity
        for (int i = 4; i <= 10; i++) {
            bank.openAccount(new BasicAccount(i, 200.00));
            System.out.println("Opened account " + i);
        }
        bank.openAccount(new BasicAccount(11, 200.00)); // Should not be allowed, bank is at full capacity
    }
}
