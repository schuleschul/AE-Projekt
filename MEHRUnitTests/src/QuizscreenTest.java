package gui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import backend.FragenFactory;
import backend.Gamemaster;
import backend.ThemenFactory;
import datenbank.DatenbankInterface;
import org.junit.Test;

import java.util.ArrayList;

public class QuizscreenTest {
    @Test
    public void testConstructor() {
        DatenbankInterface datenbankInterface = new DatenbankInterface();
        FragenFactory fragenFactory = new FragenFactory(new DatenbankInterface());
        Gamemaster gamemaster = new Gamemaster(datenbankInterface, fragenFactory,
                new ThemenFactory(new DatenbankInterface()));
        new Quizscreen(gamemaster);
        assertEquals(10, gamemaster.getAnzahlFragenProRunde());
        assertNull(gamemaster.getThema());
        assertEquals(0, gamemaster.getScore());
        assertNull(gamemaster.getSchwierigkiet());
    }
}