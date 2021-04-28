package main;

import konfiguration.Datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Datenbank db = new Datenbank();
        Connection conn = db.verbinden();
        try {
            conn.setCatalog("datenbank");
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM subjects");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               int fachId = resultSet.getInt("subject_id");
               String fachName = resultSet.getString("subject_name");
                System.out.println(fachId);
                System.out.println(fachName);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
           try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
