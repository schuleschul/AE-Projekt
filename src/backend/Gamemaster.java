package backend;

import datenbank.DatenbankInterface;

import java.util.ArrayList;

public class Gamemaster
{
    public Gamemaster(DatenbankInterface datenbankInterface, FragenFactory fragenFactory, ThemenFactory themenFactory)
    {
        this.datenbankInterface = datenbankInterface;
        this.fragenFactory = fragenFactory;
        this.themenFactory = themenFactory;
    }


    //diese Methode soll die notwendigen Reaktionen auf das Ergebnis der letzten Frage übernehmen. Bis jetzt ist es nur das Update
    //von AnzahlRichtigBeantwortet in der GUI
    public void takeAction(Frage frage, boolean wurdeRichtigBeantwortet)
    {
        if(wurdeRichtigBeantwortet)
        {
            ++score;
            datenbankInterface.update(frage.getId(), (frage.getAnzahlRichtigBeantwortet()+1));
        }
        else
        {
            //Fragen mit einer geringeren AnzahlRichtigBeantwortet sollten beim Laden aus der Datenbank
            datenbankInterface.update(frage.getId(), (frage.getAnzahlRichtigBeantwortet()-1));
        }
    }

    public ArrayList<Frage> getFragen()
    {
        if(null == schwierigkeit || null == thema)
        {
            throw new IllegalStateException("Schwierigkeit oder Thema wurden noch nicht festgelegt!");
        }
        FragenSuchkriterium fragenSuchkriterium = new FragenSuchkriterium();
        fragenSuchkriterium.setSchwierigkeit(schwierigkeit);
        fragenSuchkriterium.setFachId(thema.getId());
        return fragenFactory.laden(fragenSuchkriterium);
    }

    public int getAnzahlFragenProRunde()
    {
        return anzahlFragenProRunde;
    }

    public int getScore()
    {
        return score;
    }

    public Frage.Schwierigkeit getSchwierigkeit()
    {
        return schwierigkeit;
    }

    public Frage.Schwierigkeit getSchwierigkiet()
    {
        return schwierigkeit;
    }

    public void setSchwierigkeit(Frage.Schwierigkeit schwierigkeit)
    {
        this.schwierigkeit = schwierigkeit;
    }

    public Thema getThema()
    {
        return thema;
    }

    public void setThema(Thema thema)
    {
        this.thema = thema;
    }

    private final DatenbankInterface datenbankInterface;
    private final FragenFactory fragenFactory;
    private final ThemenFactory themenFactory;
    private final int anzahlFragenProRunde = 10;
    private int score = 0;

    //vom Spieler vorzunehmende Einstellungen
    private Frage.Schwierigkeit schwierigkeit;
    private Thema thema;

}
