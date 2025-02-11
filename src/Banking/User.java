package Banking;

public class User {
    private Account account; // User has an Account object

    public User(Account account) {
        this.account = account; // Associate the user's account
    }

    // Method to deposit money into the user's account
    public void deposit(double amount) {
        account.deposit(amount); // Delegate deposit to Account
    }

    // Method to withdraw money from the user's account
    public void withdraw(double amount) {
        account.withdraw(amount); // Delegate withdrawal to Account
    }

    // Method to view account information
    public void viewAccountInfo() {
        account.viewAccountInfo(); // Delegate to Account's method to show account info
    }
}


