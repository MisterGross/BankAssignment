public interface IAccount {
    void deposit(double amount);
    void withdraw(double amount);
    double getCurrentBalance();
    int getAccountNumber();
}
