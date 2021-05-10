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
        Datenbank db = new Datenbank();
        Connection conn = db.verbinden();
        ArrayList<Fach> faecher = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM subject"); // ich werde noch suchkriterium anpassen
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int fachId = resultSet.getInt("subject_id");
                String bezeichnung = resultSet.getString("subject_name");
                faecher.add(new Fach(fachId, bezeichnung));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return faecher;
    }

    public ArrayList<Frage> laden(FragenSuchkriterium suchkriterium)
    {
        Datenbank db = new Datenbank();
        Connection conn = db.verbinden();
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

    }

    public void speichern(Fach fach)
    {

    }

    public void update(int id, int anzahlRichtigBeantwortet)
    {

    }
}
