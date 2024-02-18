import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class SummaryReportView {
    /** Summary Report View. */
    private JPanel summaryReportViewPanel = new JPanel(new GridBagLayout());
    /** Button that changes the view to the MainMenuView. */
    private JButton backToMainMenuButton = new JButton("Back to main menu");
    /** Summary Report Model. */
    private SummaryReportModel summaryReportModel;

    /** A new JPanel that represents the SummaryReportView. */
    public SummaryReportView(SummaryReportModel summaryReportModel) {
        this.summaryReportModel = summaryReportModel;
        setupSummaryReportView();
    }

    /** Return JPanel summaryReportViewPanel. */
    public JPanel getSummaryReportViewPanel() {
        return summaryReportViewPanel;
    }

    /** Add ActionListener listenForBackToMainMenuButton to JButton backToMainMenuButton. */
    public void addBackToMainMenuButtonListener(ActionListener listenForBackToMainMenuButton) {
        backToMainMenuButton.addActionListener(listenForBackToMainMenuButton);
    }

    /** Reset JPanel summaryReportViewPanel. */
    public void resetView() {

        // Clear the view by removing all components.
        clearView();

        // Setup again.
        setupSummaryReportView();
    }

    /** Clear view by removing every component in JPanel summaryReportViewPanel. */
    private void clearView() {
        summaryReportViewPanel.removeAll();
    }

    /** Sets up JPanel summaryReportViewPanel. */
    private void setupSummaryReportView() {

        // Initialization
        JPanel summaryReportViewTitlePanel = setupSummaryReportViewTitlePanel();
        JPanel importedCarLoanTransactionTablePanel = setupImportedCarLoanTransactionTablePanel();
        JPanel localCarLoanTransactionTablePanel = setupLocalCarLoanTransactionTablePanel();
        JPanel buttonsPanel = setupSummaryReportButtonsPanel();

        // Setting up configuration for JPanel summaryReportViewTitlePanel.
        GridBagConstraints constraintsForSummaryReportViewTitlePanel = new GridBagConstraints();
        constraintsForSummaryReportViewTitlePanel.gridy = 0; // Position is first in Y order.
        constraintsForSummaryReportViewTitlePanel.insets = new Insets(0, 0, 50, 0); // Add gap below.

        // Setting up configuration for JPanel importedCarLoanTransactionTablePanel.
        GridBagConstraints constraintsForImportedCarLoanTransactionTablePanel = new GridBagConstraints();
        constraintsForImportedCarLoanTransactionTablePanel.gridy = 1; // Position is second in Y order.
        constraintsForImportedCarLoanTransactionTablePanel.insets = new Insets(0, 0, 50, 0); // Add gap below.

        // Setting up configuration for JPanel localCarLoanTransactionTablePanel.
        GridBagConstraints constraintsForLocalCarLoanTransactionTablePanel = new GridBagConstraints();
        constraintsForLocalCarLoanTransactionTablePanel.gridy = 2; // Position is third in Y order.
        constraintsForLocalCarLoanTransactionTablePanel.insets = new Insets(0, 0, 30, 0); // Add gap below.

        // Setting up configuration for JPanel buttonsPanel.
        GridBagConstraints constraintsForButtonsPanel = new GridBagConstraints();
        constraintsForButtonsPanel.gridy = 3; // Position is fourth in Y order.

        // Add the components to JPanel summaryReportViewPanel with their configurations.
        summaryReportViewPanel.add(summaryReportViewTitlePanel, constraintsForSummaryReportViewTitlePanel);
        summaryReportViewPanel.add(importedCarLoanTransactionTablePanel, constraintsForImportedCarLoanTransactionTablePanel);
        summaryReportViewPanel.add(localCarLoanTransactionTablePanel, constraintsForLocalCarLoanTransactionTablePanel);
        summaryReportViewPanel.add(buttonsPanel, constraintsForButtonsPanel);
    }

    /** Return JPanel summaryReportViewTitlePanel, after setting it up. */
    private JPanel setupSummaryReportViewTitlePanel() {

        // Initialization.
        JPanel summaryReportViewTitlePanel = new JPanel(new GridBagLayout());
        JLabel summaryReportViewTitle = new JLabel("Summary Report View");

        // Configuring JLabel summaryReportView.
        summaryReportViewTitle.setFont(new Font("Arial", Font.BOLD, 18));

        // Add JLabel summaryReportView to JPanel summaryReportViewTitlePanel.
        summaryReportViewTitlePanel.add(summaryReportViewTitle);

        // Return JPanel summaryReportViewTitlePanel.
        return summaryReportViewTitlePanel;
    }

    /** Return JPanel importedCarLoanTransactionTablePanel, after setting it up. */
    private JPanel setupImportedCarLoanTransactionTablePanel() {

        return setupCarLoanTransactionTablePanel("Imported car", summaryReportModel.getTotalNumberOfCarLoanTransactionForImportedCar(),
                summaryReportModel.getTableDataForImportedCarLoanTransaction(),
                summaryReportModel.getTableColumnForCarLoanTransaction(),
                summaryReportModel.getTotalLoanAmountOfCarLoanTransactionForImportedCar());
    }

    /** Return JPanel localCarLoanTransactionTablePanel, after setting it up. */
    private JPanel setupLocalCarLoanTransactionTablePanel() {

        return setupCarLoanTransactionTablePanel("Local car", summaryReportModel.getTotalNumberOfCarLoanTransactionForLocalCar(),
                summaryReportModel.getTableDataForLocalCarLoanTransaction(),
                summaryReportModel.getTableColumnForCarLoanTransaction(),
                summaryReportModel.getTotalLoanAmountOfCarLoanTransactionForLocalCar());
    }

    /** Return JPanel carLoanTransactionTablePanel, after setting it up with the given data. */
    private JPanel setupCarLoanTransactionTablePanel(String carType,  int totalNumberOfCarLoanTransaction, Object[][] carLoanTransactionTableData, String[] carLoanTransactionTableColumn, int totalLoanAmountOfCarLoanTransaction) {

        // Initialization
        JPanel carLoanTransactionTablePanel = new JPanel(new GridBagLayout());
        JLabel _carLoanTransactionTableLabel = new JLabel(carType);
        JLabel totalNumberOfCarLoanTransactionLabel = new JLabel("Total Number of Car Loan Transaction: " + totalNumberOfCarLoanTransaction);
        JTable carLoanTransactionTable = new JTable(new CarLoanTableModel(carLoanTransactionTableData,
                carLoanTransactionTableColumn));
        JScrollPane carLoanTransactionTablePane = new JScrollPane(carLoanTransactionTable);
        JLabel totalLoanAmountOfCarLoanTransactionLabel = new JLabel("Total Loan Amount:" + totalLoanAmountOfCarLoanTransaction);

        // Setting up configuration for JLabel _carLoanTransactionTableLabel.
        GridBagConstraints constraintsForCarLoanTransactionTableLabel = new GridBagConstraints();
        constraintsForCarLoanTransactionTableLabel.gridy = 0; // Position is first in Y order.
        constraintsForCarLoanTransactionTableLabel.anchor = GridBagConstraints.LINE_START; // Placed at left side.

        // Setting up configuration for JLabel totalNumberOfCarLoanTransactionLabel.
        GridBagConstraints constraintsForTotalNumberOfCarLoanTransactionLabel = new GridBagConstraints();
        constraintsForTotalNumberOfCarLoanTransactionLabel.gridy = 1; // Position is second in Y order.
        constraintsForTotalNumberOfCarLoanTransactionLabel.anchor = GridBagConstraints.LINE_START; // Placed at left side.

        // Setting up configuration for JScrollPane carLoanTransactionTablePane.
        GridBagConstraints constraintsForCarLoanTransactionTablePane = new GridBagConstraints();
        constraintsForCarLoanTransactionTablePane.gridy = 2; // Position is third in Y order.

        // Setting up configuration for JLabel totalLoanAmountOfCarLoanTransactionLabel.
        GridBagConstraints constraintsForTotalLoanAmountOfCarLoanTransactionLabel = new GridBagConstraints();
        constraintsForTotalLoanAmountOfCarLoanTransactionLabel.gridy = 3; // Position is fourth in Y order.
        constraintsForTotalLoanAmountOfCarLoanTransactionLabel.anchor = GridBagConstraints.LINE_START;

        // Configuring JTable carLoanTransactionTable.
        configureCarLoanTransactionTable(carLoanTransactionTable);

        // Add the components to JPanel carLoanTransactionTablePanel with their configurations.
        carLoanTransactionTablePanel.add(_carLoanTransactionTableLabel, constraintsForCarLoanTransactionTableLabel);
        carLoanTransactionTablePanel.add(totalNumberOfCarLoanTransactionLabel, constraintsForTotalNumberOfCarLoanTransactionLabel);
        carLoanTransactionTablePanel.add(carLoanTransactionTablePane, constraintsForCarLoanTransactionTablePane);
        carLoanTransactionTablePanel.add(totalLoanAmountOfCarLoanTransactionLabel, constraintsForTotalLoanAmountOfCarLoanTransactionLabel);

        // Return JPanel carLoanTransactionTablePanel.
        return carLoanTransactionTablePanel;
    }

    /** Configures the JTable carLoanTransactionTable */
    private void configureCarLoanTransactionTable(JTable carLoanTransactionTable) {
        carLoanTransactionTable.setFocusable(false);
        carLoanTransactionTable.setRowSelectionAllowed(false); // Disable selecting rows of table.
        carLoanTransactionTable.setColumnSelectionAllowed(false); // Disable selecting columns of table.
        carLoanTransactionTable.setPreferredScrollableViewportSize(new Dimension(400, 32)); // Setting size of table.
    }

    /** Return JPanel buttonsPanel, after setting it up. */
    private JPanel setupSummaryReportButtonsPanel() {

        // Initialization.
        JPanel buttonsPanel = new JPanel(new GridBagLayout());
        int widthOfButton = 10;
        int heightOfButton = 7;


        // Configuration for JButton backToMainMenuButton.
        GridBagConstraints constraintsForBackToMainMenuButton = new GridBagConstraints();
        constraintsForBackToMainMenuButton.gridy = 0; // Position is first in Y order.
        constraintsForBackToMainMenuButton.ipadx = widthOfButton; // Adjust width.
        constraintsForBackToMainMenuButton.ipady = heightOfButton; // Adjust height.

        // Add JButton backToMainMenuButton to JPanel buttonsPanel with its configuration.
        buttonsPanel.add(backToMainMenuButton, constraintsForBackToMainMenuButton);

        // Return JPanel buttonsPanel.
        return buttonsPanel;
    }

}
