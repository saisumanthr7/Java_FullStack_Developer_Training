package org.example.Week_6;

//Methods
//Assignment: Create a calculator with basic methods (add, sub, mul, div).

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Methods {

    // Basic operations
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return a / b;
    }

    // Complex operations
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double squareRoot(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(num);
    }

    public static double factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        double result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static double logarithm(double num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Logarithm is only defined for positive numbers");
        }
        return Math.log(num);
    }

    // Financial calculation - compound interest
    public static BigDecimal calculateCompoundInterest(double principal, double rate, int years, int compoundingPeriods) {
        if (principal <= 0 || rate <= 0 || years <= 0 || compoundingPeriods <= 0) {
            throw new IllegalArgumentException("All parameters must be positive values");
        }

        BigDecimal p = BigDecimal.valueOf(principal);
        BigDecimal r = BigDecimal.valueOf(rate / 100);
        BigDecimal n = BigDecimal.valueOf(compoundingPeriods);
        BigDecimal t = BigDecimal.valueOf(years);

        // A = P * (1 + r/n)^(n*t)
        BigDecimal base = BigDecimal.ONE.add(r.divide(n, 10, RoundingMode.HALF_UP));
        BigDecimal exponent = n.multiply(t);
        BigDecimal result = p.multiply(base.pow(exponent.intValue()));

        return result.setScale(2, RoundingMode.HALF_UP);
    }

    // Helper method for displaying menu
    private static void displayMenu() {
        System.out.println("\n=== Enhanced Calculator ===");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Power");
        System.out.println("6. Square Root");
        System.out.println("7. Factorial");
        System.out.println("8. Natural Logarithm");
        System.out.println("9. Compound Interest Calculator");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    // Helper method for getting double input
    private static double getDoubleInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // consume the invalid input
            System.out.print(prompt);
        }
        return scanner.nextDouble();
    }

    // Helper method for getting integer input
    private static int getIntInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // consume the invalid input
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = getIntInput(scanner, "");

            try {
                switch (choice) {
                    case 1: // Add
                        double a1 = getDoubleInput(scanner, "Enter first number: ");
                        double b1 = getDoubleInput(scanner, "Enter second number: ");
                        System.out.printf("Result: %.2f + %.2f = %.2f%n", a1, b1, add(a1, b1));
                        break;

                    case 2: // Subtract
                        double a2 = getDoubleInput(scanner, "Enter first number: ");
                        double b2 = getDoubleInput(scanner, "Enter second number: ");
                        System.out.printf("Result: %.2f - %.2f = %.2f%n", a2, b2, subtract(a2, b2));
                        break;

                    case 3: // Multiply
                        double a3 = getDoubleInput(scanner, "Enter first number: ");
                        double b3 = getDoubleInput(scanner, "Enter second number: ");
                        System.out.printf("Result: %.2f * %.2f = %.2f%n", a3, b3, multiply(a3, b3));
                        break;

                    case 4: // Divide
                        double a4 = getDoubleInput(scanner, "Enter numerator: ");
                        double b4 = getDoubleInput(scanner, "Enter denominator: ");
                        System.out.printf("Result: %.2f / %.2f = %.2f%n", a4, b4, divide(a4, b4));
                        break;

                    case 5: // Power
                        double base = getDoubleInput(scanner, "Enter base: ");
                        double exponent = getDoubleInput(scanner, "Enter exponent: ");
                        System.out.printf("Result: %.2f ^ %.2f = %.2f%n", base, exponent, power(base, exponent));
                        break;

                    case 6: // Square Root
                        double num6 = getDoubleInput(scanner, "Enter number: ");
                        System.out.printf("Result: √%.2f = %.2f%n", num6, squareRoot(num6));
                        break;

                    case 7: // Factorial
                        int num7 = getIntInput(scanner, "Enter integer (0-170): ");
                        System.out.printf("Result: %d! = %.0f%n", num7, factorial(num7));
                        break;

                    case 8: // Natural Logarithm
                        double num8 = getDoubleInput(scanner, "Enter positive number: ");
                        System.out.printf("Result: ln(%.2f) = %.4f%n", num8, logarithm(num8));
                        break;

                    case 9: // Compound Interest
                        double principal = getDoubleInput(scanner, "Enter principal amount: ");
                        double rate = getDoubleInput(scanner, "Enter annual interest rate (%): ");
                        int years = getIntInput(scanner, "Enter number of years: ");
                        int periods = getIntInput(scanner, "Enter compounding periods per year: ");
                        BigDecimal ci = calculateCompoundInterest(principal, rate, years, periods);
                        System.out.printf("Result: Future value = $%,.2f%n", ci);
                        break;

                    case 0:
                        System.out.println("Exiting calculator. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            if (choice != 0) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine(); // consume newline
                scanner.nextLine(); // wait for enter
            }

        } while (choice != 0);

        scanner.close();
    }

}
