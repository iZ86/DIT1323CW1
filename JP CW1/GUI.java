import javax.swing.*;
import java.awt.*;

public class GUI {
    public void run(){
    //Creating home page GUI
    JFrame f1 = new JFrame("Home Page");
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
    b1.setBounds(250, 50,220,30);
    b1.setLayout(null);

    }
}
