import javax.swing.*;
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
        headerPanel.setBorder(BorderFactory.createEmptyBorder(50, 5, 5, 5));

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
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
        bodyPanel.setBorder(BorderFactory.createEmptyBorder(300, 5, 5, 5));

        // Setting up the buttons
        JButton displayCarLoanButton = new JButton("Display Car Loan Scheme");
        displayCarLoanButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        displayCarLoanButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        // TODO: add more buttons.
        // Add the buttons to the panel
        bodyPanel.add(displayCarLoanButton);

        return bodyPanel;

    }

}
