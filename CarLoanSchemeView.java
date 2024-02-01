import javax.swing.*;
import java.awt.*;

/** This class represents the view for the car loan scheme. */
public class CarLoanSchemeView {
    // TODO: Implementation after implement the model.
    private final JPanel carLoanSchemeViewPanel;

    // Don't know how I'm going to pass my data yet.
    public CarLoanSchemeView(Object[][] tableData, String[] columnNames) {
        this.carLoanSchemeViewPanel = setupCarLoanSchemeViewPanel(tableData, columnNames);
    }

    public JPanel getCarLoanSchemeViewPanel() {
        return carLoanSchemeViewPanel;
    }

    private JPanel setupCarLoanSchemeViewPanel(Object[][] tableData, String[] columnNames) {

        // TODO: Constraints.
        JPanel carLoanSchemeViewPanel = new JPanel(new GridBagLayout());

        carLoanSchemeViewPanel.add(setupCarLoanSchemeTable(tableData, columnNames));

        //carLoanSchemeViewPanel.add(carLoanSchemeButtonsPanel());

        return carLoanSchemeViewPanel;
    }

    private JScrollPane setupCarLoanSchemeTable(Object[][] tableData, String[] columnNames) {

        // Table model created so that user cannot edit cells.
        JTable carLoanSchemeTable = new JTable(new CarLoanSchemeTableModel(tableData, columnNames));

        // Setting property of table so that it can't be selected.
        carLoanSchemeTable.setFocusable(false);
        carLoanSchemeTable.setRowSelectionAllowed(false);
        carLoanSchemeTable.setColumnSelectionAllowed(false);

        // TODO: Pass the data that will then be created for the table.
        return new JScrollPane(carLoanSchemeTable);
    }

    private JPanel carLoanSchemeButtonsPanel() {
        // TODO: Buttons
        return null;
    }

}
