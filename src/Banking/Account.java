package Banking;

public class Account {
    private String accountNumber;
    private String holderName;
    private double balance;
    private String username;
    private String password;
    private String phoneNumber;

    public Account(String accountNumber, String holderName, double balance, String username, String password, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter methods
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getPhoneNumber() { return phoneNumber; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful! New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal Successful! New balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void viewAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + holderName);
        System.out.println("Balance: " + balance);
    }
}
