package employee_payroll;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalarySlip {

    public static String generate(Employee employee, SalaryDetails details) {
        String line = "============================================================";
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        return "\n" + line +
                "\n                 EMPLOYEE SALARY SLIP" +
                "\n" + line +
                String.format("\nDate           : %s", date) +
                String.format("\nEmployee ID    : %d", employee.getEmployeeId()) +
                String.format("\nEmployee Name  : %s", employee.getName()) +
                String.format("\nDepartment     : %s", employee.getDepartment()) +
                String.format("\nDesignation    : %s", employee.getDesignation()) +
                "\n" + line +
                String.format("\nBasic Salary   : ₹%.2f", employee.getBasicSalary()) +
                String.format("\nAllowances     : ₹%.2f", employee.getAllowances()) +
                String.format("\nGross Salary   : ₹%.2f", details.getGrossSalary()) +
                "\n" + line +
                String.format("\nIncome Tax     : ₹%.2f", details.getTax()) +
                String.format("\nProvident Fund : ₹%.2f", details.getProvidentFund()) +
                String.format("\nOther Deduct.  : ₹%.2f", details.getOtherDeductions()) +
                String.format("\nTotal Deduct.  : ₹%.2f", details.getTotalDeductions()) +
                "\n" + line +
                String.format("\nNET SALARY     : ₹%.2f", details.getNetSalary()) +
                "\n" + line + "\n";
    }
}
