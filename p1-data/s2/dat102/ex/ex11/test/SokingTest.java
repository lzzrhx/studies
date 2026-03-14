package test;

import src.Node;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

public class SokingTest {
    static Integer[] tomTabell = {};
    static Integer[] usortertTabell = new Integer[] { 2, 8, 0, 4, 6 };
    static Integer[] sortertTabell = new Integer[] { 0, 2, 4, 6, 8 };
    static Node<Integer> tomLenke;
    static Node<Integer> usortertLenke;
    static Node<Integer> sortertLenke;

    @BeforeAll
    static void oppsett() {
        usortertLenke = lagLenke(usortertTabell);
        sortertLenke  = lagLenke( 0, 2, 4, 6, 8 );
    }

    static <T> Node<T> lagLenke(
        @SuppressWarnings("unchecked") T ... verdier) {
        Node<T> forste = null;
        for (int i=verdier.length - 1; i >= 0; i--) { // Baklengs n-1 .. 0
            Node<T> temp = new Node<>(verdier[i]);
            temp.neste = forste;
            forste = temp;
        }
        return forste;
    }

    @Test
    void testSokUsortertTabell() {
    }
}
