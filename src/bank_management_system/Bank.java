package bank_management_system;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import bank_management_system.exception.AccountNotFoundException;
import bank_management_system.exception.DuplicateAccountException;

public class Bank {

    private final Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber,String customerName, BigDecimal initialBalance) {

        validateAccountNumber(accountNumber);
        
        if (accounts.containsKey(accountNumber)) {
            throw new DuplicateAccountException("Account number already exists: "+ accountNumber);
        }

        Account account =new Account(accountNumber,customerName,initialBalance);
        accounts.put(accountNumber, account);
    }

    public Account findAccount(String accountNumber) {

        Account account = accounts.get(accountNumber);

        if (account == null) {
            throw new AccountNotFoundException("Account not found: " + accountNumber);
        }
        return account;
    }

    public void deposit(String accountNumber,BigDecimal amount) {

        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(String accountNumber,BigDecimal amount) {

        Account account = findAccount(accountNumber);
        account.withdraw(amount);
    }

    public BigDecimal checkBalance(String accountNumber) {

        return findAccount(accountNumber).getBalance();
    }

    public Collection<Account> getAllAccounts() {

        return accounts.values();
    }

    public int getTotalAccounts() {
        return accounts.size();
    }

    private void validateAccountNumber(String accountNumber) {

        if (accountNumber == null ||accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number cannot be empty.");
        }
    }
}