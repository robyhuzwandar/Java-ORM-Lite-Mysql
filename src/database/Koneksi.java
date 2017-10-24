package database;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author murabbiprogrammer
 */
public class Koneksi {

    public static ConnectionSource cs() {
        String dbName = "java-new-v2";
        String link = "jdbc:mysql://localhost:3306/" + dbName;
        String user = "root";
        String pass = "";

        ConnectionSource initCs = null;
        try {
            initCs = new JdbcConnectionSource(link, user, pass);

        } catch (SQLException ex) {
            System.out.println("Eror : " + ex);
        }
        return initCs;
    }

    private static Connection konek;

    public static Connection getKonek() {
        if (konek == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/java-new";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                konek = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, "root", "");
                System.out.println("Database berhasil konek");
            } catch (Exception e) {
                System.out.println("GAGAL KONEK " + e);
            }
        }
        return konek;
    }
}
