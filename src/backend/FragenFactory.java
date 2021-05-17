package backend;

import datenbank.DatenbankInterface;

import java.util.*;

public class FragenFactory
{
    public FragenFactory(DatenbankInterface datenbank)
    {
        this.datenbank = datenbank;
    }

    //lädt einfach alle Fragen
    public ArrayList<Frage> laden()
    {
        FragenSuchkriterium suchkriterium = new FragenSuchkriterium();
        return laden(suchkriterium);
    }

    public ArrayList<Frage> laden(FragenSuchkriterium suchkriterium)
    {
        ArrayList<Frage> alleFragen = datenbank.laden(suchkriterium);

        return alleFragen;
    }

//    public void speichern(String frage, String richtigeAntwort, ArrayList<String> falscheAntworten, String fach, Frage.Schwierigkeit leicht)
//    {
//        datenbank.speichern(new Frage(frage, richtigeAntwort, falscheAntworten, fach, leicht));
//    }

    private final DatenbankInterface datenbank;
}
