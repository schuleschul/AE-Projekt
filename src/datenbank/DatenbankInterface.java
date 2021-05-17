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
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM subjects"); // ich werde noch suchkriterium anpassen
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
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Frage> fragen = new ArrayList<>();
        try {
            conn = Datenbank.verbinden();
            preparedStatement = conn.prepareStatement("SELECT * FROM questions"); // ich werde noch suchkriterium anpassen
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int frageId = resultSet.getInt("question_id");
                int fachId = resultSet.getInt("subject_id");
                String frage = resultSet.getString("question");
                Frage.Schwierigkeit schwierigkeit = Frage.Schwierigkeit.getLevelByValue(resultSet.getInt("question_level"));
                String antwort1 = resultSet.getString("answer1");
                String antwort2 = resultSet.getString("answer2");
                String antwort3 = resultSet.getString("answer3");
                String antwort4 = resultSet.getString("answer4");
                int anzahlRichtigBeantwortet = resultSet.getInt("correct_answered");

                fragen.add(new Frage(frageId, fachId, frage, schwierigkeit, antwort1, antwort2,antwort3,antwort4, anzahlRichtigBeantwortet));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            closeConnection(conn, preparedStatement);
        }
        return fragen;
    }

    public void speichern(Frage frage) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = Datenbank.verbinden();
            preparedStatement = conn.prepareStatement("INSERT INTO questions(subject_id, question, question_level," +
                    "answer1, answer2, answer3, answer4) VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, frage.getFachId());
            preparedStatement.setString(2, frage.getFrage());
            preparedStatement.setInt(3, frage.getSchwierigkeit().getValue());
            preparedStatement.setString(4, frage.getAntwort1());
            preparedStatement.setString(5, frage.getAntwort2());
            preparedStatement.setString(6, frage.getAntwort3());
            preparedStatement.setString(7, frage.getAntwort4());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            closeConnection(conn, preparedStatement);
        }
    }

    public void speichern(Fach fach)
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = Datenbank.verbinden();
            preparedStatement = conn.prepareStatement("INSERT INTO subjects (subject_name) VALUES (?)");
            preparedStatement.setString(1, fach.getBezeichnung());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            closeConnection(conn, preparedStatement);
        }
    }

    public void update(int id, int anzahlRichtigBeantwortet) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = Datenbank.verbinden();
            preparedStatement = conn.prepareStatement("UPDATE questions set correct_answered = ? where question_id = ?");
            preparedStatement.setInt(1, anzahlRichtigBeantwortet);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            closeConnection(conn, preparedStatement);
        }
    }

    private void closeConnection(Connection conn, PreparedStatement preparedStatement) {
        if (preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null ) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
