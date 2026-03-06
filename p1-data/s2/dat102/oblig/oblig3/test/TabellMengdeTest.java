package test;

import src.MengdeADT;
import src.TabellMengde;

public class TabellMengdeTest extends AbstraktMengdeTest {
    @Override
    MengdeADT<Integer> opprettNyMengde() {
        return new TabellMengde<Integer>(); 
    }
}
