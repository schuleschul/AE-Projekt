package main;

import konfiguration.Datenbank;

public class Main {
    public static void main(String[] args) {
        Datenbank db = new Datenbank();
        db.verbinden();
    }
}
