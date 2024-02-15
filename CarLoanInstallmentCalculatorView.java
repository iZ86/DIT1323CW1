import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CarLoanInstallmentCalculatorView {

    /** The car loan installment calculator view. */
    private final JPanel carLoanInstallmentCalculatorViewPanel;
    /** Drop-down box to allow user to choose between imported and local car types. */
    private final JComboBox<String> carTypeDropDownBox = new JComboBox<String>();
    /** Check box to allow user to choose if they want insurance or not. */
    private final JCheckBox loanInsuranceCheckBox = new JCheckBox("Loan Insurance");
    /** Text field where user enters their desired loan term. */
    private final JTextField loanTermTextField = new JTextField();
    /** Text field where user enters their desired loan amount. */
    private final JTextField loanAmountTextField = new JTextField();
    /** Button that changes the view back to the MainMenuView. */
    private final JButton backToMainMenuButton = new JButton("Back to main menu");
    /** Button that changes the view to the SummaryReportView. */
    private final JButton calculateCarLoanButton = new JButton("Calculate car loan installment");


    /** Constructor to set up the car loan installment calculator view. */
    public CarLoanInstallmentCalculatorView() {
        this.carLoanInstallmentCalculatorViewPanel = setupCarLoanInstallmentCalculatorViewPanel();
    }

    /** Return JPanel CarLoanInstallmentCalculatorViewPanel. */
    public JPanel getCarLoanInstallmentCalculatorViewPanel() {
        return carLoanInstallmentCalculatorViewPanel;
    }

    /** Return the selected item in JComboBox carTypeDropDownBox. */
    public String getCarTypeDropDownBoxSelectedItem() {
        return (String) carTypeDropDownBox.getSelectedItem();
    }

    /** Return true iff JCheckBox loanInsuranceCheckBox has been checked. */
    public boolean isLoanInsuranceCheckBoxChecked() {
        return loanInsuranceCheckBox.isSelected();
    }
    /** Return the loan term in JTextField loanTermTextField inputted by user. */
    public String getLoanTerm() {
        return loanTermTextField.getText();
    }

    /** Return the loan amount in JTextField loanAmountTextField inputted by user. */
    public String getLoanAmount() {
        return loanAmountTextField.getText();
    }

    /** Add ActionListener listenForBackToMainMenuButton to JButton backToMainMenuButton. */
    public void addBackToMainMenuButtonListener(ActionListener listenForBackToMainMenuButton) {
        backToMainMenuButton.addActionListener(listenForBackToMainMenuButton);
    }

    /** Add ActionListener listenForCalculateLoanInstallmentButton to JButton calculateLoanInstallmentButton. */
    public void addCalculateCarLoanButtonListener(ActionListener listenForCalculateCarLoanButton) {
        calculateCarLoanButton.addActionListener(listenForCalculateCarLoanButton);
    }

    /** Return a JPanel that has all the necessary components,
     *  to make the car loan installment calculator view.
     */
    private JPanel setupCarLoanInstallmentCalculatorViewPanel() {

        // Initialization
        JPanel viewPanel = new JPanel(new GridBagLayout());
        JPanel carTypeDropDownBoxPanel = setupCarTypeDropDownBoxPanel(); // Car types drop-down box.
        JPanel textFieldsPanel = setupTextFieldsPanel(); // Text fields for user input.
        JPanel loanInsuranceCheckBoxPanel = setupLoanInsuranceCheckBoxPanel(); // Loan insurance choice check box.
        JPanel buttonsPanel = setupCarLoanInstallmentCalculationButtonPanel(); // Buttons for the view.

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



        // Add the JPanels to the viewPanel with their configurations.
        viewPanel.add(carTypeDropDownBoxPanel, constraintsForCarTypeDropDownBox);
        viewPanel.add(textFieldsPanel, constraintsForTextFieldPanels);
        viewPanel.add(loanInsuranceCheckBoxPanel, constraintsForLoanInsuranceCheckBoxPanel);
        viewPanel.add(buttonsPanel, constraintsForButtonsPanel);


        // Return JPanel viewPanel.
        return viewPanel;
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
        constraintsForCarTypeLabel.gridy = 0; // Position of JLabel carTypeLabel is first in Y order.
        constraintsForCarTypeLabel.anchor = GridBagConstraints.LINE_START; // Align to the left.

        // Setting up the configuration for JComboBox carTypeDropDownBox.
        GridBagConstraints constraintsForCarTypeDropDownBox = new GridBagConstraints();
        constraintsForCarTypeDropDownBox.gridy = 1; // Position of JComboBox carTypeDropDownBox is second in Y order.
        constraintsForCarTypeDropDownBox.ipadx = 20; // Horizontal size of JComboBox carTypeDropDownBox.
        constraintsForCarTypeDropDownBox.insets = new Insets(0, 0, 0, 115); // Add gap to the right.

        // Add the JComboBox to JPanel carTypeDropDownBoxPanel with their configuration.
        carTypeDropDownBoxPanel.add(carTypeLabel, constraintsForCarTypeLabel);
        carTypeDropDownBoxPanel.add(setupDropDownBox(carTypeDropDownBox, carTypes), constraintsForCarTypeDropDownBox);

        // Return JPanel carTypeDropDownBoxPanel.
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
        JLabel loanInsurancePriceFirstDescription = new JLabel("*An additional RM200 (per year) surcharge,"); // First half of loan insurance price description.
        JLabel loanInsurancePriceSecondDescription = new JLabel("will be added to the loan amount."); // Second half of loan insurance price description.

        // Configuring JLabel loanInsuranceDescription.
        loanInsuranceFirstDescription.setFont(new Font("Arial", Font.PLAIN, 10)); // Setting font and size.

        // Configuring JLabel loanInsuranceSecondDescription.
        loanInsuranceSecondDescription.setFont(new Font("Arial", Font.PLAIN, 10)); // Setting font and size.

        // Configuring JLabel loanInsurancePriceFirstDescription.
        loanInsurancePriceFirstDescription.setFont(new Font("Arial", Font.PLAIN, 10)); // Setting font and size.

        // Configuring JLabel loanInsurancePriceSecondDescription.
        loanInsurancePriceSecondDescription.setFont(new Font("Arial", Font.PLAIN, 10)); // Setting font and size.

        // Setting up the configuration for JComboBox loanInsuranceCheckBoxPanel.
        GridBagConstraints constraintsForLoanInsuranceCheckBox = new GridBagConstraints();
        constraintsForLoanInsuranceCheckBox.gridy = 0; // Position is first in Y order.
        constraintsForLoanInsuranceCheckBox.ipadx = 20; // Horizontal size of JComboBox loanInsuranceCheckBox.
        constraintsForLoanInsuranceCheckBox.insets = new Insets(10, 0, 0, 85); // Add gap to the right.

        // Setting up the configuration for JLabel loanInsuranceFirstDescription.
        GridBagConstraints constraintsForLoanInsuranceFirstDescription = new GridBagConstraints();
        constraintsForLoanInsuranceFirstDescription.gridy = 1; // Position is second in Y order.
        constraintsForLoanInsuranceFirstDescription.anchor = GridBagConstraints.LINE_START; // Align to the left.

        // Setting up the configuration for JLabel loanInsuranceSecondDescription.
        GridBagConstraints constraintsForLoanInsuranceSecondDescription = new GridBagConstraints();
        constraintsForLoanInsuranceSecondDescription.gridy = 2; // Position is third in Y order.
        constraintsForLoanInsuranceSecondDescription.anchor = GridBagConstraints.LINE_START; // Align to the left.

        // Setting up the configuration for JLabel loanInsurancePriceFirstDescription.
        GridBagConstraints constraintsForLoanInsurancePriceFirstDescription = new GridBagConstraints();
        constraintsForLoanInsurancePriceFirstDescription.gridy = 3; // Position is fourth in Y order.
        constraintsForLoanInsurancePriceFirstDescription.anchor = GridBagConstraints.LINE_START; // Align to the left.

        // Setting up the configuration for JLabel constraintsForLoanInsurancePriceSecondDescription.
        GridBagConstraints constraintsForLoanInsurancePriceSecondDescription = new GridBagConstraints();
        constraintsForLoanInsurancePriceSecondDescription.gridy = 4; // Position is fifth in Y order.
        constraintsForLoanInsurancePriceSecondDescription.anchor = GridBagConstraints.LINE_START; // Align to the left.


        // Add the JPanels to JPanel loanInsuranceCheckBoxPanel with their configurations.
        loanInsuranceCheckBoxPanel.add(loanInsuranceCheckBox, constraintsForLoanInsuranceCheckBox);
        loanInsuranceCheckBoxPanel.add(loanInsuranceFirstDescription, constraintsForLoanInsuranceFirstDescription);
        loanInsuranceCheckBoxPanel.add(loanInsuranceSecondDescription, constraintsForLoanInsuranceSecondDescription);
        loanInsuranceCheckBoxPanel.add(loanInsurancePriceFirstDescription, constraintsForLoanInsurancePriceFirstDescription);
        loanInsuranceCheckBoxPanel.add(loanInsurancePriceSecondDescription, constraintsForLoanInsurancePriceSecondDescription);

        return loanInsuranceCheckBoxPanel;
    }

    /** Returns a JComboBox that is represented as a drop-down box,
     * that contains String[] options that allow users,
     * to choose the desired option.
     */
    private JComboBox<String> setupDropDownBox(JComboBox<String> dropDownBox, String[] options) {


        for (String option : options) {
            dropDownBox.addItem(option);
        }

        // Set default option to the 0th element in String[] options.
        dropDownBox.setSelectedIndex(0);

        // Return JComboBox dropDownBox.
        return dropDownBox;
    }

    // TODO: Everything down here, might be a bit redundant/too complex.
    // TODO: If possible, try to simplify, or reduce cognitive load.
    // TODO: If not, get a better naming system lol.
    /** Return a JPanel that contains panels that contains JTextFields,
     * and their respective JLabels,
     * needed for the car loan installment calculator view panel.
     * This is for user to input their loan term,
     * and loan amount.
     */
    private JPanel setupTextFieldsPanel() {

        // Initialization
        JPanel textFieldsPanel = new JPanel(new GridBagLayout());
        int gapBetweenTextFieldsPanels = 20;
        JPanel loanTermTextFieldPanel = setupTextFieldPanel("Please insert your loan terms (Years)", loanTermTextField);
        JPanel loanAmountTextFieldPanel = setupTextFieldPanel("Please insert your loan amount (RM)", loanAmountTextField);

        // Setting up the configuration for JPanel loanTermTextFieldPanel.
        GridBagConstraints constraintsForLoanTermTextFieldPanel = new GridBagConstraints();
        constraintsForLoanTermTextFieldPanel.insets = new Insets(gapBetweenTextFieldsPanels,
                0, gapBetweenTextFieldsPanels, 0); // Add gap below and above.
        constraintsForLoanTermTextFieldPanel.gridy = 0; // Position of panel is first in Y order.
        constraintsForLoanTermTextFieldPanel.anchor = GridBagConstraints.LINE_START; // Anchor panel to the left.

        // Setting up the configuration for JPanel loanAmountTextFieldPanel.
        GridBagConstraints constraintsForLoanAmountTextFieldPanel = new GridBagConstraints();
        constraintsForLoanAmountTextFieldPanel.gridy = 1; // Position of panel is second in Y order.
        constraintsForLoanAmountTextFieldPanel.anchor = GridBagConstraints.LINE_START; // Anchor panel to the left.

        // Add the JPanels to JPanel textFieldsPanel with their configurations.
        textFieldsPanel.add(loanTermTextFieldPanel, constraintsForLoanTermTextFieldPanel);
        textFieldsPanel.add(loanAmountTextFieldPanel, constraintsForLoanAmountTextFieldPanel);

        // Return JPanel textFieldsPanel.
        return textFieldsPanel;
    }

    /** Returns a JPanel that contains a JLabel and JTextField. */
    private JPanel setupTextFieldPanel(String labelForTextField, JTextField textField) {

        // Initialization
        JPanel textFieldPanel = new JPanel(new GridBagLayout());
        JLabel textFieldLabel = new JLabel(labelForTextField);

        // Setting up configurations for JLabel textFieldLabel.
        GridBagConstraints constraintsForTextFieldLabel = new GridBagConstraints();
        constraintsForTextFieldLabel.gridy = 0;


        // Setting up configurations for JTextField textField.
        GridBagConstraints constraintsForTextField = new GridBagConstraints();
        constraintsForTextField.anchor = GridBagConstraints.LINE_START;
        constraintsForTextField.gridy = 1;
        constraintsForTextField.ipady = 5; // Set the height of the text field, may change to another code later.
        constraintsForTextField.ipadx = 150;

        // Add the components to JPanel textFieldPanel with their configurations.
        textFieldPanel.add(textFieldLabel, constraintsForTextFieldLabel);
        textFieldPanel.add(textField, constraintsForTextField);

        // Return JPanel textFieldPanel.
        return textFieldPanel;
    }

    /** Return a JPanel that contains all the necessary buttons for car loan installment calculation view. */
    private JPanel setupCarLoanInstallmentCalculationButtonPanel() {

        // Initialization.
        JPanel carLoanInstallmentCalculationButtonPanel = new JPanel(new GridBagLayout());
        int heightOfButton = 15;

        // Setting up the configuration for JButton backToMainMenu.
        GridBagConstraints constraintsForBackToMainMenuButton = new GridBagConstraints();
        constraintsForBackToMainMenuButton.gridx = 0; // Position of button is first in X order.
        constraintsForBackToMainMenuButton.ipady = heightOfButton; // Height of button.
        constraintsForBackToMainMenuButton.insets = new Insets(0, 0, 0, 20); // Add a gap on the right side.

        // Setting up the configuration for JButton calculateCarLoanButton.
        GridBagConstraints constraintsForCalculateCarLoanButton = new GridBagConstraints();
        constraintsForCalculateCarLoanButton.gridx = 1; // Position of button is second in X order.
        constraintsForCalculateCarLoanButton.fill = GridBagConstraints.VERTICAL; // Same height as the button on the left.

        // Add the JButtons to JPanel carLoanInstallmentCalculationButtonPanel with their configurations.
        carLoanInstallmentCalculationButtonPanel.add(backToMainMenuButton, constraintsForBackToMainMenuButton);
        carLoanInstallmentCalculationButtonPanel.add(calculateCarLoanButton, constraintsForCalculateCarLoanButton);

        // Return JPanel carLoanInstallmentCalculationButtonPanel.
        return carLoanInstallmentCalculationButtonPanel;
    }
}
