package kap6;

public class FlereKonstruktorer {
    private int    nr;
    private String navn;
    private double pris;
    private int    antall;

    public FlereKonstruktorer(int nr, String navn, double pris, int antall) {
        this.nr     = nr;
        this.navn   = navn;
        this.pris   = pris;
        this.antall = antall;
    }

    public FlereKonstruktorer(int nr, String navn, double pris) {
        this(nr, navn, pris, 0);
    }
    
    public FlereKonstruktorer(int nr, String navn) {
        this(nr, navn, 0, 0);
    }

    // TODO: legg til set & get metoder

    public String toString() {
        return nr + " " + navn + ": " + pris + " kr." + " (" + antall + " på lager)";
    }
}
