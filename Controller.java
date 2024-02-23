import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** The controller for Kawaguchi Bank Car Loan Application GUI,
 * and its models.
 */
public class Controller {
    /** GUI of Kawaguchi bank car loan application. */
    private final GUI gui;
    /** Model for CarLoanInstallmentCalculatorView. */
    private final CarLoanCalculationModel carLoanCalculationModel;
    /** Model for SummaryReportView. */
    private final SummaryReportModel summaryReportModel;

    /** Constructs a controller that acts as a bridge between GUI and carLoanCalculationModel,
     * and GUI and summaryReportModel,
     * controlling the workflow.
     */
    public Controller(GUI gui, CarLoanCalculationModel carLoanCalculationModel, SummaryReportModel summaryReportModel) {
        this.gui = gui;
        this.carLoanCalculationModel = carLoanCalculationModel;
        this.summaryReportModel = summaryReportModel;
        this.gui.addAllDisplayCarLoanSchemeButtonListener(new DisplayCarLoanSchemeButtonListener());
        this.gui.addAllCalculateCarLoanInstallmentButtonListener(new CalculateCarLoanInstallmentButtonListener());
        this.gui.addAllGenerateSummaryReportButtonListener(new GenerateSummaryReportButtonListener());
        this.gui.addAllExitButtonListener(new ExitButtonListener());
        this.gui.addAllBackToMainMenuButtonListener(new BackToMainMenuButtonListener());
        this.gui.addAllCalculateCarLoanInstallmentReportButtonListener(new CalculateCarLoanInstallmentReportButtonListener());
    }

    /** Listener subclass that changes the view to CarLoanSchemeView,
     * when an action is performed.
     */
    public class DisplayCarLoanSchemeButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {

            // Update CarLoanSchemeView.
            gui.getCarLoanSchemeView().updateView();

            // Change the view to CarLoanSchemeView.
            gui.changeView(GUI.CARLOANSCHEMEVIEWINDEX);
        }

    }

    /** Listener class that changes the view to CarLoanInstallmentCalculatorView,
     * when an action is performed.
     */
    public class CalculateCarLoanInstallmentButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {

            // Set the default value for CarLoanInstallmentCalculatorView.
            gui.getCarLoanInstallmentCalculatorView().setDefaultValue();

            // Change the view to CarLoanInstallmentCalculatorView.
            gui.changeView(GUI.CARLOANINSTALLMENTCALCULATORVIEWINDEX);
        }
    }

    /** Listener class that changes the view to SummaryReportView,
     * when an action is performed.
     */
    public class GenerateSummaryReportButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {

            // Update SummaryReportView.
            gui.getSummaryReportView().updateView();

            // Change the view to SummaryReportView.
            gui.changeView(GUI.SUMMARYREPORTVIEWINDEX);
        }

    }

    /** Listener class that exits the program,
     * when an action is performed.
     */
    public class ExitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {

            // Exits the program.
            gui.exit();
        }
    }

    /** Listener class that changes the view to MainMenuView,
     * when an action is performed.
     */
    public class BackToMainMenuButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.changeView(GUI.MAINMENUVIEWINDEX);
        }
    }

    /** Listener class that calculates the car loan installment,
     * and presents it in LoanInstallmentReportView,
     * when an action is performed.
     */
    public class CalculateCarLoanInstallmentReportButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {

            // Initialization
            String carType;
            int loanTerm;
            double loanAmount;
            String loanInsuranceStatus;
            boolean loanInsurance;
            double loanInsuranceFee;

            // Try-catch for validating loanTerm and loanAmount.
            try {

                // Get the values from CarLoanInstallmentCalculatorView.
                carType = gui.getCarLoanInstallmentCalculatorView().getSelectedCarType();
                loanTerm = gui.getCarLoanInstallmentCalculatorView().getLoanTerm();
                loanAmount = gui.getCarLoanInstallmentCalculatorView().getLoanAmount();
                loanInsurance = gui.getCarLoanInstallmentCalculatorView().isLoanInsuranceCheckBoxChecked();

                // Convert the boolean loanInsurance to String loanInsuranceStatus
                loanInsuranceStatus = convertLoanInsuranceStatus(loanInsurance);


                // If loanTerm or loanAmount is lesser than or equal to 0, error.
                if (loanTerm <= 0 || loanAmount <= 0) {
                    throw new NumberFormatException();
                }

                // Sets the carType, loanTerm, loanAmount and loanInsuranceStatus of carLoanCalculationModel.
                carLoanCalculationModel.setCarType(carType);
                carLoanCalculationModel.setLoanTerm(loanTerm);
                carLoanCalculationModel.setLoanAmount(loanAmount);
                carLoanCalculationModel.setLoanInsuranceStatus(loanInsuranceStatus);

                // Calculate the loan installment.
                carLoanCalculationModel.calculateLoan();

                // Get loan insurance fee.
                loanInsuranceFee = carLoanCalculationModel.getLoanInsuranceFee();

                // Update SummaryReportModel summaryReportModel.
                updateSummaryReportModel(carType, loanAmount, loanInsuranceStatus, loanInsuranceFee);

                // Update LoanInstallmentReportView.
                gui.getLoanInstallmentReportView().updateView();

                // Show LoanInstallmentReportView.
                gui.changeView(GUI.LOANINSTALLMENTREPORTVIEWINDEX);


            } catch (NumberFormatException ex) {
                // Error Window
                JOptionPane.showMessageDialog(new JFrame(),
                        "Error! You must enter a valid loan term and loan amount.",
                        "Kawaguchi Bank Car Loan Application",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    /** Convert boolean loanInsurance to String loanInsuranceStatus. */
    private String convertLoanInsuranceStatus(boolean loanInsurance) {

        String loanInsuranceStatus = "Not insured";

        if (loanInsurance) {
            loanInsuranceStatus = "Insured";
        }

        return loanInsuranceStatus;
    }

    /** Update SummaryReportModel summaryReportModel.*/
    private void updateSummaryReportModel(String carType, double loanAmount, String loanInsuranceStatus, double loanInsuranceFee) {

        if (carType.equals("Imported")) {
            updateTableDataForImportedCarLoanTransactions(loanAmount, loanInsuranceStatus, loanInsuranceFee);
        } else {
            updateTableDataForLocalCarLoanTransactions(loanAmount, loanInsuranceStatus, loanInsuranceFee);
        }
    }

    /** Update String[][] tableDataForImportedCarLoanTransactions,
     * in SummaryReportModel summaryReportModel.
     */
    private void updateTableDataForImportedCarLoanTransactions(double loanAmount, String loanInsuranceStatus, double loanInsuranceFee) {

        // Get the total number of car loan transactions and total loan amount of car loan transactions for imported car.
        int totalNumberOfCarLoanTransactionsForImportedCar = summaryReportModel.getTotalNumberOfCarLoanTransactionsForImportedCar();
        double totalLoanAmountOfCarLoanTransactionsForImportedCar = summaryReportModel.getTotalLoanAmountOfCarLoanTransactionsForImportedCar();

        // Increase the total number of car loan transactions for imported car by one.
        totalNumberOfCarLoanTransactionsForImportedCar += 1;

        // Increase the total loan amount of car loan transactions for imported car by the LOANAMOUNT and LOANINSURANCEFEE.
        totalLoanAmountOfCarLoanTransactionsForImportedCar += loanAmount + loanInsuranceFee;

        // Set the new values to SummaryReportModel summaryReportModel.
        summaryReportModel.setTotalNumberOfCarLoanTransactionsForImportedCar(totalNumberOfCarLoanTransactionsForImportedCar);
        summaryReportModel.setTotalLoanAmountOfCarLoanTransactionsForImportedCar(totalLoanAmountOfCarLoanTransactionsForImportedCar);

        // If got insurance.
        if (loanInsuranceStatus.equals("Insured")) {

            // Get the total number of insured car loan transactions and total loan amount of insured car loan transactions for imported car.
            int totalNumberOfInsuredCarLoanTransactionsForImportedCar = summaryReportModel.getTotalNumberOfInsuredCarLoanTransactionsForImportedCar();
            double totalLoanAmountOfInsuredCarLoanTransactionsForImportedCar = summaryReportModel.getTotalLoanAmountOfInsuredCarLoanTransactionsForImportedCar();

            // Increase the total number of insured car loan transactions for imported car by one.
            totalNumberOfInsuredCarLoanTransactionsForImportedCar += 1;

            // Increase the total loan amount of insured car loan transactions for imported car by the LOANAMOUNT and LOANINSURANCEFEE.
            totalLoanAmountOfInsuredCarLoanTransactionsForImportedCar += loanAmount + loanInsuranceFee;

            // Set the new values to SummaryReportModel summaryReportModel.
            summaryReportModel.setTotalNumberOfInsuredCarLoanTransactionsForImportedCar(totalNumberOfInsuredCarLoanTransactionsForImportedCar);
            summaryReportModel.setTotalLoanAmountOfInsuredCarLoanTransactionsForImportedCar(totalLoanAmountOfInsuredCarLoanTransactionsForImportedCar);

        } else {

            // Get the total number of not insured car loan transactions and total loan amount of not insured car loan transactions for imported car.
            int totalNumberOfNotInsuredCarLoanTransactionsForImportedCar = summaryReportModel.getTotalNumberOfNotInsuredCarLoanTransactionsForImportedCar();
            double totalLoanAmountOfNotInsuredCarLoanTransactionsForImportedCar = summaryReportModel.getTotalLoanAmountOfNotInsuredCarLoanTransactionsForImportedCar();

            // Increase the total number of not insured car loan transactions for imported car by one.
            totalNumberOfNotInsuredCarLoanTransactionsForImportedCar += 1;

            // Increase the total loan amount of not insured car loan transactions for imported car by the LOANAMOUNT and LOANINSURANCEFEE.
            totalLoanAmountOfNotInsuredCarLoanTransactionsForImportedCar += loanAmount;

            // Set the new values to SummaryReportModel summaryReportModel.
            summaryReportModel.setTotalNumberOfNotInsuredCarLoanTransactionsForImportedCar(totalNumberOfNotInsuredCarLoanTransactionsForImportedCar);
            summaryReportModel.setTotalLoanAmountOfNotInsuredCarLoanTransactionsForImportedCar(totalLoanAmountOfNotInsuredCarLoanTransactionsForImportedCar);
        }
    }

    /** Update String[][] tableDataForLocalCarLoanTransaction,
     * in SummaryReportModel summaryReportModel.
     */
    private void updateTableDataForLocalCarLoanTransactions(double loanAmount, String loanInsuranceStatus, double loanInsuranceFee) {

        // Get the total number of car loan transactions and total loan amount of car loan transactions for local car.
        int totalNumberOfCarLoanTransactionsForLocalCar = summaryReportModel.getTotalNumberOfCarLoanTransactionsForLocalCar();
        double totalLoanAmountOfCarLoanTransactionsForLocalCar = summaryReportModel.getTotalLoanAmountOfCarLoanTransactionsForLocalCar();

        // Increase the total number of car loan transactions for local car by one.
        totalNumberOfCarLoanTransactionsForLocalCar += 1;

        // Increase the total loan amount of car loan transactions for local car by the LOANAMOUNT and LOANINSURANCEFEE.
        totalLoanAmountOfCarLoanTransactionsForLocalCar += loanAmount + loanInsuranceFee;

        // Set the new values to SummaryReportModel summaryReportModel.
        summaryReportModel.setTotalNumberOfCarLoanTransactionsForLocalCar(totalNumberOfCarLoanTransactionsForLocalCar);
        summaryReportModel.setTotalLoanAmountOfCarLoanTransactionsForLocalCar(totalLoanAmountOfCarLoanTransactionsForLocalCar);

        // If got insurance.
        if (loanInsuranceStatus.equals("Insured")) {

            // Get the total number of insured car loan transactions and total loan amount of insured car loan transactions for local car.
            int totalNumberOfInsuredCarLoanTransactionsForLocalCar = summaryReportModel.getTotalNumberOfInsuredCarLoanTransactionsForLocalCar();
            double totalLoanAmountOfInsuredCarLoanTransactionsForLocalCar = summaryReportModel.getTotalLoanAmountOfInsuredCarLoanTransactionsForLocalCar();

            // Increase the total number of insured car loan transactions for local car by one.
            totalNumberOfInsuredCarLoanTransactionsForLocalCar += 1;

            // Increase the total loan amount of insured car loan transactions for local car by the LOANAMOUNT and LOANINSURANCEFEE.
            totalLoanAmountOfInsuredCarLoanTransactionsForLocalCar += loanAmount + loanInsuranceFee;

            // Set the new values to SummaryReportModel summaryReportModel.
            summaryReportModel.setTotalNumberOfInsuredCarLoanTransactionsForLocalCar(totalNumberOfInsuredCarLoanTransactionsForLocalCar);
            summaryReportModel.setTotalLoanAmountOfInsuredCarLoanTransactionsForLocalCar(totalLoanAmountOfInsuredCarLoanTransactionsForLocalCar);

        } else {

            // Get the total number of not insured car loan transactions and total loan amount of not insured car loan transactions for local car.
            int totalNumberOfNotInsuredCarLoanTransactionsForLocalCar = summaryReportModel.getTotalNumberOfNotInsuredCarLoanTransactionsForLocalCar();
            double totalLoanAmountOfNotInsuredCarLoanTransactionsForLocalCar = summaryReportModel.getTotalLoanAmountOfNotInsuredCarLoanTransactionsForLocalCar();

            // Increase the total number of not insured car loan transactions for local car by one.
            totalNumberOfNotInsuredCarLoanTransactionsForLocalCar += 1;

            // Increase the total loan amount of not insured car loan transactions for local car by the LOANAMOUNT and LOANINSURANCEFEE.
            totalLoanAmountOfNotInsuredCarLoanTransactionsForLocalCar += loanAmount;

            // Set the new values to SummaryReportModel summaryReportModel.
            summaryReportModel.setTotalNumberOfNotInsuredCarLoanTransactionsForLocalCar(totalNumberOfNotInsuredCarLoanTransactionsForLocalCar);
            summaryReportModel.setTotalLoanAmountOfNotInsuredCarLoanTransactionsForLocalCar(totalLoanAmountOfNotInsuredCarLoanTransactionsForLocalCar);
        }
    }
}
