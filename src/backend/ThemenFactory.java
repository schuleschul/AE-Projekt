package backend;
import datenbank.DatenbankInterface;
import java.util.ArrayList;

public class ThemenFactory
{
    public ThemenFactory(DatenbankInterface datenbank)
    {
        this.datenbank = datenbank;
    }

    //lädt einfach alle Fächer
    public ArrayList<Thema> laden()
    {
        FachSuchkriterium suchkriterium = new FachSuchkriterium();
        return laden(suchkriterium);
    }

    public ArrayList<Thema> laden(FachSuchkriterium suchkriterium)
    {
        return datenbank.laden(suchkriterium);
    }

    public void speichern(String bezeichnung)
    {
        datenbank.speichern(new Thema(bezeichnung));
    }

    private final DatenbankInterface datenbank;
}
