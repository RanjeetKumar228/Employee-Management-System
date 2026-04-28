package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {

    Choice choiceEmpId;

    JButton delete;
    JButton back;

    RemoveEmployee(){

        JLabel label = new JLabel("Employee Id");
        label.setBounds(50,50,100,30);
        label.setFont(new Font("Tahoma",Font.BOLD,15));
        add(label);

        choiceEmpId = new Choice();
        choiceEmpId.setBounds(200,50,150,30);
        add(choiceEmpId);


        try{
            conn c= new conn();
            ResultSet rs = c.stmt.executeQuery("SELECT * FROM employee");

            while (rs.next()){

                choiceEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50,100,100,30);
        labelName.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelName);

        JLabel textName = new JLabel();
        textName.setBounds(200,100,100,30);
        add(textName);


        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(50,150,100,30);
        labelPhone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelPhone);

        JLabel textPhone = new JLabel();
        textPhone.setBounds(200,150,100,30);
        add(textPhone);


        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(50,200,100,30);
        labelEmail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelEmail);

        JLabel textEmail = new JLabel();
        textEmail.setBounds(200,200,120,30);
        add(textEmail);

        try{
            conn c = new conn();
            ResultSet rs = c.stmt.executeQuery("SELECT* FROM employee WHERE empId = '"+choiceEmpId.getSelectedItem()+"'");
            while (rs.next()){
                textName.setText(rs.getString("Name"));
                textPhone.setText(rs.getString("Phone"));
                textEmail.setText(rs.getString("Email"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        choiceEmpId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c = new conn();
                    ResultSet rs = c.stmt.executeQuery("SELECT* FROM employee WHERE empId = '"+choiceEmpId.getSelectedItem()+"'");
                    while (rs.next()){
                        textName.setText(rs.getString("Name"));
                        textPhone.setText(rs.getString("Phone"));
                        textEmail.setText(rs.getString("Email"));
                    }

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setFocusPainted(false);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setFocusPainted(false);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(700,80,200,200);
        add(image);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rBack.jpg"));
        Image i21 = i11.getImage().getScaledInstance(1000,400,Image.SCALE_SMOOTH);
        ImageIcon i31 = new ImageIcon(i21);
        JLabel img = new JLabel(i31);
        img.setBounds(0,0,1000,400);
        add(img);


        setSize(1000,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            try{
                conn c = new conn();
                String query = "delete from employee where empId = '"+choiceEmpId.getSelectedItem()+"'";
                c.stmt.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Employee deleted successfully");
                setVisible(false);
                new Main();

            } catch (Exception ex) {
                System.out.println(e.getSource());
            }
        }else {
            setVisible(false);
        }

    }

    static void main(String[] args) {
        new RemoveEmployee();
    }
}
