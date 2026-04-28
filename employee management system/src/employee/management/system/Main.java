package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    Main(){

        ImageIcon img1  = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image     img2  = img1.getImage().getScaledInstance(1120,630,Image.SCALE_SMOOTH);
        ImageIcon img3  = new ImageIcon(img2);
        JLabel    image = new JLabel(img3);
        image.setBounds(0,0,1120,630);
        add(image);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340,155,400,50);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(heading);

        JButton add = new JButton("Add Employee");
        add.setBounds(360,250,120,40);
        add.setBackground(Color.WHITE);
        add.setForeground(Color.BLACK);
        add.setFocusPainted(false);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
            }
        });
        image.add(add);

        JButton view = new JButton("View Employee");
        view.setBounds(520,250,140,40);
        view.setBackground(Color.WHITE);
        view.setForeground(Color.BLACK);
        view.setFocusPainted(false);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ViewEmployee();
            }
        });
        image.add(view);

        JButton remove = new JButton("Remove Employee");
        remove.setBounds(400,350,250,40);
        remove.setBackground(Color.WHITE);
        remove.setForeground(Color.BLACK);
        remove.setFocusPainted(false);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RemoveEmployee();
            }
        });
        image.add(remove);

        setLayout(null);
        setSize(1120,630);
        setLocation(160,60);
        setVisible(true);
    }
    static void main() {
        new Main();
    }
}
