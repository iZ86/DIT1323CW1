import javax.swing.*;
import java.awt.*;

public class CarLoanInstallmentCalculator {
    private JPanel carLoanInstallmentCalculatorPanel;

    /** Constructor to set up the panel. */
    public CarLoanInstallmentCalculator() {
        this.carLoanInstallmentCalculatorPanel = setupCarLoanInstallmentCalculatorPanel();
    }

    public JPanel getCarLoanInstallmentCalculatorPanel() {
        return carLoanInstallmentCalculatorPanel;
    }

    /** Return a panel that has all the necessary components,
     *  to make the car loan installment calculator view.
     */
    private JPanel setupCarLoanInstallmentCalculatorPanel() {
        JPanel carLoanInstallmentCalculatorPanel = new JPanel(new GridBagLayout());

        // Adding drop down box panel to the car loan installment calculator panel.
        carLoanInstallmentCalculatorPanel.add(setupCarTypeDropDownBoxPanel());



        return carLoanInstallmentCalculatorPanel;
    }

    /** Return a panel that contains a dropdown box.
     * For user to choose between, local and imported car types.
     */
    private JPanel setupCarTypeDropDownBoxPanel() {
        JPanel carTypeDropDownBoxPanel = new JPanel(new GridBagLayout());

        // Adding the dropdown box to the panel
        carTypeDropDownBoxPanel.add(setupCarTypeDropDownBox());

        return carTypeDropDownBoxPanel;
    }

    /** Returns a JComboBox, that contains options that allow users,
     * to choose the desired car type.
     */
    private JComboBox<String> setupCarTypeDropDownBox() {
        String[] carTypes = {"Imported", "Local"};
        JComboBox<String> carTypeDropDownBox = new JComboBox<String>(carTypes);
        carTypeDropDownBox.setSelectedIndex(0);


        return carTypeDropDownBox;
    }
}
