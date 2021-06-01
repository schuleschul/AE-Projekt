package backend;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import datenbank.DatenbankInterface;

import java.util.ArrayList;

import org.junit.Test;

public class FragenFactoryTest {
    @Test
    public void testLaden() {
        DatenbankInterface datenbankInterface = mock(DatenbankInterface.class);
        ArrayList<Frage> frageList = new ArrayList<Frage>();
        when(datenbankInterface.laden((FragenSuchkriterium) any())).thenReturn(frageList);
        ArrayList<Frage> actualLadenResult = (new FragenFactory(datenbankInterface)).laden();
        assertSame(frageList, actualLadenResult);
        assertTrue(actualLadenResult.isEmpty());
        verify(datenbankInterface).laden((FragenSuchkriterium) any());
    }

    @Test
    public void testLaden2() {
        DatenbankInterface datenbankInterface = mock(DatenbankInterface.class);
        ArrayList<Frage> frageList = new ArrayList<Frage>();
        when(datenbankInterface.laden((FragenSuchkriterium) any())).thenReturn(frageList);
        FragenFactory fragenFactory = new FragenFactory(datenbankInterface);
        ArrayList<Frage> actualLadenResult = fragenFactory.laden(new FragenSuchkriterium());
        assertSame(frageList, actualLadenResult);
        assertTrue(actualLadenResult.isEmpty());
        verify(datenbankInterface).laden((FragenSuchkriterium) any());
        assertSame(actualLadenResult, fragenFactory.laden());
    }
}

