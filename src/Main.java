public class Main {
    public static void main(String[] args) {
        // Create a new premium account with a unique account number
        PremiumAccount account = new PremiumAccount(123456);

        // Test depositing a positive amount
        try {
            account.deposit(500.00);
            System.out.println("Deposit successful. Current balance is: " + account.getCurrentBalance());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Test withdrawing a valid amount
        try {
            account.withdraw(200.00);
            System.out.println("Withdrawal successful. Current balance is: " + account.getCurrentBalance());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Test withdrawing an amount that exceeds the balance
        try {
            account.withdraw(1000.00);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Test depositing a negative amount
        try {
            account.deposit(-150.00);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Test withdrawing a negative amount
        try {
            account.withdraw(-50.00);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Print the final state of the account
        System.out.println("Final account balance: " + account.getCurrentBalance());
    }
}
