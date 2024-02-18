import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoanInstallmentReportView {
    /** JPanel that contains all the component in LoanInstallmentReportView. */
    private JPanel loanInstallmentReportViewPanel = new JPanel(new GridBagLayout());
    /** Type of car loaned. */
    private String carType;
    /** Loan data. */
    private double loanTerm, loanAmount, interestRate , outstandingLoanAmount, monthlyRepayment;
    /** Loan insurance. */
    private String loanInsuranceStatus;
    /** Button that changes the view to the MainMenuView. */
    private JButton backToMainMenuButton = new JButton("Back to main menu");
    /** Button that changes the view to CarLoanInstallmentCalculatorView. */
    private JButton calculateCarLoanInstallmentButton = new JButton("Calculate new car loan installment");

    /** Constructor to set up the loanInstallmentReportViewPanel. */
    public LoanInstallmentReportView() {
        setupLoanInstallmentReportViewPanel();
    }

    /** Return JPanel loanInstallmentReportViewPanel. */
    public JPanel getLoanInstallmentReportViewPanel() {
        return loanInstallmentReportViewPanel;
    }

    /** Add ActionListener listenForBackToMainMenuButton to JButton backToMainMenuButton. */
    public void addBackToMainMenuButtonListener(ActionListener listenForBackToMainMenuButton) {
        backToMainMenuButton.addActionListener(listenForBackToMainMenuButton);
    }

    /** Adds an ActionListener to JButton calculateCarLoanInstallmentButton. */
    public void addCalculateCarLoanInstallmentButtonListener(ActionListener listenForCalculateCarLoanInstallmentButton) {
        calculateCarLoanInstallmentButton.addActionListener(listenForCalculateCarLoanInstallmentButton);
    }

    /** Update JPanel LoanInstallmentReportView. */
    public void updateLoanInstallmentReportView(String carType, double loanTerm, double loanAmount, double interestRate, double outstandingLoanAmount, double monthlyRepayment, String loanInsuranceStatus) {

        // Assigning new values.
        this.carType = carType;
        this.loanTerm = loanTerm;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.outstandingLoanAmount = outstandingLoanAmount;
        this.monthlyRepayment = monthlyRepayment;
        this.loanInsuranceStatus = loanInsuranceStatus;

        // Reset the view.
        resetView();

        // Updating the view.
        this.loanInstallmentReportViewPanel.revalidate();
        this.loanInstallmentReportViewPanel.repaint();
    }


    /** Set up JPanel loanInstallmentReportView. */
    private void setupLoanInstallmentReportViewPanel() {

        // Initialization.
        JPanel titlePanel = setupLoanInstallmentReportTitlePanel(); // Loan installment report title.
        JPanel showLoanDataPanel = setupShowLoanDataPanel(); // Loan data.
        JPanel buttonsPanel = setupLoanInstallmentReportButtonsPanel(); // Buttons in loan installment report view.

        // Setting up the configuration for JPanel titlePanel.
        GridBagConstraints constraintsForTitlePanel = new GridBagConstraints();
        constraintsForTitlePanel.gridy = 0; // Position of component is first in Y order.

        // Setting up the configuration for JPanel showLoanDataPanel.
        GridBagConstraints constraintsForShowLoanDataPanel = new GridBagConstraints();
        constraintsForShowLoanDataPanel.gridy = 1; // Position of component is second in Y order.
        constraintsForShowLoanDataPanel.insets = new Insets(30, 0, 70, 0); // Add gap below and above this component.

        // Setting up the configuration for JPanel buttonsPanel.
        GridBagConstraints constraintsForButtonsPanel = new GridBagConstraints();
        constraintsForButtonsPanel.gridy = 2; // Position of component is third in Y order.
        constraintsForButtonsPanel.insets = new Insets(100, 0, 0, 0); // Add gap above this component.

        // Add the JPanels to JPanel viewPanel with their configurations.
        loanInstallmentReportViewPanel.add(titlePanel, constraintsForTitlePanel);
        loanInstallmentReportViewPanel.add(showLoanDataPanel, constraintsForShowLoanDataPanel);
        loanInstallmentReportViewPanel.add(buttonsPanel, constraintsForButtonsPanel);
    }

    /** Resets JPanel loanInstallmentReportView. */
    private void resetView() {

        // Clears the view by removing all components.
        clearView();

        // Setup again.
        setupLoanInstallmentReportViewPanel();
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

    /** Returns a JPanel that contains all the data of the loan. */
    private JPanel setupShowLoanDataPanel() {
        // TODO: to update this. use a public method to update, and then .revalidate and .repaint.
        // TODO: Might need to put some stuff into array to reduce redundancy???

        // Initialization.
        JPanel showLoanDataPanel = new JPanel(new GridBagLayout());
        JLabel showCarType = new JLabel("Car Type: " + this.carType);
        JLabel showLoanTerm = new JLabel("Loan Term (Years): " + this.loanTerm);
        JLabel showLoanAmount = new JLabel("Loan Amount (RM): " + this.loanAmount);
        JLabel showInterestRate = new JLabel("Interest Rate (%): " + this.interestRate);
        JLabel showOutstandingLoanAmount = new JLabel("Total Outstanding Loan Amount (RM): " + this.outstandingLoanAmount);
        JLabel showMonthlyRepayment = new JLabel("Monthly Repayment (RM): " + this.monthlyRepayment);
        JLabel showLoanInstallmentInsurance = new JLabel("Loan Insurance Status: " + this.loanInsuranceStatus);

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
        showLoanDataPanel.add(showCarType,constraintsForShowCarType);
        showLoanDataPanel.add(showLoanTerm, constraintsForShowLoanTerm);
        showLoanDataPanel.add(showLoanAmount, constraintsForShowLoanAmount);
        showLoanDataPanel.add(showInterestRate, constraintsForShowInterestRate);
        showLoanDataPanel.add(showOutstandingLoanAmount, constraintsForShowOutstandingLoanAmount);
        showLoanDataPanel.add(showMonthlyRepayment, constraintsForShowMonthlyRepayment);
        showLoanDataPanel.add(showLoanInstallmentInsurance, constraintsForShowLoanInstallmentInsurance);

        return showLoanDataPanel;
    }

    /** Returns a JPanel that contains all the buttons in LoanInstallmentReportView. */
    private JPanel setupLoanInstallmentReportButtonsPanel() {

        // Initialization.
        JPanel loanInstallmentReportButtonsPanel = new JPanel(new GridBagLayout());
        int heightOfButton = 7;
        int gapXBetweenButtons = 10;

        // Setting up configuration for JButton backToMainMenuButton.
        GridBagConstraints constraintsForBackToMainMenuButton = new GridBagConstraints();
        constraintsForBackToMainMenuButton.gridx = 0; // Position of button is first in X order.
        constraintsForBackToMainMenuButton.ipady = heightOfButton; // Vertical height of button.
        constraintsForBackToMainMenuButton.insets = new Insets(0, 0, 0, gapXBetweenButtons); // Add gap on the right.

        //Setting up configuration for JButton calculateCarLoanInstallmentButton.
        GridBagConstraints constraintsForCalculateCarLoanInstallmentButton = new GridBagConstraints();
        constraintsForCalculateCarLoanInstallmentButton.gridx = 1; // Position of button is second in X order.
        constraintsForCalculateCarLoanInstallmentButton.fill = GridBagConstraints.VERTICAL; // Make vertical height of this button same as the first button of X order.

        // Add the JButtons to the JPanel loanInstallmentReportButtonsPanel with their configurations.
        loanInstallmentReportButtonsPanel.add(backToMainMenuButton, constraintsForBackToMainMenuButton);
        loanInstallmentReportButtonsPanel.add(calculateCarLoanInstallmentButton, constraintsForCalculateCarLoanInstallmentButton);

        // Return the JPanel.
        return loanInstallmentReportButtonsPanel;
    }

}
