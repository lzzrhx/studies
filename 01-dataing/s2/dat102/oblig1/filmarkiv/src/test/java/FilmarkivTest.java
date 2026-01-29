import no.hvl.data102.filmarkiv.impl.*;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FilmarkivTest {

    @Test
    void test() {
        testFilmarkiv(new Filmarkiv(10));
        testFilmarkiv(new Filmarkiv2());
    }

    void testFilmarkiv(FilmarkivADT filmarkiv) {
        assertEquals(filmarkiv.antall(), 0);
        
        filmarkiv.leggTilFilm(new Film(0, "tittel på film", 1999, Sjanger.DRAMA, "testnavn for filmselskap", "navn for produsent"));
        filmarkiv.leggTilFilm(new Film(1, "film2", 2999, Sjanger.DOKUMENTAR, "filmselskap", "produsent"));
        
        assertEquals(filmarkiv.antall(), 2);
        assertEquals(filmarkiv.antall(Sjanger.DRAMA), 1);
        
        assertEquals(filmarkiv.finnFilm(1).nr(), 1);

        assertEquals(1, filmarkiv.sokTittel("ittel på").length);
        assertEquals(1, filmarkiv.sokProdusent("or produs").length);
        assertEquals(1, filmarkiv.sokTittel("film2").length);

        filmarkiv.slettFilm(1);
        assertEquals(1, filmarkiv.antall());
        assertEquals(null, filmarkiv.finnFilm(1));
        assertEquals(0, filmarkiv.sokTittel("film2").length);
        
        filmarkiv.slettFilm(0);
        assertEquals(0, filmarkiv.antall());
        assertEquals(null, filmarkiv.finnFilm(0));
    }
}
