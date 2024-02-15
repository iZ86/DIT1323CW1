import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/** This class represents the kawaguchi bank car loan main menu. */
public class MainMenuView {

    /** The main menu view. */
    private final JPanel mainMenuViewPanel;
    /** Button that changes the view to the car loan scheme view. */
    private final JButton displayCarLoanSchemeButton = new JButton("Display Car Loan Scheme");
    /** Button that changes the view to calculate car loan installment view. */
    private final JButton calculateCarLoanInstallmentButton = new JButton("Calculate Car Loan Installment");
    /** Button that changes the view to summary report view. */
    private final JButton generateSummaryReportButton = new JButton("Generate summary report");
    /** Button that exits out of the program. */
    private final JButton exitButton = new JButton("Exit");


    /** Constructor is used to set up the main menu view. */
    public MainMenuView() {
        this.mainMenuViewPanel = setupMainMenuViewPanel();

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

    /** Adds an ActionListener to JButton exitButton. */
    public void addExitButtonListener(ActionListener listenForExitButton) {
        exitButton.addActionListener(listenForExitButton);
    }

    /** Return a JPanel that has all the necessary components needed to make the main menu view. */
    private JPanel setupMainMenuViewPanel() {

        // Initialization
        JPanel viewPanel = new JPanel(new GridBagLayout());
        JPanel titlePanel = setupMainMenuTitlePanel(); // Main menu title.
        JPanel buttonsPanel = setupMainMenuButtonsPanel(); // Buttons in main menu.

        // Setting up configuration for JPanel titlePanel.
        GridBagConstraints constraintsForTitlePanel = new GridBagConstraints();
        constraintsForTitlePanel.gridy = 0; // Position of component is first in Y order.
        constraintsForTitlePanel.insets = new Insets(0, 0, 50, 0); // Gap below the title.

        // Setting up configuration for JPanel buttonsPanel.
        GridBagConstraints constraintsForButtonsPanel = new GridBagConstraints();
        constraintsForButtonsPanel.gridy = 1; // Position of component is second in Y order.

        // Add the JPanels to JPanel viewPanel with their configurations.
        viewPanel.add(titlePanel, constraintsForTitlePanel);
        viewPanel.add(buttonsPanel, constraintsForButtonsPanel);

        // Returns the viewPanel.
        return viewPanel;
    }

    /** Return a JPanel that contains the title for the main menu. */
    private JPanel setupMainMenuTitlePanel() {

        // Initialization
        JPanel mainMenuTitlePanel = new JPanel(new GridBagLayout());
        JLabel mainMenuTitle = new JLabel("Kawaguchi Bank Car Loan Application"); // Main menu title.

        // Configuring JLabel mainMenuTitle.
        mainMenuTitle.setFont(new Font("Arial", Font.PLAIN, 18)); // Setting font and size.

        // Add JLabel mainMenuTitle to JPanel mainMenuTitlePanel.
        mainMenuTitlePanel.add(mainMenuTitle);

        // Return JPanel mainMenuTitlePanel.
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
        constraintsForDisplayCarLoanSchemeButton.gridy = 0; // Position of button is first in Y order.
        constraintsForDisplayCarLoanSchemeButton.ipady = verticalSizeOfButton; // Vertical size of button.
        constraintsForDisplayCarLoanSchemeButton.fill = GridBagConstraints.HORIZONTAL; // Match the second button's horizontal size.

        // Setting up configuration for JButton calculateCarLoanInstallmentButton.
        GridBagConstraints constraintsForCalculateCarLoanInstallmentButton = new GridBagConstraints();
        constraintsForCalculateCarLoanInstallmentButton.gridy = 1; // Position of button is second in Y order.
        constraintsForCalculateCarLoanInstallmentButton.ipadx = horizontalSizeOfButton; // Horizontal size of the button.
        constraintsForCalculateCarLoanInstallmentButton.ipady = verticalSizeOfButton; // Vertical size of button.
        constraintsForCalculateCarLoanInstallmentButton.insets = new Insets(gapYBetweenButtons, 0, gapYBetweenButtons, 0); // Gap above and below this button.

        // Setting up configuration for JButton generateSummaryReportButton.
        GridBagConstraints constraintsForGenerateSummaryReportButton = new GridBagConstraints();
        constraintsForGenerateSummaryReportButton.gridy = 2; // Position of button is third in Y order.
        constraintsForGenerateSummaryReportButton.ipady = verticalSizeOfButton; // Vertical size of button.
        constraintsForGenerateSummaryReportButton.fill = GridBagConstraints.HORIZONTAL; // Match the second button's horizontal size.

        // Setting up configuration for JButton exitButton.
        GridBagConstraints constraintsForExitButton = new GridBagConstraints();
        constraintsForExitButton.gridy = 3; // Position of button is fourth in Y order.
        constraintsForExitButton.ipadx = horizontalSizeOfExitButton; // Horizontal size of the EXIT button.
        constraintsForExitButton.ipady = verticalSizeOfButton; // Vertical size of the button.
        constraintsForExitButton.insets = new Insets(gapYBetweenButtons, 0, 0, 0); // Gap above the button.

        // Add the JButtons to JPanel mainMenuButtonsPanel with their configurations.
        mainMenuButtonsPanel.add(displayCarLoanSchemeButton, constraintsForDisplayCarLoanSchemeButton);
        mainMenuButtonsPanel.add(calculateCarLoanInstallmentButton, constraintsForCalculateCarLoanInstallmentButton);
        mainMenuButtonsPanel.add(generateSummaryReportButton, constraintsForGenerateSummaryReportButton);
        mainMenuButtonsPanel.add(exitButton, constraintsForExitButton);

        // Return JPanel mainMenuButtonsPanel.
        return mainMenuButtonsPanel;
    }
}
