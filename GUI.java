import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/** The GUI of Kawaguchi Bank Loan Application. */
public class GUI {
    /** GUI JFrame. */
    private final JFrame GUI;
    /** JPanel of the GUI. */
    private final JPanel GUIPanel;
    /** Main Menu View. */
    private final MainMenuView mainMenuView;
    /** Car Loan Scheme View. */
    private final CarLoanSchemeView carLoanSchemeView;
    /** Car Loan Installment Calculator View. */
    private final CarLoanInstallmentCalculatorView carLoanInstallmentCalculatorView;
    /** Loan Installment Report View. */
    private final LoanInstallmentReportView loanInstallmentReportView;
    /** Summary Report View. */
    private final SummaryReportView summaryReportView;
    /** Index used to access Main Menu View in JPanel GUIPanel. */
    public static final String MAINMENUVIEWINDEX = "MainMenuView";
    /** Index used to access Car Loan Scheme View in JPanel GUIPanel. */
    public static final String CARLOANSCHEMEVIEWINDEX = "CarLoanSchemeView";
    /** Index used to access Car Loan Installment Calculator View in JPanel GUIPanel. */
    public static final String CARLOANINSTALLMENTCALCULATORVIEWINDEX = "CarLoanInstallmentCalculatorView";
    /** Index used to access Loan Installment Report View in JPanel GUIPanel. */
    public static final String LOANINSTALLMENTREPORTVIEWINDEX = "LoanInstallmentReportView";
    /** Index used to access Summary Report View in JPanel GUIPanel. */
    public static final String SUMMARYREPORTVIEWINDEX = "SummaryReportView";


    /** A new JFrame with all the view classes, that acts as the GUI. */
    public GUI(CarLoanSchemeModel carLoanSchemeModel, CarLoanCalculationModel carLoanCalculationModel, SummaryReportModel summaryReportModel) {

        GUI = new JFrame("Kawaguchi Bank Car Loan Application");
        GUIPanel = new JPanel(new CardLayout());
        mainMenuView = new MainMenuView();
        carLoanSchemeView = new CarLoanSchemeView(carLoanSchemeModel);
        carLoanInstallmentCalculatorView = new CarLoanInstallmentCalculatorView();
        loanInstallmentReportView = new LoanInstallmentReportView(carLoanCalculationModel);
        summaryReportView = new SummaryReportView(summaryReportModel);

        setupGUI();

        // Add JPanel GUIPane to JFrame GUI.
        GUI.add(GUIPanel);

        // Configuring JFrame GUI.
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setSize(new Dimension(700, 500));
    }

    /** Adds all the view panels with their respective indexes to JPanel GUIPanel. */
    private void setupGUI() {
        GUIPanel.add(mainMenuView.getMainMenuViewPanel(), MAINMENUVIEWINDEX);
        GUIPanel.add(carLoanSchemeView.getCarLoanSchemeViewPanel(), CARLOANSCHEMEVIEWINDEX);
        GUIPanel.add(carLoanInstallmentCalculatorView.getCarLoanInstallmentCalculatorViewPanel(),
                CARLOANINSTALLMENTCALCULATORVIEWINDEX);
        GUIPanel.add(loanInstallmentReportView.getLoanInstallmentReportViewPanel(), LOANINSTALLMENTREPORTVIEWINDEX);
        GUIPanel.add(summaryReportView.getSummaryReportViewPanel(), SUMMARYREPORTVIEWINDEX);
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

    /** Return JPanel summaryReportView. */
    public SummaryReportView getSummaryReportView() {
        return summaryReportView;
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

    /** Add ActionListener listenForAllGenerateSummaryReportButton to all JButton generateSummaryReportButton. */
    public void addAllGenerateSummaryReportButtonListener(ActionListener listenForAllGenerateSummaryReportButton) {
        mainMenuView.addGenerateSummaryReportButtonListener(listenForAllGenerateSummaryReportButton);
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
        summaryReportView.addBackToMainMenuButtonListener(listenForAllBackToMainMenuButton);
    }

    /** Add ActionListener listenForAllCalculateCarLoanInstallmentReportButtonButton to all JButton calculateCarLoanInstallmentReportButton. */
    public void addAllCalculateCarLoanInstallmentReportButtonListener(ActionListener listenForAllCalculateCarLoanInstallmentReportButton) {
        carLoanInstallmentCalculatorView.addCalculateCarLoanInstallmentReportButtonListener(listenForAllCalculateCarLoanInstallmentReportButton);
    }
}
