package backend;

public class FachSuchkriterium
{
    public FachSuchkriterium(){}

    public String getBezeichnung() { return bezeichnung; }
    public void setBezeichnung(String bezeichnung) { this.bezeichnung = bezeichnung; }
    public Integer getId() { return id; }
    public void setId(int id) {this.id = id; }

    private String bezeichnung = null;
    private Integer id = null;
}
