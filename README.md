# Employee Payroll Management System

A professional **Core Java / OOP console application** that calculates employee salaries, applies tax and deductions, generates salary slips, and manages employee records.

## Task Mapping

| Requirement | Implementation |
|---|---|
| Create Employee class | `Employee.java` |
| Salary calculation logic | `PayrollCalculator.java` |
| Tax & deductions | Progressive tax + 12% PF + other deductions |
| Generate salary slips | `SalarySlip.java` |
| Store employee records | `PayrollManager.java` using `ArrayList` |
| Data processing | Payroll summary and highest-paid employee |
| Validation | `InputValidator.java` + domain validation |

## Features

- Add employee
- View all employees
- Search employee by ID
- Calculate gross salary, tax, PF, deductions and net salary
- Generate formatted salary slips
- Remove employee
- Payroll summary
- Duplicate employee-ID prevention
- Input validation
- Encapsulation and separation of responsibilities
- Java Stream API for payroll calculations
- Demo employees included for immediate testing

## Salary Formula

```text
Gross Salary = Basic Salary + Allowances

Provident Fund = 12% × Basic Salary

Tax:
  Gross <= ₹25,000       → 0%
  ₹25,001–₹50,000        → 5% on amount above ₹25,000
  ₹50,001–₹1,00,000      → ₹1,250 + 10% on amount above ₹50,000
  Above ₹1,00,000        → ₹6,250 + 15% on amount above ₹1,00,000

Total Deductions = Tax + PF + Other Deductions

Net Salary = Gross Salary - Total Deductions
```

**Important:** The tax/PF rules above are deliberately defined as educational project rules. They are not a claim about the current Indian tax or payroll system.

## Project Structure

```text
Employee-Payroll-System/
├── README.md
└── src/
    └── employee_payroll/
        ├── Employee.java
        ├── SalaryDetails.java
        ├── PayrollCalculator.java
        ├── SalarySlip.java
        ├── PayrollManager.java
        ├── InputValidator.java
        └── Main.java
```

## Concepts Demonstrated

- Classes and Objects
- Encapsulation
- Constructors
- Access modifiers
- Validation
- Composition
- `ArrayList`
- Streams and lambdas
- Exception handling
- `final` fields
- `equals()` / `hashCode()`
- Separation of concerns
- Menu-driven console programming

## Requirements

- JDK 17 or later
- Any Java IDE such as IntelliJ IDEA, Eclipse or VS Code

## Run

### Command Line

From the project directory:

```bash
javac -d out src/employee_payroll/*.java
java -cp out employee_payroll.Main
```

### Eclipse / IntelliJ

1. Create/open a Java project.
2. Add the `src` directory as the source folder.
3. Run `employee_payroll.Main`.

## Sample Test Data

The application starts with:

```text
101 | Rahul Sharma | IT      | Java Developer | Basic ₹65,000 | Allowance ₹10,000 | Other Deduction ₹1,000
102 | Priya Singh  | HR      | HR Executive   | Basic ₹45,000 | Allowance ₹7,000  | Other Deduction ₹500
103 | Amit Kumar   | Finance | Accountant      | Basic ₹80,000 | Allowance ₹12,000 | Other Deduction ₹1,500
```

## Why This Is Better Than a Single-Class Solution

The project separates:

- **Employee** → employee data and validation
- **PayrollCalculator** → salary business rules
- **SalaryDetails** → calculated result
- **SalarySlip** → presentation of payroll information
- **PayrollManager** → employee record management
- **InputValidator** → safe console input
- **Main** → application flow/menu

This makes the code easier to test, maintain and extend.

## Possible Future Enhancements

- MySQL/JDBC database persistence
- CSV/PDF salary-slip export
- Login/authentication for HR/admin users
- Monthly payroll history
- Leave and attendance integration
- Overtime calculation
- Department-wise payroll reports
- JUnit 5 unit tests
- Spring Boot REST API
- Employee CRUD dashboard
