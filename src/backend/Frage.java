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
//        Frage frage = new Frage("hallo?", "ja", liste, "meh", Schwierigkeit.schwer);
//        for (String string : frage.getAlleAntworten())
//        {
//            System.out.println(string);
//        }
//    }

    public Frage(String frage, String richtigeAntwort, ArrayList<String> falscheAntworten, String fach, Schwierigkeit schwierigkeit,
                  int id, int anzahlRichtigBeantwortet)
    {
        this.frage = frage;
        this.richtigeAntwort = richtigeAntwort;
        this.falscheAntworten = falscheAntworten;
        this.fach = fach;
        this.schwierigkeit = schwierigkeit;
        this.id = id;
        this.anzahlRichtigBeantwortet = anzahlRichtigBeantwortet;
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
    public String getFach() { return fach; }
    public Schwierigkeit getSchwierigkeit() { return schwierigkeit; }
    public int getId() { return id; }
    public int getAnzahlRichtigBeantwortet() {return anzahlRichtigBeantwortet; }

    private final String frage;
    private final String richtigeAntwort;
    private final ArrayList<String> falscheAntworten;
    private final String fach;
    private final Schwierigkeit schwierigkeit;
    private final int id;
    private final int anzahlRichtigBeantwortet;

}
