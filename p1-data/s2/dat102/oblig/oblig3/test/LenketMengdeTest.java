package test;

import src.MengdeADT;
import src.LenketMengde;

public class LenketMengdeTest extends AbstraktMengdeTest {
    @Override
    MengdeADT<Integer> opprettNyMengde() {
        return new LenketMengde<Integer>(); 
    }
}
