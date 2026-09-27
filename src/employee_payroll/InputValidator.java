package employee_payroll;

import java.util.Scanner;

public final class InputValidator {
    private InputValidator() {}

    public static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value > 0) return value;
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid input. Enter a positive whole number.");
        }
    }

    public static double readNonNegativeDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value >= 0 && Double.isFinite(value)) return value;
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid input. Enter a non-negative number.");
        }
    }

    public static double readPositiveDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value > 0 && Double.isFinite(value)) return value;
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid input. Enter a number greater than 0.");
        }
    }

    public static String readRequiredString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isBlank()) return value;
            System.out.println("This field cannot be blank.");
        }
    }
}
