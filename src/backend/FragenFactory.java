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
        Collections.shuffle(alleFragen);
        return alleFragen;
    }

    public void speichern(String frage, String richtigeAntwort, ArrayList<String> falscheAntworten, int fachId, Frage.Schwierigkeit leicht)
    {
        datenbank.speichern(new Frage(frage, richtigeAntwort, falscheAntworten, leicht, fachId));
    }

    private final DatenbankInterface datenbank;
}
