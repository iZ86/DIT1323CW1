import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/** This class represents the kawaguchi bank main menu. */
public class KawaguchiBankMainMenuView {
    private JFrame mainMenuFrame;
    public KawaguchiBankMainMenuView() {
        this.mainMenuFrame = new JFrame();
        this.mainMenuFrame.setSize(new Dimension(700, 500));
        this.mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainMenuFrame.setVisible(true);
        this.mainMenuFrame.add(testHeaderPanel(), BorderLayout.NORTH);
        // TODO: Make the frame work and resizable.
        // TODO: Make the other views, if needed.
    }
    /** This is a test for the header panel. */
    private JPanel testHeaderPanel() {
        // TODO: Figure out how to make the things resizable.
        JPanel testHeader = new JPanel(new BorderLayout());
        testHeader.setBorder(BorderFactory.createEmptyBorder());
        JLabel testMain = new JLabel("test");
        testHeader.add(testMain);
        testHeader.setVisible(true);
        return testHeader;
    }

    /** Creates and returns the header panel. */
    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        JLabel panelLabel = new JLabel("Kawaguchi Bank Car Loan Application");
        headerPanel.setBounds(5, 5, 5, 5);
        panelLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        headerPanel.add(panelLabel);
        return headerPanel;

    }

    /** Creates and return the body panel. */
     private JPanel createMainMenuPanel() {
         JPanel bodyPanel = new JPanel();
         bodyPanel.setBounds(5, 50, 30, 30);
         bodyPanel.setVisible(true);

         JButton displayCarLoanButton = new JButton("Display Car Loan Scheme");
         displayCarLoanButton.setVisible(true);
         bodyPanel.add(displayCarLoanButton);
         return bodyPanel;

     }


}
