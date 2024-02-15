
/** This class represents the calculation model for the Kawaguchi bank car loan program. */
public class CarLoanCalculationModel {
    /** Type of car loaned. */
    private String carType;
    /** Loan insurance. */
    private String loanInsurance;
    /** Loan data. */
    private double loanAmount, interestRate, loanTerm, outstandingLoanAmount, monthlyRepayment;

    public CarLoanCalculationModel() {
        this.carType = null;
        this.loanTerm = 0;
        this.loanAmount = 0;
        this.interestRate = 0;
        this.outstandingLoanAmount = 0;
        this.monthlyRepayment = 0;
        this.loanInsurance = null;
    }

    /** Calculates the loan and saves the data. */
    public void calculateLoan(String carType, double loanTerm, double loanAmount, double interestRate, String loanInsurance) {
        this.carType = carType;
        this.loanTerm = loanTerm;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate / 100;
        this.outstandingLoanAmount = roundUpTwoDecimal(loanAmount + (loanTerm * loanAmount * interestRate));
        this.monthlyRepayment = roundUpTwoDecimal((this.outstandingLoanAmount / loanTerm) / 12);
        this.loanInsurance = loanInsurance;
    }

    /** Rounds up any value to two decimal places. */
    private double roundUpTwoDecimal(double number) {
        return (double) (Math.round(number * 100)) / 100;
    }

    /** Returns true if there is loan insurance.
     * Otherwise, false
     */
    public String getLoanInsurance() {
        return loanInsurance;
    }

    /** Sets the loan insurance,
     * true if it there is loan insurance.
     * Otherwise, false
     */
    public String setLoanInsurance(String loanInsurance) {
        this.loanInsurance = loanInsurance;
    }

    /** Returns the loan term. */
    public double getLoanTerm() {
        return loanTerm;
    }

    /** Sets the loan term. */
    public void setLoanTerm(double loanTerm) {
        this.loanTerm = loanTerm;
    }

    /** Returns the loan amount. */
    public double getLoanAmount() {
        return this.loanAmount;
    }

    /** Sets the loan amount. */
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /** Returns the outstanding loan amount. */
    public double getOutstandingLoanAmount() {
        return outstandingLoanAmount;
    }

    /** Sets the outstanding loan amount. */
    public void setOutstandingLoanAmount(double outstandingLoanAmount) {
        this.outstandingLoanAmount = outstandingLoanAmount;
    }

    /** Returns the interest rate. */
    public double getInterestRate() {
        return interestRate;
    }

    /** Sets the interest rate. */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /** Returns the monthly payment. */
    public double getMonthlyRepayment() {
        return monthlyRepayment;
    }

    /** Sets the monthly payment. */
    public void setMonthlyRepayment(double monthlyRepayment) {
        this.monthlyRepayment = monthlyRepayment;
    }

    /** Returns the car type. */
    public String getCarType() {
        return carType;
    }

    /** Sets the car type. */
    public void setCarType(String carType) {
        this.carType = carType;
    }

}
