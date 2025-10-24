package innlevering3.tests;
import innlevering3.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestHtmlBlogg {
    private static String MAPPE = System.getProperty("user.dir") + "/src/test/java/innlevering3/tests/";
    private static String FILNAVN = "blogg.html";

    @Test
    public void testskriv() {
        Tekst innlegg1 = new Tekst(1, "Ole Olsen", "23-10", "DAT100 oppgave 6");
        Bilde innlegg2 = new Bilde(2, "Oline Olsen", "24-10", "HVL logo", "https://www.west-norway.no/wp-content/uploads/2018/05/HVL-nettside.jpg");
        HtmlBlogg samling = new HtmlBlogg();
        samling.leggTil(innlegg1);
        samling.leggTil(innlegg2);
        assertTrue(SkrivBlogg.skriv(samling, MAPPE, FILNAVN));
    }
}
