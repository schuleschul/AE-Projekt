package backend;
import datenbank.DatenbankInterface;
import java.util.ArrayList;

public class FachFactory
{
    public FachFactory(DatenbankInterface datenbank)
    {
        this.datenbank = datenbank;
    }

    public ArrayList<Fach> laden(FachSuchkriterium suchkriterium)
    {
        return datenbank.laden(suchkriterium);
    }

    //lädt einfach alle Fächer
    public ArrayList<Fach> laden()
    {
        FachSuchkriterium suchkriterium = new FachSuchkriterium();
        return laden(suchkriterium);
    }


    private final DatenbankInterface datenbank;
}
