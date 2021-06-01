package backend;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BildTest {
    @Test
    public void testConstructor() {
        Bild actualBild = new Bild(123, 123, "Fach Bild", "Richtig Bild", "Falsch Bild");
        assertEquals(123, actualBild.getBildId().intValue());
        assertEquals("Fach Bild", actualBild.getFachBild());
        assertEquals(123, actualBild.getFachId().intValue());
        assertEquals("Falsch Bild", actualBild.getFalschBild());
        assertEquals("Richtig Bild", actualBild.getRichtigBild());
        assertEquals(
                "Bild{bildId=123, fachId=123, fachBild='Fach Bild', richtigBild='Richtig Bild', falschBild='Falsch" + " Bild'}",
                actualBild.toString());
    }
}
