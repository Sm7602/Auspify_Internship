# 🏦 Bank Management System

A **console-based Bank Management System built with Java** that demonstrates core Object-Oriented Programming concepts, account management, deposits, withdrawals, balance tracking, transaction history, input validation, and custom exception handling.

This project was developed as part of the **Auspify Internship – Task 4 (Medium)**.

---

## 📌 Project Overview

The **Bank Management System** is a Java-based console application designed to simulate basic banking operations.

Users can:

* Create new bank accounts
* Deposit money
* Withdraw money
* Check account balance
* View account details
* View complete transaction history
* View all registered accounts
* Exit the application safely

The application uses an in-memory `HashMap` to manage accounts and `ArrayList` to maintain transaction history.

---

## ✨ Features

### 👤 Account Management

* Create a new bank account
* Store account number and customer name
* Maintain account balance
* Prevent duplicate account numbers
* Search accounts using account number
* Display all registered accounts

### 💰 Banking Operations

* Deposit money into an account
* Withdraw money from an account
* Check current account balance
* Prevent withdrawals when the balance is insufficient

### 📜 Transaction Management

* Automatically create a transaction for every deposit and withdrawal
* Generate unique transaction IDs
* Store transaction type
* Store transaction amount
* Track balance after every transaction
* Record transaction date and time
* Display formatted transaction history

### 🛡️ Validation & Exception Handling

The application includes validation for:

* Empty account numbers
* Empty customer names
* Negative initial balances
* Invalid transaction amounts
* Non-existing accounts
* Duplicate account numbers
* Insufficient account balance
* Invalid menu/input values

Custom runtime exceptions are used for important banking errors.

---

## 🛠️ Technologies Used

| Technology            | Usage                              |
| --------------------- | ---------------------------------- |
| **Java**              | Core application development       |
| **Java Collections**  | Account and transaction management |
| **HashMap**           | Store bank accounts                |
| **ArrayList**         | Store transaction history          |
| **BigDecimal**        | Accurate monetary calculations     |
| **UUID**              | Generate unique transaction IDs    |
| **LocalDateTime**     | Store transaction date and time    |
| **Enum**              | Represent transaction types        |
| **Custom Exceptions** | Handle banking-specific errors     |
| **Eclipse**           | Development environment            |

---

## 🧠 Core Java Concepts Demonstrated

This project focuses heavily on fundamental Java and OOP concepts.

### 1. Encapsulation

Class fields are kept private and accessed through controlled methods.

```java
private final String accountNumber;
private final String customerName;
private BigDecimal balance;
```

This protects account information from uncontrolled external modification.

---

### 2. Abstraction

Banking operations are exposed through simple methods such as:

```java
deposit()
withdraw()
checkBalance()
findAccount()
```

The internal implementation details remain inside the respective classes.

---

### 3. Composition

An `Account` contains a collection of `Transaction` objects.

```java
private final List<Transaction> transactionHistory;
```

This creates a clear relationship between an account and its transaction history.

---

### 4. Enum

Transaction types are represented using an enum:

```java
public enum TransactionType {
    DEPOSIT,
    WITHDRAWAL
}
```

This avoids using unreliable string values for transaction types.

---

### 5. Collections

The project uses:

```java
Map<String, Account>
```

for account management and:

```java
List<Transaction>
```

for transaction history.

---

### 6. BigDecimal for Money

`BigDecimal` is used instead of `double` for financial calculations.

```java
private BigDecimal balance;
```

This is a better approach for monetary values because floating-point arithmetic can introduce precision problems.

---

### 7. Custom Exception Handling

The application defines dedicated exceptions:

* `AccountNotFoundException`
* `DuplicateAccountException`
* `InsufficientBalanceException`
* `InvalidAmountException`

This keeps banking-related error handling meaningful and organized.

---

## 🏗️ Project Architecture

The project follows a simple layered responsibility-based structure:

```text
User
 │
 ▼
Main
 │
 ▼
Bank
 │
 ├── Account
 │    │
 │    └── Transaction History
 │
 └── Custom Exceptions
```

### Responsibility Breakdown

**Main**

* Handles user interaction
* Displays menu
* Reads and validates console input
* Calls banking operations

**Bank**

* Manages accounts
* Creates accounts
* Finds accounts
* Performs deposit and withdrawal operations
* Provides account statistics

**Account**

* Stores account information
* Maintains balance
* Handles deposits and withdrawals
* Maintains transaction history

**Transaction**

* Represents an individual banking transaction
* Stores transaction ID, type, amount, balance and timestamp

**TransactionType**

* Defines supported transaction types

**Exception Package**

* Contains custom exceptions for banking-related errors

---

## 📂 Project Structure

```text
Auspify_Internship-Task-4-Medium-Bank-Management-System/
│
├── src/
│   ├── module-info.java
│   │
│   └── bank_management_system/
│       │
│       ├── Account.java
│       ├── Bank.java
│       ├── Main.java
│       ├── Transaction.java
│       ├── TransactionType.java
│       │
│       └── exception/
│           ├── AccountNotFoundException.java
│           ├── DuplicateAccountException.java
│           ├── InsufficientBalanceException.java
│           └── InvalidAmountException.java
│
├── bin/
│   └── Compiled .class files
│
├── .classpath
├── .project
└── README.md
```

---

## 🔄 Application Flow

```text
Start Application
       │
       ▼
Display Main Menu
       │
       ▼
Select Operation
       │
       ├── Create Account
       │       └── Store Account in HashMap
       │
       ├── Deposit
       │       └── Update Balance
       │             └── Create Transaction
       │
       ├── Withdraw
       │       ├── Validate Balance
       │       └── Create Transaction
       │
       ├── Check Balance
       │
       ├── Account Details
       │
       ├── Transaction History
       │
       ├── All Accounts
       │
       └── Exit
```

---

## 🚀 Getting Started

### Prerequisites

Make sure Java is installed on your system.

Recommended:

```text
Java 17+
```

Verify your Java installation:

```bash
java -version
```

---

## ▶️ Running the Project

### Option 1: Eclipse

1. Open **Eclipse IDE**
2. Select **File → Import**
3. Import the project as an existing Eclipse project
4. Open:

```text
src/bank_management_system/Main.java
```

5. Run `Main.java`

---

### Option 2: Command Line

Navigate to the project's `src` directory and compile the source files.

```bash
javac -d ../bin src/module-info.java src/bank_management_system/*.java src/bank_management_system/exception/*.java
```

Then run:

```bash
java -cp bin bank_management_system.Main
```

> If your Java version/module configuration differs, running `Main.java` directly from Eclipse is the simplest option.

---

## 🖥️ Main Menu

When the application starts, users see:

```text
==============================================
       WELCOME TO BANK MANAGEMENT SYSTEM
==============================================

----------------------------------------------
                MAIN MENU
----------------------------------------------
1. Create Account
2. Deposit Money
3. Withdraw Money
4. Check Balance
5. Show Account Details
6. Show Transaction History
7. Show All Accounts
8. Exit
----------------------------------------------
```

---

## 💳 Example Workflow

### Step 1 — Create Account

```text
========== CREATE ACCOUNT ==========

Enter account number: ACC1001
Enter customer name: Souvik
Enter initial balance: ₹10000

✅ Account created successfully!
Account Number: ACC1001
```

---

### Step 2 — Deposit Money

```text
========== DEPOSIT MONEY ==========

Enter account number: ACC1001
Enter deposit amount: ₹2500

✅ Money deposited successfully!
Deposited Amount : ₹2500.00
Current Balance  : ₹12500.00
```

---

### Step 3 — Withdraw Money

```text
========== WITHDRAW MONEY ==========

Enter account number: ACC1001
Enter withdrawal amount: ₹1500

✅ Money withdrawn successfully!
Withdrawn Amount : ₹1500.00
Remaining Balance: ₹11000.00
```

---

### Step 4 — View Transaction History

```text
========== TRANSACTION HISTORY ==========

Account Number : ACC1001
Customer Name  : Souvik

ID           TYPE         AMOUNT          BALANCE          DATE & TIME
--------------------------------------------------------------------------
TXN-A1B2C3D4 DEPOSIT      ₹10000.00       ₹10000.00        04-09-2026 03:00:00
TXN-E5F6G7H8 DEPOSIT      ₹2500.00        ₹12500.00        04-09-2026 03:02:00
TXN-I9J0K1L2 WITHDRAWAL   ₹1500.00        ₹11000.00        04-09-2026 03:04:00
```

> The transaction IDs and timestamps shown above are illustrative.

---

## 🛡️ Exception Scenarios

### Duplicate Account

If an account number already exists:

```text
DuplicateAccountException
```

---

### Account Not Found

If the requested account does not exist:

```text
AccountNotFoundException
```

---

### Insufficient Balance

If a customer attempts to withdraw more than the available balance:

```text
InsufficientBalanceException
```

---

### Invalid Amount

Invalid transaction amounts are rejected through:

```text
InvalidAmountException
```

---

## 📊 Data Management

The application currently uses **in-memory data structures**.

### Account Storage

```java
private final Map<String, Account> accounts;
```

Implemented using:

```java
HashMap
```

### Transaction Storage

Each account maintains:

```java
private final List<Transaction> transactionHistory;
```

Implemented using:

```java
ArrayList
```

### Important Limitation

This version **does not use a database or file persistence**.

Therefore, all account and transaction data is lost when the application terminates.

This is intentional for this console-based internship task.

---

## 🔐 Design & Code Quality

The project follows several good development practices:

* Private class fields
* `final` fields where appropriate
* Dedicated classes for different responsibilities
* Custom exceptions
* Immutable transaction properties
* `BigDecimal` for financial calculations
* Unmodifiable transaction history exposure
* Input validation
* Meaningful method names
* Enum for transaction types
* UUID-based transaction identifiers

For example, transaction history is exposed safely:

```java
return Collections.unmodifiableList(transactionHistory);
```

This prevents callers from directly modifying the account's internal transaction list.

---

## ⚠️ Current Limitations

This project is a **console-based educational banking system**, not a production banking application.

Current limitations include:

* No database persistence
* No user authentication
* No password/PIN management
* No fund transfer between accounts
* No account deletion
* No account update functionality
* No interest calculation
* No loan management
* No REST API
* No GUI/web interface
* No multi-user/concurrent transaction handling

These features can be added in future versions.

---

## 🔮 Future Enhancements

Potential improvements include:

* 🗄️ MySQL/PostgreSQL database integration
* 🔐 Spring Security authentication
* 🔑 JWT-based authorization
* 💸 Account-to-account fund transfers
* 🧾 Persistent transaction records
* 🌐 RESTful APIs using Spring Boot
* 📄 Pagination for transaction history
* 🧪 JUnit and Mockito test coverage
* 🖥️ Web-based frontend
* 📊 Banking dashboard
* 📧 Transaction notifications
* 🏦 Multiple account types
* 📈 Interest calculation
* 💳 Card management
* 📱 Mobile-friendly interface

---

## 🧪 Testing Checklist

The following scenarios should be tested:

* [x] Create account with valid details
* [x] Create account with empty account number
* [x] Create account with empty customer name
* [x] Create account with negative initial balance
* [x] Prevent duplicate account
* [x] Deposit valid amount
* [x] Reject invalid deposit amount
* [x] Withdraw valid amount
* [x] Prevent insufficient-balance withdrawal
* [x] Find existing account
* [x] Handle non-existing account
* [x] Check account balance
* [x] Display account details
* [x] Display transaction history
* [x] Display all accounts
* [x] Handle invalid menu input

---

## 🎯 Learning Objectives

This project demonstrates practical understanding of:

* Java Classes & Objects
* Encapsulation
* Abstraction
* Composition
* Collections Framework
* `HashMap`
* `ArrayList`
* `BigDecimal`
* Enum
* UUID
* Date & Time API
* Exception Handling
* Custom Exceptions
* Input Validation
* Console-based application development
* Basic software design principles

---

## 👨‍💻 Author

**Souvik Maity**

Java Backend Developer | Java | Spring Boot | REST APIs | MySQL

### Connect With Me

* GitHub: `github.com/sm7602`
* LinkedIn: `linkedin.com/in/souvik-maity-2a6759333`

---

## 📜 License

This project is created for **educational and internship purposes**.

You are free to study, modify, and extend the project for learning purposes.

---

## ⭐ Support

If you found this project useful, consider giving the repository a ⭐ on GitHub.

---

### 💡 Project Summary

> **A clean Java console-based Bank Management System demonstrating OOP, collections, financial calculations with BigDecimal, transaction tracking, input validation, and custom exception handling.**
# Auspify_Internship

