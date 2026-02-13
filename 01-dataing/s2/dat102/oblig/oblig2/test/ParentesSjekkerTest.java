package test;

import src.ParentesSjekker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//assertTrue();
//assertFalse();
//assertEquals(expected, actual);
//assertArrayEquals(expected, actual);
//assertNull();
//assertNotNull();
//assertSame(a, b);
//assertNotSame(a, b);

public class ParentesSjekkerTest {
    @Test
    void test() {
        String[] strings = new String[5];
        strings[0] = "{ [ () ] }";
        strings[1] = "{ [ () }";
        strings[2] = "[ ( ) ] }";
        strings[3] = "{ [ ( ] ) }";
        strings[4] = """
            class HelloWorld {
                public static void main(String[] args) {
                System.out.println("Hello World!");
                }
            }""";
        assertTrue(ParentesSjekker.sjekk(strings[0]));
        assertFalse(ParentesSjekker.sjekk(strings[1]));
        assertFalse(ParentesSjekker.sjekk(strings[2]));
        assertFalse(ParentesSjekker.sjekk(strings[3]));
        assertTrue(ParentesSjekker.sjekk(strings[4]));
    }
}
