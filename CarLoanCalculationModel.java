
/** This class represents the calculation model for the Kawaguchi bank car loan program. */
public class CarLoanCalculationModel {
    /** Type of car loaned. */
    private String carType;
    /** Loan insurance. */
    private String loanInsuranceStatus;
    /** Loan data. */
    private double loanAmount, interestRate, loanTerm, outstandingLoanAmount, monthlyRepayment;

    public CarLoanCalculationModel() {
        this.carType = null;
        this.loanTerm = 0;
        this.loanAmount = 0;
        this.interestRate = 0;
        this.outstandingLoanAmount = 0;
        this.monthlyRepayment = 0;
        this.loanInsuranceStatus = null;
    }

    /** Calculates the loan and saves the data. */
    public void calculateLoan(String carType, double loanTerm, double loanAmount, boolean loanInsurance) {

        // Initialization.
        double interestRate, outstandingLoanAmount;
        String loanInsuranceStatus;

        // Finds the interest rate based on String carType and double loanAmount.
        interestRate = findInterestRate(carType, loanAmount);

        // Calculate the outstanding loan amount and round it up to two decimal points.
        outstandingLoanAmount = calculateOutstandingLoanAmount(loanAmount, loanTerm, interestRate, loanInsurance);
        outstandingLoanAmount = roundUpTwoDecimal(outstandingLoanAmount);

        // Get the loan insurance status.
        loanInsuranceStatus = getLoanInsuranceStatus(loanInsurance);



        // Assign all the new values.
        this.carType = carType;
        this.loanTerm = loanTerm;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.outstandingLoanAmount = outstandingLoanAmount;
        this.monthlyRepayment = roundUpTwoDecimal((this.outstandingLoanAmount / loanTerm) / 12);
        this.loanInsuranceStatus = loanInsuranceStatus;
    }

    /** Return the interest rate based on String carType and double loanAmount. */
    private double findInterestRate(String carType, double loanAmount) {

        double interestRate = 0;

        if (carType.equals("Imported")) {

            if (loanAmount > 300000) {
                interestRate = 0.0235;
            } else if (loanAmount > 100000) {
                interestRate = 0.0255;
            } else {
                interestRate = 0.0275;
            }

        } else if (carType.equals("Local")) {
            if (loanAmount > 100000) {
                interestRate = 0.03;
            } else if (loanAmount > 50000) {
                interestRate = 0.031;
            } else {
                interestRate = 0.032;
            }
        }

        return interestRate;
    }

    /** Return the result of calculating the outstanding loan amount. */
    private double calculateOutstandingLoanAmount(double loanTerm, double loanAmount, double interestRate, boolean loanInsurance) {

        // Formula = loan amount + (loan term * loan amount * interest rate).
        double outstandingLoanAmount = (loanAmount + (loanTerm * loanAmount * interestRate));

        // loanInsurance increases outstanding loan amount by (RM200 * loan term).
        if (loanInsurance) {
            outstandingLoanAmount += (200 * loanTerm);
        }

        return outstandingLoanAmount;
    }

    /** Return the loan insurance status. */
    private String getLoanInsuranceStatus(boolean loanInsurance) {
        
        String loanInsuranceStatus = "Not insured";

        if (loanInsurance) {
            loanInsuranceStatus = "Insured";
        }

        return loanInsuranceStatus;
    }

    /** Rounds up any value to two decimal places. */
    private double roundUpTwoDecimal(double number) {
        return (double) (Math.round(number * 100)) / 100;
    }

    /** Returns true if there is loan insurance.
     * Otherwise, false
     */
    public String getLoanInsuranceStatus() {
        return loanInsuranceStatus;
    }

    /** Sets the loan insurance,
     * true if it there is loan insurance.
     * Otherwise, false
     */
    public void setLoanInsuranceStatus(String loanInsuranceStatus) {
        this.loanInsuranceStatus = loanInsuranceStatus;
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
