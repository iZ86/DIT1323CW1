

public class Main {
    public static void main(String[] args) {

        CarLoanSchemeModel carLoanSchemeModel = new CarLoanSchemeModel();
        CarLoanCalculationModel carLoanCalculationModel = new CarLoanCalculationModel();
        SummaryReportModel summaryReportModel = new SummaryReportModel();

        GUI gui = new GUI(carLoanSchemeModel, carLoanCalculationModel, summaryReportModel);
        Controller controller = new Controller(gui, carLoanSchemeModel, carLoanCalculationModel, summaryReportModel);

        gui.display();
    }
}
