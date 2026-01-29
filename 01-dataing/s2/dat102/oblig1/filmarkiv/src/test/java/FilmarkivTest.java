import no.hvl.data102.filmarkiv.impl.*;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FilmarkivTest {

    @Test
    void Test() {
        Filmarkiv filmarkiv = new Filmarkiv(10);
        assertEquals(filmarkiv.antall(), 0);
        filmarkiv.leggTilFilm(new Film("tittel på film", 1999, Sjanger.DRAMA, "testnavn for filmselskap", "navn for produsent"));
        assertEquals(filmarkiv.antall(), 1);
        assertEquals(filmarkiv.antall(Sjanger.DRAMA), 1);
        assertEquals(filmarkiv.finnFilm(1).nr(), 1);
        assertEquals(1, filmarkiv.sokTittel("ittel på").length);
        assertEquals(1, filmarkiv.sokProdusent("or produs").length);
        filmarkiv.slettFilm(1);
        assertEquals(0, filmarkiv.antall());
        assertEquals(null, filmarkiv.finnFilm(1));
        assertEquals(0, filmarkiv.sokTittel("ittel på").length);
        assertEquals(0, filmarkiv.sokProdusent("or produs").length);
    }
}
