package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener{

    Choice ChoiceEmpId;

    JButton searchBtn;
    JButton printBtn;
    JButton updateBtn;
    JButton backBtn;

    JTable table;

    ViewEmployee(){

        ChoiceEmpId = new Choice();
        ChoiceEmpId.setBounds(150,20,150,20);
        add(ChoiceEmpId);

        getContentPane().setBackground(new Color(255,131,122));

        JLabel search = new JLabel("search by employee id");
        search.setBounds(20,20,150,20);
        add(search);

        try{
            conn c =new conn();
            ResultSet rs = c.stmt.executeQuery("SELECT * FROM employee");
            while(rs.next()){
                ChoiceEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        table = new JTable();

        try{
            conn c = new conn();
            ResultSet rs = c.stmt.executeQuery("SELECT * FROM employee");

            while (rs.next()){
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(20,70,80,20);
        searchBtn.setFocusPainted(false);
        searchBtn.addActionListener(this);
        add(searchBtn);

        printBtn = new JButton("Print");
        printBtn.setBounds(120,70,80,20);
        printBtn.setFocusPainted(false);
        printBtn.addActionListener(this);
        add(printBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(220,70,80,20);
        updateBtn.setFocusPainted(false);
        updateBtn.addActionListener(this);
        add(updateBtn);

        backBtn = new JButton("Back button");
        backBtn.setBounds(320,70,110,20);
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(this);
        add(backBtn);


        setLocation(260,80);
        setSize(900,600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchBtn) {
            String query = "SELECT * FROM employee WHERE empId = '"+ChoiceEmpId.getSelectedItem()+"'";
            try{
                conn c = new conn();
                ResultSet rs = c.stmt.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else if (e.getSource() == printBtn) {
            try{
                table.print();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else if (e.getSource() == updateBtn) {
            setVisible(false);
            new UpdateEmployee(ChoiceEmpId.getSelectedItem());
        } else if (e.getSource() == backBtn) {
            setVisible(false);
            new Main();
        }
    }

    static void main() {
        new ViewEmployee();
    }
}
