package test;

import src.MengdeADT;
import src.LenketMengde;
import org.junit.jupiter.api.BeforeAll;

public class LenketMengdeTest extends MengdeTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Kjører LenketMengdeTest.");
    }

    @Override
    MengdeADT<Integer> opprettNyMengde() {
        return new LenketMengde<Integer>(); 
    }
}
