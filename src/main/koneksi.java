package main;

import java.sql.*;
import javax.swing.JOptionPane;

public class koneksi {
    private String url = "jdbc:mysql://localhost/db_pbb";
    private String user = "root";
    private String pass = "";
    Connection con;
    
    public void connect(){
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("berhasil konek");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Connection getCon() {
        return con;
    }
    
}
