package konfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datenbank {

    /**
     * Datenbankverbindung
     */
    public static Connection verbinden() {
        Connection conn = null;
        try {
            // Datenbankparameter
            String url = "jdbc:sqlite:datenbank.db";
            // Datenbankverbindung herstellen
            conn = DriverManager.getConnection(url);

//            System.out.println("Die Verbindung zu SQLite wurde erfolgreich hergestellt.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}
