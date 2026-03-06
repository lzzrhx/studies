package test;

import src.MengdeADT;
import src.JavaSetToMengde;

public class JavaSetToMengdeTest extends AbstraktMengdeTest {
    @Override
    MengdeADT<Integer> opprettNyMengde() {
        return new JavaSetToMengde<Integer>(); 
    }
}
