
/** This class represents the calculation model for the Kawaguchi bank car loan program. */
public class CarLoanCalculationModel {
    /** Type of car loaned. */
    private String carType;
    /** Loan data. */
    private double loanTerm, loanAmount, interestRatePercentage , outstandingLoanAmount, monthlyRepayment;
    /** Loan insurance. */
    private boolean loanInsurance;

    public CarLoanCalculationModel() {
        this.carType = null;
        this.loanTerm = 0;
        this.loanAmount = 0;
        this.interestRatePercentage = 0;
        this.outstandingLoanAmount = 0;
        this.monthlyRepayment = 0;
        this.loanInsurance = false;
    }

    /** Calculates the loan and saves the data. */
    public void calculateLoan() {

        // Initialization.
        double interestRatePercentage, outstandingLoanAmount;

        // Finds the interest rate percentage based on String carType and double loanAmount.
        interestRatePercentage = findInterestRatePercentage(carType, loanAmount);

        // Calculate the outstanding loan amount and round it up to two decimal points.
        outstandingLoanAmount = calculateOutstandingLoanAmount(loanTerm, loanAmount, interestRatePercentage, loanInsurance);
        outstandingLoanAmount = roundUpTwoDecimal(outstandingLoanAmount);


        // Assign all the new values.
        this.interestRatePercentage = interestRatePercentage;
        this.outstandingLoanAmount = outstandingLoanAmount;
        this.monthlyRepayment = roundUpTwoDecimal((this.outstandingLoanAmount / loanTerm) / 12);
    }

    /** Return the interest rate percentage based on String carType and double loanAmount. */
    private double findInterestRatePercentage(String carType, double loanAmount) {

        double interestRatePercentage = 0;

        if (carType.equals("Imported")) {

            if (loanAmount > 300000) {
                interestRatePercentage = 2.35;
            } else if (loanAmount >= 100000) {
                interestRatePercentage = 2.55;
            } else {
                interestRatePercentage = 2.75;
            }

        } else if (carType.equals("Local")) {
            if (loanAmount > 100000) {
                interestRatePercentage = 3;
            } else if (loanAmount >= 50000) {
                interestRatePercentage = 3.1;
            } else {
                interestRatePercentage = 3.2;
            }
        }

        return interestRatePercentage;
    }

    /** Return the result of calculating the outstanding loan amount. */
    private double calculateOutstandingLoanAmount(double loanTerm, double loanAmount, double interestRatePercentage, boolean loanInsurance) {

        // Formula = loan amount + (loan term * loan amount * (interest rate percentage / 100)).
        double outstandingLoanAmount = (loanAmount + (loanTerm * loanAmount * (interestRatePercentage / 100)));

        // loanInsurance increases outstanding loan amount by (RM200 * loan term).
        if (loanInsurance) {
            outstandingLoanAmount += (200 * loanTerm);
        }

        return outstandingLoanAmount;
    }

    /** Rounds up any value to two decimal places. */
    private double roundUpTwoDecimal(double number) {
        return (double) (Math.round(number * 100)) / 100;
    }

    /** Returns true if there is loan insurance.
     * Otherwise, false
     */
    public boolean getLoanInsurance() {
        return loanInsurance;
    }

    /** Sets the loan insurance,
     * true if it there is loan insurance.
     * Otherwise, false
     */
    public void setLoanInsurance(boolean loanInsurance) {
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

    /** Returns the interest rate percentage. */
    public double getInterestRatePercentage() {
        return interestRatePercentage;
    }

    /** Sets the interest rate percentage. */
    public void setInterestRatePercentage(double interestRatePercentage) {
        this.interestRatePercentage = interestRatePercentage;
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
