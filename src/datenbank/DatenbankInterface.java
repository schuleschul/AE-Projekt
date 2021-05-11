package datenbank;

import backend.Fach;
import backend.FachSuchkriterium;
import backend.Frage;
import backend.FragenSuchkriterium;
import konfiguration.Datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatenbankInterface
{
    public ArrayList<Fach> laden(FachSuchkriterium suchkriterium)
    {
        Connection conn = null;
        ArrayList<Fach> faecher = new ArrayList<>();
        try {
            conn = Datenbank.verbinden();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM subject"); // ich werde noch suchkriterium anpassen
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int fachId = resultSet.getInt("subject_id");
                String bezeichnung = resultSet.getString("subject_name");
                faecher.add(new Fach(fachId, bezeichnung));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (conn != null ) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return faecher;
    }

    public ArrayList<Frage> laden(FragenSuchkriterium suchkriterium)
    {
        Connection conn = Datenbank.verbinden();
        ArrayList<Frage> fragen = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM questions"); // ich werde noch suchkriterium anpassen
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int frageId = resultSet.getInt("question_id");
                String frage = resultSet.getString("question");
                int antwortId = resultSet.getInt("answer_id");
                int fachId = resultSet.getInt("subject_id");
                int frageNiveau = resultSet.getInt("question_level");
                fragen.add(new Frage(frageId, frage, fachId, antwortId, frageNiveau));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return fragen;
    }

    public void speichern(Frage frage)
    {
        Connection conn = null;

        try {
            conn = Datenbank.verbinden();
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT questions INTO subject VALUES (?,?,?,?)");
            preparedStatement.setString(1, frage.getFach());
            preparedStatement.setString(2, frage.getRichtigeAntwort());
            preparedStatement.setString(3, frage.getFrage());
            preparedStatement.setInt(4, frage.getSchwierigkeit().getValue());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (conn != null ) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void speichern(Fach fach)
    {
        Connection conn = null;

        try {
            conn = Datenbank.verbinden();
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT subjcet_name INTO subject VALUES (?)");
            preparedStatement.setNString(1, fach.getBezeichnung());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (conn != null ) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void update(int id, int anzahlRichtigBeantwortet)
    {

    }
}
