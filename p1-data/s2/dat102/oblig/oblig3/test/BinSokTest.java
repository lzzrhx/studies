package test;

import src.BinSok;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

public class BinSokTest {
    private Integer[] tab = new Integer[] { 1, 1, 1, 1, 1, 1, 2, 3, 4, 5, 5, 5, 6, 6, 7, 8, 9, 9, 10 };
   
    @BeforeAll
    static void beforeAll() {
        System.out.println("Kjører BinSokTest.");
    }

    @Test
    void antLikeNaboElementer() {
        assertEquals(5, BinSok.antLikeNaboElementer(tab,  0));
        assertEquals(5, BinSok.antLikeNaboElementer(tab,  1));
        assertEquals(5, BinSok.antLikeNaboElementer(tab,  2));
        assertEquals(5, BinSok.antLikeNaboElementer(tab,  3));
        assertEquals(5, BinSok.antLikeNaboElementer(tab,  4));
        assertEquals(5, BinSok.antLikeNaboElementer(tab,  5));
        assertEquals(0, BinSok.antLikeNaboElementer(tab,  6));
        assertEquals(0, BinSok.antLikeNaboElementer(tab,  7));
        assertEquals(0, BinSok.antLikeNaboElementer(tab,  8));
        assertEquals(2, BinSok.antLikeNaboElementer(tab,  9));
        assertEquals(2, BinSok.antLikeNaboElementer(tab, 10));
        assertEquals(2, BinSok.antLikeNaboElementer(tab, 11));
        assertEquals(1, BinSok.antLikeNaboElementer(tab, 12));
        assertEquals(1, BinSok.antLikeNaboElementer(tab, 13));
        assertEquals(0, BinSok.antLikeNaboElementer(tab, 14));
        assertEquals(0, BinSok.antLikeNaboElementer(tab, 15));
        assertEquals(1, BinSok.antLikeNaboElementer(tab, 16));
        assertEquals(1, BinSok.antLikeNaboElementer(tab, 17));
        assertEquals(0, BinSok.antLikeNaboElementer(tab, 18));
    }
    
    @Test
    void rekursivt() {
        assertEquals(6, BinSok.rekursivt(tab,  1));
        assertEquals(1, BinSok.rekursivt(tab,  2));
        assertEquals(1, BinSok.rekursivt(tab,  3));
        assertEquals(1, BinSok.rekursivt(tab,  4));
        assertEquals(3, BinSok.rekursivt(tab,  5));
        assertEquals(2, BinSok.rekursivt(tab,  6));
        assertEquals(1, BinSok.rekursivt(tab,  7));
        assertEquals(1, BinSok.rekursivt(tab,  8));
        assertEquals(2, BinSok.rekursivt(tab,  9));
        assertEquals(1, BinSok.rekursivt(tab, 10));
    }
    
    @Test
    void iterativt() {
        assertEquals(6, BinSok.iterativt(tab,  1));
        assertEquals(1, BinSok.iterativt(tab,  2));
        assertEquals(1, BinSok.iterativt(tab,  3));
        assertEquals(1, BinSok.iterativt(tab,  4));
        assertEquals(3, BinSok.iterativt(tab,  5));
        assertEquals(2, BinSok.iterativt(tab,  6));
        assertEquals(1, BinSok.iterativt(tab,  7));
        assertEquals(1, BinSok.iterativt(tab,  8));
        assertEquals(2, BinSok.iterativt(tab,  9));
        assertEquals(1, BinSok.iterativt(tab, 10));
    }
}
