package backend;

public class Fach
{
    public Fach( int fachId, String bezeichnung, int anzahlFragen)
    {
        this.bezeichnung = bezeichnung;
        this.anzahlFragen = anzahlFragen;
        this.fachId = fachId;
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
