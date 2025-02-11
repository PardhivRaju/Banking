package Banking;

import java.util.Scanner;

public class BankSystem {
    static Database database = new Database();
    private static Admin admin = new Admin();
    private static User currentUser;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Bank System");
            System.out.println("1. Login as User");
            System.out.println("2. Login as Admin");
            System.out.println("3. Sign Up");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    loginAsUser(scanner);
                    break;
                case 2:
                    loginAsAdmin(scanner);
                    break;
                case 3:
                    signup(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using Bank System.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Admin login method
    private static void loginAsAdmin(Scanner scanner) {
        System.out.print("Enter Admin Username: ");
        String adminUsername = scanner.next();
        System.out.print("Enter Admin Password: ");
        String adminPassword = scanner.next();

        if (admin.login(adminUsername, adminPassword)) {
            System.out.println("Admin logged in successfully!");
            showAdminOptions(scanner);
        } else {
            System.out.println("Invalid Admin credentials.");
        }
    }

    // Admin options after login
    private static void showAdminOptions(Scanner scanner) {
        while (true) {
            System.out.println("Admin Options:");
            System.out.println("1. View All Account Info");
            System.out.println("2. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    admin.viewAllAccounts(database);
                    break;
                case 2:
                    System.out.println("Admin logged out.");
                    return; // Exit the admin menu and go back to main
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // User login method
    private static void loginAsUser(Scanner scanner) {
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.next();
        Account account = database.getAccountByPhoneNumber(phoneNumber);

        if (account != null) {
            System.out.print("Enter Username: ");
            String username = scanner.next();
            System.out.print("Enter Password: ");
            String password = scanner.next();

            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                currentUser = new User(account);
                System.out.println("Login successful!");
                userOperations(scanner);
            } else {
                System.out.println("Invalid username or password.");
            }
        } else {
            System.out.println("Account not found. Please sign up first.");
        }
    }

    // User operations after login
    private static void userOperations(Scanner scanner) {
        while (true) {
            System.out.println("User Options:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Account Info");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    currentUser.deposit(depositAmount); // This will call deposit on Account object
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    currentUser.withdraw(withdrawAmount); // This will call withdraw on Account object
                    break;
                case 3:
                    currentUser.viewAccountInfo(); // This will call viewAccountInfo on Account object
                    break;
                case 4:
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


    // Signup method
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
