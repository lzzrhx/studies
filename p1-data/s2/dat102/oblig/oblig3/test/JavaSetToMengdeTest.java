package test;

import src.MengdeADT;
import src.JavaSetToMengde;
import org.junit.jupiter.api.BeforeAll;

public class JavaSetToMengdeTest extends MengdeTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Kjører JavaSetToMengdeTest.");
    }

    @Override
    MengdeADT<Integer> opprettNyMengde() {
        return new JavaSetToMengde<Integer>(); 
    }
}
