package bank_management_system;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner =new Scanner(System.in);
    private static final Bank bank =new Bank();

    public static void main(String[] args) {

        System.out.println();
        System.out.println("==============================================");
        System.out.println("       WELCOME TO BANK MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        boolean running = true;

        while (running) {

            displayMenu();
            int choice = readInt("Enter your choice: ");

                switch (choice) {

                    case 1:
                        createAccount();
                        break;

                    case 2:
                        depositMoney();
                        break;

                    case 3:
                        withdrawMoney();
                        break;

                    case 4:
                        checkBalance();
                        break;

                    case 5:
                        showAccountDetails();
                        break;

                    case 6:
                        showTransactionHistory();
                        break;

                    case 7:
                        showAllAccounts();
                        break;

                    case 8:
                        System.out.println();
                        System.out.println("Thank you for using Bank Management System.");
                        System.out.println("Application closed successfully.");
                        running = false;
                        break;

                    default:
                        System.out.println("❌ Invalid choice. Please select 1-8.");
                }

            
        }

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println("                MAIN MENU");
        System.out.println("----------------------------------------------");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Show Account Details");
        System.out.println("6. Show Transaction History");
        System.out.println("7. Show All Accounts");
        System.out.println("8. Exit");
        System.out.println("----------------------------------------------");
    }

    private static void createAccount() {

        System.out.println();
        System.out.println("========== CREATE ACCOUNT ==========");
        
        String accountNumber =readString("Enter account number: ");
        String customerName =readString("Enter customer name: ");
        BigDecimal initialBalance =readAmount("Enter initial balance: ₹");

        bank.createAccount(accountNumber,customerName,initialBalance);

        System.out.println();
        System.out.println("✅ Account created successfully!");
        System.out.println("Account Number: " + accountNumber);
    }

    private static void depositMoney() {

        System.out.println();
        System.out.println("========== DEPOSIT MONEY ==========");

        String accountNumber =readString("Enter account number: ");
        BigDecimal amount = readAmount("Enter deposit amount: ₹");

        bank.deposit(accountNumber,amount);

        Account account =bank.findAccount(accountNumber);

        System.out.println();
        System.out.println("✅ Money deposited successfully!");
        System.out.printf("Deposited Amount : ₹%.2f%n", amount);
        System.out.printf("Current Balance  : ₹%.2f%n",account.getBalance());
    }

    private static void withdrawMoney() {

        System.out.println();
        System.out.println("========== WITHDRAW MONEY ==========");

        String accountNumber =readString("Enter account number: ");
        BigDecimal amount =readAmount("Enter withdrawal amount: ₹");

        bank.withdraw(accountNumber,amount);

        Account account =bank.findAccount(accountNumber);

        System.out.println();
        System.out.println("✅ Money withdrawn successfully!");
        System.out.printf("Withdrawn Amount : ₹%.2f%n",amount);
        System.out.printf("Remaining Balance: ₹%.2f%n", account.getBalance());
    }

    private static void checkBalance() {

        System.out.println();
        System.out.println("========== BALANCE CHECK ==========");

        String accountNumber =readString("Enter account number: ");

        BigDecimal balance =bank.checkBalance(accountNumber);

        System.out.println();
        System.out.println("Account Number : " + accountNumber);
        System.out.printf("Current Balance: ₹%.2f%n", balance);
    }

    private static void showAccountDetails() {

        System.out.println();
        System.out.println("========== ACCOUNT DETAILS ==========");

        String accountNumber =readString("Enter account number: ");
        Account account =bank.findAccount(accountNumber);

        account.displayAccountDetails();
    }

    private static void showTransactionHistory() {

        System.out.println();
        System.out.println("========== TRANSACTION HISTORY ==========");

        String accountNumber =readString("Enter account number: ");
        Account account =bank.findAccount(accountNumber);

        System.out.println();
        System.out.println("Account Number : " +account.getAccountNumber());
        System.out.println("Customer Name  : " +account.getCustomerName() );
        System.out.println();

        if (account.getTransactionHistory().isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        System.out.printf("%-12s %-12s %-15s %-17s %s%n","ID","TYPE","AMOUNT","BALANCE", "DATE & TIME");
        System.out.println("--------------------------------------------------------------------------");

        for (Transaction transaction : account.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }

    private static void showAllAccounts() {

        System.out.println();
        System.out.println("========== ALL ACCOUNTS ==========");

        if (bank.getAllAccounts().isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.println();
        System.out.printf("%-15s %-25s %-15s%n","ACCOUNT NO.","CUSTOMER NAME","BALANCE");
        System.out.println("------------------------------------------------------------");

        for (Account account :bank.getAllAccounts()) {

            System.out.printf("%-15s %-25s ₹%-15.2f%n",account.getAccountNumber(),
            		      account.getCustomerName(),account.getBalance());
        }

        System.out.println();
        System.out.println("Total Accounts: " +bank.getTotalAccounts());
    }

    private static String readString(String message) {

        while (true) {

            System.out.print(message);
            String input =scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("❌ Input cannot be empty.");
        }
    }

    private static int readInt(String message) {

        while (true) {

            System.out.print(message);
            String input =scanner.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println("❌ Please enter a valid number.");
            }
        }
    }

    private static BigDecimal readAmount(
            String message) {

        while (true) {

            System.out.print(message);
            String input =scanner.nextLine().trim();

            try {

                BigDecimal amount =new BigDecimal(input).setScale(2,RoundingMode.HALF_UP);

                if (amount.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("❌ Amount cannot be negative." );
                    continue;
                }

                return amount;

            } catch (NumberFormatException e) {
                System.out.println( "❌ Please enter a valid amount.");
            }
        }
    }
}
