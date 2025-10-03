public class Vare {
    private int varenr;
    private String navn;
    private double pris;

    // Konstruktør
    public Vare(int varenr, String navn, double pris) {
        this.varenr = varenr;
        this.navn = navn;
        this.pris = pris;
        System.out.println("Ny vare laget: " + this.toString());
    }

    // Getter for varenr
    public int varenr() {
        return varenr;
    }

    // Setter for varenr
    public void varenr(int varenr) {
        this.varenr = varenr;
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

    public double beregnMoms() {
        return pris * 0.2;
    }

    public boolean erBilligereEnn(Vare v) {
        return pris > v.pris;
    }

    public String toString() {
        return "Vare [varenr=" + varenr + ", navn=" + navn + ", pris=" + pris + "]";
    }
}
