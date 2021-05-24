package backend;

public class Fach
{
    //Konstruktor fürs Laden aus der DB
    public Fach( int fachId, String bezeichnung)
    {
        this.bezeichnung = bezeichnung;
        this.fachId = fachId;
    }

    //Konstruktor fürs Speichern in der DB
    public Fach(String bezeichnung)
    {
        this.bezeichnung = bezeichnung;
        //wird von der Datenbank bestimmt
        this.fachId = 0;
    }

    public String getBezeichnung()
    {
        return bezeichnung;
    }

    public int getId() {
        return fachId;
    }

    private final int fachId;
    private final String bezeichnung;
}
