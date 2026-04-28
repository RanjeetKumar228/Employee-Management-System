package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {
    JTextField  tfname,teducation, tphone, temail, tsalary, tdesignation, taadhar, taddress;
    JLabel tempId;
    JButton add;
    JButton back;
    JComboBox boxEdu;
    String number;

    UpdateEmployee(String number){

        this.number = number;

        getContentPane().setBackground(new Color(163,255,188));

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(200,150,200,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel dob = new JLabel("Date of Birth ");
        dob.setBounds(50,200,250,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(200,200,150,30);
        tdob.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(tdob);


        JLabel phone = new JLabel("Phone number ");
        phone.setBounds(50,250,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(200,250,200,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        JLabel designation = new JLabel("Designation ");
        designation.setBounds(50,300,150,30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200,300,200,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);

        JLabel Address = new JLabel("Address");
        Address.setBounds(50,350,150,30);
        Address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(Address);

        JLabel taddress = new JLabel();
        taddress.setBounds(200,350,200,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel empId = new JLabel("Employee Id");
        empId.setBounds(50,400,150,30);
        empId.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empId);

        tempId = new JLabel();
        tempId.setBounds(200,400,200,30);
        tempId.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        tempId.setForeground(Color.red);
        add(tempId);


        JLabel fname = new JLabel("Father's Name ");
        fname.setBounds(450,150,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,200,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        JLabel education = new JLabel("Highest Education ");
        education.setBounds(450,200,150,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(education);

        teducation = new JTextField();
        teducation.setBounds(600,200,200,30);
        teducation.setBackground(new Color(177,252,197));
        add(teducation);

        JLabel salary = new JLabel("Salary ");
        salary.setBounds(450,250,200,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600,250,200,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        JLabel email = new JLabel("Email ");
        email.setBounds(450,300,200,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);

        temail = new JTextField();
        temail.setBounds(600,300,200,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);

        JLabel aadhar = new JLabel("Aadhaar ");
        aadhar.setBounds(450,350,200,30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(aadhar);

        JLabel taadhar = new JLabel();
        taadhar.setBounds(600,350,200,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        try{
            conn c = new conn();
            String query = "SELECT * FROM employee WHERE empId = '"+number+"'";
            ResultSet rs = c.stmt.executeQuery(query);

            while (rs.next()){
                tname.setText(rs.getString("Name"));
                tdob.setText(rs.getString("DOB"));
                tphone.setText(rs.getString("Phone"));
                tdesignation.setText(rs.getString("Designation"));
                taddress.setText(rs.getString("Address"));
                tfname.setText(rs.getString("Fname"));
                teducation.setText(rs.getString("HighEdu"));
                tsalary.setText(rs.getString("Salary"));
                temail.setText(rs.getString("Email"));
                taadhar.setText(rs.getString("Aadhaar"));
                tempId.setText(rs.getString("empId"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        add = new JButton("UPDATE");
        add.setBounds(275,475,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.setFocusPainted(false);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(470,475,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.addActionListener(this);
        add(back);

        setLayout(null);
        setSize(900,600);
        setLocation(250,60);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String phone= tphone.getText();
            String designation = tdesignation.getText();
            String email = temail.getText();
            String edu   = teducation.getText();

            try{
                conn c = new conn();
                String query = "UPDATE employee SET Fname='"+fname+"',Salary='"+salary+"',Phone='"+phone+"',Designation='"+designation+"',Email='"+email+"',HighEdu='"+edu+"' WHERE empId = '"+number+"'";
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details update successfully");
                setVisible(false);
                new Main();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }else{
            setVisible(false);
            new ViewEmployee();
        }

    }

    static void main(String[] args) {
        new UpdateEmployee("");
    }
}
