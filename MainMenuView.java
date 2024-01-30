import javax.swing.*;

import java.awt.*;

/** This class represents the kawaguchi bank car loan main menu. */

public class MainMenuView {
    private JPanel mainMenuViewPanel;

    // TODO: Get thoughts on comments if needed or not. For example, is comment needed for constructor?
    public MainMenuView() {
        this.mainMenuViewPanel = setupMainMenuViewPanel();

    }

    /** Return the MainMenuViewPanel. */
    public JPanel getMainMenuViewPanel() {
        return mainMenuViewPanel;
    }

    /** Return a panel that has all the necessary components to make the main menu. */
    private JPanel setupMainMenuViewPanel() {

        // Initialization
        JPanel mainMenuViewPanel = new JPanel(new GridBagLayout());

        // Setting up properties for the main menu title panel.
        GridBagConstraints constraintsForMainMenuTitlePanel = new GridBagConstraints();
        constraintsForMainMenuTitlePanel.insets = new Insets(0, 0, 50, 0);
        mainMenuViewPanel.add(mainMenuTitlePanel(), constraintsForMainMenuTitlePanel);

        // Setting up properties for the main menu buttons panel.
        GridBagConstraints constraintsForMainMenuButtonsPanel = new GridBagConstraints();
        constraintsForMainMenuButtonsPanel.gridy = 1;
        mainMenuViewPanel.add(mainMenuButtonsPanel(), constraintsForMainMenuButtonsPanel);

        return mainMenuViewPanel;
    }

    /** Return a panel that contains the title for the main menu. */
    private JPanel mainMenuTitlePanel() {

        // Initialization
        JPanel mainMenuTitlePanel = new JPanel();
        JLabel mainMenuTitle = new JLabel("Kawaguchi Bank Car Loan Application");

        // Setting up properties for the main menu title.
        mainMenuTitle.setBorder(BorderFactory.createEmptyBorder(70, 0, 0, 0));
        mainMenuTitle.setVerticalAlignment(JLabel.VERTICAL);
        mainMenuTitle.setFont(new Font("Arial", Font.PLAIN, 18));

        mainMenuTitlePanel.add(mainMenuTitle);

        return mainMenuTitlePanel;
    }

    /** Return a panel that contains button needed for the main menu. */
    private JPanel mainMenuButtonsPanel() {

        // Initialization
        JPanel mainMenuButtonsPanel = new JPanel(new GridBagLayout());
        int horizontalSizeOfButton = 70;
        int horizontalSizeOfExitButton = (horizontalSizeOfButton * 3) / 2;
        int verticalSizeOfButton = 10;
        int gapYBetweenButtons = 20;

        // TODO: Maybe abstract the button properties.
        // Setting up properties for display car loan scheme button.
        GridBagConstraints constraintsForDisplayCarLoanSchemeButton = new GridBagConstraints();
        constraintsForDisplayCarLoanSchemeButton.gridy = 0;
        constraintsForDisplayCarLoanSchemeButton.ipady = verticalSizeOfButton;
        constraintsForDisplayCarLoanSchemeButton.fill = GridBagConstraints.HORIZONTAL;
        mainMenuButtonsPanel.add(createMainMenuButton("Display Car Loan Scheme"), constraintsForDisplayCarLoanSchemeButton);

        // Setting up properties for calculate car loan installment button.
        GridBagConstraints constraintsForCalculateCarLoanInstallmentButton = new GridBagConstraints();
        constraintsForCalculateCarLoanInstallmentButton.gridy = 1;
        constraintsForCalculateCarLoanInstallmentButton.ipadx = horizontalSizeOfButton;
        constraintsForCalculateCarLoanInstallmentButton.ipady = verticalSizeOfButton;
        constraintsForCalculateCarLoanInstallmentButton.insets = new Insets(gapYBetweenButtons, 0, gapYBetweenButtons, 0);
        mainMenuButtonsPanel.add(createMainMenuButton("Calculate Car Loan Installment"), constraintsForCalculateCarLoanInstallmentButton);

        // Setting up properties for generate summary report button.
        GridBagConstraints constraintsForGenerateSummaryReportButton = new GridBagConstraints();
        constraintsForGenerateSummaryReportButton.gridy = 2;
        constraintsForGenerateSummaryReportButton.ipady = verticalSizeOfButton;
        constraintsForGenerateSummaryReportButton.fill = GridBagConstraints.HORIZONTAL;
        mainMenuButtonsPanel.add(createMainMenuButton("Generate Summary Report"), constraintsForGenerateSummaryReportButton);

        // Setting up properties for exit button.
        GridBagConstraints constraintsForExitButton = new GridBagConstraints();
        constraintsForExitButton.gridy = 3;
        constraintsForExitButton.ipadx = horizontalSizeOfExitButton;
        constraintsForExitButton.ipady = verticalSizeOfButton;
        constraintsForExitButton.insets = new Insets(gapYBetweenButtons, 0, 0, 0);
        mainMenuButtonsPanel.add(createMainMenuButton("Exit"), constraintsForExitButton);

        return mainMenuButtonsPanel;
    }

    // May or may not be part of finished product
    private JButton createMainMenuButton(String name) {
        return new JButton(name);
    }
}
