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

    //returned, ob das Level erhöht wurde
    public boolean maxLevelErhoehen(int anzahlFragen)
    {
        System.out.println(anzahlFragen);
        System.out.println(score);
        if( score == anzahlFragen)
        {
            //level ist noch nicht max
            if(maxSchwierigkeit.ordinal() < Frage.Schwierigkeit.schwer.ordinal())
            {
                datenbankInterface.updatCurrentLevel(thema.getId(), (maxSchwierigkeit.ordinal()+1));
                loadMaxSchwierigkeit();
                return true;
            }
        }
        return false;
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


    public Frage.Schwierigkeit getMaxSchwierigkeit()
    {
        if(null == maxSchwierigkeit)
        {
            loadMaxSchwierigkeit();
        }
        return maxSchwierigkeit;
    }

    public Frage.Schwierigkeit getSchwierigkeit()
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

    public DatenbankInterface getDatenbankInterface()
    {
        return datenbankInterface;
    }

    public FragenFactory getFragenFactory()
    {
        return fragenFactory;
    }

    public ThemenFactory getThemenFactory()
    {
        return themenFactory;
    }

    private void loadMaxSchwierigkeit()
    {
        if(null == thema)
        {
            throw new IllegalStateException("Das Thema wurde noch nicht festgelegt!");
        }
        maxSchwierigkeit = Frage.Schwierigkeit.values()[datenbankInterface.getCurrentLevel(thema.getId())];
    }

    private final DatenbankInterface datenbankInterface;
    private final FragenFactory fragenFactory;
    private final ThemenFactory themenFactory;
    private final int anzahlFragenProRunde = 10;
    private int score = 0;
    private Frage.Schwierigkeit maxSchwierigkeit;       //die maximal auswählbare Schwierigkeit

    //vom Spieler vorzunehmende Einstellungen
    private Frage.Schwierigkeit schwierigkeit;
    private Thema thema;

}
