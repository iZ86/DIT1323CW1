import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// TODO: Get logic from controller
// TODO: Most important is the carLoanSchemeTable
// TODO: Maybe change the index variables to static.

public class GUI {
    /** GUI. */
    private JFrame GUI;
    /** JPanel of the GUI. */
    private JPanel GUIPanel;
    /** Main Menu View. */
    private MainMenuView mainMenuView;
    /** Car Loan Scheme View. */
    private CarLoanSchemeView carLoanSchemeView;
    /** Car Loan Installment Calculator View. */
    private CarLoanInstallmentCalculatorView carLoanInstallmentCalculatorView;
    /** Summary Report View. */
    private SummaryReportView summaryReportView;
    /** Index used to access Main Menu View in JPanel GUIPanel. */
    private String mainMenuViewIndex = "MainMenuView";
    /** Index used to access Car Loan Scheme View in JPanel GUIPanel. */
    private String carLoanSchemeViewIndex = "CarLoanSchemeView";
    /** Index used to access Car Loan Installment Calculator View in JPanel GUIPanel. */
    private String carLoanInstallmentCalculatorViewIndex = "CarLoanInstallmentCalculatorView";
    /** Index used to access Summary Report View in JPanel GUIPanel. */
    private String summaryReportViewIndex = "SummaryReportView";


    /** A new JFrame with all the view classes. */
    public GUI() {

        GUI = new JFrame("Kawaguchi Bank Car Loan Application");
        GUIPanel = new JPanel(new CardLayout());
        mainMenuView = new MainMenuView();
        carLoanSchemeView = new CarLoanSchemeView();
        carLoanInstallmentCalculatorView = new CarLoanInstallmentCalculatorView();
        summaryReportView = new SummaryReportView();

        setupGUI();

        GUI.add(GUIPanel);

        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setSize(new Dimension(700, 500));
    }

    /** Adds all the view panels to the main JPanel GUIPanel. */
    private void setupGUI() {
        GUIPanel.add(mainMenuView.getMainMenuViewPanel(), mainMenuViewIndex);
        GUIPanel.add(carLoanSchemeView.getCarLoanSchemeViewPanel(), carLoanSchemeViewIndex);
        GUIPanel.add(carLoanInstallmentCalculatorView.getCarLoanInstallmentCalculatorViewPanel(),
                carLoanInstallmentCalculatorViewIndex);
        GUIPanel.add(summaryReportView.getSummaryReportViewPanel(), summaryReportViewIndex);
    }

    /** Displays the GUI. */
    public void display() {
        GUI.setVisible(true);
    }

    /** Exits the GUI. */
    public void exit() {
        GUI.dispose();
    }

    /** Changes the view of the GUI. */
    public void changeView(String index) {
        CardLayout cl = (CardLayout) (GUIPanel.getLayout());
        cl.show(GUIPanel, index);
    }

    /** Return String mainMenuViewIndex. */
    public String getMainMenuViewIndex() {
        return mainMenuViewIndex;
    }

    /** Return String carLoanSchemeViewIndex. */
    public String getCarLoanSchemeViewIndex() {
        return carLoanSchemeViewIndex;
    }

    /** Return String carLoanInstallmentCalculationViewIndex. */
    public String getCarLoanInstallmentCalculatorViewIndex() {
        return carLoanInstallmentCalculatorViewIndex;
    }

    /** Return String summaryReportViewIndex. */
    public String getSummaryReportViewIndex() {
        return summaryReportViewIndex;
    }
    
    /** Add ActionListener listenForAllDisplayCarLoanSchemeButton to all JButton displayCarLoanSchemeButton. */
    public void addAllDisplayCarLoanSchemeButtonListener(ActionListener listenForAllDisplayCarLoanSchemeButton) {
        mainMenuView.addDisplayCarLoanSchemeButtonListener(listenForAllDisplayCarLoanSchemeButton);
    }

    /** Add ActionListener listenForAllCalculateCarLoanInstallmentButton to all JButton calculateCarLoanInstallmentButton. */
    public void addAllCalculateCarLoanInstallmentButtonListener(ActionListener listenForAllCalculateCarLoanInstallmentButton) {
        mainMenuView.addCalculateCarLoanInstallmentButtonListener(listenForAllCalculateCarLoanInstallmentButton);
        carLoanSchemeView.addCalculateCarLoanInstallmentButtonListener(listenForAllCalculateCarLoanInstallmentButton);
        summaryReportView.addCalculateCarLoanInstallmentButtonListener(listenForAllCalculateCarLoanInstallmentButton);
    }

    /** Add ActionListener listenForAllExitButton to all JButton exitButton. */
    public void addAllExitButtonListener(ActionListener listenForAllExitButton) {
        mainMenuView.addExitButtonListener(listenForAllExitButton);
    }

    /** Add ActionListener object to all JButton backToMainMenuButton. */
    public void addAllBackToMainMenuButtonListener(ActionListener listenForAllBackToMainMenuButton) {
        carLoanSchemeView.addBackToMainMenuButtonListener(listenForAllBackToMainMenuButton);
        carLoanInstallmentCalculatorView.addBackToMainMenuButtonListener(listenForAllBackToMainMenuButton);
        summaryReportView.addBackToMainMenuButtonListener(listenForAllBackToMainMenuButton);
    }

    /** Add ActionListener listenForAllCalculateCarLoanInstallmentReportButtonButton to all JButton calculateCarLoanInstallmentReportButton. */
    public void addAllCalculateCarLoanInstallmentReportButtonListener(ActionListener listenForAllCalculateCarLoanInstallmentReportButton) {
        carLoanInstallmentCalculatorView.addCalculateCarLoanInstallmentReportButtonListener(listenForAllCalculateCarLoanInstallmentReportButton);
    }


}
