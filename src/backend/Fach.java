package backend;

public class Fach
{
    //Konstruktor fürs Laden aus der DB
    public Fach( int fachId, String bezeichnung, int anzahlFragen)
    {
        this.bezeichnung = bezeichnung;
        this.anzahlFragen = anzahlFragen;
        this.fachId = fachId;
    }

    //Konstruktor fürs Speichern in der DB
    public Fach(String bezeichnung)
    {
        this.bezeichnung = bezeichnung;
        //werden von der Datenbank bestimmt
        this.anzahlFragen = 0;
        this.fachId = 0;
    }

    public String getBezeichnung()
    {
        return bezeichnung;
    }

    public int getAnzahlFragen()
    {
        return anzahlFragen;
    }

    public int getFachId() {
        return fachId;
    }

    private final int fachId;
    private final String bezeichnung;
    private final int anzahlFragen;
}
