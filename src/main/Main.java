package main;

import backend.*;
import datenbank.DatenbankInterface;
import gui.Startwindow;


public class Main {
    public static void main(String[] args)
    {
        DatenbankInterface datenbankInterface = new DatenbankInterface();
        FragenFactory fragenFactory = new FragenFactory(datenbankInterface);
        ThemenFactory themenFactory = new ThemenFactory(datenbankInterface);
        Gamemaster gamemaster = new Gamemaster(datenbankInterface, fragenFactory, themenFactory);
        Startwindow startwindow = new Startwindow(gamemaster);
        startwindow.setVisible(true);
    }

}
