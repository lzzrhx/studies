public class Vare {
    
    // Klassevariabler
    private static final double MOMS = 0.2;
    
    // Objektvariabler
    private int nr;
    private String navn;
    private double pris;

    // Konstruktør
    public Vare(int nr, String navn, double pris) {
        this.nr = nr;
        this.navn = navn;
        this.pris = pris;
    }

    // Getter for varenr
    public int nr() {
        return nr;
    }

    // Setter for varenr
    public void nr(int nr) {
        this.nr = nr;
    }

    // Getter for navn
    public String navn() {
        return navn;
    }

    // Setter for navn
    public void navn(String navn) {
        this.navn = navn;
    }

    // Getter for pris
    public double pris() {
        return pris;
    }

    // Setter for pris
    public void pris(double pris) {
        this.pris = pris;
    }

    // Bergen moms
    public double moms() {
        return pris * MOMS;
    }

    // Stringrepresentasjon av objektet
    public String toString() {
        return "Vare [varenr=" + nr + ", navn=" + navn + ", pris=" + pris + "]";
    }

    // Sammenlign pris med annen vare
    public boolean billigereEnn(Vare v) {
        return pris < v.pris;
    }

    // Finn den billigste av to varer
    public static Vare billigste(Vare a, Vare b) {
        return a.billigereEnn(b) ? a : b;
    }
}
