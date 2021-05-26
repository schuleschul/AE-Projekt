package main;

import backend.*;
import datenbank.DatenbankInterface;

import java.util.ArrayList;
import java.util.Date;
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
        Scanner scanner = new Scanner(System.in);

        System.out.println(datenbankInterface.bilderLaden(1));

        System.out.println("Hallösche! Was möchten Sie tun?");
        System.out.println("1: Spielen");
        System.out.println("2: Fragen hinzufügen");
        System.out.println("3: alle Fragen anzeigen");
        int wahl = scanner.nextInt();
        if(wahl == 2)
        {
            frageAdden();
            return;
        }
        else if(wahl == 3)
        {
            printAntworten();
            return;
        }

        ArrayList<Fach> faecher = fachFactory.laden();
        int fachIndex = getFach(faecher);
        System.out.println("Die Fragen werden aus dem Fach " + faecher.get(fachIndex).getBezeichnung() + " stammen.");

        Frage.Schwierigkeit level = getSchwierigkeit();
        System.out.println("Schwierigkeit " + level + " wurde gewählt");
        fragenSuchkriterium.setSchwierigkeit(level);
        ArrayList<Frage> fragen = fragenFactory.laden(fragenSuchkriterium);

        System.out.println("So mögen die Spiele beginnen!");


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
            wahl = scanner.nextInt();
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

    private static void frageAdden()
    {
        char wahl = 'n';
        Scanner scanner = new Scanner(System.in);
        DatenbankInterface db = new DatenbankInterface();
        do
        {
            System.out.println("Natürlich können Sie eine Frage hinzufügen");
            System.out.println("Geben Sie nun den Wortlaut der Frage ein.");
            String frage = scanner.nextLine();
            System.out.println("Geben Sie nun bitte die richtige Antwort ein.");
            String richtigeAntwort = scanner.nextLine();
            ArrayList<String> falscheAntworten = new ArrayList<String>();
            System.out.println("Sie müssen 3 falsche Antworten angeben.");
            for (int i = 0; i < Frage.getAnzahlFalscheAntworten(); ++i)
            {
                System.out.println("Geben sie nun bitte falsche Antwort Nummer " + i + " ein.");
                falscheAntworten.add(scanner.nextLine());
            }
            System.out.println("Wählen Sie nun bitte das Fach aus, dem die Frage zugeordnet werden soll.");
            System.out.println("1: AE");
            System.out.println("2: ITS");
            int fachId = scanner.nextInt();
            System.out.println("Wählen Sie nun bitte die Schwierigkeit der Frage aus.");
            System.out.println("1: leicht");
            System.out.println("2: mittel");
            System.out.println("3: schwer");
            Frage.Schwierigkeit schwierigkeit = Frage.Schwierigkeit.values()[(scanner.nextInt()-1)];
            Frage fragebla = new Frage(frage, richtigeAntwort, falscheAntworten, schwierigkeit, fachId);
            db.speichern(fragebla);
            System.out.println("Möchten Sie eine weitere Frage hinzufügen? y/Y");
            wahl = scanner.next().charAt(0);
        }
        while(wahl == 'y');
    }

    private static void printAntworten()
    {
        DatenbankInterface db = new DatenbankInterface();
        FragenFactory fragenFactory = new FragenFactory(db);
        ArrayList<Frage> fragen = fragenFactory.laden();
        for (Frage frage : fragen)
        {
            System.out.println(frage.getFrage());
        }
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
