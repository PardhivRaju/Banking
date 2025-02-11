package Banking;

public class Admin {
    private String username = "admin"; // Set a default username for admin
    private String password = "admin123"; // Set a default password for admin

    // Method for Admin login
    public boolean login(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    // Method to view all accounts in the system
    public void viewAllAccounts(Database database) {
        System.out.println("All Accounts in the System:");
        for (Account account : database.getAllAccounts().values()) {
            account.viewAccountInfo();
        }
    }
}
