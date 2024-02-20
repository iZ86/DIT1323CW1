import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/** This class represents the main menu view in the GUI. */
public class MainMenuView {
    /** The main menu view. */
    private final JPanel mainMenuViewPanel = new JPanel(new GridBagLayout());
    /** Button that changes the view to the car loan scheme view. */
    private final JButton displayCarLoanSchemeButton = new JButton("Display Car Loan Scheme");
    /** Button that changes the view to calculate car loan installment view. */
    private final JButton calculateCarLoanInstallmentButton = new JButton("Calculate Car Loan Installment");
    /** Button that changes the view to summary report view. */
    private final JButton generateSummaryReportButton = new JButton("Generate Summary Report");
    /** Button that exits out of the program. */
    private final JButton exitButton = new JButton("Exit");


    /** Constructor is used to set up the main menu view. */
    public MainMenuView() {
        setupMainMenuViewPanel();
    }

    /** Return JPanel mainMenuViewPanel. */
    public JPanel getMainMenuViewPanel() {
        return mainMenuViewPanel;
    }

    /** Adds an ActionListener to JButton displayCarLoanSchemeButton. */
    public void addDisplayCarLoanSchemeButtonListener(ActionListener listenForDisplayCarLoanSchemeButton) {
        displayCarLoanSchemeButton.addActionListener(listenForDisplayCarLoanSchemeButton);
    }

    /** Adds an ActionListener to JButton calculateCarLoanInstallmentButton. */
    public void addCalculateCarLoanInstallmentButtonListener(ActionListener listenForCalculateCarLoanInstallmentButton) {
        calculateCarLoanInstallmentButton.addActionListener(listenForCalculateCarLoanInstallmentButton);
    }

    /** Adds an ActionListener to JButton generateSummaryReportButton. */
    public void addGenerateSummaryReportButtonListener(ActionListener listenForGenerateSummaryReportButton) {
        generateSummaryReportButton.addActionListener(listenForGenerateSummaryReportButton);
    }

    /** Adds an ActionListener to JButton exitButton. */
    public void addExitButtonListener(ActionListener listenForExitButton) {
        exitButton.addActionListener(listenForExitButton);
    }

    /** Set up JPanel mainMenuView. */
    private void setupMainMenuViewPanel() {

        // Initialization
        JPanel titlePanel = setupMainMenuTitlePanel();
        JPanel buttonsPanel = setupMainMenuButtonsPanel();

        // Setting up configuration for JPanel titlePanel.
        GridBagConstraints constraintsForTitlePanel = new GridBagConstraints();
        constraintsForTitlePanel.gridy = 0; // Position is first in Y order.
        constraintsForTitlePanel.insets = new Insets(0, 0, 50, 0); // Add gap below.

        // Setting up configuration for JPanel buttonsPanel.
        GridBagConstraints constraintsForButtonsPanel = new GridBagConstraints();
        constraintsForButtonsPanel.gridy = 1; // Position is second in Y order.

        // Add the JPanels to JPanel mainMenuViewPanel with their configurations.
        mainMenuViewPanel.add(titlePanel, constraintsForTitlePanel);
        mainMenuViewPanel.add(buttonsPanel, constraintsForButtonsPanel);
    }

    /** Return a JPanel that contains the title for the main menu. */
    private JPanel setupMainMenuTitlePanel() {

        // Initialization
        JPanel mainMenuTitlePanel = new JPanel(new GridBagLayout());
        JLabel mainMenuTitle = new JLabel("Kawaguchi Bank Car Loan Application");

        // Configuring JLabel mainMenuTitle.
        mainMenuTitle.setFont(new Font("Arial", Font.PLAIN, 18)); // Setting font and size.

        // Add JLabel mainMenuTitle to JPanel mainMenuTitlePanel.
        mainMenuTitlePanel.add(mainMenuTitle);

        return mainMenuTitlePanel;
    }

    /** Return a JPanel that contains the JButtons needed for the main menu view. */
    private JPanel setupMainMenuButtonsPanel() {

        // Initialization
        JPanel mainMenuButtonsPanel = new JPanel(new GridBagLayout());
        int horizontalSizeOfButton = 70;
        int horizontalSizeOfExitButton = (horizontalSizeOfButton * 3) / 2;
        int verticalSizeOfButton = 10;
        int gapYBetweenButtons = 20;


        // Setting up configuration for JButton displayCarLoanSchemeButton.
        GridBagConstraints constraintsForDisplayCarLoanSchemeButton = new GridBagConstraints();
        constraintsForDisplayCarLoanSchemeButton.gridy = 0; // Position is first in Y order.
        constraintsForDisplayCarLoanSchemeButton.ipady = verticalSizeOfButton; // Vertical size.
        constraintsForDisplayCarLoanSchemeButton.fill = GridBagConstraints.HORIZONTAL; // Horizontal size is same as the second button in Y order.

        // Setting up configuration for JButton calculateCarLoanInstallmentButton.
        GridBagConstraints constraintsForCalculateCarLoanInstallmentButton = new GridBagConstraints();
        constraintsForCalculateCarLoanInstallmentButton.gridy = 1; // Position is second in Y order.
        constraintsForCalculateCarLoanInstallmentButton.ipadx = horizontalSizeOfButton; // Horizontal size.
        constraintsForCalculateCarLoanInstallmentButton.ipady = verticalSizeOfButton; // Vertical size of button.
        constraintsForCalculateCarLoanInstallmentButton.insets = new Insets(gapYBetweenButtons, 0, gapYBetweenButtons, 0); // Gap above and below.

        // Setting up configuration for JButton generateSummaryReportButton.
        GridBagConstraints constraintsForGenerateSummaryReportButton = new GridBagConstraints();
        constraintsForGenerateSummaryReportButton.gridy = 2; // Position is third in Y order.
        constraintsForGenerateSummaryReportButton.ipady = verticalSizeOfButton; // Vertical.
        constraintsForGenerateSummaryReportButton.fill = GridBagConstraints.HORIZONTAL; // Horizontal size is same as the second button in Y order.

        // Setting up configuration for JButton exitButton.
        GridBagConstraints constraintsForExitButton = new GridBagConstraints();
        constraintsForExitButton.gridy = 3; // Position is fourth in Y order.
        constraintsForExitButton.ipadx = horizontalSizeOfExitButton; // Horizontal size.
        constraintsForExitButton.ipady = verticalSizeOfButton; // Vertical size.
        constraintsForExitButton.insets = new Insets(gapYBetweenButtons, 0, 0, 0); // Add Gap above.

        // Add the JButtons to JPanel mainMenuButtonsPanel with their configurations.
        mainMenuButtonsPanel.add(displayCarLoanSchemeButton, constraintsForDisplayCarLoanSchemeButton);
        mainMenuButtonsPanel.add(calculateCarLoanInstallmentButton, constraintsForCalculateCarLoanInstallmentButton);
        mainMenuButtonsPanel.add(generateSummaryReportButton, constraintsForGenerateSummaryReportButton);
        mainMenuButtonsPanel.add(exitButton, constraintsForExitButton);

        return mainMenuButtonsPanel;
    }
}
