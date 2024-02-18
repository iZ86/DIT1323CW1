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

        CarLoanSchemeModel carLoanSchemeModel = new CarLoanSchemeModel();
        CarLoanCalculationModel carLoanCalculationModel = new CarLoanCalculationModel();
        SummaryReportModel summaryReportModel = new SummaryReportModel();
        GUI gui = new GUI(carLoanSchemeModel, summaryReportModel);
        Controller controller = new Controller(gui, carLoanSchemeModel, carLoanCalculationModel);
        gui.display();
    }

    /** To test each individual Views. */
    public static void testIndividualView() {
        JFrame test = new JFrame();

        // Change the method to get the different view Panels.
        test.add(summaryReportViewPanel());

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
        CarLoanSchemeModel carLoanSchemeModel = new CarLoanSchemeModel();
        CarLoanSchemeView carLoanSchemeView = new CarLoanSchemeView(carLoanSchemeModel);
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

    public static JPanel summaryReportViewPanel() {
        SummaryReportModel summaryReportModel = new SummaryReportModel();
        SummaryReportView summaryReportViewPanel = new SummaryReportView(summaryReportModel);
        return summaryReportViewPanel.getSummaryReportViewPanel();

    }
}
