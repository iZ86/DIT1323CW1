import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/** This class represents the summary report view in the GUI. */
public class SummaryReportView {
    /** Summary Report View. */
    private final JPanel summaryReportViewPanel = new JPanel(new GridBagLayout());
    /** Model for Summary Report View. */
    private final SummaryReportModel summaryReportModel;
    /** Button that changes the view to the MainMenuView. */
    private final JButton backToMainMenuButton = new JButton("Back to main menu");


    /** A new JPanel that represents the SummaryReportView. */
    public SummaryReportView(SummaryReportModel summaryReportModel) {
        this.summaryReportModel = summaryReportModel;
        setupSummaryReportView();
    }

    /** Return JPanel summaryReportViewPanel. */
    public JPanel getSummaryReportViewPanel() {
        return summaryReportViewPanel;
    }

    /** update JPanel summaryReportViewPanel. */
    public void updateView() {

        // Clear the view by removing all components.
        clearView();

        // Set up JPanel summaryReportViewPanel again.
        setupSummaryReportView();
    }

    /** Add ActionListener listenForBackToMainMenuButton to JButton backToMainMenuButton. */
    public void addBackToMainMenuButtonListener(ActionListener listenForBackToMainMenuButton) {
        backToMainMenuButton.addActionListener(listenForBackToMainMenuButton);
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
        summaryReportViewPanel.add(importedCarLoanTransactionTablePanel,
                constraintsForImportedCarLoanTransactionTablePanel);
        summaryReportViewPanel.add(localCarLoanTransactionTablePanel, constraintsForLocalCarLoanTransactionTablePanel);
        summaryReportViewPanel.add(buttonsPanel, constraintsForButtonsPanel);
    }

    /** Return a JPanel that contains the title for SummaryReportView. */
    private JPanel setupSummaryReportViewTitlePanel() {

        // Initialization.
        JPanel summaryReportViewTitlePanel = new JPanel(new GridBagLayout());
        JLabel summaryReportViewTitle = new JLabel("Summary Report View");

        // Configuring JLabel summaryReportView.
        summaryReportViewTitle.setFont(new Font("Arial", Font.BOLD, 18));

        // Add JLabel summaryReportView to JPanel summaryReportViewTitlePanel.
        summaryReportViewTitlePanel.add(summaryReportViewTitle);

        return summaryReportViewTitlePanel;
    }

    /** Return a JPanel that contains a table of imported car loan transactions data. */
    private JPanel setupImportedCarLoanTransactionTablePanel() {

        return setupCarLoanTransactionTablePanel("Imported car",
                summaryReportModel.getTotalNumberOfCarLoanTransactionForImportedCar(),
                summaryReportModel.getTableDataForImportedCarLoanTransaction(),
                summaryReportModel.getTableColumnForCarLoanTransaction(),
                summaryReportModel.getTotalLoanAmountOfCarLoanTransactionForImportedCar());
    }

    /** Return a JPanel that contains a table of local car loan transactions data. */
    private JPanel setupLocalCarLoanTransactionTablePanel() {

        return setupCarLoanTransactionTablePanel("Local car",
                summaryReportModel.getTotalNumberOfCarLoanTransactionForLocalCar(),
                summaryReportModel.getTableDataForLocalCarLoanTransaction(),
                summaryReportModel.getTableColumnForCarLoanTransaction(),
                summaryReportModel.getTotalLoanAmountOfCarLoanTransactionForLocalCar());
    }

    /** Return a JPanel that contains a table of the given data. */
    private JPanel setupCarLoanTransactionTablePanel(String carType,  int totalNumberOfCarLoanTransaction, Object[][] carLoanTransactionTableData, String[] carLoanTransactionTableColumn, double totalLoanAmountOfCarLoanTransaction) {

        // Initialization
        JPanel carLoanTransactionTablePanel = new JPanel(new GridBagLayout());
        JLabel _carLoanTransactionTableLabel = new JLabel(carType);
        JLabel totalNumberOfCarLoanTransactionLabel = new JLabel("Total Number of Car Loan Transaction: " + totalNumberOfCarLoanTransaction);
        JTable carLoanTransactionTable = new JTable(new CarLoanTableModel(carLoanTransactionTableData,
                carLoanTransactionTableColumn));
        JScrollPane carLoanTransactionTablePane = new JScrollPane(carLoanTransactionTable);
        JLabel totalLoanAmountOfCarLoanTransactionLabel = new JLabel("Total Loan Amount (RM): " + totalLoanAmountOfCarLoanTransaction);

        // Setting up configuration for JLabel _carLoanTransactionTableLabel.
        GridBagConstraints constraintsForCarLoanTransactionTableLabel = new GridBagConstraints();
        constraintsForCarLoanTransactionTableLabel.gridy = 0; // Position is first in Y order.
        constraintsForCarLoanTransactionTableLabel.anchor = GridBagConstraints.LINE_START; // Align to left.

        // Setting up configuration for JLabel totalNumberOfCarLoanTransactionLabel.
        GridBagConstraints constraintsForTotalNumberOfCarLoanTransactionLabel = new GridBagConstraints();
        constraintsForTotalNumberOfCarLoanTransactionLabel.gridy = 1; // Position is second in Y order.
        constraintsForTotalNumberOfCarLoanTransactionLabel.anchor = GridBagConstraints.LINE_START; // Align to left.

        // Setting up configuration for JScrollPane carLoanTransactionTablePane.
        GridBagConstraints constraintsForCarLoanTransactionTablePane = new GridBagConstraints();
        constraintsForCarLoanTransactionTablePane.gridy = 2; // Position is third in Y order.

        // Setting up configuration for JLabel totalLoanAmountOfCarLoanTransactionLabel.
        GridBagConstraints constraintsForTotalLoanAmountOfCarLoanTransactionLabel = new GridBagConstraints();
        constraintsForTotalLoanAmountOfCarLoanTransactionLabel.gridy = 3; // Position is fourth in Y order.
        constraintsForTotalLoanAmountOfCarLoanTransactionLabel.anchor = GridBagConstraints.LINE_START; // Align to left.

        // Configuring JTable carLoanTransactionTable.
        configureCarLoanTransactionTable(carLoanTransactionTable);

        // Add the components to JPanel carLoanTransactionTablePanel with their configurations.
        carLoanTransactionTablePanel.add(_carLoanTransactionTableLabel, constraintsForCarLoanTransactionTableLabel);
        carLoanTransactionTablePanel.add(totalNumberOfCarLoanTransactionLabel,
                constraintsForTotalNumberOfCarLoanTransactionLabel);
        carLoanTransactionTablePanel.add(carLoanTransactionTablePane, constraintsForCarLoanTransactionTablePane);
        carLoanTransactionTablePanel.add(totalLoanAmountOfCarLoanTransactionLabel,
                constraintsForTotalLoanAmountOfCarLoanTransactionLabel);

        return carLoanTransactionTablePanel;
    }

    /** Configures the JTable carLoanTransactionTable */
    private void configureCarLoanTransactionTable(JTable carLoanTransactionTable) {
        carLoanTransactionTable.setFocusable(false);
        carLoanTransactionTable.setRowSelectionAllowed(false); // Disable selecting rows of table.
        carLoanTransactionTable.setColumnSelectionAllowed(false); // Disable selecting columns of table.
        carLoanTransactionTable.setPreferredScrollableViewportSize(new Dimension(400, 32)); // Setting size of table.
    }

    /** Return a JPanel that contains all the buttons needed for SummaryReportView. */
    private JPanel setupSummaryReportButtonsPanel() {

        // Initialization.
        JPanel summaryReportButtonsPanel = new JPanel(new GridBagLayout());
        int horizontalSizeOfButton = 10;
        int verticalSizeOfButton = 7;

        // Configuration for JButton backToMainMenuButton.
        GridBagConstraints constraintsForBackToMainMenuButton = new GridBagConstraints();
        constraintsForBackToMainMenuButton.gridy = 0; // Position is first in Y order.
        constraintsForBackToMainMenuButton.ipadx = horizontalSizeOfButton; // Horizontal size.
        constraintsForBackToMainMenuButton.ipady = verticalSizeOfButton; // Vertical size.

        // Add JButton backToMainMenuButton to JPanel summaryReportButtonsPanel with its configuration.
        summaryReportButtonsPanel.add(backToMainMenuButton, constraintsForBackToMainMenuButton);

        return summaryReportButtonsPanel;
    }

}
