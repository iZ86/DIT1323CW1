import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/** This class represents the car loan scheme view in the GUI. */
public class CarLoanSchemeView {

    /** The car loan scheme view. */
    private final JPanel carLoanSchemeViewPanel = new JPanel(new GridBagLayout());
    /** Model for Car Loan Scheme View. */
    private final CarLoanSchemeModel carLoanSchemeModel;
    /** Button that changes the view back to the MainMenuView. */
    private final JButton backToMainMenuButton = new JButton("Back to Main Menu");
    /** Button that changes the view to the CalculateCarLoanInstallmentView. */
    private final JButton calculateCarLoanInstallmentButton = new JButton("Calculate Car Loan Installment");

    /** A new JPanel that represents the CarLoanSchemeView. */
    public CarLoanSchemeView(CarLoanSchemeModel carLoanSchemeModel) {
        this.carLoanSchemeModel = carLoanSchemeModel;
        setupCarLoanSchemeViewPanel();
    }

    /** Return JPanel carLoanSchemeViewPanel. */
    public JPanel getCarLoanSchemeViewPanel() {
        return carLoanSchemeViewPanel;
    }

    /** Update JPanel carLoanSchemeViewPanel. */
    public void updateView() {

        // Clear the view.
        clearView();

        // Set up JPanel carLoanSchemeViewPanel again.
        setupCarLoanSchemeViewPanel();

    }

    /** Add ActionListener listenForBackToMainMenuButton to JButton backToMainMenuButton. */
    public void addBackToMainMenuButtonListener(ActionListener listenForBackToMainMenuButton) {
        backToMainMenuButton.addActionListener(listenForBackToMainMenuButton);
    }

    /** Add ActionListener listenForCalculateCarLoanInstallmentButton JButton calculateCarLoanInstallmentButton. */
    public void addCalculateCarLoanInstallmentButtonListener(ActionListener listenForCalculateCarLoanInstallmentButton) {
        calculateCarLoanInstallmentButton.addActionListener(listenForCalculateCarLoanInstallmentButton);
    }

    /** Clear JPanel carLoanSchemeViewPanel by removing all components. */
    private void clearView() {
        carLoanSchemeViewPanel.removeAll();
    }

    /** Set up JPanel carLoanSchemeViewPanel. */
    private void setupCarLoanSchemeViewPanel() {

        // Initialization
        JPanel carLoanSchemeTablePanel = setupCarLoanSchemeTablePane();
        JPanel buttonsPanel = setupCarLoanSchemeButtonsPanel();

        // Setting up configuration for JPanel carLoanSchemeTablePanel.
        GridBagConstraints constraintsForCarLoanSchemeTablePanel = new GridBagConstraints();
        constraintsForCarLoanSchemeTablePanel.gridy = 0; // Position is first in Y order.

        // Setting up configuration for JPanel buttonsPanel.
        GridBagConstraints constraintsForButtonsPanel = new GridBagConstraints();
        constraintsForButtonsPanel.gridy = 1; // Position is second in Y order.
        constraintsForButtonsPanel.insets = new Insets(50, 0, 0, 0); // Add gap above.

        // Add the components to JPanel carLoanSchemeViewPanel with their configurations.
        carLoanSchemeViewPanel.add(carLoanSchemeTablePanel, constraintsForCarLoanSchemeTablePanel);
        carLoanSchemeViewPanel.add(buttonsPanel, constraintsForButtonsPanel);
    }

    /** Return a JScrollPane that contains the table of the car loan scheme data. */
    private JPanel setupCarLoanSchemeTablePane() {

        // Initialization
        JPanel carLoanSchemeTablePanel = new JPanel(new GridBagLayout());
        JTable carLoanSchemeTable = new JTable(new CarLoanTableModel(carLoanSchemeModel.getCarLoanTableData(),
                carLoanSchemeModel.getCarLoanTableDataColumn()));
        JScrollPane carLoanSchemeTablePane = new JScrollPane(carLoanSchemeTable);

        // Configuring JTable carLoanSchemeTable.
        carLoanSchemeTable.setFocusable(false);
        carLoanSchemeTable.setRowSelectionAllowed(false); // Disable selecting rows of table.
        carLoanSchemeTable.setColumnSelectionAllowed(false); // Disable selecting columns of table.
        carLoanSchemeTable.setPreferredScrollableViewportSize(new Dimension(500, 96)); // Setting size of the table.

        // Add JScrollPane carLoanSchemeTablePane to JPanel carLoanSchemeTablePanel.
        carLoanSchemeTablePanel.add(carLoanSchemeTablePane);

        // Return JPanel carLoanSchemeTablePanel.
        return carLoanSchemeTablePanel;
    }

    /** Return a JPanel that contains all the necessary buttons for CarLoanSchemeView. */
    private JPanel setupCarLoanSchemeButtonsPanel() {

        // Initialization.
        JPanel carLoanSchemeButtonsPanel = new JPanel(new GridBagLayout());
        int horizontalSizeOfButton = 70;
        int verticalSizeOfButton = 10;
        int gapXBetweenButtons = 20;

        // Setting up configuration for JButton backToMainMenu.
        GridBagConstraints constraintsForBackToMainMenuButton = new GridBagConstraints();
        constraintsForBackToMainMenuButton.gridx = 0; // Position is first in X order.
        constraintsForBackToMainMenuButton.ipadx = horizontalSizeOfButton; // Adjust horizontal size.
        constraintsForBackToMainMenuButton.ipady = verticalSizeOfButton; // Adjust vertical size.
        constraintsForBackToMainMenuButton.insets = new Insets(0, 0, 0, gapXBetweenButtons); // Add gap to the right.

        // Setting up configuration for JButton calculateCarLoanInstallmentButton.
        GridBagConstraints constraintsForCalculateCarLoanInstallmentButton = new GridBagConstraints();
        constraintsForCalculateCarLoanInstallmentButton.gridx = 1; // Position is second in X order.
        constraintsForCalculateCarLoanInstallmentButton.ipadx = horizontalSizeOfButton; // Adjust horizontal size.
        constraintsForCalculateCarLoanInstallmentButton.fill = GridBagConstraints.VERTICAL; // Vertical size of button is the same as the first button in X order.

        // Add the JButtons to JPanel carLoanSchemeButtonsPanel with their configurations.
        carLoanSchemeButtonsPanel.add(backToMainMenuButton, constraintsForBackToMainMenuButton);
        carLoanSchemeButtonsPanel.add(calculateCarLoanInstallmentButton,
                constraintsForCalculateCarLoanInstallmentButton);

        // Return the JPanel carLoanSchemeButtonsPanel.
        return carLoanSchemeButtonsPanel;
    }
}
