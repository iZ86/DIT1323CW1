import javax.swing.*;
import java.awt.*;

public class SummaryReportView {
    /** JPanel that contains all the component in SummaryReportView. */
    JPanel summaryReportViewPanel;
    /** Data of loan. */
    private String loanYears, loanAmount, outstandingLoanAmount, interestRate, monthlyRepayment, carType;
    private boolean loanInsurance;
    /** Button that changes the view to the MainMenuView. */
    private JButton backToMainMenuButton = new JButton("Back to main menu");
    /** Button that changes the view to CarLoanInstallmentCalculatorView. */
    private JButton calculateCarLoanInstallmentButton = new JButton("Calculate new car loan installment");

    /** Constructor to set up the summaryReportViewPanel. */
    public SummaryReportView() {
        this.summaryReportViewPanel = setupSummaryReportViewPanel();
    }

    /** Return summaryReportViewPanel. */
    public JPanel getSummaryReportViewPanel() {
        return summaryReportViewPanel;
    }


    /** Updates the SummaryReportView. */
    public void updateSummaryReportView() {
    }
    /** Return a JPanel that contains all the necessary components needed,
     * to set up SummaryReportView.
     */
    private JPanel setupSummaryReportViewPanel() {

        // Initialization.
        JPanel viewPanel = new JPanel(new GridBagLayout());
        JPanel titlePanel = setupSummaryReportTitlePanel(); // Title of the view.
        JPanel showLoanDataPanel = setupShowLoanDataPanel(); // Loan data.
        JPanel buttonsPanel = setupSummaryReportButtonsPanel(); // Buttons in summary report view

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
        viewPanel.add(titlePanel, constraintsForTitlePanel);
        viewPanel.add(showLoanDataPanel, constraintsForShowLoanDataPanel);
        viewPanel.add(buttonsPanel, constraintsForButtonsPanel);

        // Return JPanel viewPanel.
        return viewPanel;
    }

    /** Return a JPanel that contains the title of the SummaryReportView. */
    private JPanel setupSummaryReportTitlePanel() {

        // Initialization.
        JPanel summaryReportTitlePanel = new JPanel(new GridBagLayout());
        JLabel summaryReportTitle = new JLabel("Summary Report Page");

        // Configuring summaryReportTitle.
        summaryReportTitle.setFont(new Font("Arial", Font.BOLD, 18));

        // Add JLabel summaryReportTitle to JPanel summaryReportTitlePanel.
        summaryReportTitlePanel.add(summaryReportTitle);

        return summaryReportTitlePanel;
    }

    /** Returns a JPanel that contains all the data of the loan. */
    private JPanel setupShowLoanDataPanel() {
        // TODO: to update this. use a public method to update, and then .revalidate and .repaint.
        // TODO: Might need to put some stuff into array to reduce redundancy???

        // Initialization.
        JPanel showLoanDataPanel = new JPanel(new GridBagLayout());
        JLabel showCarType = new JLabel("Car Type: " + this.carType);
        JLabel showLoanAmount = new JLabel("Loan Amount (RM): " + this.loanAmount);
        JLabel showInterestRate = new JLabel("Interest Rate (%): " + this.interestRate);
        JLabel showLoanTerm = new JLabel("Loan Term (Years): " + this.loanYears);
        JLabel showOutstandingLoanAmount = new JLabel("Total Payback (RM): " + this.outstandingLoanAmount);
        JLabel showMonthlyRepayment = new JLabel("Monthly Repayment (RM): " + this.monthlyRepayment);

        // Setting up configuration for JLabel showCarType.
        GridBagConstraints constraintsForShowCarType = new GridBagConstraints();
        constraintsForShowCarType.gridy = 0; // Position of this JLabel is first in Y order.

        // Setting up configuration for JLabel showLoanAmount.
        GridBagConstraints constraintsForShowLoanAmount = new GridBagConstraints();
        constraintsForShowLoanAmount.gridy = 1; // Position of this JLabel is second in Y order.

        // Setting up configuration for JLabel showInterestRate.
        GridBagConstraints constraintsForShowInterestRate = new GridBagConstraints();
        constraintsForShowInterestRate.gridy = 2; // Position of this JLabel is third in Y order.

        // Setting up configuration for JLabel showLoanTerm.
        GridBagConstraints constraintsForShowLoanTerm = new GridBagConstraints();
        constraintsForShowLoanTerm.gridy = 3; // Position of this JLabel is fourth in Y order.

        // Setting up configuration for JLabel showOutstandingLoanAmount.
        GridBagConstraints constraintsForShowOutstandingLoanAmount = new GridBagConstraints();
        constraintsForShowOutstandingLoanAmount.gridy = 4; // Position of this JLabel is fifth in Y order.

        // Setting up configuration for JLabel showMonthlyRepayment.
        GridBagConstraints constraintsForShowMonthlyRepayment = new GridBagConstraints();
        constraintsForShowMonthlyRepayment.gridy = 5; // Position of this JLabel is sixth in Y order.

        // Add the JLabels into the JPanel with their configurations.
        showLoanDataPanel.add(showCarType,constraintsForShowCarType);
        showLoanDataPanel.add(showLoanAmount, constraintsForShowLoanAmount);
        showLoanDataPanel.add(showInterestRate, constraintsForShowInterestRate);
        showLoanDataPanel.add(showLoanTerm, constraintsForShowLoanTerm);
        showLoanDataPanel.add(showOutstandingLoanAmount, constraintsForShowOutstandingLoanAmount);
        showLoanDataPanel.add(showMonthlyRepayment, constraintsForShowMonthlyRepayment);

        return showLoanDataPanel;
    }

    /** Returns a JPanel that contains all the buttons in SummaryReportView. */
    private JPanel setupSummaryReportButtonsPanel() {

        // Initialization.
        JPanel summaryReportButtonsPanel = new JPanel(new GridBagLayout());
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

        // Add the JButtons to the JPanel summaryReportButtonsPanel with their configurations.
        summaryReportButtonsPanel.add(backToMainMenuButton, constraintsForBackToMainMenuButton);
        summaryReportButtonsPanel.add(calculateCarLoanInstallmentButton, constraintsForCalculateCarLoanInstallmentButton);

        // Return the JPanel.
        return summaryReportButtonsPanel;
    }
}
