import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

/** This class represents the kawaguchi bank car loan main menu. */
public class MainMenuView {
    private JPanel mainMenuViewPanel;

    public MainMenuView() {
        this.mainMenuViewPanel = setupMainMenuViewPanel();

    }

    public JPanel getMainMenuViewPanel() {
        return mainMenuViewPanel;
    }

    private JPanel setupMainMenuViewPanel() {

        JPanel mainMenuViewPanel = new JPanel();
        mainMenuViewPanel.setLayout(new BorderLayout());
        mainMenuViewPanel.add(mainMenuTitlePanel(), BorderLayout.NORTH);
        //mainMenuViewPanel.add(mainMenuButtonsPanel(), BorderLayout.CENTER);

        return mainMenuViewPanel;
    }

    private JPanel mainMenuTitlePanel() {
        JPanel mainMenuTitlePanel = new JPanel();
        JLabel mainMenuTitle = new JLabel("Kawaguchi Bank Car Loan Application");
        mainMenuTitle.setFont(new Font("Arial", Font.PLAIN, 18));
        mainMenuTitlePanel.add(mainMenuTitle, BorderLayout.CENTER);
        return mainMenuTitlePanel;
    }

    private JPanel mainMenuButtonsPanel() {
        return null;
    }
}
