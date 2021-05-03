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
import java.util.List;

public class DatenbankInterface
{
    public ArrayList<Fach> laden(FachSuchkriterium suchkriterium)
    {
        Datenbank db = new Datenbank();
        Connection conn = db.verbinden();
        ArrayList<Fach> faecher = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM subject");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int fachId = resultSet.getInt("subject_id");
                String bezeichnung = resultSet.getString("subject_name");
                faecher.add(new Fach(fachId, bezeichnung, 0));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return faecher;
    }

    public ArrayList<Frage> laden(FragenSuchkriterium suchkriterium)
    {

    }

    public void speichern(Frage frage)
    {

    }

    public void speichern(Fach fach)
    {

    }
}
