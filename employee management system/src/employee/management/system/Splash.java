package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    Splash(){

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpeg"));
        Image img2 = img1.getImage().getScaledInstance(1170,650, Image.SCALE_SMOOTH);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
         image.setBounds(0,0,1170,650);
        add(image);


        setSize(1170,650);
        setLocation(100,50);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        try {
            Thread.sleep(6000);
            setVisible(false);
            new Login();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    static void main(String[] args) {
        Splash sp = new Splash();
    }
}
