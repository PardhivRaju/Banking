package Banking;

import java.util.Scanner;

public class Signup {
    private static String adminUsername = "admin";
    private static String adminPassword = "admin123";
    private static boolean firstTimeSignup = true;

    public static boolean isFirstTimeSignup() {
        return firstTimeSignup;
    }

    public static void signup(Scanner scanner) {
        if (isFirstTimeSignup()) {
            // Admin signup
            System.out.println("Please create an admin account.");
            System.out.print("Enter Username (admin): ");
            String username = scanner.next();
            System.out.print("Enter Password (admin123): ");
            String password = scanner.next();

            if (username.equals(adminUsername) && password.equals(adminPassword)) {
                System.out.println("Admin account created successfully.");
                firstTimeSignup = false;
                Login.isLoggedIn = true; // Log the admin in immediately after signup
            } else {
                System.out.println("Invalid credentials. Use default admin username and password.");
            }
        } else {
            // User signup
            System.out.println("\nCreate a new account.");
            System.out.print("Enter Account Number: ");
            String accountNumber = scanner.next();
            System.out.print("Enter Account Holder Name: ");
            String holderName = scanner.next();
            System.out.print("Enter Initial Deposit: ");
            double initialDeposit = scanner.nextDouble();
            Account account = new Account(accountNumber, holderName, initialDeposit);

            // Ask user to create username and password
            System.out.print("Create a Username: ");
            String userUsername = scanner.next();
            System.out.print("Create a Password: ");
            String userPassword = scanner.next();

            account.setUsername(userUsername);
            account.setPassword(userPassword);

            Bank bank = new Bank();
            bank.addAccount(account);

            System.out.println("Account created successfully!");
            System.out.println("You can now log in with your credentials.");
        }
    }
}


