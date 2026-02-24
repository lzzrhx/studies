package innlevering3.tests;
import innlevering3.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestTekst {
    
    @Test
    public void testConstructor1() {
        Tekst tekst = new Tekst(1, "Ole Olsen", "23-10", "en tekst");
        assertEquals("Ole Olsen", tekst.bruker());
        assertEquals(1, tekst.id());
        assertEquals(0, tekst.likes());
        assertEquals("23-10", tekst.dato());
        assertEquals("en tekst", tekst.tekst());
    }

    @Test
    public void testConstructor2() {
        Tekst tekst = new Tekst(1, "Ole Olsen", "23-10", 7, "en tekst");
        assertEquals("Ole Olsen", tekst.bruker());
        assertEquals(1, tekst.id());
        assertEquals(7, tekst.likes());
        assertEquals("23-10", tekst.dato());
        assertEquals("en tekst", tekst.tekst());
    }
    
    @Test
    public void testSet() {
        Tekst tekst = new Tekst(1, "Ole Olsen", "23-10", "en tekst");
        tekst.tekst("ny tekst");
        assertEquals("ny tekst", tekst.tekst());
    }
    
    @Test
    public void testToString() {
        Tekst tekst = new Tekst(1, "Ole Olsen", "23-10", "en tekst");
        assertEquals("TEKST\n1\nOle Olsen\n23-10\n0\nen tekst\n", tekst.toString());
    }

}
