package employee_payroll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PayrollManager {
    private final List<Employee> employees = new ArrayList<>();
    private final PayrollCalculator calculator = new PayrollCalculator();

    public void addEmployee(Employee employee) {
        if (findEmployee(employee.getEmployeeId()) != null) {
            throw new IllegalArgumentException("Employee ID already exists.");
        }
        employees.add(employee);
    }

    public boolean removeEmployee(int employeeId) {
        return employees.removeIf(e -> e.getEmployeeId() == employeeId);
    }

    public Employee findEmployee(int employeeId) {
        return employees.stream()
                .filter(e -> e.getEmployeeId() == employeeId)
                .findFirst()
                .orElse(null);
    }

    public List<Employee> getEmployees() {
        return List.copyOf(employees);
    }

    public SalaryDetails calculateSalary(int employeeId) {
        Employee employee = requireEmployee(employeeId);
        return calculator.calculate(employee);
    }

    public String generateSalarySlip(int employeeId) {
        Employee employee = requireEmployee(employeeId);
        return SalarySlip.generate(employee, calculator.calculate(employee));
    }

    public double getTotalMonthlyPayroll() {
        return employees.stream()
                .mapToDouble(e -> calculator.calculate(e).getNetSalary())
                .sum();
    }

    public Employee getHighestPaidEmployee() {
        return employees.stream()
                .max(Comparator.comparingDouble(e -> calculator.calculate(e).getNetSalary()))
                .orElse(null);
    }

    private Employee requireEmployee(int employeeId) {
        Employee employee = findEmployee(employeeId);
        if (employee == null) throw new IllegalArgumentException("Employee not found.");
        return employee;
    }
}
