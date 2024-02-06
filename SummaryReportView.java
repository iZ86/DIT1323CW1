import javax.swing.*;
import java.awt.*;

public class SummaryReportView {
    /** JPanel that contains all the component in SummaryReportView. */
    JPanel summaryReportViewPanel;
    /** Data of loan. */
    private String loanYears, loanAmount, outstandingLoanAmount, interestRate, monthlyRepayment, carType;
    private boolean loanInsurance;

    /** Constructor to set up the summaryReportViewPanel. */
    public SummaryReportView() {
        this.summaryReportViewPanel = setupSummaryReportViewPanel();
    }

    /** Return summaryReportViewPanel. */
    public JPanel getSummaryReportViewPanel() {
        return summaryReportViewPanel;
    }


    /** Return a JPanel that contains all the necessary components needed,
     * to set up SummaryReportView.
     */
    private JPanel setupSummaryReportViewPanel() {

        // Initialization.
        JPanel viewPanel = new JPanel(new GridBagLayout());

        // Setting up the configuration for summaryReportTitle.
        GridBagConstraints constraintsForSummaryReportTitle = new GridBagConstraints();
        constraintsForSummaryReportTitle.gridy = 0; // Position of component is first in Y order.

        // Setting up the configuration of the loanDataPanel.
        GridBagConstraints constraintsForShowLoanDataPanel = new GridBagConstraints();
        constraintsForShowLoanDataPanel.gridy = 1; // Position of component is second in Y order.

        // Setting up the configuration of SummaryReportButtonsPanel.
        GridBagConstraints constraintsForSummaryReportButtonsPanel = new GridBagConstraints();
        constraintsForSummaryReportButtonsPanel.gridy = 2; // Position of component is third in Y order.

        // Add necessary JPanels to the viewPanel with their configurations.
        viewPanel.add(setupSummaryReportTitle(), constraintsForSummaryReportTitle);
        viewPanel.add(setupShowLoanDataPanel(), constraintsForShowLoanDataPanel);
        viewPanel.add(setupSummaryReportButtonsPanel(), constraintsForSummaryReportButtonsPanel);


        return viewPanel;
    }

    /** Return a JPanel that contains the title of the SummaryReportView. */
    private JPanel setupSummaryReportTitle() {

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

        // Add the labels into the panel with their configurations.
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

        return summaryReportButtonsPanel;
    }
}
