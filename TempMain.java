import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class TempMain {

    /** Main used to temporarily work the new MVC implementations. */
    public static void main(String[] args) {
        testProgram();
    }

    /** To test the whole program. */
    public static void testProgram() {
        GUI gui = new GUI();
        CarLoanSchemeModel carLoanSchemeModel = new CarLoanSchemeModel();
        CarLoanCalculationModel carLoanCalculationModel = new CarLoanCalculationModel();
        Controller controller = new Controller(gui, carLoanSchemeModel, carLoanCalculationModel);
        gui.display();
    }

    /** To test each individual Views. */
    public static void testIndividualView() {
        JFrame test = new JFrame();

        // Change the method to get the different view Panels.
        test.add(mainMenuViewPanel());

        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setSize(new Dimension(700, 500));
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
        CarLoanSchemeView carLoanSchemeView = new CarLoanSchemeView();
        carLoanSchemeView.setCarLoanSchemeTable(loans, column);
        return carLoanSchemeView.getCarLoanSchemeViewPanel();
    }

    public static JPanel carLoanInstallmentCalculatorViewPanel() {
        CarLoanInstallmentCalculatorView clim = new CarLoanInstallmentCalculatorView();
        return clim.getCarLoanInstallmentCalculatorViewPanel();
    }

    public static JPanel loanInstallmentReportViewPanel() {
        LoanInstallmentReportView LIRV = new LoanInstallmentReportView();
        return LIRV.getLoanInstallmentReportViewPanel();
    }
}
