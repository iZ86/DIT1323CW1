
/** This class represents the model that will hold the data
 * of all the car loan scheme information. */
public class CarLoanSchemeModel {
    private static final String[] carTypes = new String[]{"Imported", "Local"};
    private static final String[] importedCarLoanAmounts = new String[]{">300,000", "100,000-300,000", "<100,000"};
    private static final String[] localCarLoanAmounts = new String[]{">100,000", "50,000-100,000", "<50,000"};
    private static final String[] importedInterestRates = new String[]{"2.35%", "2.55%", "2.75%"};
    private static final String[] localInterestRates = new String[]{"3.0%", "3.1%", "3.2%"};

    /** Returns an array of car types. */
    public static String[] getCarTypes() {
        return carTypes;
    }

    /** Returns an array of imported car loan amounts. */
    public static String[] getImportedCarLoanAmounts() {
        return importedCarLoanAmounts;
    }

    public static String[] getLocalCarLoanAmounts() {
        return localCarLoanAmounts;
    }

    public static String[] getImportedInterestRates() {
        return importedInterestRates;
    }

    public static String[] getLocalInterestRates() {
        return localInterestRates;
    }

}
