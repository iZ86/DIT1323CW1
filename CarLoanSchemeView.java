import javax.swing.*;
import java.awt.*;

/** This class represents the view for the car loan scheme. */
public class CarLoanSchemeView {

    /** The panel that contains all the components in car loan scheme view. */
    private final JPanel carLoanSchemeViewPanel;
    /** Button that changes the view back to the MainMenuView. */
    private final JButton backToMainMenuButton = new JButton("Back to Main Menu");
    /** Button that changes the view to the CalculateCarLoanInstallmentView. */
    private final JButton calculateCarLoanInstallmentButton = new JButton("Calculate Car Loan Installment");

    /** Constructor sets up the view for car loan scheme view.
     * Takes in data to be shown in the GUI via table.
     */
    public CarLoanSchemeView(Object[][] tableData, String[] columnNames) {
        this.carLoanSchemeViewPanel = setupCarLoanSchemeViewPanel(tableData, columnNames);
    }

    /** Returns the car loan scheme view panel. */
    public JPanel getCarLoanSchemeViewPanel() {
        return carLoanSchemeViewPanel;
    }

    /** Return a panel that has all the necessary components,
     * that composes the car loan scheme view.
     */
    private JPanel setupCarLoanSchemeViewPanel(Object[][] tableData, String[] columnNames) {

        // Initialization
        JPanel viewPanel = new JPanel(new GridBagLayout());

        // Setting up configuration for car loan scheme table pane.
        GridBagConstraints constraintsForCarLoanSchemeViewTable = new GridBagConstraints();
        constraintsForCarLoanSchemeViewTable.gridy = 0; // Position of component is first in Y order.


        // Setting up configuration for car loan scheme view buttons panel.
        // TODO: Asked if can reduce names for comments.
        GridBagConstraints constraintsForButtonsPanel = new GridBagConstraints();
        constraintsForButtonsPanel.gridy = 1; // Position of component is second in Y order.
        constraintsForButtonsPanel.insets = new Insets(50, 0, 0, 0); // Add gap above.


        // Add panels to the car loan scheme view panel with their configurations.
        viewPanel.add(setupCarLoanSchemeTablePane(tableData, columnNames),
                constraintsForCarLoanSchemeViewTable);
        viewPanel.add(setupCarLoanSchemeButtonsPanel(), constraintsForButtonsPanel);

        return viewPanel;
    }

    /** Returns a JScrollPane that contains the car loan scheme JTable object. */
    private JScrollPane setupCarLoanSchemeTablePane(Object[][] tableData, String[] columnNames) {

        // Initialization
        JTable carLoanSchemeTable = new JTable(new CarLoanSchemeTableModel(tableData, columnNames));

        // Configuring car loan scheme table.
        carLoanSchemeTable.setFocusable(false);
        carLoanSchemeTable.setRowSelectionAllowed(false); // Disable selecting rows of table.
        carLoanSchemeTable.setColumnSelectionAllowed(false); // Disable selecting columns of table.
        carLoanSchemeTable.setPreferredScrollableViewportSize(new Dimension(500, 96)); // Setting size of the table.

        // Return a new JScrollPane that contains the table.
        return new JScrollPane(carLoanSchemeTable);
    }

    /** Return a panel that contains the buttons needed for the car loan scheme view. */
    private JPanel setupCarLoanSchemeButtonsPanel() {

        // Initialization.
        JPanel carLoanSchemeButtonsPanel = new JPanel(new GridBagLayout());
        int horizontalSizeOfButton = 70;
        int verticalSizeOfButton = 10;
        int gapXBetweenButtons = 20;

        // Setting up configuration for back to main menu button.
        GridBagConstraints constraintsForBackToMainMenuButton = new GridBagConstraints();
        constraintsForBackToMainMenuButton.gridx = 0; // Position of button is first in X order.
        constraintsForBackToMainMenuButton.ipadx = horizontalSizeOfButton; // Horizontal size of button.
        constraintsForBackToMainMenuButton.ipady = verticalSizeOfButton; // Vertical size of button.
        constraintsForBackToMainMenuButton.insets = new Insets(0, 0, 0, gapXBetweenButtons); // Gap on the right side of button.

        // Setting up configuration for calculate car loan installment button.
        GridBagConstraints constraintsForCalculateCarLoanInstallmentButton = new GridBagConstraints();
        constraintsForCalculateCarLoanInstallmentButton.gridx = 1; // Position of button is second in X order.
        constraintsForCalculateCarLoanInstallmentButton.ipadx = horizontalSizeOfButton; // Horizontal size of button.
        constraintsForCalculateCarLoanInstallmentButton.fill = GridBagConstraints.VERTICAL; // Vertical size of button is the same as the second button in X order.

        // Add the buttons to the car loan scheme buttons panel with their configuration.
        carLoanSchemeButtonsPanel.add(backToMainMenuButton, constraintsForBackToMainMenuButton);
        carLoanSchemeButtonsPanel.add(calculateCarLoanInstallmentButton,
                constraintsForCalculateCarLoanInstallmentButton);

        // Return the panel.
        return carLoanSchemeButtonsPanel;
    }
}
