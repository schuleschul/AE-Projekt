package backend;

import java.util.ArrayList;
import java.util.Collections;

public class Frage
{
    public static enum Schwierigkeit
    {
        leicht,
        mittel,
        schwer

    }

//    public static void main(String[] args)
//    {
//        ArrayList<String> liste = new ArrayList<String>();
//        liste.add("1");
//        liste.add("2");
//        liste.add("3");
//        liste.add("4");
//        Schwierigkeit schwierigkeit = Schwierigkeit.values()[1];
//        Frage frage = new Frage("hallo?", "ja", liste,  schwierigkeit, 2);
//        System.out.println(frage.getSchwierigkeit());
//        System.out.println(frage.getSchwierigkeit().ordinal());
//        for (String string : frage.getAlleAntworten())
//        {
//            System.out.println(string);
//        }
//    }

    //Konstruktor fürs Laden aus der DB
    public Frage(String frage, String richtigeAntwort, ArrayList<String> falscheAntworten, Schwierigkeit schwierigkeit, int fachId,
                  int id, int anzahlRichtigBeantwortet)
    {
        this.frage = frage;
        this.richtigeAntwort = richtigeAntwort;
        this.falscheAntworten = falscheAntworten;
        this.fachId = fachId;
        this.schwierigkeit = schwierigkeit;
        this.id = id;
        this.anzahlRichtigBeantwortet = anzahlRichtigBeantwortet;

    }

    //Konstruktor für Fragen, die neu in der Datenbank gespeichert werden sollen
    public Frage(String frage, String richtigeAntwort, ArrayList<String> falscheAntworten, Schwierigkeit schwierigkeit, int fachId)
    {
        this.frage = frage;
        this.richtigeAntwort = richtigeAntwort;
        this.falscheAntworten = falscheAntworten;
        this.fachId = fachId;
        this.schwierigkeit = schwierigkeit;
        this.id = 0;        //die ID wird in der Datenbank durch autoincrement bestimmt
        this.anzahlRichtigBeantwortet = 0;
    }

    public ArrayList<String> getAlleAntworten()
    {
        ArrayList<String> alleAntworten = falscheAntworten;
        alleAntworten.add(richtigeAntwort);
        Collections.shuffle(alleAntworten);
        return alleAntworten;
    }

    public String getFrage() { return frage; }
    public String getRichtigeAntwort() { return richtigeAntwort;}
    public ArrayList<String> getFalscheAntworten() { return falscheAntworten; }
    public int getFachId() { return fachId; }
    public Schwierigkeit getSchwierigkeit() { return schwierigkeit; }
    public int getId() { return id; }
    public int getAnzahlRichtigBeantwortet() {return anzahlRichtigBeantwortet; }

    private final String frage;
    private final String richtigeAntwort;
    private final ArrayList<String> falscheAntworten;
    private final int fachId;
    private final Schwierigkeit schwierigkeit;
    private final int id;
    //selbst wenn dieselbe Schwierigkeit nochmal gespielt wird, sollten die Fragen neu aus der Datenbank geladen werden, damit
    //nicht die exakt selben Fragen noch einmal auftreten. Daher muss auch anzahlRichtigBeantwortet nicht in der Frage selbst verändert werden
    private final int anzahlRichtigBeantwortet;

}
