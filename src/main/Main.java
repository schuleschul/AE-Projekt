package main;

import backend.*;
import datenbank.DatenbankInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        DatenbankInterface datenbankInterface = new DatenbankInterface();
        FragenFactory fragenFactory = new FragenFactory(datenbankInterface);
        FachFactory fachFactory = new FachFactory(datenbankInterface);
        FragenSuchkriterium fragenSuchkriterium = new FragenSuchkriterium();
        AntwortValidierer antwortValidierer = new AntwortValidierer();
        Gamemaster gamemaster = new Gamemaster(datenbankInterface);

        ArrayList<Fach> faecher = fachFactory.laden();
        int fachIndex = getFach(faecher);
        System.out.println("Die Fragen werden aus dem Fach " + faecher.get(fachIndex).getBezeichnung() + " stammen.");

        Frage.Schwierigkeit level = getSchwierigkeit();
        System.out.println("Schwierigkeit " + level + " wurde gewählt");
        fragenSuchkriterium.setSchwierigkeit(level);
        ArrayList<Frage> fragen = fragenFactory.laden(fragenSuchkriterium);

        System.out.println("So mögen die Spiele beginnen!");
        Scanner scanner = new Scanner(System.in);

        for(Frage frage : fragen)
        {
            System.out.println(frage.getFrage());
            System.out.println(frage.getAlleAntworten().size());
            ArrayList<String> alleAntworten = frage.getAlleAntworten();
            System.out.println(alleAntworten.size());
            for(int i = 0; i < alleAntworten.size(); i++)
            {
                System.out.println((i+1)+ ": " + frage.getAlleAntworten().get(i));
            }
            int wahl = scanner.nextInt();
            boolean istRichtig = antwortValidierer.istRichtig(frage, frage.getAlleAntworten().get(wahl - 1));
            gamemaster.takeAction(frage, istRichtig);
            if(istRichtig)
            {
                System.out.println("Korrekt");
            }
            else
            {
                System.out.println("Falsch. Die richtige Antwort lautet:");
                System.out.println(frage.getRichtigeAntwort());
            }
        }
        System.out.println("Feddich. Der Score ist: ");
        System.out.println(gamemaster.getScore() + "/" + gamemaster.getAnzahlFragenProRunde());
    }



    //fragt den User nach dem Fach; returned momentan den Index des gewählten Fachs im Array
    private static int getFach(ArrayList<Fach> faecher)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Aus welchem Fach sollen Ihre Fragen stammen?");
        for (Fach fach : faecher)
        {
            System.out.println(fach.getBezeichnung() + ": " + (fach.getId()));      //die IDs starten bei 1
        }

        int wahl = scanner.nextInt();
        //CLI ist nur für Demozwecke. Daher keine Inputkontrolle
        return (wahl-1);
    }

    //fragt den User nach der gewünschten Schwierigkeit
    private static Frage.Schwierigkeit getSchwierigkeit()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welche Schwierigkeit solls sein?");
        for(Frage.Schwierigkeit schwierigkeit: Frage.Schwierigkeit.values())
        {
            System.out.println(schwierigkeit + ": " + (schwierigkeit.ordinal() + 1));   //man kann einem User ja nicht zumuten, bei 0 anzufangen zu zählen
        }
        int wahl = scanner.nextInt();
        return Frage.Schwierigkeit.values()[(wahl-1)];
    }
}
