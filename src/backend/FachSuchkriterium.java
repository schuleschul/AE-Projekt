package backend;

public class FachSuchkriterium
{
    public FachSuchkriterium(){}

    public String getBezeichnung() { return bezeichnung; }
    public void setBezeichnung(String bezeichnung) { this.bezeichnung = bezeichnung; }
    public Integer getAnzahlFragen() { return anzahlFragen; }
    public void setAnzahlFragen() { this.anzahlFragen = anzahlFragen; }

    private String bezeichnung = null;
    private Integer anzahlFragen = null;
}
