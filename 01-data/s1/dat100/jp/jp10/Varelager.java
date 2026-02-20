public class Varelager {

    // Objektvariabler
    private Vare[] varer;
    private int antall = 0;

    // Konstruktør
    public Varelager(int n) {
        varer = new Vare[n];
    }

    // Getter for varetabell
    public Vare[] varer() {
        return varer;
    }

    // Legg til vare
    public boolean leggTil(Vare v) {
        if (antall < varer.length) {
            varer[antall] = v;
            antall++;
            return true;
        } else {
            return false;
        }
    }

    // Legg til vare
    public boolean leggTil(int nr, String navn, double pris) {
        return leggTil(new Vare(nr, navn, pris));
    }

    // Finn vare etter varenr
    public Vare finn(int nr) {
        for (int i = 0; i < antall; i++) {
            if (varer[i].nr() == nr) {
                return varer[i];
            }
        }
        return null;
    }

    // Stringrepresentasjon av objekt
    public String toString() {
        String result = "=================================\n";
        for (int i = 0; i < antall; i++) {
            result += varer[i] + "\n";
        }
        return result + "=================================";
    }

    // Print objekt
    public void print() {
        System.out.println(this);
    }
    
    // Finn billigste vare fra gitt varelager
    public static Vare billigste(Varelager vl) {
        if (vl.antall == 0) {
            return null;
        } else {
            Vare v = vl.varer()[0];
            for (int i = 1; i < vl.antall; i++) {
                v = Vare.billigste(v, vl.varer()[i]);
            }
            return v;
        }
    }

    // Beregn samlet pris på alle varer i gitt varelager
    public static double totalPris(Varelager vl) {
        double sum = 0.0;
        for (Vare v : vl.varer) {
            sum += v.pris();
        }
        return sum;
    }

    // Generer tabell med varenummer for alle varer i gitt varelager
    public static int[] nr(Varelager vl) {
        int[] res = new int[vl.antall];
        for (int i = 0; i < vl.antall; i++) {
            res[i] = vl.varer[i].nr();
        }
        return res;
    }

    // Generer tabell med prisdifferanser for alle varer i gitt varelager
    public static double[] prisDifferanser(Varelager vl) {
        if (vl.antall < 2) {
            return null;
        } else {
            double[] res = new double[vl.antall-1];
            for (int i = 0; i < vl.antall- 1; i++) {
                res[i] = Math.abs(vl.varer[i].pris() - vl.varer[i+1].pris());
            }
            return res;
        }
    }
}
