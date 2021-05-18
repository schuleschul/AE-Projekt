package backend;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FachTest {
    @Test
    public void testConstructor() {
        Fach actualFach = new Fach(123, "Bezeichnung");
        assertEquals("Bezeichnung", actualFach.getBezeichnung());
        assertEquals(123, actualFach.getFachId());
        assertEquals("Fach{fachId=123, bezeichnung='Bezeichnung'}", actualFach.toString());
    }

    @Test
    public void testConstructor2() {
        Fach actualFach = new Fach("Bezeichnung");
        assertEquals("Bezeichnung", actualFach.getBezeichnung());
        assertEquals(0, actualFach.getFachId());
        assertEquals("Fach{fachId=0, bezeichnung='Bezeichnung'}", actualFach.toString());
    }
}


