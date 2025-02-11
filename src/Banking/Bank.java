package Banking;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public Account getAccountByUsername(String username) {
        for (Account account : accounts.values()) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }

    public void displayAllAccounts() {
        if (Login.isLoggedIn) {
            System.out.println("\n-- All Accounts --");
            for (Account account : accounts.values()) {
                account.displayAccountInfo();
            }
        } else {
            System.out.println("Only admin can view all accounts.");
        }
    }
}



