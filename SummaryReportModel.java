

public class SummaryReportModel {
    /** Total number of car loan transactions for imported cars. */
    private int totalNumberOfCarLoanTransactionForImportedCar;
    /** Total number of car loan transactions for local cars. */
    private int totalNumberOfCarLoanTransactionForLocalCar;
    /** Total loan amount of car loan transaction for imported cars. */
    private int totalLoanAmountOfCarLoanTransactionForImportedCar;
    /** Total loan amount of car loan transaction for local cars. */
    private int totalLoanAmountOfCarLoanTransactionForLocalCar;
    /** Column for local and imported car loan transaction table. */
    private String[] tableColumnForCarLoanTransaction = {"Total transaction", "Loan Insurance Status", "Amount"};
    // TODO: maybe put it in a function?
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

    /** Return int totalLoanAmountOfCarLoanTransactionForImportedCar. */
    public int getTotalLoanAmountOfCarLoanTransactionForImportedCar() {
        return totalLoanAmountOfCarLoanTransactionForImportedCar;
    }

    /** Set new int totalLoanAmountOfCarLoanTransactionForImportedCar. */
    public void setTotalLoanAmountOfCarLoanTransactionForImportedCar(int totalLoanAmountOfCarLoanTransactionForImportedCar) {
        this.totalLoanAmountOfCarLoanTransactionForImportedCar = totalLoanAmountOfCarLoanTransactionForImportedCar;
    }

    /** Return int totalLoanAmountOfCarLoanTransactionForLocalCar. */
    public int getTotalLoanAmountOfCarLoanTransactionForLocalCar() {
        return totalLoanAmountOfCarLoanTransactionForLocalCar;
    }

    /** Set new int totalLoanAmountOfCarLoanTransactionForLocalCar. */
    public void setTotalLoanAmountOfCarLoanTransactionForLocalCar(int totalLoanAmountOfCarLoanTransactionForLocalCar) {
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
    public int getTotalLoanAmountOfInsuredCarLoanTransactionForImportedCar() {
        return Integer.parseInt(tableDataForImportedCarLoanTransaction[0][3]);
    }

    /** Set new total loan amount from every insured car loan transactions for imported cars,
     * from String[][] tableDataForImportedCarLoanTransaction.
     */
    public void setTotalLoanAmountOfInsuredCarLoanTransactionForImportedCar(int totalLoanAmountOfInsuredCarLoanTransactionForImportedCar) {
        tableDataForImportedCarLoanTransaction[0][3] = Integer.toString(totalLoanAmountOfInsuredCarLoanTransactionForImportedCar);
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
    public int getTotalLoanAmountOfNotInsuredCarLoanTransactionForImportedCar() {
        return Integer.parseInt(tableDataForImportedCarLoanTransaction[1][3]);
    }

    /** Set new total loan amount from every not insured car loan transactions for imported cars,
     * from String[][] tableDataForImportedCarLoanTransaction.
     */
    public void setTotalLoanAmountOfNotInsuredCarLoanTransactionForImportedCar(int totalLoanAmountOfNotInsuredCarLoanTransactionForImportedCar) {
        tableDataForImportedCarLoanTransaction[1][3] = Integer.toString(totalLoanAmountOfNotInsuredCarLoanTransactionForImportedCar);
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
    public int getTotalLoanAmountOfInsuredCarLoanTransactionForLocalCar() {
        return Integer.parseInt(tableDataForLocalCarLoanTransaction[0][3]);
    }

    /** Set new total loan amount from every insured car loan transactions for local cars,
     * from String[][] tableDataForLocalCarLoanTransaction.
     */
    public void setTotalLoanAmountOfInsuredCarLoanTransactionForLocalCar(int totalLoanAmountOfInsuredCarLoanTransactionForLocalCar) {
        tableDataForLocalCarLoanTransaction[0][3] = Integer.toString(totalLoanAmountOfInsuredCarLoanTransactionForLocalCar);
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
    public int getTotalLoanAmountOfNotInsuredCarLoanTransactionForLocalCar() {
        return Integer.parseInt(tableDataForLocalCarLoanTransaction[1][3]);
    }

    /** Set new total loan amount from every not insured car loan transactions for local cars,
     * from String[][] tableDataForLocalCarLoanTransaction.
     */
    public void setTotalLoanAmountOfNotInsuredCarLoanTransactionForLocalCar(int totalLoanAmountOfNotInsuredCarLoanTransactionForLocalCar) {
        tableDataForLocalCarLoanTransaction[1][3] = Integer.toString(totalLoanAmountOfNotInsuredCarLoanTransactionForLocalCar);
    }




}
