package innlevering3.tests;
import innlevering3.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestInnlegg {

    @Test
    public void testConstructor1() {
        TInnlegg innlegg = new TInnlegg(1, "Ole Olsen", "23-10");
        assertEquals("Ole Olsen", innlegg.bruker());
        assertEquals(1, innlegg.id());
        assertEquals(0, innlegg.likes());
        assertEquals("23-10", innlegg.dato()); 
    }

    @Test
    public void testConstructor2() {
        TInnlegg innlegg = new TInnlegg(1, "Ole Olsen", "23-10", 7);
        assertEquals("Ole Olsen", innlegg.bruker());
        assertEquals(1, innlegg.id());
        assertEquals(7, innlegg.likes());
        assertEquals("23-10",innlegg.dato()); 
    }

    @Test
    public void testSet() {
        TInnlegg innlegg = new TInnlegg(1, "Ole Olsen", "23-10", 7);
        innlegg.bruker("Oline Olsen");
        innlegg.dato("24-10");
        assertEquals("Oline Olsen", innlegg.bruker());
        assertEquals("24-10", innlegg.dato());
    }

    @Test
    public void testdoLike() {
        TInnlegg innlegg = new TInnlegg(1, "Ole Olsen", "23-10");
        assertEquals(0, innlegg.likes());
        innlegg.like();
        assertEquals(1, innlegg.likes());
    }
 
    @Test
    public void testLik() {
        TInnlegg innlegg1 = new TInnlegg(1, "Ole Olsen","23-10");
        TInnlegg innlegg2 = new TInnlegg(2, "Oline Olsen","24-10");
        assertFalse(innlegg1.equals(innlegg2));
        assertTrue(innlegg1.equals(innlegg1));
    }
    
    @Test
    public void testtoString () {
        TInnlegg innlegg = new TInnlegg(1, "Ole Olsen","23-10");
        assertEquals("1\nOle Olsen\n23-10\n0\n", innlegg.toString());
    }

}
