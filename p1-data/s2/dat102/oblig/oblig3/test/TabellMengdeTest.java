package test;

import src.MengdeADT;
import src.TabellMengde;
import org.junit.jupiter.api.BeforeAll;

public class TabellMengdeTest extends MengdeTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Kjører TabellMengdeTest.");
    }

    @Override
    MengdeADT<Integer> opprettNyMengde() {
        return new TabellMengde<Integer>(); 
    }
}
