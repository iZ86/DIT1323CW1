import javax.swing.*;
import java.awt.*;

/** This class represents the view for the car loan scheme. */
public class CarLoanSchemeView {
    // TODO: Implementation after implement the model.
    private JPanel carLoanSchemeViewPanel;

    public CarLoanSchemeView() {
        this.carLoanSchemeViewPanel = setupCarLoanSchemeViewPanel();
    }

    public JPanel getCarLoanSchemeViewPanel() {
        return carLoanSchemeViewPanel;
    }

    private JPanel setupCarLoanSchemeViewPanel() {

        JPanel carLoanSchemeViewPanel = new JPanel(new GridBagLayout());

        return carLoanSchemeViewPanel;
    }
}
