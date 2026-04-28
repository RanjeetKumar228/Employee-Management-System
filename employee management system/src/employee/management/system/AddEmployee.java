package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField tname, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation;
    JLabel tempId;
    JDateChooser tdob;

    JComboBox boxEdu;

    JButton add;
    JButton back;

    AddEmployee(){

        getContentPane().setBackground(new Color(163,255,188));

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200,150,200,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);

        JLabel dob = new JLabel("Date of Birth ");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200,200,200,30);
        tdob.setBackground(new Color(177,252,197));
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

        taddress = new JTextField();
        taddress.setBounds(200,350,200,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel empId = new JLabel("Employee Id");
        empId.setBounds(50,400,150,30);
        empId.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empId);

        tempId = new JLabel(""+number);
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

        String[] items = {"B.Tech","BBA","BCA","BA","B.Com","MBA","MA","M.Tech","MSC","PHD"};

        boxEdu= new JComboBox(items);
        boxEdu.setBackground(new Color(177,252,197));
        boxEdu.setBounds(600,200,200,30);
        add(boxEdu);


        JLabel salary = new JLabel("Salary ");
        salary.setBounds(450,250,150,30);
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

        taadhar = new JTextField();
        taadhar.setBounds(600,350,200,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        add = new JButton("ADD");
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
        if (e.getSource() == add){
            String Name = tname.getText();
            String DOB = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String Phone= tphone.getText();
            String Designation = tdesignation.getText();
            String Address = taddress.getText();
            String Fname = tfname.getText();
            String HighEdu = (String) boxEdu.getSelectedItem();
            String Salary = tsalary.getText();
            String Email = temail.getText();
            String Aadhaar = taadhar.getText();

            String empId = tempId.getText();


            try{
                conn c = new conn();
                String query = "INSERT INTO employee(Name,DOB,Phone,Designation,Address,Fname,HighEdu,Salary,Email,Aadhaar,empId) VALUES('"+Name+"','"+DOB+"','"+Phone+"','"+Designation+"','"+Address+"','"+Fname+"','"+HighEdu+"','"+Salary+"','"+Email+"','"+Aadhaar+"','"+empId+"')";

                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
                setVisible(false);
                new Main();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            setVisible(false);
            new Main();
        }
    }

    static void main() {
        new AddEmployee();

    }
}
