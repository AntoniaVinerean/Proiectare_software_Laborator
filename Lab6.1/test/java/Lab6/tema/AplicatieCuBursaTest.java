package Lab6.tema;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class AplicatieCuBursaTest {

    @Test
    public void testSorteazaCriterii() {
        AplicatieCuBursa app = new AplicatieCuBursa();
        List<StudentiBursieri> lista = app.genereaza();
        List<StudentiBursieri> sortata = app.sorteaza(lista);

        assertNotNull(sortata, "Lista sortată nu ar trebui să fie null");
        assertFalse(sortata.isEmpty(), "Lista sortată nu ar trebui să fie goală");
        assertEquals("Ioan", sortata.get(0).getNume(), "Primul student după sortare ar trebui să fie Mihalcea");
        assertTrue(sortata.get(0).getFormatieDeStudiu().compareTo(sortata.get(sortata.size()-1).getFormatieDeStudiu()) <= 0);
    }
}
