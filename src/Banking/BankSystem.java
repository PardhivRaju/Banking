package Banking;

import java.util.Scanner;

public class BankSystem {
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n-- Bank Management System --");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Account Info");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    displayAccountInfo(scanner);
                    break;
                case 5:
                    bank.displayAllAccounts();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter Account Holder Name: ");
        String holderName = scanner.next();
        System.out.print("Enter Initial Deposit: ");
        double initialDeposit = scanner.nextDouble();

        Account account = new Account(accountNumber, holderName, initialDeposit);
        bank.addAccount(account);
        System.out.println("Account created successfully!");
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();
        Account account = bank.getAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter Deposit Amount: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();
        Account account = bank.getAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter Withdrawal Amount: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void displayAccountInfo(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();
        Account account = bank.getAccount(accountNumber);

        if (account != null) {
            account.displayAccountInfo();
        } else {
            System.out.println("Account not found.");
        }
    }
}
