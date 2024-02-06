import javax.swing.*;
import java.awt.*;

public class CarLoanInstallmentCalculatorView {

    /** The panel that contains all the components,
     *  in the car loan installment calculator view.
     */
    private final JPanel carLoanInstallmentCalculatorViewPanel;
    /** Drop-down box that allows user to choose between imported and local car types. */
    private final JComboBox<String> carTypeDropDownBox = new JComboBox<String>();
    /** Text field where user enters their desired loan term. */
    private final JTextField loanTermTextField = new JTextField();
    /** Text field where user enters their desired loan amount. */
    private final JTextField loanAmountTextField = new JTextField();
    /** Button that changes the view back to the MainMenuView. */
    private final JButton backToMainMenuButton = new JButton("Back to main menu");
    /** Button that changes the view to the SummaryReportView. */
    private final JButton generateSummaryReportButton = new JButton("Generate summary report");


    /** Constructor to set up the car loan installment calculator view panel. */
    public CarLoanInstallmentCalculatorView() {
        this.carLoanInstallmentCalculatorViewPanel = setupCarLoanInstallmentCalculatorViewPanel();
    }

    /** Return the CarLoanInstallmentCalculatorViewPanel. */
    public JPanel getCarLoanInstallmentCalculatorViewPanel() {
        return carLoanInstallmentCalculatorViewPanel;
    }

    /** Return a panel that has all the necessary components,
     *  to make the car loan installment calculator view.
     */
    private JPanel setupCarLoanInstallmentCalculatorViewPanel() {

        // Initialization
        JPanel viewPanel = new JPanel(new GridBagLayout());

        // TODO: Shorter variable names allowed? For example, 2nd and 3rd.
        // Setting up the configuration for car type drop down box.
        GridBagConstraints constraintsForCarTypeDropDownBox = new GridBagConstraints();
        constraintsForCarTypeDropDownBox.anchor = GridBagConstraints.LINE_START; // Anchor component to the left.
        constraintsForCarTypeDropDownBox.gridy = 0; // Position of component is the first in Y order.

        // Setting up the configuration for text fields panel.
        GridBagConstraints constraintsForTextFieldPanels = new GridBagConstraints();
        constraintsForTextFieldPanels.anchor = GridBagConstraints.LINE_START; // Anchor component to the left.
        constraintsForTextFieldPanels.gridy = 1; // Position of component is the second in Y order.

        // Setting up the configuration for the buttons panel.
        GridBagConstraints constraintsForButtons = new GridBagConstraints();
        constraintsForButtons.gridy = 2; // Position of component is third in Y order.
        constraintsForButtons.insets = new Insets(50, 0, 0, 0); // Add gap above.

        // Add the panels to the view panel with their configurations.
        viewPanel.add(setupCarTypeDropDownBoxPanel(), constraintsForCarTypeDropDownBox);
        viewPanel.add(setupTextFieldsPanel(), constraintsForTextFieldPanels);
        viewPanel.add(setupCarLoanInstallmentCalculationButtonPanel(), constraintsForButtons);

        // Return the panel.
        return viewPanel;
    }

    /** Return a panel that contains a dropdown box component.
     * For user to choose between, local and imported car types.
     */
    private JPanel setupCarTypeDropDownBoxPanel() {

        // Initialization
        JPanel carTypeDropDownBoxPanel = new JPanel(new GridBagLayout());

        // Add the dropdown box to the panel
        carTypeDropDownBoxPanel.add(setupCarTypeDropDownBox());

        // Return the car type drop-down box panel.
        return carTypeDropDownBoxPanel;
    }

    /** Returns a JComboBox that is represented as a drop-down box,
     * that contains options that allow users,
     * to choose the desired car type.
     */
    private JComboBox<String> setupCarTypeDropDownBox() {

        // Initialization
        String[] carTypes = {"Imported", "Local"};
        for (String carType : carTypes) {
            carTypeDropDownBox.addItem(carType);
        }

        // Configuring the drop-down box.
        // Set default option to the 0th element in the CARTYPES array.
        carTypeDropDownBox.setSelectedIndex(0);

        // Return the drop-down box.
        return carTypeDropDownBox;
    }

    // TODO: Everything down here, might be a bit redundant/too complex.
    // TODO: If possible, try to simplify, or reduce cognitive load.
    // TODO: If not, get a better naming system lol.
    /** Returns a panel that contains panels that contains text fields,
     * and their respective labels,
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

        // Setting up the configuration for loan term text field panel.
        GridBagConstraints constraintsForLoanTermTextFieldPanel = new GridBagConstraints();
        constraintsForLoanTermTextFieldPanel.insets = new Insets(gapBetweenTextFieldsPanels,
                0, gapBetweenTextFieldsPanels, 0); // Add gap below and above.
        constraintsForLoanTermTextFieldPanel.gridy = 0; // Position of panel is first in Y order.
        constraintsForLoanTermTextFieldPanel.anchor = GridBagConstraints.LINE_START; // Anchor panel to the left.

        // Setting up the configuration for loan amount text field panel.
        GridBagConstraints constraintsForLoanAmountTextFieldPanel = new GridBagConstraints();
        constraintsForLoanAmountTextFieldPanel.gridy = 1; // Position of panel is second in Y order.
        constraintsForLoanAmountTextFieldPanel.anchor = GridBagConstraints.LINE_START; // Anchor panel to the left.

        // Add text fields panels with their configurations.
        textFieldsPanel.add(loanTermTextFieldPanel, constraintsForLoanTermTextFieldPanel);
        textFieldsPanel.add(loanAmountTextFieldPanel, constraintsForLoanAmountTextFieldPanel);

        return textFieldsPanel;
    }

    /** Returns a panel that contains a label and a text field. */
    private JPanel setupTextFieldPanel(String labelForTextField, JTextField textField) {

        // Initialization
        JPanel textFieldPanel = new JPanel(new GridBagLayout());
        JLabel textFieldLabel = new JLabel(labelForTextField);

        // Setting up configurations for label.
        GridBagConstraints constraintsForTextFieldLabel = new GridBagConstraints();
        constraintsForTextFieldLabel.gridy = 0;


        // Setting up configurations for text field.
        GridBagConstraints constraintsForTextField = new GridBagConstraints();
        constraintsForTextField.anchor = GridBagConstraints.LINE_START;
        constraintsForTextField.gridy = 1;
        constraintsForTextField.ipady = 5; // Set the height of the text field, may change to another code later.
        constraintsForTextField.ipadx = 150;

        // Add the components with their configurations.
        textFieldPanel.add(textFieldLabel, constraintsForTextFieldLabel);
        textFieldPanel.add(textField, constraintsForTextField);

        // Return the panel.
        return textFieldPanel;
    }

    /** Returns a panel that contains all the necessary buttons for car loan installment calculation view. */
    private JPanel setupCarLoanInstallmentCalculationButtonPanel() {

        // Initialization.
        JPanel carLoanInstallmentCalculationButtonPanel = new JPanel(new GridBagLayout());
        int heightOfButton = 15;

        // Setting up the configuration for back to main menu button.
        GridBagConstraints constraintsForBackToMainMenuButton = new GridBagConstraints();
        constraintsForBackToMainMenuButton.gridx = 0; // Position of button is first in X order.
        constraintsForBackToMainMenuButton.ipady = heightOfButton; // Height of button.
        constraintsForBackToMainMenuButton.insets = new Insets(0, 0, 0, 20); // Add a gap on the right side.

        // Setting up the configuration for generate summary report button.
        GridBagConstraints constraintsForGenerateSummaryReportButton = new GridBagConstraints();
        constraintsForGenerateSummaryReportButton.gridx = 1; // Position of button is second in X order.
        constraintsForGenerateSummaryReportButton.fill = GridBagConstraints.VERTICAL; // Same height as the button on the left.

        // Add the buttons to the buttons panel with their configurations.
        carLoanInstallmentCalculationButtonPanel.add(backToMainMenuButton, constraintsForBackToMainMenuButton);
        carLoanInstallmentCalculationButtonPanel.add(generateSummaryReportButton, constraintsForGenerateSummaryReportButton);

        // Return the car loan installment calculation button panel.
        return carLoanInstallmentCalculationButtonPanel;
    }
}
