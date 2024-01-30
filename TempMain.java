import javax.swing.*;

public class TempMain {

    /** Main used to temporarily work the new MVC implementations. */
    public static void main(String[] args) {
        MainMenuView mainMenuView = new MainMenuView();
        JFrame test = new JFrame();
        test.add(mainMenuView.getMainMenuViewPanel());
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.pack();
        test.setVisible(true);
    }
}
