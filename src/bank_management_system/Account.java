package bank_management_system;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import bank_management_system.exception.InsufficientBalanceException;
import bank_management_system.exception.InvalidAmountException;

public class Account {

    private final String accountNumber;
    private final String customerName;
    private BigDecimal balance;
    private final List<Transaction> transactionHistory;

    public Account(String accountNumber,String customerName,BigDecimal initialBalance) {

        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number cannot be empty.");
        }

        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("Customer name cannot be empty.");
        }

        if (initialBalance == null ||initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException( "Initial balance cannot be negative.");
        }

        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();

        // Record initial deposit if balance is greater than zero
        if (initialBalance.compareTo(BigDecimal.ZERO) > 0) {
            addTransaction(TransactionType.DEPOSIT,initialBalance);
        }
    }

    public void deposit(BigDecimal amount) {

        validateAmount(amount);
        balance = balance.add(amount);
        addTransaction(TransactionType.DEPOSIT,amount);
    }

    public void withdraw(BigDecimal amount) {

        validateAmount(amount);
        if (amount.compareTo(balance) > 0) {
            throw new InsufficientBalanceException("Insufficient balance. Available balance: ₹"+ balance);
        }

        balance = balance.subtract(amount);
        addTransaction(TransactionType.WITHDRAWAL,amount);
    }

    private void validateAmount(BigDecimal amount) {

        if (amount == null ||amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAmountException("Transaction amount must be greater than zero.");
        }
    }

    private void addTransaction(TransactionType type,BigDecimal amount) {

        String transactionId ="TXN-" +UUID.randomUUID()
                                          .toString()
                                          .substring(0, 8)
                                          .toUpperCase();

        Transaction transaction =new Transaction(transactionId,type,amount,balance);
        transactionHistory.add(transaction);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return Collections.unmodifiableList( transactionHistory);
    }

    public void displayAccountDetails() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("           ACCOUNT DETAILS");
        System.out.println("==========================================");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Customer Name  : " + customerName);
        System.out.printf("Balance        : ₹%.2f%n", balance);
        System.out.println("==========================================");
    }

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customerName=" + customerName + ", balance=" + balance
				+ ", transactionHistory=" + transactionHistory + "]";
	}
    
    
}
