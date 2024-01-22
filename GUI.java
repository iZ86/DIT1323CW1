import javax.swing.*;
import java.awt.*;

public class GUI {
    public void mainMenu(){
    // Creating main menu GUI
    JFrame mainMenuFrame = new JFrame("Main Menu - Kawaguchi Car Loan Application");
    mainMenuFrame.setVisible(true);
    mainMenuFrame.setBounds(425, 200, 700, 500);// Setting size of the home page
    mainMenuFrame.setLayout(null);  

    // Home page header
    JLabel header = new JLabel("Kawaguchi Bank Car Loan Application");
    mainMenuFrame.add(header);
    header.setVisible(true);
    header.setBounds(205,10, 350,30);
    header.setFont(new Font("Arial", Font.PLAIN, 18));
    

    JButton displayScheme = new JButton("Display Car Loan Scheme");// Button for display car loan
    mainMenuFrame.add(displayScheme);
    displayScheme.setBounds(240, 80,220,30);
    displayScheme.setLayout(null);
    
    // Display the Car Loan Scheme if presses the button
    displayScheme.addActionListener(e ->{
        mainMenuFrame.dispose(); // Closes main menu frame 
        LoanScheme(); // Display loan scheme fuction
    });
    
    // Button for calculate car loan
    JButton calcInstallment = new JButton("Calculate Car Loan Installment");
    mainMenuFrame.add(calcInstallment);
    calcInstallment.setBounds(240, 130,220,30);
    calcInstallment.setLayout(null);

    // Add an action to calculate installment button, to closes the main menu and open the calculator page
    calcInstallment.addActionListener(e ->{
        mainMenuFrame.dispose();
        CarLoanGUI();

    });

    

    JButton generateReport = new JButton("Generate Summary Report");// Button for generate summary report
    mainMenuFrame.add(generateReport);
    generateReport.setBounds(240, 180,220,30);
    generateReport.setLayout(null);

    // Add an action to the generate summary report button, when u presses it, it closes the main menu and open the report page
    generateReport.addActionListener(e ->{
        mainMenuFrame.dispose();
        reportPage();
    });    
    
    JButton exit = new JButton("Exit");// Button for exit the program
    mainMenuFrame.add(exit);
    exit.setBounds(275, 260,150,30);
    exit.setLayout(null);
        exit.addActionListener(e ->{
        System.exit(0);
        });
    }


    // Function to make a table for car loan scheme
    public void LoanScheme(){
        JFrame schemeFrame = new JFrame("Car Loan Scheme");
        schemeFrame.setVisible(true);
        schemeFrame.setBounds(425, 200, 700, 500);
        
        String loans[][] = {
            {"Imported",">300,000","2.35%"},  
            {null,"100,000-300,000","2.55%"},
            {null,"<100,000","2.55%"},
            {"Local",">100,000","3.0%"},
            {null,"50,000-100,000","3.1%"},
            {null,"<50,000","3.2%"},
        };
        String column[]= {"Car Type","Loan Amount (RM)","Interest Rate (%)"};
        
      // Car Loan Scheme Table  
      JTable schemeTable = new JTable(loans, column);
      schemeTable.setBounds(200, 250, 500, 250);
      schemeFrame.add(schemeTable);
      JScrollPane scroll = new JScrollPane(schemeTable);// Using this to make our screen is not limited
      schemeFrame.add(scroll);
      schemeFrame.setLayout(null);
      scroll.setBounds(20, 20, 660, 250);
      schemeFrame.setVisible(true);
      schemeTable.setLayout(null);

      // Button for back to main menu
      JButton backMenu = new JButton("Back to Main Menu");
      schemeFrame.add(backMenu);
      backMenu.setLayout(null);
      backMenu.setBounds(30,320,150,35);

      // Adding a function for the button to close the frame of car loan scheme
      backMenu.addActionListener(e ->{
        schemeFrame.dispose();
        mainMenu();
      });

      JButton exit = new JButton("Exit");
      schemeFrame.add(exit);
      exit.setBounds(220,320,150,35);
      exit.setLayout(null);

      exit.addActionListener(e ->{
        System.exit(0);
      });

      //Button for goes to car loan installment calculator
      JButton goToCalculator = new JButton("Calculate Car Loan Installment");
      schemeFrame.add(goToCalculator);
      goToCalculator.setLayout(null);
      goToCalculator.setBounds(400,320,250,35);
      goToCalculator.setVisible(true);

      //If you presses the button calculate car loan installment, it will goes to the Calculation page
      goToCalculator.addActionListener(e->{
        schemeFrame.dispose();
        CarLoanGUI();
      });
    }

    
    //GUI to Calculate Car Loan
    public void CarLoanGUI() {
        JFrame calcFrame = new JFrame("Car Loan Installment Calculator");// Frame for calculate car loan installment
        calcFrame.setBounds(425, 200, 700, 500);
        calcFrame.setLayout(null);
        calcFrame.setVisible(true);

        //Drop down list for choosing car type
        String carType[] = {"Imported", "Local"};
        JComboBox<String> carTypeComboBox = new JComboBox<>(carType);
        calcFrame.add(carTypeComboBox);
        carTypeComboBox.setVisible(true);
        carTypeComboBox.setBounds(20,30, 150,30);
        
        //Button to generates the report
        JButton generateReport = new JButton("Generates Summary Report");
        calcFrame.add(generateReport);
        generateReport.setLayout(null);
        generateReport.setBounds(30,320,200,35);
        
        // Button for back to main menu
        JButton backMenu = new JButton("Back to Main Menu");
        calcFrame.add(backMenu);
        backMenu.setLayout(null);
        backMenu.setBounds(250,320,150,35);

        // Adding a function for the button to close the frame of car loan scheme
        backMenu.addActionListener(e ->{
        calcFrame.dispose();
        mainMenu();
        });

        // Exit button 
        JButton exit = new JButton("Exit");
        calcFrame.add(exit);
        exit.setBounds(420,320,150,35);
        exit.setLayout(null);

        //Add an action for the button exit to close the program
        exit.addActionListener(e ->{
        System.exit(0);
        });

        // Insert Loan Term header
        JLabel loanTerm = new JLabel("Please Insert Your Loan Term (Years)");
        calcFrame.add(loanTerm);
        loanTerm.setBounds(20,70, 250,30);
        loanTerm.setVisible(true);

        // Text Field for Loan Term
        JTextField insertLoanTextField = new JTextField();
        calcFrame.add(insertLoanTextField);
        insertLoanTextField.setVisible(true);
        insertLoanTextField.setBounds(20,100, 150,30);
        
        // Insert loan amount header
        JLabel loanAmount = new JLabel("Please Insert Your Loan Amount (RM)");
        calcFrame.add(loanAmount);
        loanAmount.setBounds(20,130, 250,30);
        loanAmount.setVisible(true);

        // Text field for Insert Loan Amount
        JTextField insertLoanAmountField = new JTextField();
        calcFrame.add(insertLoanAmountField);
        insertLoanAmountField.setVisible(true);
        insertLoanAmountField.setBounds(20,160, 150,30);

        //When you clicks the button Generates Summary Report, if the amount is empty or its <=0, it will required you too input again
        generateReport.addActionListener(e->{
            String valueOfInsertAmountTextField = insertLoanAmountField.getText();
            String valueOfInsertLoanTermTextField = insertLoanTextField.getText();
            
            if (valueOfInsertAmountTextField.equals("") || valueOfInsertLoanTermTextField.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Input Amount and Years");
                
            } else {
                int intValueOfInsertAmountTextField = Integer.parseInt(valueOfInsertAmountTextField);
                int intvalueOfInsertLoanTermTextField = Integer.parseInt(valueOfInsertLoanTermTextField);
                if (intValueOfInsertAmountTextField <= 0 || intvalueOfInsertLoanTermTextField <= 0 ) {
                    JOptionPane.showMessageDialog(null, "Please Input Amount and Years");
                }  
                if(intValueOfInsertAmountTextField > 0 && intvalueOfInsertLoanTermTextField > 0 ){
                    calcFrame.dispose();
                    reportPage();
                } // Added this for goes to the report page, @Isaac pls check if any bug.
            }
            
        });

        // For collect the input
        
    } 
    
    public void reportPage() {
        // Page for show summary report
        JFrame summaryReportFrame = new JFrame("Summary Report Page");
        summaryReportFrame.setBounds(425, 200, 700, 500);
        summaryReportFrame.setLayout(null);
        summaryReportFrame.setVisible(true);

        // Header for summary page 
        JLabel summaryPageHeader = new JLabel("Summary Report Page");
        summaryPageHeader.setBounds(230,10, 350,30);
        summaryPageHeader.setFont(new Font("Arial", Font.BOLD, 18));
        summaryReportFrame.add(summaryPageHeader);

        // Showing the Loan Years
        int years = 0;
        JLabel showLoanYears = new JLabel("Your Total Loan Years is: " + years);
        showLoanYears.setBounds(250,60, 200,30);
        summaryReportFrame.add(showLoanYears);

        // Showing the Loan Amount
        int amount = 0; // To show the loan amount
        JLabel showLoanAmount = new JLabel("Your Total Loan Amount is: RM" + amount);
        showLoanAmount.setBounds(240,110, 200,30);
        summaryReportFrame.add(showLoanAmount);

        int interest = 0; // To show the loan amount
        JLabel showLoanInterest = new JLabel("Your Total Interest Amount is: RM" + interest);
        showLoanInterest.setBounds(230,160, 200,30);
        summaryReportFrame.add(showLoanInterest);

        int monthlyRepayment = 0; // This means that how much the user needs to pay in a month
        JLabel showMonthlyPay = new JLabel("Your Monthly Repayment is: RM" + monthlyRepayment);
        showMonthlyPay.setBounds(230,210, 200,30);
        summaryReportFrame.add(showMonthlyPay);

        JButton exit = new JButton("Exit");
        summaryReportFrame.add(exit);
        exit.setBounds(510,320,150,35);
        exit.setLayout(null);

        exit.addActionListener(e ->{
        System.exit(0);
        });

        // Button for back to main menu
        JButton backMenu = new JButton("Back to Main Menu");
        summaryReportFrame.add(backMenu);
        backMenu.setLayout(null);
        backMenu.setBounds(20,320,150,35);

        // Adding a function for the button to close the frame of car loan scheme
        backMenu.addActionListener(e ->{
        summaryReportFrame.dispose();
        mainMenu();
        });
        
        //Button for goes to car loan installment calculator
        JButton backToCalculator = new JButton("Caulculate a new Car Loan Installment");
        summaryReportFrame.add(backToCalculator);
        backToCalculator.setLayout(null);
        backToCalculator.setBounds(210,320,260,35);
        backToCalculator.setVisible(true);

        //If you presses the button calculate car loan installment, it will goes to the Calculation page
        backToCalculator.addActionListener(e->{
        summaryReportFrame.dispose();
        CarLoanGUI();
        });
        

    }
}
