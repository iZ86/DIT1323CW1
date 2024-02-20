
/** This class represents the model for SummaryReportView. */
public class SummaryReportModel {
    /** Total number of car loan transactions for imported cars. */
    private int totalNumberOfCarLoanTransactionsForImportedCar;
    /** Total number of car loan transactions for local cars. */
    private int totalNumberOfCarLoanTransactionsForLocalCar;
    /** Total loan amount of car loan transactions for imported cars. */
    private double totalLoanAmountOfCarLoanTransactionsForImportedCar;
    /** Total loan amount of car loan transactions for local cars. */
    private double totalLoanAmountOfCarLoanTransactionsForLocalCar;
    /** Column for local and imported car loan transactions table. */
    private final String[] tableColumnForCarLoanTransactions = {"Loan Insurance Status", "Total transactions", "Amount (RM)"};
    /** The car loan transactions data for imported car transactions loan table. */
    private final String[][] tableDataForImportedCarLoanTransactions = {
            {"Insured", "0", "0.00"},
            {"Not insured", "0", "0.00"}
    };
    /** The car loan transactions data for local car loan transactions table. */
    private final String[][] tableDataForLocalCarLoanTransactions = {
            {"Insured", "0", "0.00"},
            {"Not insured", "0", "0.00"}
    };


    public SummaryReportModel() {
        totalNumberOfCarLoanTransactionsForImportedCar = 0;
        totalNumberOfCarLoanTransactionsForLocalCar = 0;
        totalLoanAmountOfCarLoanTransactionsForImportedCar = 0;
        totalLoanAmountOfCarLoanTransactionsForLocalCar = 0;
    }

    /** Return int totalNumberOfCarLoanTransactionsForImportedCar. */
    public int getTotalNumberOfCarLoanTransactionsForImportedCar() {
        return totalNumberOfCarLoanTransactionsForImportedCar;
    }

    /** Set new int totalNumberOfCarLoanTransactionsForImportedCar. */
    public void setTotalNumberOfCarLoanTransactionsForImportedCar(int totalNumberOfCarLoanTransactionsForImportedCar) {
        this.totalNumberOfCarLoanTransactionsForImportedCar = totalNumberOfCarLoanTransactionsForImportedCar;
    }

    /** Return int totalNumberOfCarLoanTransactionsForLocalCar. */
    public int getTotalNumberOfCarLoanTransactionsForLocalCar() {
        return totalNumberOfCarLoanTransactionsForLocalCar;
    }

    /** Set new int totalNumberOfCarLoanTransactionsForLocalCar. */
    public void setTotalNumberOfCarLoanTransactionsForLocalCar(int totalNumberOfCarLoanTransactionsForLocalCar) {
        this.totalNumberOfCarLoanTransactionsForLocalCar = totalNumberOfCarLoanTransactionsForLocalCar;
    }

    /** Return double totalLoanAmountOfCarLoanTransactionsForImportedCar. */
    public double getTotalLoanAmountOfCarLoanTransactionsForImportedCar() {
        return totalLoanAmountOfCarLoanTransactionsForImportedCar;
    }

    /** Set new double totalLoanAmountOfCarLoanTransactionsForImportedCar. */
    public void setTotalLoanAmountOfCarLoanTransactionsForImportedCar(double totalLoanAmountOfCarLoanTransactionsForImportedCar) {
        this.totalLoanAmountOfCarLoanTransactionsForImportedCar = totalLoanAmountOfCarLoanTransactionsForImportedCar;
    }

    /** Return double totalLoanAmountOfCarLoanTransactionsForLocalCar. */
    public double getTotalLoanAmountOfCarLoanTransactionsForLocalCar() {
        return totalLoanAmountOfCarLoanTransactionsForLocalCar;
    }

    /** Set new double totalLoanAmountOfCarLoanTransactionsForLocalCar. */
    public void setTotalLoanAmountOfCarLoanTransactionsForLocalCar(double totalLoanAmountOfCarLoanTransactionsForLocalCar) {
        this.totalLoanAmountOfCarLoanTransactionsForLocalCar = totalLoanAmountOfCarLoanTransactionsForLocalCar;
    }

    /** Return String[] tableColumnForCarLoanTransactions. */
    public String[] getTableColumnForCarLoanTransactions() {
        return tableColumnForCarLoanTransactions;
    }

    /** Return String[][] tableDataForImportedCarLoanTransactions. */
    public String[][] getTableDataForImportedCarLoanTransactions() {
        return tableDataForImportedCarLoanTransactions;
    }

    /** Return total number of insured car loan transactions for imported cars,
     * from String[][] tableDataForImportedCarLoanTransactions.
     */
    public int getTotalNumberOfInsuredCarLoanTransactionsForImportedCar() {
        return Integer.parseInt(tableDataForImportedCarLoanTransactions[0][1]);

    }

    /** Set new total number of insured car loan transactions for imported cars,
     *  in String[][] tableDataForImportedCarLoanTransactions.
     */
    public void setTotalNumberOfInsuredCarLoanTransactionsForImportedCar(int totalNumberOfInsuredCarLoanTransactionsForImportedCar) {
        tableDataForImportedCarLoanTransactions[0][1] = Integer.toString(totalNumberOfInsuredCarLoanTransactionsForImportedCar);
    }

    /** Return total loan amount from every insured car loan transactions for imported cars,
     * from String[][] tableDataForImportedCarLoanTransactions.
     */
    public double getTotalLoanAmountOfInsuredCarLoanTransactionsForImportedCar() {
        return Double.parseDouble(tableDataForImportedCarLoanTransactions[0][2]);
    }

    /** Set new total loan amount from every insured car loan transactions for imported cars,
     * from String[][] tableDataForImportedCarLoanTransactions.
     */
    public void setTotalLoanAmountOfInsuredCarLoanTransactionsForImportedCar(double totalLoanAmountOfInsuredCarLoanTransactionsForImportedCar) {
        tableDataForImportedCarLoanTransactions[0][2] = String.format("%.2f",
                totalLoanAmountOfInsuredCarLoanTransactionsForImportedCar);
    }

    /** Return total number of not insured car loan transactions for imported cars,
     * from String[][] tableDataForImportedCarLoanTransactions.
     */
    public int getTotalNumberOfNotInsuredCarLoanTransactionsForImportedCar() {
        return Integer.parseInt(tableDataForImportedCarLoanTransactions[1][1]);
    }

    /** Set new total number of not insured car loan transactions for imported cars,
     * in String[][] tableDataForImportedCarLoanTransactions.
     */
    public void setTotalNumberOfNotInsuredCarLoanTransactionsForImportedCar(int totalNumberOfNotInsuredCarLoanTransactionsForImportedCar) {
        tableDataForImportedCarLoanTransactions[1][1] = Integer.toString(totalNumberOfNotInsuredCarLoanTransactionsForImportedCar);
    }

    /** Return total loan amount from every not insured car loan transactions for imported cars,
     * from String[][] tableDataForImportedCarLoanTransactions.
     */
    public double getTotalLoanAmountOfNotInsuredCarLoanTransactionsForImportedCar() {
        return Double.parseDouble(tableDataForImportedCarLoanTransactions[1][2]);
    }

    /** Set new total loan amount from every not insured car loan transactions for imported cars,
     * from String[][] tableDataForImportedCarLoanTransactions.
     */
    public void setTotalLoanAmountOfNotInsuredCarLoanTransactionsForImportedCar(double totalLoanAmountOfNotInsuredCarLoanTransactionsForImportedCar) {
        tableDataForImportedCarLoanTransactions[1][2] = String.format("%.2f",
                totalLoanAmountOfNotInsuredCarLoanTransactionsForImportedCar);
    }

    /** Return String[] tableDataForLocalCarLoanTransactions. */
    public String[][] getTableDataForLocalCarLoanTransactions() {
        return tableDataForLocalCarLoanTransactions;
    }

    /** Return total number of insured car loan transactions for local cars,
     * from String[][] tableDataForLocalCarLoanTransactions.
     */
    public int getTotalNumberOfInsuredCarLoanTransactionsForLocalCar() {
        return Integer.parseInt(tableDataForLocalCarLoanTransactions[0][1]);

    }

    /** Set new total number of insured car loan transactions for local cars,
     *  in String[][] tableDataForLocalCarLoanTransactions.
     */
    public void setTotalNumberOfInsuredCarLoanTransactionsForLocalCar(int totalNumberOfInsuredCarLoanTransactionsForLocalCar) {
        tableDataForLocalCarLoanTransactions[0][1] = Integer.toString(totalNumberOfInsuredCarLoanTransactionsForLocalCar);
    }

    /** Return total loan amount from every insured car loan transactions for local cars,
     * from String[][] tableDataForLocalCarLoanTransactions.
     */
    public double getTotalLoanAmountOfInsuredCarLoanTransactionsForLocalCar() {
        return Double.parseDouble(tableDataForLocalCarLoanTransactions[0][2]);
    }

    /** Set new total loan amount from every insured car loan transactions for local cars,
     * from String[][] tableDataForLocalCarLoanTransactions.
     */
    public void setTotalLoanAmountOfInsuredCarLoanTransactionsForLocalCar(double totalLoanAmountOfInsuredCarLoanTransactionsForLocalCar) {
        tableDataForLocalCarLoanTransactions[0][2] = String.format("%.2f",
                totalLoanAmountOfInsuredCarLoanTransactionsForLocalCar);
    }

    /** Return total number of not insured car loan transactions for local cars,
     * from String[][] tableDataForLocalCarLoanTransactions.
     */
    public int getTotalNumberOfNotInsuredCarLoanTransactionsForLocalCar() {
        return Integer.parseInt(tableDataForLocalCarLoanTransactions[1][1]);
    }

    /** Set new total number of not insured car loan transactions for local cars,
     * in String[][] tableDataForLocalCarLoanTransactions.
     */
    public void setTotalNumberOfNotInsuredCarLoanTransactionsForLocalCar(int totalNumberOfNotInsuredCarLoanTransactionsForLocalCar) {
        tableDataForLocalCarLoanTransactions[1][1] = Integer.toString(totalNumberOfNotInsuredCarLoanTransactionsForLocalCar);
    }

    /** Return total loan amount from every not insured car loan transactions for local cars,
     * from String[][] tableDataForLocalCarLoanTransactions.
     */
    public double getTotalLoanAmountOfNotInsuredCarLoanTransactionsForLocalCar() {
        return Double.parseDouble(tableDataForLocalCarLoanTransactions[1][2]);
    }

    /** Set new total loan amount from every not insured car loan transactions for local cars,
     * from String[][] tableDataForLocalCarLoanTransactions.
     */
    public void setTotalLoanAmountOfNotInsuredCarLoanTransactionsForLocalCar(double totalLoanAmountOfNotInsuredCarLoanTransactionsForLocalCar) {
        tableDataForLocalCarLoanTransactions[1][2] = String.format("%.2f",
                totalLoanAmountOfNotInsuredCarLoanTransactionsForLocalCar);
    }
}
