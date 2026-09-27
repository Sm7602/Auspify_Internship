package employee_payroll;

public class SalaryDetails {
    private final double grossSalary;
    private final double tax;
    private final double providentFund;
    private final double otherDeductions;
    private final double totalDeductions;
    private final double netSalary;

    public SalaryDetails(double grossSalary, double tax, double providentFund,
                         double otherDeductions, double totalDeductions, double netSalary) {
        this.grossSalary = grossSalary;
        this.tax = tax;
        this.providentFund = providentFund;
        this.otherDeductions = otherDeductions;
        this.totalDeductions = totalDeductions;
        this.netSalary = netSalary;
    }

    public double getGrossSalary() { return grossSalary; }
    public double getTax() { return tax; }
    public double getProvidentFund() { return providentFund; }
    public double getOtherDeductions() { return otherDeductions; }
    public double getTotalDeductions() { return totalDeductions; }
    public double getNetSalary() { return netSalary; }
}
