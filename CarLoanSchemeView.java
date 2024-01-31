import javax.swing.*;
import java.awt.*;

/** This class represents the view for the car loan scheme. */
public class CarLoanSchemeView {
    // TODO: Implementation after implement the model.
    private final JPanel carLoanSchemeViewPanel;

    // Don't know how I'm going to pass my data yet.
    public CarLoanSchemeView() {
        this.carLoanSchemeViewPanel = setupCarLoanSchemeViewPanel();
    }

    public JPanel getCarLoanSchemeViewPanel() {
        return carLoanSchemeViewPanel;
    }

    private JPanel setupCarLoanSchemeViewPanel() {

        // TODO: Constraints.
        JPanel carLoanSchemeViewPanel = new JPanel(new GridBagLayout());

        carLoanSchemeViewPanel.add(setupCarLoanSchemeTable());

        carLoanSchemeViewPanel.add(carLoanSchemeButtonsPanel());

        return carLoanSchemeViewPanel;
    }

    private JScrollPane setupCarLoanSchemeTable() {
        JTable carLoanSchemeTable = new JTable();
        // TODO: Pass the data that will then be created for the table.
        return null;
    }

    private JPanel carLoanSchemeButtonsPanel() {
        // TODO: Buttons
        return null;
    }

}
