package backend;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ThemaTest {
    @Test
    public void testConstructor() {
        Thema actualThema = new Thema(123, "Bezeichnung");
        assertEquals("Bezeichnung", actualThema.getBezeichnung());
        assertEquals(123, actualThema.getId());
    }

    @Test
    public void testConstructor2() {
        Thema actualThema = new Thema("Bezeichnung");
        assertEquals("Bezeichnung", actualThema.getBezeichnung());
        assertEquals(0, actualThema.getId());
    }
}