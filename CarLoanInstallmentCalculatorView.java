import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/** This class represents the car loan installment calculator view in the GUI. */
public class CarLoanInstallmentCalculatorView {

    /** The car loan installment calculator view. */
    private final JPanel carLoanInstallmentCalculatorViewPanel = new JPanel(new GridBagLayout());
    /** Drop-down box to allow user to choose between imported and local car types. */
    private final JComboBox<String> carTypeDropDownBox = new JComboBox<String>();
    /** Check box to allow user to choose if they want loan insurance or not. */
    private final JCheckBox loanInsuranceCheckBox = new JCheckBox("Loan Insurance");
    /** Text field where desired loan term is entered. */
    private final JTextField loanTermTextField = new JTextField();
    /** Text field where desired loan amount is entered. */
    private final JTextField loanAmountTextField = new JTextField();
    /** Button that changes the view back to the MainMenuView. */
    private final JButton backToMainMenuButton = new JButton("Back to main menu");
    /** Button that calculates the car loan installment and changes the view to the LoanInstallmentReportView. */
    private final JButton calculateCarLoanInstallmentReportButton = new JButton("Calculate car loan installment");


    /** A new JPanel that represents the CarLoanInstallmentCalculatorView. */
    public CarLoanInstallmentCalculatorView() {
        setupCarLoanInstallmentCalculatorViewPanel();
    }

    /** Return JPanel carLoanInstallmentCalculatorViewPanel. */
    public JPanel getCarLoanInstallmentCalculatorViewPanel() {
        return carLoanInstallmentCalculatorViewPanel;
    }

    /** Return the selected item in JComboBox carTypeDropDownBox. */
    public String getSelectedCarType() {
        return (String) carTypeDropDownBox.getSelectedItem();
    }

    /** Return true iff JCheckBox loanInsuranceCheckBox has been checked. */
    public boolean getLoanInsuranceCheckBoxChecked() {
        return loanInsuranceCheckBox.isSelected();
    }

    /** Return the loan term in JTextField loanTermTextField inputted by user. */
    public int getLoanTerm() {
        return Integer.parseInt(loanTermTextField.getText());
    }

    /** Return the loan amount in JTextField loanAmountTextField inputted by user. */
    public double getLoanAmount() {
        return Double.parseDouble(loanAmountTextField.getText());
    }

    /** Set the default value of all components in the view. */
    public void setDefaultValue() {
        carTypeDropDownBox.setSelectedIndex(0);
        loanTermTextField.setText("");
        loanAmountTextField.setText("");
        loanInsuranceCheckBox.setSelected(false);
    }

    /** Add ActionListener listenForBackToMainMenuButton to JButton backToMainMenuButton. */
    public void addBackToMainMenuButtonListener(ActionListener listenForBackToMainMenuButton) {
        backToMainMenuButton.addActionListener(listenForBackToMainMenuButton);
    }

    /** Add ActionListener listenForCalculateLoanInstallmentReportButton,
     * to JButton calculateCarLoanInstallmentReportButton.
     */
    public void addCalculateCarLoanInstallmentReportButtonListener(ActionListener listenForCalculateCarLoanInstallmentReportButton) {
        calculateCarLoanInstallmentReportButton.addActionListener(listenForCalculateCarLoanInstallmentReportButton);
    }

    /** Set up JPanel carLoanInstallmentCalculatorViewPanel. */
    private void setupCarLoanInstallmentCalculatorViewPanel() {

        // Initialization
        JPanel carTypeDropDownBoxPanel = setupCarTypeDropDownBoxPanel();
        JPanel textFieldsPanel = setupTextFieldsPanel();
        JPanel loanInsuranceCheckBoxPanel = setupLoanInsuranceCheckBoxPanel();
        JPanel buttonsPanel = setupCarLoanInstallmentCalculationButtonPanel();

        // Setting up the configuration for JPanel carTypeDropDownBoxPanel.
        GridBagConstraints constraintsForCarTypeDropDownBox = new GridBagConstraints();
        constraintsForCarTypeDropDownBox.gridy = 0; // Position is first in Y order.

        // Setting up the configuration for JPanel textFieldsPanel.
        GridBagConstraints constraintsForTextFieldPanels = new GridBagConstraints();
        constraintsForTextFieldPanels.gridy = 1; // Position is second in Y order.

        // Setting up the configuration for JPanel loanInsuranceCheckBoxPanel.
        GridBagConstraints constraintsForLoanInsuranceCheckBoxPanel = new GridBagConstraints();
        constraintsForLoanInsuranceCheckBoxPanel.gridy = 2; // Position is third in Y order.

        // Setting up the configuration for JPanel buttonsPanel.
        GridBagConstraints constraintsForButtonsPanel = new GridBagConstraints();
        constraintsForButtonsPanel.gridy = 3; // Position is fourth in Y order.
        constraintsForButtonsPanel.insets = new Insets(20, 0, 0, 0); // Add gap above.


        // Add the JPanels to JPanel carLoanInstallmentCalculatorViewPanel with their configurations.
        carLoanInstallmentCalculatorViewPanel.add(carTypeDropDownBoxPanel, constraintsForCarTypeDropDownBox);
        carLoanInstallmentCalculatorViewPanel.add(textFieldsPanel, constraintsForTextFieldPanels);
        carLoanInstallmentCalculatorViewPanel.add(loanInsuranceCheckBoxPanel, constraintsForLoanInsuranceCheckBoxPanel);
        carLoanInstallmentCalculatorViewPanel.add(buttonsPanel, constraintsForButtonsPanel);
    }

    /** Return a JPanel that contains JComboBox carTypeDropDownBox.
     * For user to choose between, local and imported car types.
     */
    private JPanel setupCarTypeDropDownBoxPanel() {

        // Initialization
        JPanel carTypeDropDownBoxPanel = new JPanel(new GridBagLayout());
        JLabel carTypeLabel = new JLabel("Car Type"); // Let user know the drop-down box is for car types.
        String[] carTypes = {"Imported", "Local"}; // Car type options

        // Setting up the configuration for JLabel carTypeLabel.
        GridBagConstraints constraintsForCarTypeLabel = new GridBagConstraints();
        constraintsForCarTypeLabel.gridy = 0; // Position is first in Y order.
        constraintsForCarTypeLabel.anchor = GridBagConstraints.LINE_START; // Align to the left.

        // Setting up the configuration for JComboBox carTypeDropDownBox.
        GridBagConstraints constraintsForCarTypeDropDownBox = new GridBagConstraints();
        constraintsForCarTypeDropDownBox.gridy = 1; // Position is second in Y order.
        constraintsForCarTypeDropDownBox.ipadx = 20; // Horizontal size of JComboBox carTypeDropDownBox.
        constraintsForCarTypeDropDownBox.insets = new Insets(0, 0, 0, 115); // Add gap to the right.

        // Add the components to JPanel carTypeDropDownBoxPanel with their configuration.
        carTypeDropDownBoxPanel.add(carTypeLabel, constraintsForCarTypeLabel);
        carTypeDropDownBoxPanel.add(setupDropDownBox(carTypeDropDownBox, carTypes), constraintsForCarTypeDropDownBox);

        return carTypeDropDownBoxPanel;
    }

    /** Return a JPanel that contains JCheckBox insuranceDropDownBox.
     * For user to choose whether to get insurance or not.
     */
    private JPanel setupLoanInsuranceCheckBoxPanel() {

        // Initialization
        JPanel loanInsuranceCheckBoxPanel = new JPanel(new GridBagLayout());
        JLabel loanInsuranceFirstDescription = new JLabel("*Loan payback will be waived in the event,"); // First half of loan insurance description.
        JLabel loanInsuranceSecondDescription = new JLabel("of the borrower's death or permanent disability."); // Second half of loan insurance description.
        JLabel loanInsuranceFirstPriceDescription = new JLabel("*An additional RM200 (per year) surcharge,"); // First half of loan insurance price description.
        JLabel loanInsuranceSecondPriceDescription = new JLabel("will be added to the loan amount."); // Second half of loan insurance price description.

        // Configuring JLabel loanInsuranceFirstDescription.
        loanInsuranceFirstDescription.setFont(new Font("Arial", Font.PLAIN, 10)); // Setting font and size.

        // Configuring JLabel loanInsuranceSecondDescription.
        loanInsuranceSecondDescription.setFont(new Font("Arial", Font.PLAIN, 10)); // Setting font and size.

        // Configuring JLabel loanInsuranceFirstPriceDescription.
        loanInsuranceFirstPriceDescription.setFont(new Font("Arial", Font.PLAIN, 10)); // Setting font and size.

        // Configuring JLabel loanInsuranceSecondPriceDescription.
        loanInsuranceSecondPriceDescription.setFont(new Font("Arial", Font.PLAIN, 10)); // Setting font and size.

        // Setting up the configuration for JCheckBox loanInsuranceCheckBoxPanel.
        GridBagConstraints constraintsForLoanInsuranceCheckBox = new GridBagConstraints();
        constraintsForLoanInsuranceCheckBox.gridy = 0; // Position is first in Y order.
        constraintsForLoanInsuranceCheckBox.ipadx = 20; // Horizontal size of JCheckBox loanInsuranceCheckBox.
        constraintsForLoanInsuranceCheckBox.insets = new Insets(10, 0, 0, 85); // Add gap to the right.

        // Setting up the configuration for JLabel loanInsuranceFirstDescription.
        GridBagConstraints constraintsForLoanInsuranceFirstDescription = new GridBagConstraints();
        constraintsForLoanInsuranceFirstDescription.gridy = 1; // Position is second in Y order.
        constraintsForLoanInsuranceFirstDescription.anchor = GridBagConstraints.LINE_START; // Align to the left.

        // Setting up the configuration for JLabel loanInsuranceSecondDescription.
        GridBagConstraints constraintsForLoanInsuranceSecondDescription = new GridBagConstraints();
        constraintsForLoanInsuranceSecondDescription.gridy = 2; // Position is third in Y order.
        constraintsForLoanInsuranceSecondDescription.anchor = GridBagConstraints.LINE_START; // Align to the left.

        // Setting up the configuration for JLabel loanInsuranceFirstPriceDescription.
        GridBagConstraints constraintsForLoanInsuranceFirstPriceDescription = new GridBagConstraints();
        constraintsForLoanInsuranceFirstPriceDescription.gridy = 3; // Position is fourth in Y order.
        constraintsForLoanInsuranceFirstPriceDescription.anchor = GridBagConstraints.LINE_START; // Align to the left.

        // Setting up the configuration for JLabel loanInsuranceSecondPriceDescription.
        GridBagConstraints constraintsForLoanInsuranceSecondPriceDescription = new GridBagConstraints();
        constraintsForLoanInsuranceSecondPriceDescription.gridy = 4; // Position is fifth in Y order.
        constraintsForLoanInsuranceSecondPriceDescription.anchor = GridBagConstraints.LINE_START; // Align to the left.


        // Add the JPanels to JPanel loanInsuranceCheckBoxPanel with their configurations.
        loanInsuranceCheckBoxPanel.add(loanInsuranceCheckBox, constraintsForLoanInsuranceCheckBox);
        loanInsuranceCheckBoxPanel.add(loanInsuranceFirstDescription, constraintsForLoanInsuranceFirstDescription);
        loanInsuranceCheckBoxPanel.add(loanInsuranceSecondDescription, constraintsForLoanInsuranceSecondDescription);
        loanInsuranceCheckBoxPanel.add(loanInsuranceFirstPriceDescription,
                constraintsForLoanInsuranceFirstPriceDescription);
        loanInsuranceCheckBoxPanel.add(loanInsuranceSecondPriceDescription,
                constraintsForLoanInsuranceSecondPriceDescription);

        return loanInsuranceCheckBoxPanel;
    }

    /** Return a JComboBox that is represented as a drop-down box,
     * that contains String[] options that allow users,
     * to choose the desired option.
     */
    private JComboBox<String> setupDropDownBox(JComboBox<String> dropDownBox, String[] options) {


        for (String option : options) {
            dropDownBox.addItem(option);
        }

        // Set default option to the 0th element in String[] options.
        dropDownBox.setSelectedIndex(0);

        return dropDownBox;
    }

    /** Return a JPanel that contains JPanels that contains JTextFields,
     * and their respective JLabels.
     */
    private JPanel setupTextFieldsPanel() {

        // Initialization
        JPanel textFieldsPanel = new JPanel(new GridBagLayout());
        JPanel loanTermTextFieldPanel = setupTextFieldPanel("Please insert your loan terms (Years)",
                loanTermTextField);
        JPanel loanAmountTextFieldPanel = setupTextFieldPanel("Please insert your loan amount (RM)",
                loanAmountTextField);
        int gapBetweenTextFieldsPanels = 20; // Gap between text field panels.


        // Setting up the configuration for JPanel loanTermTextFieldPanel.
        GridBagConstraints constraintsForLoanTermTextFieldPanel = new GridBagConstraints();
        constraintsForLoanTermTextFieldPanel.gridy = 0; // Position is first in Y order.
        constraintsForLoanTermTextFieldPanel.insets = new Insets(gapBetweenTextFieldsPanels,
                0, gapBetweenTextFieldsPanels, 0); // Add gap below and above.
        constraintsForLoanTermTextFieldPanel.anchor = GridBagConstraints.LINE_START; // Align to the left.

        // Setting up the configuration for JPanel loanAmountTextFieldPanel.
        GridBagConstraints constraintsForLoanAmountTextFieldPanel = new GridBagConstraints();
        constraintsForLoanAmountTextFieldPanel.gridy = 1; // Position is second in Y order.
        constraintsForLoanAmountTextFieldPanel.anchor = GridBagConstraints.LINE_START; // Align to the left.

        // Add the JPanels to JPanel textFieldsPanel with their configurations.
        textFieldsPanel.add(loanTermTextFieldPanel, constraintsForLoanTermTextFieldPanel);
        textFieldsPanel.add(loanAmountTextFieldPanel, constraintsForLoanAmountTextFieldPanel);

        return textFieldsPanel;
    }

    /** Returns a JPanel that contains a JLabel and JTextField. */
    private JPanel setupTextFieldPanel(String labelForTextField, JTextField textField) {

        // Initialization
        JPanel textFieldPanel = new JPanel(new GridBagLayout());
        JLabel textFieldLabel = new JLabel(labelForTextField);

        // Setting up configurations for JLabel textFieldLabel.
        GridBagConstraints constraintsForTextFieldLabel = new GridBagConstraints();
        constraintsForTextFieldLabel.gridy = 0; // Position is first in Y order.


        // Setting up configurations for JTextField textField.
        GridBagConstraints constraintsForTextField = new GridBagConstraints();
        constraintsForTextField.anchor = GridBagConstraints.LINE_START; // Align to the left.
        constraintsForTextField.gridy = 1; // Position is second in Y order.
        constraintsForTextField.ipady = 5; // Vertical size.
        constraintsForTextField.ipadx = 150; // Horizontal size.

        // Add the components to JPanel textFieldPanel with their configurations.
        textFieldPanel.add(textFieldLabel, constraintsForTextFieldLabel);
        textFieldPanel.add(textField, constraintsForTextField);

        return textFieldPanel;
    }

    /** Return a JPanel that contains all the necessary buttons for car loan installment calculation view. */
    private JPanel setupCarLoanInstallmentCalculationButtonPanel() {

        // Initialization.
        JPanel carLoanInstallmentCalculationButtonPanel = new JPanel(new GridBagLayout());
        int verticalSizeOfButton = 15;

        // Setting up the configuration for JButton backToMainMenu.
        GridBagConstraints constraintsForBackToMainMenuButton = new GridBagConstraints();
        constraintsForBackToMainMenuButton.gridx = 0; // Position is first in X order.
        constraintsForBackToMainMenuButton.ipady = verticalSizeOfButton; // Vertical size.
        constraintsForBackToMainMenuButton.insets = new Insets(0, 0, 0, 20); // Add a gap on the right side.

        // Setting up the configuration for JButton calculateCarLoanInstallmentReportButton.
        GridBagConstraints constraintsForCalculateCarLoanInstallmentReportButton = new GridBagConstraints();
        constraintsForCalculateCarLoanInstallmentReportButton.gridx = 1; // Position is second in X order.
        constraintsForCalculateCarLoanInstallmentReportButton.fill = GridBagConstraints.VERTICAL; // Same vertical size as the first button in X order.

        // Add the JButtons to JPanel carLoanInstallmentCalculationButtonPanel with their configurations.
        carLoanInstallmentCalculationButtonPanel.add(backToMainMenuButton, constraintsForBackToMainMenuButton);
        carLoanInstallmentCalculationButtonPanel.add(calculateCarLoanInstallmentReportButton,
                constraintsForCalculateCarLoanInstallmentReportButton);

        return carLoanInstallmentCalculationButtonPanel;
    }
}
