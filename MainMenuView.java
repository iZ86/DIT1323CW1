import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

/** This class represents the kawaguchi bank car loan main menu. */
public class MainMenuView {
    private JFrame mainMenuFrame;
    public MainMenuView() {
        // Setting up the frame
        this.mainMenuFrame = new JFrame();
        this.mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainMenuFrame.setLayout(new BorderLayout());
        this.mainMenuFrame.setSize(new Dimension(700, 500));


        // Adding the panels to the frame
        this.mainMenuFrame.add(createHeaderPanel(), BorderLayout.NORTH);
        this.mainMenuFrame.add(createMainMenuPanel(), BorderLayout.CENTER);


        this.mainMenuFrame.setVisible(true);
        // TODO: Make the frame work and resizable.
        // TODO: Make the other views, if needed.
    }

    /** Creates and returns the header panel. */
    private JPanel createHeaderPanel() {
        // Setting up the panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBorder(BorderFactory.createEmptyBorder(70, 0, 0, 0));
        headerPanel.setBackground(Color.black);

        // Setting up the label
        JLabel panelLabel = new JLabel("Kawaguchi Bank Car Loan Application");
        panelLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        panelLabel.setHorizontalAlignment(JLabel.CENTER);

        // Adding the label to the header panel
        headerPanel.add(panelLabel);

        return headerPanel;

    }

    /** Creates and return the body panel. */
    private JPanel createMainMenuPanel() {
        // Setting up the panel
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new GridBagLayout());

        // Setting up the display car loan option button
        JButton displayCarLoanSchemeButton = new JButton("Display Car Loan Scheme");
        displayCarLoanSchemeButton.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.black, 1), BorderFactory.createEmptyBorder(15, 29, 15, 29)));
        // displayCarLoanSchemeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        // TODO: add more buttons.

        // Setting up the calculate car loan installment option button
        JButton calculateCarLoanInstallmentButton = new JButton("Calculate Car Loan Installment");
        calculateCarLoanInstallmentButton.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.black, 1), BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        // calculateCarLoanInstallmentButton.setAlignmentX(Component.CENTER_ALIGNMENT);




        // Setting up constraints
        GridBagConstraints c = new GridBagConstraints();
        GridBagConstraints c1 = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        // Add the buttons to the panel
        bodyPanel.add(displayCarLoanSchemeButton, c);
        c1.gridy = 1;
        c1.insets = new Insets(10, 10, 10 , 10);
        bodyPanel.add(calculateCarLoanInstallmentButton, c1);

        return bodyPanel;

    }

}
