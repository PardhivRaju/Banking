package Banking;

import java.util.Scanner;

import static Banking.BankSystem.database;

public class Signup {
    private static String adminUsername = "admin";
    private static String adminPassword = "admin123";
    private static boolean firstTimeSignup = true;

    public static boolean isFirstTimeSignup() {
        return firstTimeSignup;
    }

    private static void signup(Scanner scanner) {
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.next();

        // Check if phone number is already registered
        if (database.getAccountByPhoneNumber(phoneNumber) != null) {
            System.out.println("Phone number already registered. Please log in.");
            return;
        }

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter Account Holder Name: ");
        String holderName = scanner.next();
        System.out.print("Enter Initial Deposit: ");
        double initialDeposit = scanner.nextDouble();

        // Collect username and password for login
        System.out.print("Create Username: ");
        String username = scanner.next();
        System.out.print("Create Password: ");
        String password = scanner.next();

        // Create the Account object with all 6 required fields
        Account account = new Account(accountNumber, holderName, initialDeposit, username, password, phoneNumber);

        // Add the new account to the database
        database.addAccount(account);
        System.out.println("Account created successfully! You can now log in.");
    }

}


