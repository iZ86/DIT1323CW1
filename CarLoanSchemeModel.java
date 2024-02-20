
/** This class represents the model for CarLoanSchemeView,
 *  that will hold the data
 * of all the car loan scheme information.
 */
public class CarLoanSchemeModel {
    /** Column for car loan scheme table. */
    private final String[] carLoanTableDataColumn = {"Car Type", "Loan Amount (RM)", "Interest Rate (%)"};
    /** Data for car loan scheme table. */
    private final String[][] carLoanTableData = {
            {"Imported", ">300,000", "2.35%"},
            {null, "100,000-300,000", "2.55%"},
            {null, "<100,000", "2.75%"},
            {"Local", ">100,000", "3.0%"},
            {null, "50,000-100,000", "3.1%"},
            {null, "<50,000", "3.2%"},
    };

    /** Return String[] carLoanTableDataColumn. */
    public String[] getCarLoanTableDataColumn() {
        return carLoanTableDataColumn;
    }

    /** Return String[][] carLoanTableData. */
    public String[][] getCarLoanTableData() {
        return carLoanTableData;
    }



}
