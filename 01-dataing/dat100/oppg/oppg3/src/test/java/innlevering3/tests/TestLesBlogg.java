package innlevering3.tests;
import innlevering3.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestLesBlogg {
    private static String MAPPE = System.getProperty("user.dir") + "/src/test/java/innlevering3/tests/";
    private static String FILNAVN = "bloggkorrekt.dat";

    @Test
    public void testles() {
        Blogg samling = LesBlogg.les(MAPPE,FILNAVN);
        Tekst innlegg1 = new Tekst(1, "Ole Olsen", "23-10", "en tekst");
        Bilde innlegg2 = new Bilde(2, "Oline Olsen", "24-10", "et bilde", "http://www.picture.com/oo.jpg");
        assertEquals(samling.antall(), 2);
        assertTrue(samling.finnes(innlegg1));
        assertTrue(samling.finnes(innlegg2));
        System.out.println(samling.toString());
    }
}
