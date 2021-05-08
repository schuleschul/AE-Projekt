package backend;
import datenbank.DatenbankInterface;
import java.util.ArrayList;

public class FachFactory
{
    public FachFactory(DatenbankInterface datenbank)
    {
        this.datenbank = datenbank;
    }

    //lädt einfach alle Fächer
    public ArrayList<Fach> laden()
    {
        FachSuchkriterium suchkriterium = new FachSuchkriterium();
        return laden(suchkriterium);
    }

    public ArrayList<Fach> laden(FachSuchkriterium suchkriterium)
    {
        return datenbank.laden(suchkriterium);
    }

    public void speichern(String bezeichnung)
    {
        datenbank.speichern(new Fach(bezeichnung));
    }

    private final DatenbankInterface datenbank;
}
