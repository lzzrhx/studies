package innlevering3.tests;
import innlevering3.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestSkrivBlogg {
    private static String FILNAVN = "blogg.dat";
    private static String MAPPE = System.getProperty("user.dir") + "/src/test/java/innlevering3/tests/";
    
    @Test
    public void testskriv() {
        Tekst innlegg1 = new Tekst(1, "Ole Olsen", "23-10", "en tekst");
        Bilde innlegg2 = new Bilde(2, "Oline Olsen", "24-10", "et bilde", "http://www.picture.com/oo.jpg");
        Blogg samling = new Blogg();
        samling.leggTil(innlegg1);
        samling.leggTil(innlegg2);
        assertTrue(SkrivBlogg.skriv(samling, MAPPE, FILNAVN));
    }
}
