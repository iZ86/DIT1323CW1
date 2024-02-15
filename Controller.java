import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Logic between model and comments
// TODO: Most important is the carLoanSchemeTable

public class Controller {
    GUI gui;
    CarLoanSchemeModel carLoanSchemeModel;
    CarLoanCalculationModel carLoanCalculationModel;

    /** Controller that bridges the gap between GUI and carLoanSchemeModel,
     * and GUI and carLoanCalculationModel.
     */
    public Controller(GUI gui, CarLoanSchemeModel carLoanSchemeModel, CarLoanCalculationModel carLoanCalculationModel) {
        this.gui = gui;
        this.carLoanSchemeModel = carLoanSchemeModel;
        this.carLoanCalculationModel = carLoanCalculationModel;
        this.gui.addAllDisplayCarLoanSchemeButtonListener(new displayCarLoanSchemeButtonListener());
        this.gui.addAllCalculateCarLoanInstallmentButtonListener(new calculateCarLoanInstallmentButtonListener());
        this.gui.addAllExitButtonListener(new exitButtonListener());
        this.gui.addAllBackToMainMenuButtonListener(new backToMainMenuButtonListener());
        this.gui.addAllCalculateCarLoanButtonListener(new calculateCarLoanButtonListener());
    }

    public class displayCarLoanSchemeButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.changeView(gui.getCarLoanSchemeViewIndex());
        }

    }

    public class calculateCarLoanInstallmentButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.changeView(gui.getCarLoanInstallmentCalculatorViewIndex());
        }
    }

    public class exitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.exit();
        }
    }

    public class backToMainMenuButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.changeView(gui.getMainMenuViewIndex());
        }
    }

    public class calculateCarLoanButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.changeView(gui.getSummaryReportViewIndex());
        }
    }




}
