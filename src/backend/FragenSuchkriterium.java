package backend;

public class FragenSuchkriterium
{
    public FragenSuchkriterium(){}

    public String getFrage() { return frage; }
    public void setFrage(String frage) { this.frage = frage; }
    public String getRichtigeAntwort() { return richtigeAntwort; }
    public void setRichtigeAntwort(String richtigeAntwort) { this.richtigeAntwort = richtigeAntwort; }
    public String getFalscheAntwort() { return falscheAntwort; }
    public void setFalscheAntwort(String falscheAntwort) { this.falscheAntwort = falscheAntwort; }
    public String getFach() { return fach; }
    public void setFach(String fach) { this.fach = fach; }
    public Frage.Schwierigkeit getSchwierigkeit() { return schwierigkeit; }
    public void setSchwierigkeit(Frage.Schwierigkeit schwierigkeit) { this.schwierigkeit = schwierigkeit; }
    public Integer getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Integer getAnzahlRichtigBeantwortet() { return anzahlRichtigBeantwortet; }
    public void setAnzahlRichtigBeantwortet(int anzahlRichtigBeantwortet) { this.anzahlRichtigBeantwortet = anzahlRichtigBeantwortet; }


    private String frage = null;
    private String richtigeAntwort = null;
    private String falscheAntwort = null;   //hier vielleicht auch ne Liste benutzen, dann muss aber festgelegt werden, ob die Elemente in der Suche eine UND oder eine ODER Funktion haben sollen
    private String fach = null;
    private Frage.Schwierigkeit schwierigkeit = null;
    private Integer id = null;
    private Integer anzahlRichtigBeantwortet = null;
}
