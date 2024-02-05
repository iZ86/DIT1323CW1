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
        constraintsForCarTypeDropDownBox.anchor = GridBagConstraints.LINE_START;
        constraintsForCarTypeDropDownBox.gridy = 0;

        // TODO: Here.
        // Configuring panel that contains text fields.
        GridBagConstraints constraintsForTextFieldPanels = new GridBagConstraints();
        constraintsForTextFieldPanels.anchor = GridBagConstraints.LINE_START;
        constraintsForTextFieldPanels.gridy = 1;

        // TODO: Here too.
        // Configuring panel that contains buttons.
        GridBagConstraints constraintsForButtons = new GridBagConstraints();
        constraintsForButtons.gridy = 2;

        // Adding drop down box panel to the car loan installment calculator panel.
        carLoanInstallmentCalculatorPanel.add(setupCarTypeDropDownBoxPanel(), constraintsForCarTypeDropDownBox);
        carLoanInstallmentCalculatorPanel.add(setupTextFieldsPanel(), constraintsForTextFieldPanels);
        carLoanInstallmentCalculatorPanel.add(setupCarLoanInstallmentCalculationButtonPanel(), constraintsForButtons);


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
        int gapBetweenTextFields = 20;

        // Configuring for loan term text field.
        GridBagConstraints constraintsForLoanTermTextField = new GridBagConstraints();
        constraintsForLoanTermTextField.insets = new Insets(gapBetweenTextFields, 0, gapBetweenTextFields, 0);
        constraintsForLoanTermTextField.gridy = 0; // Set the component at the top.

        // Configuring for loan amount text field.
        GridBagConstraints constraintsForLoanAmountTextField = new GridBagConstraints();
        // constraintsForLoanAmountTextField.anchor = GridBagConstraints.LINE_START; // Set the component on the left.
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
        constraintsForTextFieldLabel.anchor = GridBagConstraints.LINE_START;

        // Configuring text field.
        GridBagConstraints constraintsForTextField = new GridBagConstraints();
        constraintsForTextField.gridy = 1;
        constraintsForTextField.ipady = 5; // Set the height of the text field, may change to another code later.
        constraintsForTextField.anchor = GridBagConstraints.LINE_START;

        // Adding the components with their respective constraints.
        textBoxPanel.add(textFieldLabel, constraintsForTextFieldLabel);
        textBoxPanel.add(textField, constraintsForTextField);

        return textBoxPanel;
    }

    /** Returns a panel that contains all the necessary buttons for car loan installment calculation. */
    private JPanel setupCarLoanInstallmentCalculationButtonPanel() {

        // Initialization.
        JPanel carLoanInstallmentCalculationButtonPanel = new JPanel(new GridBagLayout());
        int heightOfButton = 20;
        JButton backToMainMenuButton = new JButton("Back to main menu");
        JButton generateSummaryReportButton = new JButton("Generate summary report");

        // Configuring back to main menu button.
        GridBagConstraints constraintsForBackToMainMenuButton = new GridBagConstraints();
        constraintsForBackToMainMenuButton.gridx = 0; // Button will be on the left.
        constraintsForBackToMainMenuButton.ipady = heightOfButton; // Set the height of the button.
        constraintsForBackToMainMenuButton.insets = new Insets(0, 0, 0, 20); // Set a gap on the right side of the button.

        // Configuring generate summary report button.
        GridBagConstraints constraintsForGenerateSummaryReportButton = new GridBagConstraints();
        constraintsForGenerateSummaryReportButton.gridx = 1; // Button will be on the right.
        constraintsForGenerateSummaryReportButton.fill = GridBagConstraints.VERTICAL; // Same height as the button on the left.

        // Adding buttons to the panel.
        carLoanInstallmentCalculationButtonPanel.add(backToMainMenuButton, constraintsForBackToMainMenuButton);
        carLoanInstallmentCalculationButtonPanel.add(generateSummaryReportButton, constraintsForGenerateSummaryReportButton);



        return carLoanInstallmentCalculationButtonPanel;
    }



}
