
/** This class represents the model for SummaryReportView. */
public class SummaryReportModel {
    /** Total number of car loan transactions for imported cars. */
    private int totalNumberOfCarLoanTransactionForImportedCar;
    /** Total number of car loan transactions for local cars. */
    private int totalNumberOfCarLoanTransactionForLocalCar;
    /** Total loan amount of car loan transaction for imported cars. */
    private double totalLoanAmountOfCarLoanTransactionForImportedCar;
    /** Total loan amount of car loan transaction for local cars. */
    private double totalLoanAmountOfCarLoanTransactionForLocalCar;
    /** Column for local and imported car loan transaction table. */
    private String[] tableColumnForCarLoanTransaction = {"Total transaction", "Loan Insurance Status", "Amount"};
    /** The car loan transaction data for imported car transaction loan table. */
    private String[][] tableDataForImportedCarLoanTransaction = {
            {"0", "Insured", "0"},
            {"0", "Not insured", "0"}
    };
    /** The car loan transaction data for local car loan transaction table. */
    private String[][] tableDataForLocalCarLoanTransaction = {
            {"0", "Insured", "0"},
            {"0", "Not insured", "0"}
    };


    public SummaryReportModel() {
        totalNumberOfCarLoanTransactionForImportedCar = 0;
        totalNumberOfCarLoanTransactionForLocalCar = 0;
        totalLoanAmountOfCarLoanTransactionForImportedCar = 0;
        totalLoanAmountOfCarLoanTransactionForLocalCar = 0;
    }

    /** Return int totalNumberOfCarLoanTransactionForImportedCar. */
    public int getTotalNumberOfCarLoanTransactionForImportedCar() {
        return totalNumberOfCarLoanTransactionForImportedCar;
    }

    /** Set new int totalNumberOfCarLoanTransactionForImportedCar. */
    public void setTotalNumberOfCarLoanTransactionForImportedCar(int totalNumberOfCarLoanTransactionForImportedCar) {
        this.totalNumberOfCarLoanTransactionForImportedCar = totalNumberOfCarLoanTransactionForImportedCar;
    }

    /** Return int totalNumberOfCarLoanTransactionForLocalCar. */
    public int getTotalNumberOfCarLoanTransactionForLocalCar() {
        return totalNumberOfCarLoanTransactionForLocalCar;
    }

    /** Set new int totalNumberOfCarLoanTransactionForLocalCar. */
    public void setTotalNumberOfCarLoanTransactionForLocalCar(int totalNumberOfCarLoanTransactionForLocalCar) {
        this.totalNumberOfCarLoanTransactionForLocalCar = totalNumberOfCarLoanTransactionForLocalCar;
    }

    /** Return double totalLoanAmountOfCarLoanTransactionForImportedCar. */
    public double getTotalLoanAmountOfCarLoanTransactionForImportedCar() {
        return totalLoanAmountOfCarLoanTransactionForImportedCar;
    }

    /** Set new double totalLoanAmountOfCarLoanTransactionForImportedCar. */
    public void setTotalLoanAmountOfCarLoanTransactionForImportedCar(double totalLoanAmountOfCarLoanTransactionForImportedCar) {
        this.totalLoanAmountOfCarLoanTransactionForImportedCar = totalLoanAmountOfCarLoanTransactionForImportedCar;
    }

    /** Return double totalLoanAmountOfCarLoanTransactionForLocalCar. */
    public double getTotalLoanAmountOfCarLoanTransactionForLocalCar() {
        return totalLoanAmountOfCarLoanTransactionForLocalCar;
    }

    /** Set new double totalLoanAmountOfCarLoanTransactionForLocalCar. */
    public void setTotalLoanAmountOfCarLoanTransactionForLocalCar(double totalLoanAmountOfCarLoanTransactionForLocalCar) {
        this.totalLoanAmountOfCarLoanTransactionForLocalCar = totalLoanAmountOfCarLoanTransactionForLocalCar;
    }

    /** Return String[] tableColumnForCarLoanTransaction. */
    public String[] getTableColumnForCarLoanTransaction() {
        return tableColumnForCarLoanTransaction;
    }

    /** Return String[][] tableDataForImportedCarLoanTransaction. */
    public String[][] getTableDataForImportedCarLoanTransaction() {
        return tableDataForImportedCarLoanTransaction;
    }

    /** Return total number of insured car loan transactions for imported cars,
     * from String[][] tableDataForImportedCarLoanTransaction.
     */
    public int getTotalNumberOfInsuredCarLoanTransactionForImportedCar() {
        return Integer.parseInt(tableDataForImportedCarLoanTransaction[0][0]);

    }

    /** Set new total number of insured car loan transactions for imported cars,
     *  in String[][] tableDataForImportedCarLoanTransaction.
     */
    public void setTotalNumberOfInsuredCarLoanTransactionForImportedCar(int totalNumberOfInsuredCarLoanTransactionForImportedCar) {
        tableDataForImportedCarLoanTransaction[0][0] = Integer.toString(totalNumberOfInsuredCarLoanTransactionForImportedCar);
    }

    /** Return total loan amount from every insured car loan transactions for imported cars,
     * from String[][] tableDataForImportedCarLoanTransaction.
     */
    public double getTotalLoanAmountOfInsuredCarLoanTransactionForImportedCar() {
        return Double.parseDouble(tableDataForImportedCarLoanTransaction[0][2]);
    }

    /** Set new total loan amount from every insured car loan transactions for imported cars,
     * from String[][] tableDataForImportedCarLoanTransaction.
     */
    public void setTotalLoanAmountOfInsuredCarLoanTransactionForImportedCar(double totalLoanAmountOfInsuredCarLoanTransactionForImportedCar) {
        tableDataForImportedCarLoanTransaction[0][2] = Double.toString(totalLoanAmountOfInsuredCarLoanTransactionForImportedCar);
    }

    /** Return total number of not insured car loan transactions for imported cars,
     * from String[][] tableDataForImportedCarLoanTransaction.
     */
    public int getTotalNumberOfNotInsuredCarLoanTransactionForImportedCar() {
        return Integer.parseInt(tableDataForImportedCarLoanTransaction[1][0]);
    }

    /** Set new total number of not insured car loan transactions for imported cars,
     * in String[][] tableDataForImportedCarLoanTransaction.
     */
    public void setTotalNumberOfNotInsuredCarLoanTransactionForImportedCar(int totalNumberOfNotInsuredCarLoanTransactionForImportedCar) {
        tableDataForImportedCarLoanTransaction[1][0]= Integer.toString(totalNumberOfNotInsuredCarLoanTransactionForImportedCar);
    }

    /** Return total loan amount from every not insured car loan transactions for imported cars,
     * from String[][] tableDataForImportedCarLoanTransaction.
     */
    public double getTotalLoanAmountOfNotInsuredCarLoanTransactionForImportedCar() {
        return Double.parseDouble(tableDataForImportedCarLoanTransaction[1][2]);
    }

    /** Set new total loan amount from every not insured car loan transactions for imported cars,
     * from String[][] tableDataForImportedCarLoanTransaction.
     */
    public void setTotalLoanAmountOfNotInsuredCarLoanTransactionForImportedCar(double totalLoanAmountOfNotInsuredCarLoanTransactionForImportedCar) {
        tableDataForImportedCarLoanTransaction[1][2] = Double.toString(totalLoanAmountOfNotInsuredCarLoanTransactionForImportedCar);
    }

    /** Return String[] tableDataForLocalCarLoanTransaction. */
    public String[][] getTableDataForLocalCarLoanTransaction() {
        return tableDataForLocalCarLoanTransaction;
    }

    /** Return total number of insured car loan transactions for local cars,
     * from String[][] tableDataForLocalCarLoanTransaction.
     */
    public int getTotalNumberOfInsuredCarLoanTransactionForLocalCar() {
        return Integer.parseInt(tableDataForLocalCarLoanTransaction[0][0]);

    }

    /** Set new total number of insured car loan transactions for local cars,
     *  in String[][] tableDataForLocalCarLoanTransaction.
     */
    public void setTotalNumberOfInsuredCarLoanTransactionForLocalCar(int totalNumberOfInsuredCarLoanTransactionForLocalCar) {
        tableDataForLocalCarLoanTransaction[0][0] = Integer.toString(totalNumberOfInsuredCarLoanTransactionForLocalCar);
    }

    /** Return total loan amount from every insured car loan transactions for local cars,
     * from String[][] tableDataForLocalCarLoanTransaction.
     */
    public double getTotalLoanAmountOfInsuredCarLoanTransactionForLocalCar() {
        return Double.parseDouble(tableDataForLocalCarLoanTransaction[0][2]);
    }

    /** Set new total loan amount from every insured car loan transactions for local cars,
     * from String[][] tableDataForLocalCarLoanTransaction.
     */
    public void setTotalLoanAmountOfInsuredCarLoanTransactionForLocalCar(double totalLoanAmountOfInsuredCarLoanTransactionForLocalCar) {
        tableDataForLocalCarLoanTransaction[0][2] = Double.toString(totalLoanAmountOfInsuredCarLoanTransactionForLocalCar);
    }

    /** Return total number of not insured car loan transactions for local cars,
     * from String[][] tableDataForLocalCarLoanTransaction.
     */
    public int getTotalNumberOfNotInsuredCarLoanTransactionForLocalCar() {
        return Integer.parseInt(tableDataForLocalCarLoanTransaction[1][0]);
    }

    /** Set new total number of not insured car loan transactions for local cars,
     * in String[][] tableDataForLocalCarLoanTransaction.
     */
    public void setTotalNumberOfNotInsuredCarLoanTransactionForLocalCar(int totalNumberOfNotInsuredCarLoanTransactionForLocalCar) {
        tableDataForLocalCarLoanTransaction[1][0]= Integer.toString(totalNumberOfNotInsuredCarLoanTransactionForLocalCar);
    }

    /** Return total loan amount from every not insured car loan transactions for local cars,
     * from String[][] tableDataForLocalCarLoanTransaction.
     */
    public double getTotalLoanAmountOfNotInsuredCarLoanTransactionForLocalCar() {
        return Double.parseDouble(tableDataForLocalCarLoanTransaction[1][2]);
    }

    /** Set new total loan amount from every not insured car loan transactions for local cars,
     * from String[][] tableDataForLocalCarLoanTransaction.
     */
    public void setTotalLoanAmountOfNotInsuredCarLoanTransactionForLocalCar(double totalLoanAmountOfNotInsuredCarLoanTransactionForLocalCar) {
        tableDataForLocalCarLoanTransaction[1][2] = Double.toString(totalLoanAmountOfNotInsuredCarLoanTransactionForLocalCar);
    }




}
