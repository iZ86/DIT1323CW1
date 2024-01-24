
/** This class represents the calculation model for the Kawaguchi bank car loan program. */
public class CarLoanCalculationModel {
    private boolean loanInsurance;
    private double totalLoanYears, totalLoanAmount, loanPayback, interestRate, monthlyRepayment;
    private String carType;

    public CarLoanCalculationModel() {
        this.loanInsurance = false;
        this.totalLoanYears = this.totalLoanAmount = this.loanPayback = this.interestRate = this.monthlyRepayment = 0;
        this.carType = "None";
    }

    public boolean isLoanInsurance() {
        return loanInsurance;
    }

    public void setLoanInsurance(boolean loanInsurance) {
        this.loanInsurance = loanInsurance;
    }

    public double getTotalLoanYears() {
        return totalLoanYears;
    }

    public void setTotalLoanYears(double totalLoanYears) {
        this.totalLoanYears = totalLoanYears;
    }

    public double getTotalLoanAmount() {
        return totalLoanAmount;
    }

    public void setTotalLoanAmount(double totalLoanAmount) {
        this.totalLoanAmount = totalLoanAmount;
    }

    public double getLoanPayback() {
        return loanPayback;
    }

    public void setLoanPayback(double loanPayback) {
        this.loanPayback = loanPayback;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getMonthlyRepayment() {
        return monthlyRepayment;
    }

    public void setMonthlyRepayment(double monthlyRepayment) {
        this.monthlyRepayment = monthlyRepayment;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

}
