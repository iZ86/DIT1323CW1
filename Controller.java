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
        this.gui.addAllDisplayCarLoanSchemeButtonListener(new DisplayCarLoanSchemeButtonListener());
        this.gui.addAllCalculateCarLoanInstallmentButtonListener(new CalculateCarLoanInstallmentButtonListener());
        this.gui.addAllExitButtonListener(new ExitButtonListener());
        this.gui.addAllBackToMainMenuButtonListener(new BackToMainMenuButtonListener());
        this.gui.addAllCalculateCarLoanInstallmentReportButtonListener(new CalculateCarLoanInstallmentReportButtonListener());
        setupCarLoanSchemeViewTable();
    }

    private void setupCarLoanSchemeViewTable() {
        String[] carLoanTableDataColumn = carLoanSchemeModel.getCarLoanTableDataColumn();
        String[][] carLoanTableData = carLoanSchemeModel.getCarLoanTableData();
        this.gui.setCarLoanSchemeViewTable(carLoanTableData, carLoanTableDataColumn);
    }

    public class DisplayCarLoanSchemeButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.changeView(gui.getCarLoanSchemeViewIndex());
        }

    }

    public class CalculateCarLoanInstallmentButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.changeView(gui.getCarLoanInstallmentCalculatorViewIndex());
        }
    }

    public class ExitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.exit();
        }
    }

    public class BackToMainMenuButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.changeView(gui.getMainMenuViewIndex());
        }
    }

    public class CalculateCarLoanInstallmentReportButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            gui.changeView(gui.getLoanInstallmentReportViewIndex());
        }
    }




}
