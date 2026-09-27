package employee_payroll;

public class PayrollCalculator {

    // Demonstration payroll rules for this assignment:
    // HRA/allowances are entered separately by the user.
    // Tax is calculated progressively on monthly gross salary.
    // PF is 12% of basic salary.
    // These are educational rules, not a real country's current tax system.

    private static final double PF_RATE = 0.12;

    public SalaryDetails calculate(Employee employee) {
        double gross = employee.getBasicSalary() + employee.getAllowances();
        double tax = calculateTax(gross);
        double providentFund = employee.getBasicSalary() * PF_RATE;
        double totalDeductions = tax + providentFund + employee.getOtherDeductions();
        double netSalary = gross - totalDeductions;

        if (netSalary < 0) {
            throw new IllegalStateException("Deductions cannot exceed gross salary.");
        }

        return new SalaryDetails(
                round(gross),
                round(tax),
                round(providentFund),
                round(employee.getOtherDeductions()),
                round(totalDeductions),
                round(netSalary)
        );
    }

    private double calculateTax(double monthlyGross) {
        // Simple progressive monthly tax model for academic purposes.
        if (monthlyGross <= 25000) return 0;
        if (monthlyGross <= 50000) return (monthlyGross - 25000) * 0.05;
        if (monthlyGross <= 100000) return 1250 + (monthlyGross - 50000) * 0.10;
        return 6250 + (monthlyGross - 100000) * 0.15;
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
