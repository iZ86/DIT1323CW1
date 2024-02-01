import javax.swing.*;

public class TempMain {

    /** Main used to temporarily work the new MVC implementations. */
    public static void main(String[] args) {
        JFrame test = new JFrame();

        // Change the method to get the different view Panels.
        test.add(carLoanSchemeViewPanel());

        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.pack();
        test.setVisible(true);
    }

    /** Creates a mainMenuView Object and return the panel.
     * For testing purposes
     */
    public static JPanel mainMenuViewPanel() {
        MainMenuView mainMenuView = new MainMenuView();
        return mainMenuView.getMainMenuViewPanel();
    }


    /** Creates a carLoanSchemeView Object and return the panel.
     * For testing purposes
     */
    public static JPanel carLoanSchemeViewPanel() {
        Object loans[][] = {
                {"Imported",">300,000","2.35%"},
                {null,"100,000-300,000","2.55%"},
                {null,"<100,000","2.55%"},
                {"Local",">100,000","3.0%"},
                {null,"50,000-100,000","3.1%"},
                {null,"<50,000","3.2%"},
        };
        String column[]= {"Car Type","Loan Amount (RM)","Interest Rate (%)"};
        CarLoanSchemeView carLoanSchemeView = new CarLoanSchemeView(loans, column);
        return carLoanSchemeView.getCarLoanSchemeViewPanel();
    }
}
