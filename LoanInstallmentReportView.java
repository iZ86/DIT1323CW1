import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoanInstallmentReportView {
    /** JPanel that contains all the component in LoanInstallmentReportView. */
    private final JPanel loanInstallmentReportViewPanel = new JPanel(new GridBagLayout());
    /** Model for LoanInstallReportView. */
    private final CarLoanCalculationModel carLoanCalculationModel;
    /** Button that changes the view to the MainMenuView. */
    private final JButton backToMainMenuButton = new JButton("Back to main menu");
    /** Button that changes the view to CarLoanInstallmentCalculatorView. */
    private final JButton calculateCarLoanInstallmentButton = new JButton("Calculate new car loan installment");

    /** Constructor to set up the loanInstallmentReportViewPanel. */
    public LoanInstallmentReportView(CarLoanCalculationModel carLoanCalculationModel) {
        this.carLoanCalculationModel = carLoanCalculationModel;
        setupLoanInstallmentReportViewPanel();
    }

    /** Return JPanel loanInstallmentReportViewPanel. */
    public JPanel getLoanInstallmentReportViewPanel() {
        return loanInstallmentReportViewPanel;
    }

    /** Update JPanel loanInstallmentReportViewPanel. */
    public void updateView() {

        // Clears the view by removing all components.
        clearView();

        // Set up JPanel loanInstallmentReportViewPanel again.
        setupLoanInstallmentReportViewPanel();
    }

    /** Add ActionListener listenForBackToMainMenuButton to JButton backToMainMenuButton. */
    public void addBackToMainMenuButtonListener(ActionListener listenForBackToMainMenuButton) {
        backToMainMenuButton.addActionListener(listenForBackToMainMenuButton);
    }

    /** Adds an ActionListener to JButton calculateCarLoanInstallmentButton. */
    public void addCalculateCarLoanInstallmentButtonListener(ActionListener listenForCalculateCarLoanInstallmentButton) {
        calculateCarLoanInstallmentButton.addActionListener(listenForCalculateCarLoanInstallmentButton);
    }


    /** Set up JPanel loanInstallmentReportView. */
    private void setupLoanInstallmentReportViewPanel() {

        // Initialization.
        JPanel titlePanel = setupLoanInstallmentReportTitlePanel(); // Loan installment report title.
        JPanel showLoanDataPanel = setupShowLoanDataPanel(); // Loan data.
        JPanel buttonsPanel = setupLoanInstallmentReportButtonsPanel(); // Buttons in loan installment report view.

        // Setting up the configuration for JPanel titlePanel.
        GridBagConstraints constraintsForTitlePanel = new GridBagConstraints();
        constraintsForTitlePanel.gridy = 0; // Position is first in Y order.

        // Setting up the configuration for JPanel showLoanDataPanel.
        GridBagConstraints constraintsForShowLoanDataPanel = new GridBagConstraints();
        constraintsForShowLoanDataPanel.gridy = 1; // Position is second in Y order.
        constraintsForShowLoanDataPanel.insets = new Insets(30, 0, 70, 0); // Add gap below and above this component.

        // Setting up the configuration for JPanel buttonsPanel.
        GridBagConstraints constraintsForButtonsPanel = new GridBagConstraints();
        constraintsForButtonsPanel.gridy = 2; // Position is third in Y order.
        constraintsForButtonsPanel.insets = new Insets(100, 0, 0, 0); // Add gap above this component.

        // Add the JPanels to JPanel viewPanel with their configurations.
        loanInstallmentReportViewPanel.add(titlePanel, constraintsForTitlePanel);
        loanInstallmentReportViewPanel.add(showLoanDataPanel, constraintsForShowLoanDataPanel);
        loanInstallmentReportViewPanel.add(buttonsPanel, constraintsForButtonsPanel);
    }

    /** Clear view by removing every component in JPanel loanInstallmentReportView. */
    private void clearView() {
        loanInstallmentReportViewPanel.removeAll();
    }

    /** Return a JPanel that contains the title of the LoanInstallmentReportView. */
    private JPanel setupLoanInstallmentReportTitlePanel() {

        // Initialization.
        JPanel loanInstallmentReportTitlePanel = new JPanel(new GridBagLayout());
        JLabel loanInstallmentReportTitle = new JLabel("Loan Installment Report Page");

        // Configuring loanInstallmentReportTitle.
        loanInstallmentReportTitle.setFont(new Font("Arial", Font.BOLD, 18));

        // Add JLabel loanInstallmentReportTitle to JPanel loanInstallmentReportTitlePanel.
        loanInstallmentReportTitlePanel.add(loanInstallmentReportTitle);

        return loanInstallmentReportTitlePanel;
    }

    /** Return a JPanel that presents all the data of the loan. */
    private JPanel setupShowLoanDataPanel() {

        // Initialization.
        JPanel showLoanDataPanel = new JPanel(new GridBagLayout());
        JLabel showCarType = new JLabel("Car Type: " + carLoanCalculationModel.getCarType());
        JLabel showLoanTerm = new JLabel("Loan Term (Years): " + carLoanCalculationModel.getLoanTerm());
        JLabel showLoanAmount = new JLabel("Loan Amount (RM): " + carLoanCalculationModel.getLoanAmount());
        JLabel showInterestRate = new JLabel("Interest Rate (%): " + carLoanCalculationModel.getInterestRatePercentage());
        JLabel showOutstandingLoanAmount = new JLabel("Total Outstanding Loan Amount (RM): " + carLoanCalculationModel.getOutstandingLoanAmount());
        JLabel showMonthlyRepayment = new JLabel("Monthly Repayment (RM): " + carLoanCalculationModel.getMonthlyRepayment());
        JLabel showLoanInstallmentInsurance = new JLabel("Loan Insurance Status: " + carLoanCalculationModel.getLoanInsuranceStatus());

        // Setting up configuration for JLabel showCarType.
        GridBagConstraints constraintsForShowCarType = new GridBagConstraints();
        constraintsForShowCarType.gridy = 0; // Position is first in Y order.

        // Setting up configuration for JLabel showLoanTerm.
        GridBagConstraints constraintsForShowLoanTerm = new GridBagConstraints();
        constraintsForShowLoanTerm.gridy = 1; // Position is second in Y order.

        // Setting up configuration for JLabel showLoanAmount.
        GridBagConstraints constraintsForShowLoanAmount = new GridBagConstraints();
        constraintsForShowLoanAmount.gridy = 2; // Position is third in Y order.

        // Setting up configuration for JLabel showInterestRate.
        GridBagConstraints constraintsForShowInterestRate = new GridBagConstraints();
        constraintsForShowInterestRate.gridy = 3; // Position is fourth in Y order.

        // Setting up configuration for JLabel showOutstandingLoanAmount.
        GridBagConstraints constraintsForShowOutstandingLoanAmount = new GridBagConstraints();
        constraintsForShowOutstandingLoanAmount.gridy = 4; // Position is fifth in Y order.

        // Setting up configuration for JLabel showMonthlyRepayment.
        GridBagConstraints constraintsForShowMonthlyRepayment = new GridBagConstraints();
        constraintsForShowMonthlyRepayment.gridy = 5; // Position is sixth in Y order.

        // Setting up configuration for JLabel showLoanInstallmentInsurance.
        GridBagConstraints constraintsForShowLoanInstallmentInsurance = new GridBagConstraints();
        constraintsForShowLoanInstallmentInsurance.gridy = 6; // Position is seventh in Y order.

        // Add the JLabels into the JPanel with their configurations.
        showLoanDataPanel.add(showCarType, constraintsForShowCarType);
        showLoanDataPanel.add(showLoanTerm, constraintsForShowLoanTerm);
        showLoanDataPanel.add(showLoanAmount, constraintsForShowLoanAmount);
        showLoanDataPanel.add(showInterestRate, constraintsForShowInterestRate);
        showLoanDataPanel.add(showOutstandingLoanAmount, constraintsForShowOutstandingLoanAmount);
        showLoanDataPanel.add(showMonthlyRepayment, constraintsForShowMonthlyRepayment);
        showLoanDataPanel.add(showLoanInstallmentInsurance, constraintsForShowLoanInstallmentInsurance);

        return showLoanDataPanel;
    }

    /** Return a JPanel that contains all the buttons in LoanInstallmentReportView. */
    private JPanel setupLoanInstallmentReportButtonsPanel() {

        // Initialization.
        JPanel loanInstallmentReportButtonsPanel = new JPanel(new GridBagLayout());
        int verticalSizeOfButton = 7;
        int gapXBetweenButtons = 10;

        // Setting up configuration for JButton backToMainMenuButton.
        GridBagConstraints constraintsForBackToMainMenuButton = new GridBagConstraints();
        constraintsForBackToMainMenuButton.gridx = 0; // Position is first in X order.
        constraintsForBackToMainMenuButton.ipady = verticalSizeOfButton; // Vertical size.
        constraintsForBackToMainMenuButton.insets = new Insets(0, 0, 0, gapXBetweenButtons); // Add gap on the right.

        //Setting up configuration for JButton calculateCarLoanInstallmentButton.
        GridBagConstraints constraintsForCalculateCarLoanInstallmentButton = new GridBagConstraints();
        constraintsForCalculateCarLoanInstallmentButton.gridx = 1; // Position is second in X order.
        constraintsForCalculateCarLoanInstallmentButton.fill = GridBagConstraints.VERTICAL; // Make vertical size of this button same as the first button of X order.

        // Add the JButtons to the JPanel loanInstallmentReportButtonsPanel with their configurations.
        loanInstallmentReportButtonsPanel.add(backToMainMenuButton, constraintsForBackToMainMenuButton);
        loanInstallmentReportButtonsPanel.add(calculateCarLoanInstallmentButton,
                constraintsForCalculateCarLoanInstallmentButton);

        return loanInstallmentReportButtonsPanel;
    }

}
