package datenbank;

import backend.*;
import konfiguration.Datenbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatenbankInterface
{
    Frage.Schwierigkeit schwierigkeiten[] = Frage.Schwierigkeit.values();

    // alle Themengebiete aus der Datenbank laden
    public ArrayList<Thema> laden(FachSuchkriterium suchkriterium)
    {
        Connection conn = null;
        ArrayList<Thema> faecher = new ArrayList<>();
        try {
            conn = Datenbank.verbinden();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM subjects");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int fachId = resultSet.getInt("subject_id");
                String bezeichnung = resultSet.getString("subject_name");
                faecher.add(new Thema(fachId, bezeichnung));
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

    // alle Fragen aus der Datenbank laden
    // alle Fragen nach Suchkriterien aus der Datenbank laden
    public ArrayList<Frage> laden(FragenSuchkriterium suchkriterium)
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Frage> fragen = new ArrayList<>();
        try {
            conn = Datenbank.verbinden();
            StringBuilder query = new StringBuilder("SELECT * FROM questions");

            // Suchkriterien, wenn Frageschwierigkeit und Thema eingegeben ist
            // oder wenn nur Thema eingegeben ist
            if (suchkriterium.getSchwierigkeit()!=null && suchkriterium.getFachId()!=null) {
                query.append(" WHERE subject_id=? AND question_level=?");
            } else if(suchkriterium.getFachId()!=null) { //
                query.append("WHERE subject_id=?");
            }
            preparedStatement = conn.prepareStatement(query.toString());

            if (suchkriterium.getSchwierigkeit() != null && suchkriterium.getFachId()!=null) {
                preparedStatement.setInt(1, suchkriterium.getFachId());
                preparedStatement.setInt( 2, suchkriterium.getSchwierigkeit().ordinal());
            } else if(suchkriterium.getFachId()!=null){
                preparedStatement.setInt(1, suchkriterium.getFachId());
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            //es wird bei jedem Aufruf eine Kopie des Arrays erstellt, weshalb es wesentlich effizienter ist, dieses Array einmalig zu cachen, statt in der folgenden Schleife jedes Mal neu zu initialisieren
//            Frage.Schwierigkeit schwierigkeiten[] = Frage.Schwierigkeit.values();
            while (resultSet.next()) {
                int frageId = resultSet.getInt("question_id");
                int fachId = resultSet.getInt("subject_id");
                String frage = resultSet.getString("question");
                Frage.Schwierigkeit schwierigkeit = schwierigkeiten[(resultSet.getInt("question_level"))];
                String antwort1 = resultSet.getString("answer1");
                String antwort2 = resultSet.getString("answer2");
                String antwort3 = resultSet.getString("answer3");
                String antwort4 = resultSet.getString("answer4");
                int anzahlRichtigBeantwortet = resultSet.getInt("correct_answered");
                ArrayList falscheAntworten = new ArrayList();
                falscheAntworten.add(antwort2);
                falscheAntworten.add(antwort3);
                falscheAntworten.add(antwort4);

                fragen.add(new Frage(frage, antwort1, falscheAntworten, schwierigkeit, frageId, fachId, anzahlRichtigBeantwortet));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            closeConnection(conn, preparedStatement);
        }
        return fragen;
    }

    // alle Bilder, die zugeh??riges Thema aus der Datenbank laden
    public Bild bilderLaden(int subjectId) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = Datenbank.verbinden();
            preparedStatement = conn.prepareStatement("SELECT * FROM images where subject_id=?");
            preparedStatement.setInt(1, subjectId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer bildId = resultSet.getInt("image_id");
                Integer fachId = resultSet.getInt("subject_id");
                String fachBild = resultSet.getString("subject_image");
                String richtigBild = resultSet.getString("true_image");
                String falschBild = resultSet.getString("false_image");
                return new Bild(bildId, fachId, fachBild, richtigBild, falschBild);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            closeConnection(conn, preparedStatement);
        }
        return null;
    }

    // Fragen in die Datenbank eintragen
    public void speichern(Frage frage) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = Datenbank.verbinden();
            preparedStatement = conn.prepareStatement("INSERT INTO questions(subject_id, question, question_level," +
                    "answer1, answer2, answer3, answer4) VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, frage.getFachId());
            preparedStatement.setString(2, frage.getFrage());
            preparedStatement.setInt(3, frage.getSchwierigkeit().ordinal());
            preparedStatement.setString(4, frage.getRichtigeAntwort());
            for(int i = 0; i<3; ++i)
            {
                preparedStatement.setString((i+5), frage.getFalscheAntworten().get(i));
            }
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            closeConnection(conn, preparedStatement);
        }
    }

    // Themen in die Datenbank eintragen
    public void speichern(Thema thema)
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = Datenbank.verbinden();
            preparedStatement = conn.prepareStatement("INSERT INTO subjects (subject_name) VALUES (?)");
            preparedStatement.setString(1, thema.getBezeichnung());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            closeConnection(conn, preparedStatement);
        }
    }

    // Anzahl der richtig beantworteten Fragen aktualisieren
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

    //nur das outline
    // aktuelles Level aus der Datenbank laden
    public int getCurrentLevel(int subjectId)
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = Datenbank.verbinden();
            preparedStatement = conn.prepareStatement("SELECT * FROM current_state where subject_id=?");
            preparedStatement.setInt(1, subjectId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Integer subjectIdFromDb = resultSet.getInt("subject_id");
                Integer currentLavel = resultSet.getInt("current_level");
                return currentLavel;
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            closeConnection(conn, preparedStatement);
        }
        return 0;
    }

    // Stand des Spielers in der Datenbank aktualisieren
    public void updatCurrentLevel (int subjectId, int level) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = Datenbank.verbinden();
            preparedStatement = conn.prepareStatement("UPDATE current_state set current_level = ? where subject_id = ?");
            preparedStatement.setInt(1, level);
            preparedStatement.setInt(2, subjectId);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            closeConnection(conn, preparedStatement);
        }
    }

    // Datenbankverbindung schlie??en
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
