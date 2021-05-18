package backend;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class AntwortValidiererTest {
    @Test
    public void testIstRichtig() {
        AntwortValidierer antwortValidierer = new AntwortValidierer();
        assertFalse(antwortValidierer.istRichtig(
                new Frage(123, "Frage", Frage.Schwierigkeit.Leicht, "Antwort1", "Antwort2", "Antwort3", "Antwort4"),
                "Gegebene Antwort"));
    }
}
