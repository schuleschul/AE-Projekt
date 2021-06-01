import java.util.ArrayList;

public class ThemenFactoryTest {

    @Test
    public void testLaden() {
        DatenbankInterface datenbankInterface = mock(DatenbankInterface.class);
        ArrayList<Thema> themaList = new ArrayList<Thema>();
        when(datenbankInterface.laden((FachSuchkriterium) any())).thenReturn(themaList);
        ArrayList<Thema> actualLadenResult = (new ThemenFactory(datenbankInterface)).laden();
        assertSame(themaList, actualLadenResult);
        assertTrue(actualLadenResult.isEmpty());
        verify(datenbankInterface).laden((FachSuchkriterium) any());
    }

    @Test
    public void testLaden2() {
        DatenbankInterface datenbankInterface = mock(DatenbankInterface.class);
        ArrayList<Thema> themaList = new ArrayList<Thema>();
        when(datenbankInterface.laden((FachSuchkriterium) any())).thenReturn(themaList);
        ThemenFactory themenFactory = new ThemenFactory(datenbankInterface);
        ArrayList<Thema> actualLadenResult = themenFactory.laden(new FachSuchkriterium());
        assertSame(themaList, actualLadenResult);
        assertTrue(actualLadenResult.isEmpty());
        verify(datenbankInterface).laden((FachSuchkriterium) any());
        assertSame(actualLadenResult, themenFactory.laden());
    }

    @Test
    public void testSpeichern() {
        DatenbankInterface datenbankInterface = mock(DatenbankInterface.class);
        doNothing().when(datenbankInterface).speichern((Thema) any());
        ThemenFactory themenFactory = new ThemenFactory(datenbankInterface);
        themenFactory.speichern("Bezeichnung");
        verify(datenbankInterface).speichern((Thema) any());
        assertTrue(themenFactory.laden().isEmpty());
    }
}