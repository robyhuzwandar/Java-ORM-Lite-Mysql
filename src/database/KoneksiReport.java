/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author MurabbiProgrammer
 */
public class KoneksiReport {

    private String Database = "java-new-v2";
    private String Server = "jdbc:mysql://localhost/" + Database;
    private String Username = "root";
    private String Password = "";
    private Connection kon = null;
    private Statement statement = null;

    public KoneksiReport() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            kon = DriverManager.getConnection(Server, Username, Password);
            statement = (Statement) kon.createStatement();
//            JOptionPane.showMessageDialog(null,"berhasil terkoneksi");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal terkoneksi ke database" + e.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Gagal terkoneksi ke database" + ex.getMessage());
        }

    }

    public Connection getKon() {
        return kon;
    }

    public Statement getStatement() {
        return statement;
    }

}
