package backend;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FrageTest {
    @Test
    public void testConstructor() {
        Frage actualFrage = new Frage(123, 123, "Frage", Frage.Schwierigkeit.Leicht, "Antwort1", "Antwort2", "Antwort3",
                "Antwort4", 1);
        actualFrage.setAntwort1("Antwort1");
        actualFrage.setAntwort2("Antwort2");
        actualFrage.setAntwort3("Antwort3");
        actualFrage.setAntwort4("Antwort4");
        actualFrage.setAnzahlRichtigBeantwortet(1);
        actualFrage.setFachId(123);
        actualFrage.setFrage("Frage");
        actualFrage.setFrageId(123);
        actualFrage.setSchwierigkeit(Frage.Schwierigkeit.Leicht);
        assertEquals("Antwort1", actualFrage.getAntwort1());
        assertEquals("Antwort2", actualFrage.getAntwort2());
        assertEquals("Antwort3", actualFrage.getAntwort3());
        assertEquals("Antwort4", actualFrage.getAntwort4());
        assertEquals(1, actualFrage.getAnzahlRichtigBeantwortet());
        assertEquals(123, actualFrage.getFachId());
        assertEquals("Frage", actualFrage.getFrage());
        assertEquals(123, actualFrage.getFrageId());
        assertEquals(Frage.Schwierigkeit.Leicht, actualFrage.getSchwierigkeit());
        assertEquals(
                "Frage{frage='Frage', antwort1='Antwort1', antwort2='Antwort2', antwort3='Antwort3', antwort4='Antwort4',"
                        + " fachId=123, schwierigkeit=Leicht, frageId=123, anzahlRichtigBeantwortet=1}",
                actualFrage.toString());
    }

    @Test
    public void testConstructor2() {
        Frage actualFrage = new Frage(123, "Frage", Frage.Schwierigkeit.Leicht, "Antwort1", "Antwort2", "Antwort3",
                "Antwort4");
        actualFrage.setAntwort1("Antwort1");
        actualFrage.setAntwort2("Antwort2");
        actualFrage.setAntwort3("Antwort3");
        actualFrage.setAntwort4("Antwort4");
        actualFrage.setAnzahlRichtigBeantwortet(1);
        actualFrage.setFachId(123);
        actualFrage.setFrage("Frage");
        actualFrage.setFrageId(123);
        actualFrage.setSchwierigkeit(Frage.Schwierigkeit.Leicht);
        assertEquals("Antwort1", actualFrage.getAntwort1());
        assertEquals("Antwort2", actualFrage.getAntwort2());
        assertEquals("Antwort3", actualFrage.getAntwort3());
        assertEquals("Antwort4", actualFrage.getAntwort4());
        assertEquals(1, actualFrage.getAnzahlRichtigBeantwortet());
        assertEquals(123, actualFrage.getFachId());
        assertEquals("Frage", actualFrage.getFrage());
        assertEquals(123, actualFrage.getFrageId());
        assertEquals(Frage.Schwierigkeit.Leicht, actualFrage.getSchwierigkeit());
        assertEquals(
                "Frage{frage='Frage', antwort1='Antwort1', antwort2='Antwort2', antwort3='Antwort3', antwort4='Antwort4',"
                        + " fachId=123, schwierigkeit=Leicht, frageId=123, anzahlRichtigBeantwortet=1}",
                actualFrage.toString());
    }
}

