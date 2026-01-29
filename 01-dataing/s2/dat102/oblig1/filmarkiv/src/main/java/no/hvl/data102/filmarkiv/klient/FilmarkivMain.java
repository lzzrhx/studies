package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.*;
import no.hvl.data102.filmarkiv.klient.*;

public class FilmarkivMain {
    static void main() {
        FilmarkivADT filmarkiv = new Filmarkiv(100);
        Meny meny = new Meny(filmarkiv);
        meny.start();
    }
}
