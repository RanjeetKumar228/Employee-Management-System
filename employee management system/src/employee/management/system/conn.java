package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

    Connection conn;
    Statement stmt;

    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/employeeManagement";
            String user = "root";
            String pass = "";

            conn = DriverManager.getConnection(url, user, pass);

            stmt = conn.createStatement();
        } catch (Exception e) {
            System.out.println("Connection failed");
            System.out.println(e.getMessage());
        }
    }

    static void main() throws ClassNotFoundException {
        new conn();
    }
}
