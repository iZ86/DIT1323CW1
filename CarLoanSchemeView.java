import javax.swing.*;
import java.awt.*;

/** This class represents the view for the car loan scheme. */
public class CarLoanSchemeView {
    private final JPanel carLoanSchemeViewPanel;

    /** Creates the view for car loan scheme view.
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
     * that is composed of the car loan scheme view.
     */
    private JPanel setupCarLoanSchemeViewPanel(Object[][] tableData, String[] columnNames) {

        // Initialization
        JPanel carLoanSchemeViewPanel = new JPanel(new GridBagLayout());

        //Setting up properties for car loan scheme table.
        GridBagConstraints constraintsForCarLoanSchemeViewTable = new GridBagConstraints();
        constraintsForCarLoanSchemeViewTable.gridy = 0; // Places the panel at the top.



        // Setting up the properties for the button panel.
        GridBagConstraints constraintsForButtonsPanel = new GridBagConstraints();
        constraintsForButtonsPanel.gridy = 1; // Places the panel below the first panel.
        constraintsForButtonsPanel.insets = new Insets(50, 0, 0, 0); // Add gap between the panel above.


        // Add panels to main Panel.
        carLoanSchemeViewPanel.add(setupCarLoanSchemeTable(tableData, columnNames),
                constraintsForCarLoanSchemeViewTable);
        carLoanSchemeViewPanel.add(carLoanSchemeButtonsPanel(), constraintsForButtonsPanel);

        return carLoanSchemeViewPanel;
    }

    /** Returns the car loan scheme table contained in a JScrollPane. */
    private JScrollPane setupCarLoanSchemeTable(Object[][] tableData, String[] columnNames) {

        // Table model created so that user cannot edit cells.
        JTable carLoanSchemeTable = new JTable(new CarLoanSchemeTableModel(tableData, columnNames));

        // Setting property of table so that it can't be selected.
        carLoanSchemeTable.setFocusable(false);
        carLoanSchemeTable.setRowSelectionAllowed(false);
        carLoanSchemeTable.setColumnSelectionAllowed(false);

        // Setting the table size.
        carLoanSchemeTable.setPreferredScrollableViewportSize(new Dimension(500, 96));

        return new JScrollPane(carLoanSchemeTable);
    }

    private JPanel carLoanSchemeButtonsPanel() {

        // Initialization.
        JPanel carLoanSchemeButtonsPanel = new JPanel(new GridBagLayout());
        JButton backToMainMenuButton = new JButton("Back to Main Menu");
        JButton calculateCarLoanInstallmentButton = new JButton("Calculate Car Loan Installment");
        int horizontalSizeOfButton = 70;
        int verticalSizeOfButton = 10;
        int gapXBetweenButtons = 20;

        // Setting up properties for Back to Main Menu Button.
        GridBagConstraints constraintsForBackToMainMenuButton = new GridBagConstraints();
        constraintsForBackToMainMenuButton.gridx = 0; // Place the button on the left side.
        constraintsForBackToMainMenuButton.ipadx = horizontalSizeOfButton; // Set the button horizontal size.
        constraintsForBackToMainMenuButton.ipady = verticalSizeOfButton; // Set the button vertical size.
        constraintsForBackToMainMenuButton.insets = new Insets(0, 0, 0, gapXBetweenButtons); // Add some space on the left side of the button.

        // Setting up properties for Calculate Car Loan Installment Button.
        GridBagConstraints constraintsForCalculateCarLoanInstallmentButton = new GridBagConstraints();
        constraintsForCalculateCarLoanInstallmentButton.gridx = 1; // Place the button on the right side.
        constraintsForCalculateCarLoanInstallmentButton.ipadx = horizontalSizeOfButton; // Set the button horizontal size.
        constraintsForCalculateCarLoanInstallmentButton.fill = GridBagConstraints.VERTICAL; // Set the button vertical size the same as the button on the left.

        // Add buttons to the panel.
        carLoanSchemeButtonsPanel.add(backToMainMenuButton, constraintsForBackToMainMenuButton);
        carLoanSchemeButtonsPanel.add(calculateCarLoanInstallmentButton,
                constraintsForCalculateCarLoanInstallmentButton);

        return carLoanSchemeButtonsPanel;
    }

    // Maybe temporary method to create buttons.
    private JButton createCarLoanSchemeButtonsPanel(String name) {
        return new JButton(name);
    }

}
