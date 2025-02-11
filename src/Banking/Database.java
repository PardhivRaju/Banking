package Banking;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<String, Account> accounts = new HashMap<>();

    // Add new account to the database
    public void addAccount(Account account) {
        accounts.put(account.getPhoneNumber(), account);
    }

    // Get account by phone number
    public Account getAccountByPhoneNumber(String phoneNumber) {
        return accounts.get(phoneNumber);
    }

    // Get all accounts
    public Map<String, Account> getAllAccounts() {
        return accounts;
    }
}
