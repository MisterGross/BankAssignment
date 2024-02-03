public class MainTest {
    public static void main(String[] args) {
        // Test BasicAccount
        BasicAccount basicAccount = new BasicAccount(111111, 300.00); // Account with withdrawal limit
        testAccountOperations(basicAccount);
        testNegativeDeposit(basicAccount);
        testZeroBalanceWithdrawal(basicAccount);

        // Test StandardAccount
        StandardAccount standardAccount = new StandardAccount(222222, 500.00); // Account with credit limit
        testAccountOperations(standardAccount);
        testNegativeDeposit(standardAccount);
        testCreditLimitWithdrawal(standardAccount);
    }
    private static void testAccountOperations(IAccount account) {
        System.out.println("Testing account number: " + account.getAccountNumber());

        // Test deposit
        try {
            account.deposit(1000.00);
            System.out.println("Deposit successful. Current balance: " + account.getCurrentBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to deposit: " + e.getMessage());
        }

        // Test withdrawal within the limit
        try {
            account.withdraw(250.00);
            System.out.println("Withdrawal successful. Current balance: " + account.getCurrentBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to withdraw: " + e.getMessage());
        }

        // Test withdrawal that exceeds the limit
        try {
            account.withdraw(600.00);
            System.out.println("Withdrawal successful. Current balance: " + account.getCurrentBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to withdraw: " + e.getMessage());
        }

        // Test withdrawal with negative amount
        try {
            account.withdraw(-50.00);
            System.out.println("Withdrawal successful. Current balance: " + account.getCurrentBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to withdraw: " + e.getMessage());
        }

        // Final account balance
        System.out.println("Final balance for account number " + account.getAccountNumber() + ": " + account.getCurrentBalance());
        System.out.println("-----------------------");
    }


    private static void testNegativeDeposit(IAccount account) {
             // Test depositing a negative amount
              try {
                account.deposit(-100.00);
                System.out.println("Negative deposit should not be successful.");
            } catch (IllegalArgumentException e) {
                System.out.println("Correctly caught negative deposit: " + e.getMessage());
            }
        }

        private static void testZeroBalanceWithdrawal(BasicAccount account) {
            // Test withdrawing from zero balance
            try {
                account.withdraw(10.00); // Attempt to withdraw with zero balance
                System.out.println("Withdrawal from zero balance should not be successful.");
            } catch (IllegalArgumentException e) {
                System.out.println("Correctly caught withdrawal from zero balance: " + e.getMessage());
            }
        }

        private static void testCreditLimitWithdrawal(StandardAccount account) {
            // Test withdrawing up to the credit limit
            try {
                account.withdraw(account.getCreditLimit());
                System.out.println("Withdrawal up to the credit limit successful. Current balance: " + account.getCurrentBalance());
            } catch (IllegalArgumentException e) {
                System.out.println("Failed to withdraw up to the credit limit: " + e.getMessage());
            }
        }
    }




