import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// TODO: Logic connect with controller
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

        // Initialization
        JPanel importedCarLoanTransactionTablePanel = new JPanel(new GridBagLayout());
        JLabel importedCarLoanTransactionTableLabel = new JLabel("Imported Car");
        JTable importedCarLoanTransactionTable = new JTable(new CarLoanTableModel(summaryReportModel.getTableDataForImportedCarLoanTransaction(),
                summaryReportModel.getCarLoanTransactionDataTableColumn()));
        JScrollPane importedCarLoanTransactionTablePane = new JScrollPane(importedCarLoanTransactionTable);

        // Setting up configuration for JLabel importedCarLoanTransactionTableLabel.
        GridBagConstraints constraintsForImportedCarLoanTransactionTableLabel = new GridBagConstraints();
        constraintsForImportedCarLoanTransactionTableLabel.gridy = 0; // Position is first in Y order.

        // Setting up configuration for JScrollPane importedCarLoanTransactionTablePane.
        GridBagConstraints constraintsForImportedCarLoanTransactionTablePane = new GridBagConstraints();
        constraintsForImportedCarLoanTransactionTablePane.gridy = 1; // Position is second in Y order.

        // Configuring JTable importedCarLoanTransactionTable.
        configureCarLoanTransactionTable(importedCarLoanTransactionTable);

        // Add the components to JPanel importedCarLoanTransactionTablePanel with their configurations.
        importedCarLoanTransactionTablePanel.add(importedCarLoanTransactionTableLabel, constraintsForImportedCarLoanTransactionTableLabel);
        importedCarLoanTransactionTablePanel.add(importedCarLoanTransactionTablePane, constraintsForImportedCarLoanTransactionTablePane);

        // Return JPanel importedCarLoanTransactionTablePanel.
        return importedCarLoanTransactionTablePanel;
    }

    /** Return JPanel localCarLoanTransactionTablePanel, after setting it up. */
    private JPanel setupLocalCarLoanTransactionTablePanel() {

        // Initialization
        JPanel localCarLoanTransactionTablePanel = new JPanel(new GridBagLayout());
        JLabel localCarLoanTransactionTableLabel = new JLabel("Local Car");
        JTable localCarLoanTransactionTable = new JTable(new CarLoanTableModel(summaryReportModel.getTableDataForLocalCarLoanTransaction(),
                summaryReportModel.getCarLoanTransactionDataTableColumn()));
        JScrollPane localCarLoanTransactionTablePane = new JScrollPane(localCarLoanTransactionTable);

        // Setting up configuration for JLabel localCarLoanTransactionTableLabel.
        GridBagConstraints constraintsForLocalCarLoanTransactionTableLabel = new GridBagConstraints();
        constraintsForLocalCarLoanTransactionTableLabel.gridy = 0; // Position is first in Y order.

        // Setting up configuration for JScrollPane localCarLoanTransactionTablePane.
        GridBagConstraints constraintsForLocalCarLoanTransactionTablePane = new GridBagConstraints();
        constraintsForLocalCarLoanTransactionTablePane.gridy = 1; // Position is second in Y order.

        // Configuring JTable localCarLoanTransactionTable.
        configureCarLoanTransactionTable(localCarLoanTransactionTable);

        // Add the components to JPanel localCarLoanTransactionTablePanel with their configurations.
        localCarLoanTransactionTablePanel.add(localCarLoanTransactionTableLabel, constraintsForLocalCarLoanTransactionTableLabel);
        localCarLoanTransactionTablePanel.add(localCarLoanTransactionTablePane, constraintsForLocalCarLoanTransactionTablePane);

        // Return JPanel localCarLoanTransactionTablePanel.
        return localCarLoanTransactionTablePanel;
    }

    /** Return JPanel carLoanTransactionTablePanel, after setting it up. */
    private JPanel setupCarLoanTransactionTablePanel(String carLoanTransactionTableLabel, Object[][] carLoanTransactionTableData, String[] carLoanTransactionTableColumn) {

        // Initialization
        JPanel carLoanTransactionTablePanel = new JPanel(new GridBagLayout());
        JLabel _carLoanTransactionTableLabel = new JLabel(carLoanTransactionTableLabel);
        JTable carLoanTransactionTable = new JTable(new CarLoanTableModel(carLoanTransactionTableData,
                carLoanTransactionTableColumn));
        JScrollPane carLoanTransactionTablePane = new JScrollPane(carLoanTransactionTable);

        // Setting up configuration for JLabel _carLoanTransactionTableLabel.
        GridBagConstraints constraintsForCarLoanTransactionTableLabel = new GridBagConstraints();
        constraintsForCarLoanTransactionTableLabel.gridy = 0; // Position is first in Y order.

        // Setting up configuration for JScrollPane carLoanTransactionTablePane.
        GridBagConstraints constraintsForCarLoanTransactionTablePane = new GridBagConstraints();
        constraintsForCarLoanTransactionTablePane.gridy = 1; // Position is second in Y order.

        // Configuring JTable carLoanTransactionTable.
        configureCarLoanTransactionTable(carLoanTransactionTable);

        // Add the components to JPanel carLoanTransactionTablePanel with their configurations.
        carLoanTransactionTablePanel.add(_carLoanTransactionTableLabel, constraintsForCarLoanTransactionTableLabel);
        carLoanTransactionTablePanel.add(carLoanTransactionTablePane, constraintsForCarLoanTransactionTablePane);

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
