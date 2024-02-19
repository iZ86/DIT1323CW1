
/** This class represents the model for CarLoanInstallmentCalculatorView,
 * and LoanInstallmentReportView.
 */
public class CarLoanCalculationModel {
    /** Type of car loaned. */
    private String carType;
    /** Loan term. */
    private int loanTerm;
    /** Loan amount. */
    private double loanAmount;
    /** Interest Rate in percentage. */
    private double interestRatePercentage;
    /** Outstanding loan amount. */
    private double outstandingLoanAmount;
    /** Monthly repayment for the loan. */
    private double monthlyRepayment;
    /** Loan insurance status. */
    private String loanInsuranceStatus;
    /** Loan insurance fee. */
    private double loanInsuranceFee;

    public CarLoanCalculationModel() {
        carType = null;
        loanTerm = 0;
        loanAmount = 0;
        interestRatePercentage = 0;
        outstandingLoanAmount = 0;
        monthlyRepayment = 0;
        loanInsuranceStatus = null;
        loanInsuranceFee = 0;
    }

    /** Calculates the loan and saves the data. */
    public void calculateLoan() {

        // Initialization.
        double interestRatePercentage, outstandingLoanAmount, loanInsuranceFee;

        // Finds the interest rate percentage based on String carType and double loanAmount.
        interestRatePercentage = findInterestRatePercentage(carType, loanAmount);

        // Calculate the loanInsuranceFee.
        loanInsuranceFee = calculateLoanInsuranceFee(loanTerm, loanInsuranceStatus);

        // Calculate the outstanding loan amount and round it up to two decimal points.
        outstandingLoanAmount = calculateOutstandingLoanAmount(loanTerm, loanAmount,
                interestRatePercentage, loanInsuranceFee);
        outstandingLoanAmount = roundUpTwoDecimal(outstandingLoanAmount);


        // Assign all the new values.
        this.interestRatePercentage = interestRatePercentage;
        this.outstandingLoanAmount = outstandingLoanAmount;
        this.monthlyRepayment = roundUpTwoDecimal((this.outstandingLoanAmount / loanTerm) / 12);
        this.loanInsuranceFee = loanInsuranceFee;
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

    /** Return the result of calculating the loan insurance fee. */
    private double calculateLoanInsuranceFee(int loanTerm, String loanInsuranceStatus) {

        // If there is loan insurance, loan insurance fee is (RM200 * loan term).
        if (loanInsuranceStatus.equals("Insured")) {
            return (200 * loanTerm);
        }
        return 0;
    }

    /** Return the result of calculating the outstanding loan amount. */
    private double calculateOutstandingLoanAmount(int loanTerm, double loanAmount, double interestRatePercentage, double loanInsuranceFee) {

        // Formula = loan amount + (loan term * loan amount * (interest rate percentage / 100)).
        return  ((loanAmount + (loanTerm * loanAmount * (interestRatePercentage / 100))) + loanInsuranceFee);
    }

    /** Rounds up any value to two decimal places. */
    private double roundUpTwoDecimal(double number) {
        return (double) (Math.round(number * 100)) / 100;
    }

    /** Returns String loanInsuranceStatus. */
    public String getLoanInsuranceStatus() {
        return loanInsuranceStatus;
    }

    /** Set new String loanInsuranceStatus
     */
    public void setLoanInsuranceStatus(String loanInsuranceStatus) {
        this.loanInsuranceStatus = loanInsuranceStatus;
    }

    /** Return int loanTerm. */
    public int getLoanTerm() {
        return loanTerm;
    }

    /** Set new int loanTerm. */
    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    /** Return double loanAmount. */
    public double getLoanAmount() {
        return this.loanAmount;
    }

    /** Set new double loanAmount.. */
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /** Return double outstandingLoanAmount. */
    public double getOutstandingLoanAmount() {
        return outstandingLoanAmount;
    }

    /** Return double interestRatePercentage. */
    public double getInterestRatePercentage() {
        return interestRatePercentage;
    }

    /** Return double monthlyRepayment. */
    public double getMonthlyRepayment() {
        return monthlyRepayment;
    }

    /** Return String carType. */
    public String getCarType() {
        return carType;
    }

    /** Set new String carType. */
    public void setCarType(String carType) {
        this.carType = carType;
    }

    /** Return double loanInsuranceFee. */
    public double getLoanInsuranceFee() {
        return loanInsuranceFee;
    }

}
