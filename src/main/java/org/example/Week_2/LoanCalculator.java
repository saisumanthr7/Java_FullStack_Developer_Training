package org.example.Week_2;

// Assignment: Create a Java class with different primitive data types.
// I have written a loan calculator program to calculate the loan repayment and used different data types and variables.

public class LoanCalculator {
    private long loanId;
    private double principal;
    private float annualInterestRate;
    private int loanTermYears;
    private byte paymentsPerYear;
    private short startYear;
    private char loanType;
    private boolean isApproved;

    // Constructor
    public LoanCalculator(long loanId, double principal, float annualInterestRate, int loanTermYears,
                          byte paymentsPerYear, short startYear, char loanType, boolean isApproved) {
        this.loanId = loanId;
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.loanTermYears = loanTermYears;
        this.paymentsPerYear = paymentsPerYear;
        this.startYear = startYear;
        this.loanType = loanType;
        this.isApproved = isApproved;
    }

    // Display basic loan info
    private void displayLoanOverview(String context) {
        System.out.println("\n--- " + context + " ---");
        System.out.println("Loan ID         : " + loanId);
        System.out.println("Loan Type       : " + loanType);
        System.out.println("Start Year      : " + startYear);
        System.out.println("Principal       : $" + principal);
        System.out.println("Interest Rate   : " + annualInterestRate + "%");
        System.out.println("Term            : " + loanTermYears + " years");
        System.out.println("Payments/Year   : " + paymentsPerYear);
    }

    public double calculateMonthlyPayment() {
        displayLoanOverview("Before Monthly Payment Calculation");

        int totalPayments = loanTermYears * paymentsPerYear;
        double monthlyInterestRate = (annualInterestRate / 100) / paymentsPerYear;

        double monthlyPayment = (principal * monthlyInterestRate)
                / (1 - Math.pow(1 + monthlyInterestRate, -totalPayments));

        System.out.println("Monthly Payment : $" + String.format("%.2f", monthlyPayment));
        displayLoanOverview("After Monthly Payment Calculation");
        return monthlyPayment;
    }

    public double calculateYearlyPayment(double monthlyPayment) {
        displayLoanOverview("Before Yearly Payment Calculation");

        double yearlyPayment = monthlyPayment * paymentsPerYear;

        System.out.println("Yearly Payment  : $" + String.format("%.2f", yearlyPayment));
        displayLoanOverview("After Yearly Payment Calculation");
        return yearlyPayment;
    }

    public double calculateDailyPayment(double monthlyPayment) {
        displayLoanOverview("Before Daily Payment Calculation");

        double dailyPayment = (monthlyPayment * paymentsPerYear) / 365.0;

        System.out.println("Daily Payment   : $" + String.format("%.2f", dailyPayment));
        displayLoanOverview("After Daily Payment Calculation");
        return dailyPayment;
    }

    public void displayLoanSummary(double monthly, double yearly, double daily) {
        double totalPayment = monthly * loanTermYears * paymentsPerYear;
        double totalInterest = totalPayment - principal;

        System.out.println("\n📄 Final Loan Summary");
        System.out.println("-----------------------------");
        System.out.println("Monthly Payment : $" + String.format("%.2f", monthly));
        System.out.println("Yearly Payment  : $" + String.format("%.2f", yearly));
        System.out.println("Daily Payment   : $" + String.format("%.2f", daily));
        System.out.println("Total Payment   : $" + String.format("%.2f", totalPayment));
        System.out.println("Total Interest  : $" + String.format("%.2f", totalInterest));
    }

    public static void main(String[] args) {
        LoanCalculator personalLoan = new LoanCalculator(
                777888999L, 100000.0, 7.0f, 15, (byte)12, (short)2025, 'P', true
        );

        if (!personalLoan.isApproved) {
            System.out.println("❌ Loan is not approved.");
            return;
        }

        double monthly = personalLoan.calculateMonthlyPayment();
        double yearly = personalLoan.calculateYearlyPayment(monthly);
        double daily = personalLoan.calculateDailyPayment(monthly);
        personalLoan.displayLoanSummary(monthly, yearly, daily);
    }
}
