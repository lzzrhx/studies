package innlevering3.tests;
import innlevering3.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestBilde {
    
    @Test
    public void testConstructor1() {
        Bilde bilde = new Bilde(1, "Ole Olsen", "23-10","et bilde","http://www.picture.com/oo.jpg");
        assertEquals("Ole Olsen", bilde.bruker());
        assertEquals(1, bilde.id());
        assertEquals("23-10", bilde.dato());
        assertEquals(0, bilde.likes());
        assertEquals("et bilde", bilde.tekst());
        assertEquals("http://www.picture.com/oo.jpg", bilde.url());
    }

    @Test
    public void testConstructor2() {
        Bilde bilde = new Bilde(1, "Ole Olsen", "23-10",7,"et bilde","http://www.picture.com/oo.jpg");
        assertEquals("Ole Olsen", bilde.bruker());
        assertEquals(1, bilde.id());
        assertEquals("23-10", bilde.dato());
        assertEquals(7, bilde.likes());
        assertEquals("et bilde", bilde.tekst());
        assertEquals("http://www.picture.com/oo.jpg", bilde.url());
    }

    @Test
    public void testSet() {
        Bilde bilde = new Bilde(1, "Ole Olsen", "23-10","et bilde","http://www.picture.com/oo.jpg");
        bilde.url("http://www.picture.com/new.jpg");
        assertEquals("http://www.picture.com/new.jpg", bilde.url());
    }

    @Test
    public void testToString() {
        Bilde bilde = new Bilde(1, "Ole Olsen", "23-10","et bilde","http://www.picture.com/oo.jpg");
        assertEquals("BILDE\n1\nOle Olsen\n23-10\n0\net bilde\nhttp://www.picture.com/oo.jpg\n", bilde.toString());
    }
}
