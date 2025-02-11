package Banking;

import java.util.Scanner;

public class Login {
    public static boolean isLoggedIn = false;
    private static String username;
    private static String password;

    public static void login(Scanner scanner) {
        if (!isLoggedIn) {
            System.out.println("\n-- Login --");
            System.out.print("Enter Username: ");
            username = scanner.next();
            System.out.print("Enter Password: ");
            password = scanner.next();

            // Check if the user is an admin
            if (username.equals("admin") && password.equals("admin123")) {
                isLoggedIn = true;
                System.out.println("Admin logged in successfully!");
            } else {
                // Check if the user exists in the bank system
                Bank bank = new Bank();
                Account account = bank.getAccountByUsername(username);

                if (account != null && account.getPassword().equals(password)) {
                    isLoggedIn = true;
                    System.out.println("User logged in successfully!");
                } else {
                    System.out.println("Invalid username or password. Please try again or sign up.");
                }
            }
        } else {
            System.out.println("You are already logged in.");
        }
    }
}

