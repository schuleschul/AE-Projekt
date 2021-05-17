package backend;

public class Frage
{
    public static enum Schwierigkeit {
        Leicht(1),
        Mittel(2),
        Schwer(3);
        private int value;
        Schwierigkeit(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Schwierigkeit getLevelByValue(int value){
            for(Schwierigkeit schwierigkeit: Schwierigkeit.values()){
                if(schwierigkeit.getValue() == value){
                    return schwierigkeit;
                }
            }
            return null;
        }
    }

//    public static void main(String[] args)
//    {
//        ArrayList<String> liste = new ArrayList<String>();
//        liste.add("1");
//        liste.add("2");
//        liste.add("3");
//        liste.add("4");
//        Frage frage = new Frage("hallo?", "ja", liste, "meh", Schwierigkeit.schwer);
//        for (String string : frage.getAlleAntworten())
//        {
//            System.out.println(string);
//        }
//    }

    //Konstruktor fürs Laden aus der DB


    public Frage(int frageId, int fachId, String frage, Schwierigkeit schwierigkeit, String antwort1, String antwort2,
                 String antwort3, String antwort4, int anzahlRichtigBeantwortet) {
        this.frageId = frageId;
        this.fachId = fachId;
        this.frage = frage;
        this.schwierigkeit = schwierigkeit;
        this.antwort1 = antwort1;
        this.antwort2 = antwort2;
        this.antwort3 = antwort3;
        this.antwort4 = antwort4;
        this.anzahlRichtigBeantwortet = anzahlRichtigBeantwortet;
    }

    //Konstruktor für Fragen, die neu in der Datenbank gespeichert werden sollen
    public Frage(int fachId, String frage, Schwierigkeit schwierigkeit, String antwort1, String antwort2,
                 String antwort3, String antwort4)
    {
        this.fachId = fachId;
        this.frage = frage;
        this.schwierigkeit = schwierigkeit;
        this.antwort1 = antwort1;
        this.antwort2 = antwort2;
        this.antwort3 = antwort3;
        this.antwort4 = antwort4;
        this.anzahlRichtigBeantwortet = 0;
    }

    public String getFrage() { return frage; }
    public Schwierigkeit getSchwierigkeit() { return schwierigkeit; }
    public int getFrageId() { return frageId; }
    public int getAnzahlRichtigBeantwortet() {return anzahlRichtigBeantwortet; }

    public String getAntwort1() {
        return antwort1;
    }

    public String getAntwort2() {
        return antwort2;
    }

    public String getAntwort3() {
        return antwort3;
    }

    public String getAntwort4() {
        return antwort4;
    }

    public int getFachId() {
        return fachId;
    }

    public void setFrage(String frage) {
        this.frage = frage;
    }

    public void setAntwort1(String antwort1) {
        this.antwort1 = antwort1;
    }

    public void setAntwort2(String antwort2) {
        this.antwort2 = antwort2;
    }

    public void setAntwort3(String antwort3) {
        this.antwort3 = antwort3;
    }

    public void setAntwort4(String antwort4) {
        this.antwort4 = antwort4;
    }

    public void setFachId(int fachId) {
        this.fachId = fachId;
    }

    public void setSchwierigkeit(Schwierigkeit schwierigkeit) {
        this.schwierigkeit = schwierigkeit;
    }

    public void setFrageId(int frageId) {
        this.frageId = frageId;
    }

    public void setAnzahlRichtigBeantwortet(int anzahlRichtigBeantwortet) {
        this.anzahlRichtigBeantwortet = anzahlRichtigBeantwortet;
    }

    private String frage;
    private String antwort1;
    private String antwort2;
    private String antwort3;
    private String antwort4;
    private int fachId;
    private Schwierigkeit schwierigkeit;
    private int frageId;
    //selbst wenn dieselbe Schwierigkeit nochmal gespielt wird, sollten die Fragen neu aus der Datenbank geladen werden, damit
    //nicht die exakt selben Fragen noch einmal auftreten. Daher muss auch anzahlRichtigBeantwortet nicht in der Frage selbst verändert werden
    private int anzahlRichtigBeantwortet;


    @Override
    public String toString() {
        return "Frage{" +
                "frage='" + frage + '\'' +
                ", antwort1='" + antwort1 + '\'' +
                ", antwort2='" + antwort2 + '\'' +
                ", antwort3='" + antwort3 + '\'' +
                ", antwort4='" + antwort4 + '\'' +
                ", fachId=" + fachId +
                ", schwierigkeit=" + schwierigkeit +
                ", frageId=" + frageId +
                ", anzahlRichtigBeantwortet=" + anzahlRichtigBeantwortet +
                '}';
    }
}
