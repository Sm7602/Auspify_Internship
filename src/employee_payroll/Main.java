package employee_payroll;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PayrollManager payrollManager = new PayrollManager();

    public static void main(String[] args) {
        seedDemoEmployees();

        boolean running = true;
        System.out.println("\n==============================================");
        System.out.println("        EMPLOYEE PAYROLL MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1" -> addEmployee();
                    case "2" -> viewEmployees();
                    case "3" -> calculateSalary();
                    case "4" -> generateSalarySlip();
                    case "5" -> searchEmployee();
                    case "6" -> removeEmployee();
                    case "7" -> showPayrollSummary();
                    case "8" -> {
                        running = false;
                        System.out.println("Thank you for using the Payroll System.");
                    }
                    default -> System.out.println("Invalid choice. Please select 1-8.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--------------- MENU ----------------");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Calculate Salary");
        System.out.println("4. Generate Salary Slip");
        System.out.println("5. Search Employee");
        System.out.println("6. Remove Employee");
        System.out.println("7. Payroll Summary");
        System.out.println("8. Exit");
        System.out.println("-------------------------------------");
        System.out.print("Enter choice: ");
    }

    private static void addEmployee() {
        System.out.println("\n--- Add Employee ---");
        int id = InputValidator.readPositiveInt(scanner, "Employee ID: ");
        String name = InputValidator.readRequiredString(scanner, "Name: ");
        String department = InputValidator.readRequiredString(scanner, "Department: ");
        String designation = InputValidator.readRequiredString(scanner, "Designation: ");
        double basic = InputValidator.readPositiveDouble(scanner, "Basic Salary: ₹");
        double allowances = InputValidator.readNonNegativeDouble(scanner, "Allowances: ₹");
        double deductions = InputValidator.readNonNegativeDouble(scanner, "Other Deductions: ₹");

        payrollManager.addEmployee(
                new Employee(id, name, department, designation, basic, allowances, deductions)
        );
        System.out.println("Employee added successfully.");
    }

    private static void viewEmployees() {
        System.out.println("\n--- Employee Records ---");
        if (payrollManager.getEmployees().isEmpty()) {
            System.out.println("No employee records found.");
            return;
        }

        System.out.printf("%-8s %-22s %-16s %-18s %12s%n",
                "ID", "Name", "Department", "Designation", "Basic");
        System.out.println("-".repeat(82));
        payrollManager.getEmployees().forEach(System.out::println);
    }

    private static void calculateSalary() {
        int id = InputValidator.readPositiveInt(scanner, "Enter Employee ID: ");
        Employee employee = payrollManager.findEmployee(id);
        if (employee == null) throw new IllegalArgumentException("Employee not found.");

        SalaryDetails details = payrollManager.calculateSalary(id);
        System.out.println("\nSalary calculation for " + employee.getName());
        System.out.printf("Gross Salary   : ₹%.2f%n", details.getGrossSalary());
        System.out.printf("Income Tax     : ₹%.2f%n", details.getTax());
        System.out.printf("Provident Fund : ₹%.2f%n", details.getProvidentFund());
        System.out.printf("Other Deduct.  : ₹%.2f%n", details.getOtherDeductions());
        System.out.printf("Total Deduct.  : ₹%.2f%n", details.getTotalDeductions());
        System.out.printf("Net Salary     : ₹%.2f%n", details.getNetSalary());
    }

    private static void generateSalarySlip() {
        int id = InputValidator.readPositiveInt(scanner, "Enter Employee ID: ");
        System.out.println(payrollManager.generateSalarySlip(id));
    }

    private static void searchEmployee() {
        int id = InputValidator.readPositiveInt(scanner, "Enter Employee ID: ");
        Employee employee = payrollManager.findEmployee(id);
        if (employee == null) {
            System.out.println("Employee not found.");
        } else {
            System.out.println("\nEmployee found:");
            System.out.println(employee);
        }
    }

    private static void removeEmployee() {
        int id = InputValidator.readPositiveInt(scanner, "Enter Employee ID: ");
        if (payrollManager.removeEmployee(id)) {
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void showPayrollSummary() {
        if (payrollManager.getEmployees().isEmpty()) {
            System.out.println("No employee records available.");
            return;
        }

        Employee highest = payrollManager.getHighestPaidEmployee();
        System.out.println("\n--- Payroll Summary ---");
        System.out.println("Total Employees : " + payrollManager.getEmployees().size());
        System.out.printf("Total Net Payroll: ₹%.2f%n", payrollManager.getTotalMonthlyPayroll());
        System.out.println("Highest Net Paid : " + highest.getName()
                + " (₹" + String.format("%.2f",
                payrollManager.calculateSalary(highest.getEmployeeId()).getNetSalary()) + ")");
    }

    private static void seedDemoEmployees() {
        payrollManager.addEmployee(new Employee(
                101, "Rahul Sharma", "IT", "Java Developer", 65000, 10000, 1000));
        payrollManager.addEmployee(new Employee(
                102, "Priya Singh", "HR", "HR Executive", 45000, 7000, 500));
        payrollManager.addEmployee(new Employee(
                103, "Amit Kumar", "Finance", "Accountant", 80000, 12000, 1500));
    }
}
