import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/** This class represents the view for the car loan scheme. */
public class CarLoanSchemeView {

    /** The car loan scheme view. */
    private final JPanel carLoanSchemeViewPanel;
    /** Button that changes the view back to the MainMenuView. */
    private final JButton backToMainMenuButton = new JButton("Back to Main Menu");
    /** Button that changes the view to the CalculateCarLoanInstallmentView. */
    private final JButton calculateCarLoanInstallmentButton = new JButton("Calculate Car Loan Installment");

    /** Constructor sets up the car loan scheme view.
     * Takes in data needed for table.
     */
    public CarLoanSchemeView() {
        this.carLoanSchemeViewPanel = setupCarLoanSchemeViewPanel();
    }

    /** Return JPanel carLoanSchemeViewPanel. */
    public JPanel getCarLoanSchemeViewPanel() {
        return carLoanSchemeViewPanel;
    }

    /** Add ActionListener listenForBackToMainMenuButton to JButton backToMainMenuButton. */
    public void addBackToMainMenuButtonListener(ActionListener listenForBackToMainMenuButton) {
        backToMainMenuButton.addActionListener(listenForBackToMainMenuButton);
    }

    /** Add ActionListener listenForCalculateCarLoanInstallmentButton JButton calculateCarLoanInstallmentButton. */
    public void addCalculateCarLoanInstallmentButtonListener(ActionListener listenForCalculateCarLoanInstallmentButton) {
        calculateCarLoanInstallmentButton.addActionListener(listenForCalculateCarLoanInstallmentButton);
    }

    /** Sets up a JScrollPane that will contain the table of the car loan scheme. */
    public void setCarLoanSchemeTable(Object[][] tableData, String[] columnNames) {
        // Initialization
        JScrollPane carLoanSchemeTablePane = setupCarLoanSchemeTablePane(tableData, columnNames); // Table containing car loan scheme.

        // Setting up configuration for JScrollPane carLoanSchemeTablePane.
        GridBagConstraints constraintsForCarLoanSchemeTablePane = new GridBagConstraints();
        constraintsForCarLoanSchemeTablePane.gridy = 0; // Position of component is first in Y order.


        carLoanSchemeViewPanel.add(carLoanSchemeTablePane, constraintsForCarLoanSchemeTablePane);
    }

    /** Return a JPanel that has all the necessary components,
     * that composes the car loan scheme view.
     */
    private JPanel setupCarLoanSchemeViewPanel() {

        // Initialization
        JPanel viewPanel = new JPanel(new GridBagLayout());
        JPanel buttonsPanel = setupCarLoanSchemeButtonsPanel(); // Buttons in JPanel carLoanSchemeViewPanel.

        // Setting up configuration for JPanel buttonsPanel.
        GridBagConstraints constraintsForButtonsPanel = new GridBagConstraints();
        constraintsForButtonsPanel.gridy = 1; // Position of component is second in Y order.
        constraintsForButtonsPanel.insets = new Insets(50, 0, 0, 0); // Add gap above.

        // Adding the components to JPanel viewPanel with their configurations.
        viewPanel.add(buttonsPanel, constraintsForButtonsPanel);

        return viewPanel;
    }

    /** Return a JScrollPane that contains JTable carLoanSchemeTable. */
    private JScrollPane setupCarLoanSchemeTablePane(Object[][] tableData, String[] columnNames) {

        // Initialization
        JTable carLoanSchemeTable = new JTable(new CarLoanTableModel(tableData, columnNames));

        // Configuring JTable carLoanSchemeTable.
        carLoanSchemeTable.setFocusable(false);
        carLoanSchemeTable.setRowSelectionAllowed(false); // Disable selecting rows of table.
        carLoanSchemeTable.setColumnSelectionAllowed(false); // Disable selecting columns of table.
        carLoanSchemeTable.setPreferredScrollableViewportSize(new Dimension(500, 96)); // Setting size of the table.

        // Return a new JScrollPane that contains JTable carLoanSchemeTable.
        return new JScrollPane(carLoanSchemeTable);
    }

    /** Return a JPanel that contains the JButtons needed for the car loan scheme view. */
    private JPanel setupCarLoanSchemeButtonsPanel() {

        // Initialization.
        JPanel carLoanSchemeButtonsPanel = new JPanel(new GridBagLayout());
        int horizontalSizeOfButton = 70;
        int verticalSizeOfButton = 10;
        int gapXBetweenButtons = 20;

        // Setting up configuration for JButton backToMainMenu.
        GridBagConstraints constraintsForBackToMainMenuButton = new GridBagConstraints();
        constraintsForBackToMainMenuButton.gridx = 0; // Position of button is first in X order.
        constraintsForBackToMainMenuButton.ipadx = horizontalSizeOfButton; // Horizontal size of button.
        constraintsForBackToMainMenuButton.ipady = verticalSizeOfButton; // Vertical size of button.
        constraintsForBackToMainMenuButton.insets = new Insets(0, 0, 0, gapXBetweenButtons); // Gap on the right side of button.

        // Setting up configuration for JButton calculateCarLoanInstallmentButton.
        GridBagConstraints constraintsForCalculateCarLoanInstallmentButton = new GridBagConstraints();
        constraintsForCalculateCarLoanInstallmentButton.gridx = 1; // Position of button is second in X order.
        constraintsForCalculateCarLoanInstallmentButton.ipadx = horizontalSizeOfButton; // Horizontal size of button.
        constraintsForCalculateCarLoanInstallmentButton.fill = GridBagConstraints.VERTICAL; // Vertical size of button is the same as the second button in X order.

        // Add the JButtons to JPanel carLoanSchemeButtonsPanel with their configuration.
        carLoanSchemeButtonsPanel.add(backToMainMenuButton, constraintsForBackToMainMenuButton);
        carLoanSchemeButtonsPanel.add(calculateCarLoanInstallmentButton,
                constraintsForCalculateCarLoanInstallmentButton);

        // Return the panel.
        return carLoanSchemeButtonsPanel;
    }
}
