package backend;

import datenbank.DatenbankInterface;

public class Gamemaster
{
    public Gamemaster(DatenbankInterface datenbankInterface) { this.datenbankInterface = datenbankInterface; }


    //diese Methode soll die notwendigen Reaktionen auf das Ergebnis der letzten Frage übernehmen. Bis jetzt ist es nur das Update
    //von AnzahlRichtigBeantwortet in der GUI
    public void takeAction(Frage frage, boolean wurdeRichtigBeantwortet)
    {
        if(wurdeRichtigBeantwortet)
        {
            datenbankInterface.update(frage.getId(), (frage.getAnzahlRichtigBeantwortet()+1));
        }
        else
        {
            //Fragen mit einer geringeren AnzahlRichtigBeantwortet sollten beim Laden aus der Datenbank
            datenbankInterface.update(frage.getId(), (frage.getAnzahlRichtigBeantwortet()-1));
        }
    }

    private final DatenbankInterface datenbankInterface;
}
