import javax.swing.*;
import java.awt.*;

/** This class represents the view for the car loan scheme. */
public class CarLoanSchemeView {
    // TODO: Implementation after implement the model.
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
        constraintsForCarLoanSchemeViewTable.gridy = 0;
        carLoanSchemeViewPanel.add(setupCarLoanSchemeTable(tableData, columnNames),
                constraintsForCarLoanSchemeViewTable);


        GridBagConstraints tempConstraitn = new GridBagConstraints();
        tempConstraitn.gridy = 1;
        carLoanSchemeViewPanel.add(carLoanSchemeButtonsPanel(), tempConstraitn);

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

        // One way to set the size
        carLoanSchemeTable.setPreferredScrollableViewportSize(new Dimension(500, 100));
        return new JScrollPane(carLoanSchemeTable);
    }

    private JPanel carLoanSchemeButtonsPanel() {
        // TODO: Buttons
        // Initialization.
        JPanel carLoanSchemeButtonsPanel = new JPanel(new GridBagLayout());
        JButton backToMainMenuButton = new JButton("Back to Main Menu");
        JButton calculateCarLoanInstallmentButton = new JButton("Calculate Car Loan Installment");

        // Setting up properties for Back to Main Menu Button.
        GridBagConstraints constraintsForBackToMainMenuButton = new GridBagConstraints();
        constraintsForBackToMainMenuButton.gridx = 0;

        // Setting up properties for Calculate Car Loan Installment Button.
        GridBagConstraints constraintsForCalculateCarLoanInstallmentButton = new GridBagConstraints();
        constraintsForCalculateCarLoanInstallmentButton.gridx = 1;

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
