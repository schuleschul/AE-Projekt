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
            // Pfad kann je nach Betriebssystem anders sein,
            // hauptsache die Datei heißt datenbank.db
            String url = "jdbc:sqlite:/Users/jeyhunr/Documents/JavaWorkSpace/AE-Projekt/datenbank.db";
            // Datenbankverbindung herstellen
            conn = DriverManager.getConnection(url);

            System.out.println("Die Verbindung zu SQLite wurde erfolgreich hergestellt.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}
