package main;

import backend.Fach;
import backend.FachSuchkriterium;
import backend.Frage;
import backend.FragenSuchkriterium;
import datenbank.DatenbankInterface;

public class Main {
    public static void main(String[] args) {
        DatenbankInterface datenbankInterface = new DatenbankInterface();

//        datenbankInterface.speichern(new Fach("ITS"));
//        datenbankInterface.speichern(new Frage(1, "Who are you?", Frage.Schwierigkeit.Leicht,
//                "Me", "you", "wrong2","false"));
        datenbankInterface.laden(new FachSuchkriterium()).forEach(fach -> System.out.println(fach));
        datenbankInterface.laden(new FragenSuchkriterium()).forEach(frage -> System.out.println(frage));
//        datenbankInterface.update(3, 5);
    }
}
