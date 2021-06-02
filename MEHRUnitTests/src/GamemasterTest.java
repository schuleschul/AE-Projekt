package backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import datenbank.DatenbankInterface;

import java.util.ArrayList;

import org.junit.Test;

public class GamemasterTest {
    @Test
    public void testConstructor() {
        DatenbankInterface datenbankInterface = new DatenbankInterface();
        FragenFactory fragenFactory = new FragenFactory(new DatenbankInterface());
        Gamemaster actualGamemaster = new Gamemaster(datenbankInterface, fragenFactory,
                new ThemenFactory(new DatenbankInterface()));
        actualGamemaster.setSchwierigkeit(Frage.Schwierigkeit.leicht);
        Thema thema = new Thema("Bezeichnung");
        actualGamemaster.setThema(thema);
        assertEquals(Frage.Schwierigkeit.leicht, actualGamemaster.getSchwierigkiet());
        assertEquals(0, actualGamemaster.getScore());
        assertSame(thema, actualGamemaster.getThema());
    }

    @Test
    public void testTakeAction() {
        DatenbankInterface datenbankInterface = new DatenbankInterface();
        FragenFactory fragenFactory = new FragenFactory(new DatenbankInterface());
        Gamemaster gamemaster = new Gamemaster(datenbankInterface, fragenFactory,
                new ThemenFactory(new DatenbankInterface()));
        Frage frage = mock(Frage.class);
        when(frage.getAnzahlRichtigBeantwortet()).thenThrow(new IllegalStateException("foo"));
        when(frage.getId()).thenReturn(1);
        assertThrows(IllegalStateException.class, () -> gamemaster.takeAction(frage, true));
        verify(frage).getAnzahlRichtigBeantwortet();
        verify(frage).getId();
    }

    @Test
    public void testTakeAction2() {
        DatenbankInterface datenbankInterface = new DatenbankInterface();
        FragenFactory fragenFactory = new FragenFactory(new DatenbankInterface());
        Gamemaster gamemaster = new Gamemaster(datenbankInterface, fragenFactory,
                new ThemenFactory(new DatenbankInterface()));
        Frage frage = mock(Frage.class);
        when(frage.getAnzahlRichtigBeantwortet()).thenThrow(new IllegalStateException("foo"));
        when(frage.getId()).thenReturn(1);
        assertThrows(IllegalStateException.class, () -> gamemaster.takeAction(frage, false));
        verify(frage).getAnzahlRichtigBeantwortet();
        verify(frage).getId();
    }

    @Test
    public void testTakeAction3() {
        DatenbankInterface datenbankInterface = mock(DatenbankInterface.class);
        doNothing().when(datenbankInterface).update(anyInt(), anyInt());
        FragenFactory fragenFactory = new FragenFactory(new DatenbankInterface());
        Gamemaster gamemaster = new Gamemaster(datenbankInterface, fragenFactory,
                new ThemenFactory(new DatenbankInterface()));
        Frage frage = mock(Frage.class);
        when(frage.getAnzahlRichtigBeantwortet()).thenReturn(1);
        when(frage.getId()).thenReturn(1);
        gamemaster.takeAction(frage, false);
        verify(datenbankInterface).update(anyInt(), anyInt());
        verify(frage).getAnzahlRichtigBeantwortet();
        verify(frage).getId();
    }

    @Test
    public void testTakeAction4() {
        DatenbankInterface datenbankInterface = mock(DatenbankInterface.class);
        doNothing().when(datenbankInterface).update(anyInt(), anyInt());
        FragenFactory fragenFactory = new FragenFactory(new DatenbankInterface());
        Gamemaster gamemaster = new Gamemaster(datenbankInterface, fragenFactory,
                new ThemenFactory(new DatenbankInterface()));
        Frage frage = mock(Frage.class);
        when(frage.getAnzahlRichtigBeantwortet()).thenReturn(1);
        when(frage.getId()).thenReturn(1);
        gamemaster.takeAction(frage, true);
        verify(datenbankInterface).update(anyInt(), anyInt());
        verify(frage).getAnzahlRichtigBeantwortet();
        verify(frage).getId();
        assertEquals(1, gamemaster.getScore());
    }

    @Test
    public void testGetFragen() {
        DatenbankInterface datenbankInterface = new DatenbankInterface();
        FragenFactory fragenFactory = new FragenFactory(new DatenbankInterface());
        assertThrows(IllegalStateException.class,
                () -> (new Gamemaster(datenbankInterface, fragenFactory, new ThemenFactory(new DatenbankInterface())))
                        .getFragen());
    }

    @Test
    public void testGetFragen2() {
        DatenbankInterface datenbankInterface = new DatenbankInterface();
        FragenFactory fragenFactory = new FragenFactory(new DatenbankInterface());

        Gamemaster gamemaster = new Gamemaster(datenbankInterface, fragenFactory,
                new ThemenFactory(new DatenbankInterface()));
        gamemaster.setSchwierigkeit(Frage.Schwierigkeit.leicht);
        assertThrows(IllegalStateException.class, () -> gamemaster.getFragen());
    }

    @Test
    public void testGetFragen3() {
        DatenbankInterface datenbankInterface = mock(DatenbankInterface.class);
        ArrayList<Frage> frageList = new ArrayList<Frage>();
        when(datenbankInterface.laden((FragenSuchkriterium) any())).thenReturn(frageList);
        FragenFactory fragenFactory = new FragenFactory(datenbankInterface);
        DatenbankInterface datenbankInterface1 = new DatenbankInterface();

        Gamemaster gamemaster = new Gamemaster(datenbankInterface1, fragenFactory,
                new ThemenFactory(new DatenbankInterface()));
        gamemaster.setThema(new Thema("Bezeichnung"));
        gamemaster.setSchwierigkeit(Frage.Schwierigkeit.leicht);
        ArrayList<Frage> actualFragen = gamemaster.getFragen();
        assertSame(frageList, actualFragen);
        assertTrue(actualFragen.isEmpty());
        verify(datenbankInterface).laden((FragenSuchkriterium) any());
    }

    @Test
    public void testGetFragen4() {
        DatenbankInterface datenbankInterface = mock(DatenbankInterface.class);
        ArrayList<Frage> frageList = new ArrayList<Frage>();
        when(datenbankInterface.laden((FragenSuchkriterium) any())).thenReturn(frageList);
        FragenFactory fragenFactory = new FragenFactory(datenbankInterface);
        Thema thema = mock(Thema.class);
        when(thema.getId()).thenReturn(1);
        DatenbankInterface datenbankInterface1 = new DatenbankInterface();

        Gamemaster gamemaster = new Gamemaster(datenbankInterface1, fragenFactory,
                new ThemenFactory(new DatenbankInterface()));
        gamemaster.setThema(thema);
        gamemaster.setSchwierigkeit(Frage.Schwierigkeit.leicht);
        ArrayList<Frage> actualFragen = gamemaster.getFragen();
        assertSame(frageList, actualFragen);
        assertTrue(actualFragen.isEmpty());
        verify(datenbankInterface).laden((FragenSuchkriterium) any());
        verify(thema).getId();
    }

    @Test
    public void testGetAnzahlFragenProRunde() {
        DatenbankInterface datenbankInterface = new DatenbankInterface();
        FragenFactory fragenFactory = new FragenFactory(new DatenbankInterface());
        assertEquals(10, (new Gamemaster(datenbankInterface, fragenFactory, new ThemenFactory(new DatenbankInterface())))
                .getAnzahlFragenProRunde());
    }
}

