package employee.management.system;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Arrays;

public class Login extends JFrame implements ActionListener {

    JTextField tUserName;
    JPasswordField tPassword;
    JButton LoginBtn;
    JButton BackBtn;

    Login(){
        setLayout(null);


        JLabel userName = new JLabel("User Name  ");
        userName.setBounds(40,30,100,40);
        add(userName);

        tUserName = new JTextField();
        tUserName.setBounds(150,40,150,20);
        add(tUserName);


        JLabel password = new JLabel("Password  ");
        password.setBounds(40,60,100,40);
        add(password);

        tPassword = new JPasswordField();
        tPassword.setBounds(150,70,150,20);
        add(tPassword);


        LoginBtn = new JButton("Login");
        LoginBtn.setBounds(150,110,150,25);
        LoginBtn.setBackground(Color.BLACK);
        LoginBtn.setForeground(Color.WHITE);
        LoginBtn.setFocusPainted(false);
        LoginBtn.addActionListener(this);
        add(LoginBtn);

        BackBtn = new JButton("Back");
        BackBtn.setBounds(150,160,150,25);
        BackBtn.setBackground(Color.BLACK);
        BackBtn.setForeground(Color.WHITE);
        BackBtn.setFocusPainted(false);
        BackBtn.addActionListener(this);
        add(BackBtn);

        ImageIcon img11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image img22 = img11.getImage().getScaledInstance(500,500,Image.SCALE_SMOOTH);
        ImageIcon img33 = new ImageIcon(img22);
        JLabel imagee = new JLabel(img33);
        imagee.setBounds(360,30,500,500);
        add(imagee);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/loginB.jpg"));
        Image img2 = img1.getImage().getScaledInstance(700,400,Image.SCALE_SMOOTH);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0,0,700,400);
        add(image);


        setSize(700,400);
        setLocation(350,150);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == LoginBtn) {
            try{
                String username = tUserName.getText();
                String password = tPassword.getText();

                conn conn = new conn();

                String query = "select * from login where name = '"+username+"' and password = '"+password+"'";

                ResultSet rs = conn.stmt.executeQuery(query);

                if (rs.next()){
                    setVisible(false);
                    new Main();
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        } else if (e.getSource() == BackBtn) {
            System.exit(369);
        }
    }

    static void main() {
        Login lg = new Login();
    }
}
