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
        // TODO: Better semantics.
        JPanel carLoanInstallmentCalculatorPanel = new JPanel(new GridBagLayout());

        // Configuring drop down box for car type.
        GridBagConstraints constraintsForCarTypeDropDownBox = new GridBagConstraints();
        constraintsForCarTypeDropDownBox.gridy = 0;

        // TODO: Here.
        // Configuring panel that contains text fields.
        GridBagConstraints constraintsForTextFieldPanels = new GridBagConstraints();
        constraintsForTextFieldPanels.gridy = 1;

        // Adding drop down box panel to the car loan installment calculator panel.
        carLoanInstallmentCalculatorPanel.add(setupCarTypeDropDownBoxPanel(), constraintsForCarTypeDropDownBox);
        carLoanInstallmentCalculatorPanel.add(setupTextFieldsPanel(), constraintsForTextFieldPanels);



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

    // TODO: Everything down here, might be a bit redundant/too complex.
    // TODO: If possible, try to simplify, or reduce cognitive load.
    // TODO: If not, get a better naming system lol.
    /** Returns a panel that contains at least one text field.
     * This is for user to input their loan term,
     * and loan amount.
     */
    private JPanel setupTextFieldsPanel() {
        JPanel textFieldsPanel = new JPanel(new GridBagLayout());

        // Configuring for loan term text field.
        GridBagConstraints constraintsForLoanTermTextField = new GridBagConstraints();
        constraintsForLoanTermTextField.gridy = 0;

        // Configuring for loan amount text field.
        GridBagConstraints constraintsForLoanAmountTextField = new GridBagConstraints();
        constraintsForLoanAmountTextField.gridy = 1;

        // Adding text fields with their respective label to the panel.
        textFieldsPanel.add(setupTextFieldPanel("Please insert your loan terms (Years)"), constraintsForLoanTermTextField);
        textFieldsPanel.add(setupTextFieldPanel("Please insert your loan amount (RM)"), constraintsForLoanAmountTextField);

        return textFieldsPanel;
    }

    /** Returns a panel that contains a text field and a label. */
    private JPanel setupTextFieldPanel(String labelForTextField) {
        JPanel textBoxPanel = new JPanel(new GridBagLayout());
        JLabel textFieldLabel = new JLabel(labelForTextField);
        JTextField textField = new JTextField(20);

        // Configuring text field label.
        GridBagConstraints constraintsForTextFieldLabel = new GridBagConstraints();
        constraintsForTextFieldLabel.gridy = 0;

        // Configuring text field.
        GridBagConstraints constraintsForTextField = new GridBagConstraints();
        constraintsForTextField.gridy = 1;

        // Adding the components with their respective constraints.
        textBoxPanel.add(textFieldLabel, constraintsForTextFieldLabel);
        textBoxPanel.add(textField, constraintsForTextField);

        return textBoxPanel;
    }

}
