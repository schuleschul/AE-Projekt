package backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class FragenSuchkriteriumTest {
    @Test
    public void testConstructor() {
        FragenSuchkriterium actualFragenSuchkriterium = new FragenSuchkriterium();
        actualFragenSuchkriterium.setFach("Fach");
        actualFragenSuchkriterium.setFalscheAntwort("Falsche Antwort");
        actualFragenSuchkriterium.setFrage("Frage");
        actualFragenSuchkriterium.setRichtigeAntwort("Richtige Antwort");
        actualFragenSuchkriterium.setSchwierigkeit(Frage.Schwierigkeit.Leicht);
        assertNull(actualFragenSuchkriterium.getAnzahlRichtigBeantwortet());
        assertEquals("Fach", actualFragenSuchkriterium.getFach());
        assertEquals("Falsche Antwort", actualFragenSuchkriterium.getFalscheAntwort());
        assertEquals("Frage", actualFragenSuchkriterium.getFrage());
        assertNull(actualFragenSuchkriterium.getId());
        assertEquals("Richtige Antwort", actualFragenSuchkriterium.getRichtigeAntwort());
        assertEquals(Frage.Schwierigkeit.Leicht, actualFragenSuchkriterium.getSchwierigkeit());
    }

    @Test
    public void testSetId() {
        FragenSuchkriterium fragenSuchkriterium = new FragenSuchkriterium();
        fragenSuchkriterium.setId(1);
        assertEquals(1, fragenSuchkriterium.getId().intValue());
    }

    @Test
    public void testSetAnzahlRichtigBeantwortet() {
        FragenSuchkriterium fragenSuchkriterium = new FragenSuchkriterium();
        fragenSuchkriterium.setAnzahlRichtigBeantwortet(1);
        assertEquals(1, fragenSuchkriterium.getAnzahlRichtigBeantwortet().intValue());
    }
}
