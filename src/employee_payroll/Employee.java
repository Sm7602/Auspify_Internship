package employee_payroll;

import java.util.Objects;

public class Employee {
    private final int employeeId;
    private String name;
    private String department;
    private String designation;
    private double basicSalary;
    private double allowances;
    private double otherDeductions;

    public Employee(int employeeId, String name, String department, String designation,
                    double basicSalary, double allowances, double otherDeductions) {
        validateId(employeeId);
        this.employeeId = employeeId;
        setName(name);
        setDepartment(department);
        setDesignation(designation);
        setBasicSalary(basicSalary);
        setAllowances(allowances);
        setOtherDeductions(otherDeductions);
    }

    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getDesignation() { return designation; }
    public double getBasicSalary() { return basicSalary; }
    public double getAllowances() { return allowances; }
    public double getOtherDeductions() { return otherDeductions; }

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be blank.");
        this.name = name.trim();
    }

    public void setDepartment(String department) {
        if (department == null || department.isBlank()) throw new IllegalArgumentException("Department cannot be blank.");
        this.department = department.trim();
    }

    public void setDesignation(String designation) {
        if (designation == null || designation.isBlank()) throw new IllegalArgumentException("Designation cannot be blank.");
        this.designation = designation.trim();
    }

    public void setBasicSalary(double basicSalary) {
        if (basicSalary <= 0) throw new IllegalArgumentException("Basic salary must be greater than 0.");
        this.basicSalary = basicSalary;
    }

    public void setAllowances(double allowances) {
        if (allowances < 0) throw new IllegalArgumentException("Allowances cannot be negative.");
        this.allowances = allowances;
    }

    public void setOtherDeductions(double otherDeductions) {
        if (otherDeductions < 0) throw new IllegalArgumentException("Other deductions cannot be negative.");
        this.otherDeductions = otherDeductions;
    }

    private static void validateId(int id) {
        if (id <= 0) throw new IllegalArgumentException("Employee ID must be positive.");
    }

    @Override
    public String toString() {
        return String.format("%-8d %-22s %-16s %-18s %12.2f",
                employeeId, name, department, designation, basicSalary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return employeeId == employee.employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }
}
