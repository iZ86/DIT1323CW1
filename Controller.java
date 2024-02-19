import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Logic between model and comments for summary report.

public class Controller {
    /** GUI of Kawaguchi bank loan application. */
    GUI gui;
    /** Model for CarLoanSchemeView carLoanSchemeView. */
    CarLoanSchemeModel carLoanSchemeModel;
    /** Model for CarLoanInstallmentCalculatorView carLoanInstallmentCalculatorView. */
    CarLoanCalculationModel carLoanCalculationModel;
    /** Model for SummaryReportView summaryReportView. */
    SummaryReportModel summaryReportModel;

    /** Controller that acts as a bridge between GUI and carLoanSchemeModel,
     * GUI and carLoanCalculationModel, and GUI and summaryReportModel,
     * controlling the workflow.
     */
    public Controller(GUI gui, CarLoanSchemeModel carLoanSchemeModel, CarLoanCalculationModel carLoanCalculationModel, SummaryReportModel summaryReportModel) {
        this.gui = gui;
        this.carLoanSchemeModel = carLoanSchemeModel;
        this.carLoanCalculationModel = carLoanCalculationModel;
        this.summaryReportModel = summaryReportModel;
        this.gui.addAllDisplayCarLoanSchemeButtonListener(new DisplayCarLoanSchemeButtonListener());
        this.gui.addAllCalculateCarLoanInstallmentButtonListener(new CalculateCarLoanInstallmentButtonListener());
        this.gui.addAllGenerateSummaryReportButtonListener(new GenerateSummaryReportButtonListener());
        this.gui.addAllExitButtonListener(new ExitButtonListener());
        this.gui.addAllBackToMainMenuButtonListener(new BackToMainMenuButtonListener());
        this.gui.addAllCalculateCarLoanInstallmentReportButtonListener(new CalculateCarLoanInstallmentReportButtonListener());
    }

    /** Listener subclass that changes the view to CarLoanSchemeView carLoanSchemeView,
     * when an action is performed.
     */
    public class DisplayCarLoanSchemeButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.getCarLoanSchemeView().updateView();
            gui.changeView(GUI.carLoanSchemeViewIndex);
        }

    }

    /** Listener class that changes the view to CarLoanInstallmentCalculatorView carLoanInstallmentCalculatorView,
     * when an action is performed.
     */
    public class CalculateCarLoanInstallmentButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.changeView(GUI.carLoanInstallmentCalculatorViewIndex);
        }
    }

    /** Listener class that changes the view to SummaryReportView summaryReportView,
     * when an action is performed.
     */
    public class GenerateSummaryReportButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.getSummaryReportView().updateView();
            gui.changeView(GUI.summaryReportViewIndex);
        }

    }

    /** Listener class that finishes the program,
     * when an action is performed.
     */
    public class ExitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.exit();
        }
    }

    /** Listener class that changes the view to MainMenuView mainMenuView,
     * when an action is performed.
     */
    public class BackToMainMenuButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.changeView(GUI.mainMenuViewIndex);
        }
    }

    /** Listener class that calculates the car loan installment,
     * and presents it in LoanInstallmentReportView loanInstallmentReportView,
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

            // Try-catch for validating loanTerm and loanAmount.
            try {

                // Get the values from CarLoanInstallmentCalculatorView.
                carType = gui.getCarLoanInstallmentCalculatorView().getSelectedCarType();
                loanTerm = gui.getCarLoanInstallmentCalculatorView().getLoanTerm();
                loanAmount = gui.getCarLoanInstallmentCalculatorView().getLoanAmount();
                loanInsurance = gui.getCarLoanInstallmentCalculatorView().getLoanInsuranceCheckBoxChecked();

                // Convert the boolean loanInsurance to String loanInsuranceStatus
                loanInsuranceStatus = getLoanInsuranceStatus(loanInsurance);


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

                // Update SummaryReportModel summaryReportModel.
                updateSummaryReportModel(carType, loanAmount, loanInsuranceStatus);

                // Update LoanInstallmentReportView.
                gui.getLoanInstallmentReportView().updateView();

                // Show LoanInstallmentReportView.
                gui.changeView(GUI.loanInstallmentReportViewIndex);


            } catch (NumberFormatException ex) {
                // Error Window
                JOptionPane.showMessageDialog(new JFrame(),
                        "You must enter a valid loan term and loan amount.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    /** Return the loan insurance status. */
    private String getLoanInsuranceStatus(boolean loanInsurance) {

        String loanInsuranceStatus = "Not insured";

        if (loanInsurance) {
            loanInsuranceStatus = "Insured";
        }

        return loanInsuranceStatus;
    }

    /** Update SummaryReportModel summaryReportModel.*/
    private void updateSummaryReportModel(String carType, double loanAmount, String loanInsuranceStatus) {

        if (carType.equals("Imported")) {
            updateTableDataForImportedCarLoanTransaction(loanAmount, loanInsuranceStatus);
        } else {
            updateTableDataForLocalCarLoanTransaction(loanAmount, loanInsuranceStatus);
        }

    }

    /** Update String[][] tableDataForImportedCarLoanTransaction,
     * in SummaryReportModel summaryReportModel.
     */
    private void updateTableDataForImportedCarLoanTransaction(double loanAmount, String loanInsuranceStatus) {

        int totalNumberOfCarLoanTransactionForImportedCar = summaryReportModel.getTotalNumberOfCarLoanTransactionForImportedCar();
        double totalLoanAmountOfCarLoanTransactionForImportedCar = summaryReportModel.getTotalLoanAmountOfCarLoanTransactionForImportedCar();

        totalNumberOfCarLoanTransactionForImportedCar += 1;
        totalLoanAmountOfCarLoanTransactionForImportedCar += loanAmount;

        summaryReportModel.setTotalNumberOfCarLoanTransactionForImportedCar(totalNumberOfCarLoanTransactionForImportedCar);
        summaryReportModel.setTotalLoanAmountOfCarLoanTransactionForImportedCar(totalLoanAmountOfCarLoanTransactionForImportedCar);


        if (loanInsuranceStatus.equals("Insured")) {

            int totalNumberOfInsuredCarLoanTransactionForImportedCar = summaryReportModel.getTotalNumberOfInsuredCarLoanTransactionForImportedCar();
            double totalLoanAmountOfInsuredCarLoanTransactionForImportedCar = summaryReportModel.getTotalLoanAmountOfInsuredCarLoanTransactionForImportedCar();

            totalNumberOfInsuredCarLoanTransactionForImportedCar += 1;
            totalLoanAmountOfInsuredCarLoanTransactionForImportedCar += loanAmount;

            summaryReportModel.setTotalNumberOfInsuredCarLoanTransactionForImportedCar(totalNumberOfInsuredCarLoanTransactionForImportedCar);
            summaryReportModel.setTotalLoanAmountOfInsuredCarLoanTransactionForImportedCar(totalLoanAmountOfInsuredCarLoanTransactionForImportedCar);

        } else {
            int totalNumberOfNotInsuredCarLoanTransactionForImportedCar = summaryReportModel.getTotalNumberOfNotInsuredCarLoanTransactionForImportedCar();
            double totalLoanAmountOfNotInsuredCarLoanTransactionForImportedCar = summaryReportModel.getTotalLoanAmountOfNotInsuredCarLoanTransactionForImportedCar();

            totalNumberOfNotInsuredCarLoanTransactionForImportedCar += 1;
            totalLoanAmountOfNotInsuredCarLoanTransactionForImportedCar += loanAmount;

            summaryReportModel.setTotalNumberOfNotInsuredCarLoanTransactionForImportedCar(totalNumberOfNotInsuredCarLoanTransactionForImportedCar);
            summaryReportModel.setTotalLoanAmountOfNotInsuredCarLoanTransactionForImportedCar(totalLoanAmountOfNotInsuredCarLoanTransactionForImportedCar);
        }
    }

    /** Update String[][] tableDataForLocalCarLoanTransaction,
     * in SummaryReportModel summaryReportModel.
     */
    private void updateTableDataForLocalCarLoanTransaction(double loanAmount, String loanInsuranceStatus) {

        int totalNumberOfCarLoanTransactionForLocalCar = summaryReportModel.getTotalNumberOfCarLoanTransactionForLocalCar();
        double totalLoanAmountOfCarLoanTransactionForLocalCar = summaryReportModel.getTotalLoanAmountOfCarLoanTransactionForLocalCar();

        totalNumberOfCarLoanTransactionForLocalCar += 1;
        totalLoanAmountOfCarLoanTransactionForLocalCar += loanAmount;

        summaryReportModel.setTotalNumberOfCarLoanTransactionForLocalCar(totalNumberOfCarLoanTransactionForLocalCar);
        summaryReportModel.setTotalLoanAmountOfCarLoanTransactionForLocalCar(totalLoanAmountOfCarLoanTransactionForLocalCar);

        if (loanInsuranceStatus.equals("Insured")) {

            int totalNumberOfInsuredCarLoanTransactionForLocalCar = summaryReportModel.getTotalNumberOfInsuredCarLoanTransactionForLocalCar();
            double totalLoanAmountOfInsuredCarLoanTransactionForLocalCar = summaryReportModel.getTotalLoanAmountOfInsuredCarLoanTransactionForLocalCar();

            totalNumberOfInsuredCarLoanTransactionForLocalCar += 1;
            totalLoanAmountOfInsuredCarLoanTransactionForLocalCar += loanAmount;

            summaryReportModel.setTotalNumberOfInsuredCarLoanTransactionForLocalCar(totalNumberOfInsuredCarLoanTransactionForLocalCar);
            summaryReportModel.setTotalLoanAmountOfInsuredCarLoanTransactionForLocalCar(totalLoanAmountOfInsuredCarLoanTransactionForLocalCar);

        } else {
            int totalNumberOfNotInsuredCarLoanTransactionForLocalCar = summaryReportModel.getTotalNumberOfNotInsuredCarLoanTransactionForLocalCar();
            double totalLoanAmountOfNotInsuredCarLoanTransactionForLocalCar = summaryReportModel.getTotalLoanAmountOfNotInsuredCarLoanTransactionForLocalCar();

            totalNumberOfNotInsuredCarLoanTransactionForLocalCar += 1;
            totalLoanAmountOfNotInsuredCarLoanTransactionForLocalCar += loanAmount;

            summaryReportModel.setTotalNumberOfNotInsuredCarLoanTransactionForLocalCar(totalNumberOfNotInsuredCarLoanTransactionForLocalCar);
            summaryReportModel.setTotalLoanAmountOfNotInsuredCarLoanTransactionForLocalCar(totalLoanAmountOfNotInsuredCarLoanTransactionForLocalCar);
        }

    }


}
