import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// TODO: Get logic from controller
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
    /** Loan Installment Report View. */
    private LoanInstallmentReportView loanInstallmentReportView;
    /** Index used to access Main Menu View in JPanel GUIPanel. */
    public static final String mainMenuViewIndex = "MainMenuView";
    /** Index used to access Car Loan Scheme View in JPanel GUIPanel. */
    public static final String carLoanSchemeViewIndex = "CarLoanSchemeView";
    /** Index used to access Car Loan Installment Calculator View in JPanel GUIPanel. */
    public static final String carLoanInstallmentCalculatorViewIndex = "CarLoanInstallmentCalculatorView";
    /** Index used to access Loan Installment Report View in JPanel GUIPanel. */
    public static final String loanInstallmentReportViewIndex = "LoanInstallmentReportView";


    /** A new JFrame with all the view classes. */
    public GUI() {

        GUI = new JFrame("Kawaguchi Bank Car Loan Application");
        GUIPanel = new JPanel(new CardLayout());
        mainMenuView = new MainMenuView();
        carLoanSchemeView = new CarLoanSchemeView();
        carLoanInstallmentCalculatorView = new CarLoanInstallmentCalculatorView();
        loanInstallmentReportView = new LoanInstallmentReportView();

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
        GUIPanel.add(loanInstallmentReportView.getLoanInstallmentReportViewPanel(), loanInstallmentReportViewIndex);
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

    /** Return JPanel mainMenuView. */
    public MainMenuView getMainMenuView() {
        return mainMenuView;
    }

    /** Return JPanel carLoanSchemeView. */
    public CarLoanSchemeView getCarLoanSchemeView() {
        return carLoanSchemeView;
    }

    /** Return JPanel carLoanInstallmentCalculatorView. */
    public CarLoanInstallmentCalculatorView getCarLoanInstallmentCalculatorView() {
        return carLoanInstallmentCalculatorView;
    }

    /** Return JPanel loanInstallmentReportView. */
    public LoanInstallmentReportView getLoanInstallmentReportView() {
        return loanInstallmentReportView;
    }
    
    /** Add ActionListener listenForAllDisplayCarLoanSchemeButton to all JButton displayCarLoanSchemeButton. */
    public void addAllDisplayCarLoanSchemeButtonListener(ActionListener listenForAllDisplayCarLoanSchemeButton) {
        mainMenuView.addDisplayCarLoanSchemeButtonListener(listenForAllDisplayCarLoanSchemeButton);
    }

    /** Add ActionListener listenForAllCalculateCarLoanInstallmentButton to all JButton calculateCarLoanInstallmentButton. */
    public void addAllCalculateCarLoanInstallmentButtonListener(ActionListener listenForAllCalculateCarLoanInstallmentButton) {
        mainMenuView.addCalculateCarLoanInstallmentButtonListener(listenForAllCalculateCarLoanInstallmentButton);
        carLoanSchemeView.addCalculateCarLoanInstallmentButtonListener(listenForAllCalculateCarLoanInstallmentButton);
        loanInstallmentReportView.addCalculateCarLoanInstallmentButtonListener(listenForAllCalculateCarLoanInstallmentButton);
    }

    /** Add ActionListener listenForAllExitButton to all JButton exitButton. */
    public void addAllExitButtonListener(ActionListener listenForAllExitButton) {
        mainMenuView.addExitButtonListener(listenForAllExitButton);
    }

    /** Add ActionListener object to all JButton backToMainMenuButton. */
    public void addAllBackToMainMenuButtonListener(ActionListener listenForAllBackToMainMenuButton) {
        carLoanSchemeView.addBackToMainMenuButtonListener(listenForAllBackToMainMenuButton);
        carLoanInstallmentCalculatorView.addBackToMainMenuButtonListener(listenForAllBackToMainMenuButton);
        loanInstallmentReportView.addBackToMainMenuButtonListener(listenForAllBackToMainMenuButton);
    }

    /** Add ActionListener listenForAllCalculateCarLoanInstallmentReportButtonButton to all JButton calculateCarLoanInstallmentReportButton. */
    public void addAllCalculateCarLoanInstallmentReportButtonListener(ActionListener listenForAllCalculateCarLoanInstallmentReportButton) {
        carLoanInstallmentCalculatorView.addCalculateCarLoanInstallmentReportButtonListener(listenForAllCalculateCarLoanInstallmentReportButton);
    }


}
