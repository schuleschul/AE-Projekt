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
    public HashMap<Frage.Schwierigkeit, ArrayList<Frage>> laden()
    {
        FragenSuchkriterium suchkriterium = new FragenSuchkriterium();
        return laden(suchkriterium);
    }

    public HashMap<Frage.Schwierigkeit, ArrayList<Frage>> laden(FragenSuchkriterium suchkriterium)
    {
        HashMap<Frage.Schwierigkeit, ArrayList<Frage>> map = new HashMap<Frage.Schwierigkeit, ArrayList<Frage>>();
        map.put(Frage.Schwierigkeit.leicht, new ArrayList<Frage>());
        map.put(Frage.Schwierigkeit.mittel, new ArrayList<Frage>());
        map.put(Frage.Schwierigkeit.schwer, new ArrayList<Frage>());

        ArrayList<Frage> alleFragen = datenbank.laden(suchkriterium);
        for (Frage frage : alleFragen)
        {
            map.get(frage.getSchwierigkeit()).add(frage);
        }

        return map;
    }


    private final DatenbankInterface datenbank;
}
