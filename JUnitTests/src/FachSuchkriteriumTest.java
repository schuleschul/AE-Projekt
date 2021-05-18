package backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class FachSuchkriteriumTest {
    @Test
    public void testConstructor() {
        FachSuchkriterium actualFachSuchkriterium = new FachSuchkriterium();
        actualFachSuchkriterium.setBezeichnung("Bezeichnung");
        assertEquals("Bezeichnung", actualFachSuchkriterium.getBezeichnung());
        assertNull(actualFachSuchkriterium.getId());
    }

    @Test
    public void testSetId() {
        FachSuchkriterium fachSuchkriterium = new FachSuchkriterium();
        fachSuchkriterium.setId(1);
        assertEquals(1, fachSuchkriterium.getId().intValue());
    }
}

