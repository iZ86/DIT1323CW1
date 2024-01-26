
/** This class represents the calculation model for the Kawaguchi bank car loan program. */
public class CarLoanCalculationModel {
    private boolean loanInsurance;
    private double loanYears, loanAmount, loanPayback, interestRate, monthlyRepayment;
    private String carType;

    public CarLoanCalculationModel() {
        this.loanInsurance = false;
        this.loanYears = this.loanAmount = this.loanPayback = this.interestRate = this.monthlyRepayment = 0;
        this.carType = "None";
    }

    /** Calculates the loan and saves the data. */
    public void calculateLoan(String carType, double loanYears, double loanAmount, double interestRate) {
        this.carType = carType;
        this.loanYears = loanYears;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate / 100;
        this.loanPayback = roundUpTwoDecimal(loanAmount + (loanYears * loanAmount * interestRate));
        this.monthlyRepayment = roundUpTwoDecimal((this.loanPayback / loanYears) / 12);
    }

    /** Rounds up any value to two decimal places. */
    private double roundUpTwoDecimal(double number) {
        return (double) (Math.round(number * 100)) / 100;
    }

    /** Returns true if there is loan insurance.
     * Otherwise, false
     */
    public boolean isLoanInsurance() {
        return loanInsurance;
    }

    /** Sets the loan insurance,
     * true if it there is loan insurance.
     * Otherwise, false
     */
    public void setLoanInsurance(boolean loanInsurance) {
        this.loanInsurance = loanInsurance;
    }

    /** Returns the loan years. */
    public double getloanYears() {
        return loanYears;
    }

    /** Sets the loan years. */
    public void setloanYears(double loanYears) {
        this.loanYears = loanYears;
    }

    /** Returns the loan amount. */
    public double getLoanAmount() {
        return this.loanAmount;
    }

    /** Sets the loan amount. */
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /** Returns the loan payback. */
    public double getLoanPayback() {
        return loanPayback;
    }

    /** Sets the loan payback. */
    public void setLoanPayback(double loanPayback) {
        this.loanPayback = loanPayback;
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
