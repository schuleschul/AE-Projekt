package backend;

public class Fach
{
    public Fach(String bezeichnung, int anzahlFragen)
    {
        this.bezeichnung = bezeichnung;
        this.anzahlFragen = anzahlFragen;
    }

    public String getBezeichnung()
    {
        return bezeichnung;
    }

    public int getAnzahlFragen()
    {
        return anzahlFragen;
    }

    private final String bezeichnung;
    private final int anzahlFragen;
}
