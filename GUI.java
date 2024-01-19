import javax.swing.*;
import java.awt.*;

public class GUI {
    public void mainMenu(){
    //Creating home page GUI
    JFrame f1 = new JFrame("Main Menu - Kawaguchi Car Loan Application");
    f1.setVisible(true);
    f1.setBounds(425, 200, 700, 500);//Setting size of the home page
    f1.setLayout(null);  

    JLabel l1 = new JLabel("Kawaguchi Bank Car Loan Application");//Home page header
    f1.add(l1);
    l1.setVisible(true);
    l1.setBounds(205,10, 350,30);
    l1.setFont(new Font("Arial", Font.PLAIN, 18));
    

    JButton b1 = new JButton("Display Car Loan Scheme");//Button for display car loan
    f1.add(b1);
    b1.setBounds(240, 80,220,30);
    b1.setLayout(null);
    
    //Display the Car Loan Scheme if presses the button
    b1.addActionListener(e ->{
        LoanScheme();//Display loan scheme fuction
        f1.setVisible(false);//You won't see the main menu after clicking the button
    });

    JButton b2 = new JButton("Calculate Car Loan Installment");//Button for calculate car loan
    f1.add(b2);
    b2.setBounds(240, 130,220,30);
    b2.setLayout(null);

    JButton b3 = new JButton("Generate Summary Report");//Button for generate summary report
    f1.add(b3);
    b3.setBounds(240, 180,220,30);
    b3.setLayout(null);
    
    JButton exit = new JButton("Exit");//Button for exit the program
    f1.add(exit);
    exit.setBounds(275, 260,150,30);
    exit.setLayout(null);
        exit.addActionListener(e ->{
        System.exit(0);
        });
    }


    //Function to make a table for car loan scheme
    public void LoanScheme(){
        JFrame f2 = new JFrame("Car Loan Scheme");
        f2.setVisible(true);
        f2.setBounds(425, 200, 700, 500);
        
        String loans[][] = {
            {"Imported",">300,000","2.35%"},  
            {null,"100,000-300,000","2.55%"},
            {null,"<100,000","2.55%"},
            {"Local",">100,000","3.0%"},
            {null,"50,000-100,000","3.1%"},
            {null,"<50,000","3.2%"},
        };
        String collumn[]= {"Car Type","Loan Amount (RM)","Interest Rate (%)"};
        
      //Car Loan Scheme Table  
      JTable t1 = new JTable(loans, collumn);
      t1.setBounds(200, 250, 500, 400);
      f2.add(t1);
      JScrollPane scroll = new JScrollPane(t1);//Using this to make our screen is not limited
      f2.add(scroll);
      f2.setLayout(null);
      scroll.setBounds(20, 20, 660, 400);
      f2.setVisible(true);
    }
}
