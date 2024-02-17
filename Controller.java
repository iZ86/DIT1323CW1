import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Logic between model and comments

public class Controller {
    GUI gui;
    CarLoanSchemeModel carLoanSchemeModel;
    CarLoanCalculationModel carLoanCalculationModel;

    /** Controller that bridges the gap between GUI and carLoanSchemeModel,
     * and GUI and carLoanCalculationModel.
     */
    public Controller(GUI gui, CarLoanSchemeModel carLoanSchemeModel, CarLoanCalculationModel carLoanCalculationModel) {
        this.gui = gui;
        this.carLoanSchemeModel = carLoanSchemeModel;
        this.carLoanCalculationModel = carLoanCalculationModel;
        this.gui.addAllDisplayCarLoanSchemeButtonListener(new DisplayCarLoanSchemeButtonListener());
        this.gui.addAllCalculateCarLoanInstallmentButtonListener(new CalculateCarLoanInstallmentButtonListener());
        this.gui.addAllExitButtonListener(new ExitButtonListener());
        this.gui.addAllBackToMainMenuButtonListener(new BackToMainMenuButtonListener());
        this.gui.addAllCalculateCarLoanInstallmentReportButtonListener(new CalculateCarLoanInstallmentReportButtonListener());
        setupCarLoanSchemeViewTable();
    }

    private void setupCarLoanSchemeViewTable() {
        String[] carLoanTableDataColumn = carLoanSchemeModel.getCarLoanTableDataColumn();
        String[][] carLoanTableData = carLoanSchemeModel.getCarLoanTableData();
        gui.getCarLoanSchemeView().setCarLoanSchemeTable(carLoanTableData, carLoanTableDataColumn);
    }

    public class DisplayCarLoanSchemeButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.changeView(GUI.carLoanSchemeViewIndex);
        }

    }

    public class CalculateCarLoanInstallmentButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.changeView(GUI.carLoanInstallmentCalculatorViewIndex);
        }
    }

    public class ExitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.exit();
        }
    }

    public class BackToMainMenuButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.changeView(GUI.mainMenuViewIndex);
        }
    }

    public class CalculateCarLoanInstallmentReportButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {

            // Initialization
            String carType;
            double loanTerm;
            double loanAmount;
            double interestRate;
            double outstandingLoanAmount;
            double monthlyRepayment;
            String loanInsuranceStatus;
            boolean loanInsurance;

            // Try-catch for validating loanTerm and loanAmount.
            try {
                // Get the values from CarLoanInstallmentCalculatorView.
                carType = gui.getCarLoanInstallmentCalculatorView().getSelectedCarType();
                loanTerm = gui.getCarLoanInstallmentCalculatorView().getLoanTerm();
                loanAmount = gui.getCarLoanInstallmentCalculatorView().getLoanAmount();
                loanInsurance = gui.getCarLoanInstallmentCalculatorView().getLoanInsuranceCheckBoxChecked();

                // If loanTerm or loanAmount is lesser than or equal to 0, error.
                if (loanTerm <= 0 || loanAmount <= 0) {
                    throw new NumberFormatException();
                }

                // Calculate the loan installment.
                carLoanCalculationModel.calculateLoan(carType, loanTerm, loanAmount, loanInsurance);

                // Get the results from carLoanCalculationModel.
                interestRate = carLoanCalculationModel.getInterestRate();
                outstandingLoanAmount = carLoanCalculationModel.getOutstandingLoanAmount();
                monthlyRepayment = carLoanCalculationModel.getMonthlyRepayment();
                loanInsuranceStatus = carLoanCalculationModel.getLoanInsuranceStatus();

                // Update LoanInstallmentReportView.
                gui.getLoanInstallmentReportView().updateLoanInstallmentReportView(carType, loanTerm,
                        loanAmount, interestRate, outstandingLoanAmount,
                        monthlyRepayment, loanInsuranceStatus);

                // Show LoanInstallmentReportView.
                gui.changeView(GUI.loanInstallmentReportViewIndex);


            } catch(NumberFormatException ex) {
                System.out.print("test error");
            }

        }
    }




}
