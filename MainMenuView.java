import javax.swing.*;
import java.awt.*;

/** This class represents the kawaguchi bank car loan main menu. */
public class MainMenuView {

    /** The panel that contains all the components in the main menu view. */
    private final JPanel mainMenuViewPanel;

    /** Constructor is used to set up the main menu view. */
    public MainMenuView() {
        this.mainMenuViewPanel = setupMainMenuViewPanel();

    }

    /** Return the MainMenuViewPanel. */
    public JPanel getMainMenuViewPanel() {
        return mainMenuViewPanel;
    }

    /** Return a panel that has all the necessary components needed to make the main menu. */
    private JPanel setupMainMenuViewPanel() {

        // Initialization
        JPanel mainMenuViewPanel = new JPanel(new GridBagLayout());

        // Setting up configuration for the main menu title panel.
        GridBagConstraints constraintsForMainMenuTitlePanel = new GridBagConstraints();
        constraintsForMainMenuTitlePanel.gridy = 0; // Position of component is first in Y order.
        constraintsForMainMenuTitlePanel.insets = new Insets(0, 0, 50, 0); // Gap below the title.

        // Setting up configuration for the main menu buttons panel.
        GridBagConstraints constraintsForMainMenuButtonsPanel = new GridBagConstraints();
        constraintsForMainMenuButtonsPanel.gridy = 1; // Position of component is second in Y order.

        // Add the panels to the main menu view panel with their configurations.
        mainMenuViewPanel.add(setupMainMenuTitlePanel(), constraintsForMainMenuTitlePanel);
        mainMenuViewPanel.add(setupMainMenuButtonsPanel(), constraintsForMainMenuButtonsPanel);


        return mainMenuViewPanel;
    }

    /** Return a panel that contains the title for the main menu. */
    private JPanel setupMainMenuTitlePanel() {

        // Initialization
        JPanel mainMenuTitlePanel = new JPanel(new GridBagLayout());
        JLabel mainMenuTitle = new JLabel("Kawaguchi Bank Car Loan Application"); // Main menu title.

        // Configuring the main menu title.
        mainMenuTitle.setFont(new Font("Arial", Font.PLAIN, 18)); // Setting font and size.

        // Add the title label to the panel.
        mainMenuTitlePanel.add(mainMenuTitle);

        // Return the panel.
        return mainMenuTitlePanel;
    }

    /** Return a panel that contains the buttons needed for the main menu viwe. */
    private JPanel setupMainMenuButtonsPanel() {

        // Initialization
        JPanel mainMenuButtonsPanel = new JPanel(new GridBagLayout());
        JButton displayCarLoanSchemeButton = new JButton("Display Car Loan Scheme");
        JButton calculateCarLoanInstallmentButton = new JButton("Calculate Car Loan Installment");
        JButton generateSummaryReportButton = new JButton("Generate summary report");
        JButton exitButton = new JButton("Exit");
        int horizontalSizeOfButton = 70;
        int horizontalSizeOfExitButton = (horizontalSizeOfButton * 3) / 2;
        int verticalSizeOfButton = 10;
        int gapYBetweenButtons = 20;


        // Setting up configuration for display car loan scheme button.
        GridBagConstraints constraintsForDisplayCarLoanSchemeButton = new GridBagConstraints();
        constraintsForDisplayCarLoanSchemeButton.gridy = 0; // Position of button is first in Y order.
        constraintsForDisplayCarLoanSchemeButton.ipady = verticalSizeOfButton; // Vertical size of button.
        constraintsForDisplayCarLoanSchemeButton.fill = GridBagConstraints.HORIZONTAL; // Match the second button's horizontal size.

        // Setting up configuration for calculate car loan installment button.
        GridBagConstraints constraintsForCalculateCarLoanInstallmentButton = new GridBagConstraints();
        constraintsForCalculateCarLoanInstallmentButton.gridy = 1; // Position of button is second in Y order.
        constraintsForCalculateCarLoanInstallmentButton.ipadx = horizontalSizeOfButton; // Horizontal size of the button.
        constraintsForCalculateCarLoanInstallmentButton.ipady = verticalSizeOfButton; // Vertical size of button.
        constraintsForCalculateCarLoanInstallmentButton.insets = new Insets(gapYBetweenButtons, 0, gapYBetweenButtons, 0); // Gap above and below this button.

        // Setting up configuration for generate summary report button.
        GridBagConstraints constraintsForGenerateSummaryReportButton = new GridBagConstraints();
        constraintsForGenerateSummaryReportButton.gridy = 2; // Position of button is third in Y order.
        constraintsForGenerateSummaryReportButton.ipady = verticalSizeOfButton; // Vertical size of button.
        constraintsForGenerateSummaryReportButton.fill = GridBagConstraints.HORIZONTAL; // Match the second button's horizontal size.

        // Setting up configuration for exit button.
        GridBagConstraints constraintsForExitButton = new GridBagConstraints();
        constraintsForExitButton.gridy = 3; // Position of button is fourth in Y order.
        constraintsForExitButton.ipadx = horizontalSizeOfExitButton; // Horizontal size of the EXIT button.
        constraintsForExitButton.ipady = verticalSizeOfButton; // Vertical size of the button.
        constraintsForExitButton.insets = new Insets(gapYBetweenButtons, 0, 0, 0); // Gap above the button.

        // Add the buttons to the main menu buttons panel with their configurations.
        mainMenuButtonsPanel.add(displayCarLoanSchemeButton, constraintsForDisplayCarLoanSchemeButton);
        mainMenuButtonsPanel.add(calculateCarLoanInstallmentButton, constraintsForCalculateCarLoanInstallmentButton);
        mainMenuButtonsPanel.add(generateSummaryReportButton, constraintsForGenerateSummaryReportButton);
        mainMenuButtonsPanel.add(exitButton, constraintsForExitButton);

        // Return the main menu buttons panel.
        return mainMenuButtonsPanel;
    }
}
