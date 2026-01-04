public class TerningSim {

    // Konstanter
    public static final int NUM = 100;

    // Objektvariabler
    private Terning[] terninger = new Terning[NUM];
    private int[] resultat = new int[Terning.MAX];
    private int forsteM = -1;
    private int sum = 0;
    private int flest = 0;
    private boolean verbose;

    // Konstruktør
    public TerningSim() {
        this(false);
    }
    
    // Konstruktør
    public TerningSim(boolean verbose) {
        this.verbose = verbose;
        run();
        print();
    }

    // Kjør simulasjon
    private void run() {
        for (int i = 0; i < NUM; i++) {
            terninger[i] = new Terning();
            resultat[terninger[i].n()-1]++;
            sum += terninger[i].n();
            if (forsteM == -1 && terninger[i].n() == Terning.MAX) {
                forsteM = i+1;
            }
        }
        for (int i = 0; i < Terning.MAX; i++) {
            if (resultat[i] > resultat[flest]) {
                flest = i;
            }
        }
        flest++;
    }

    // Strengrespresentasjon av objektet
    public String toString() {
        String res = "\n";
        res += "-------------------------------------------------------------------------------\n";
        res += " TERNINGKASTSIMULATOR\n";
        res += "-------------------------------------------------------------------------------\n";
        res += "\n";
        for (int i = 0; i < NUM; i++) {
            res += " " + (verbose ? terninger[i].n() : terninger[i]) + ((i+1) % 20 == 0 ? "\n" : "  ");
        }
        res += "\n";
        res += " Antall kast:  " + NUM + "\n";
        for (int i = Terning.MAX-1; i >= 0; i--) {
            res += "  Antall " + (i+1) + "-ere: " + resultat[i] + "\n";
        }
        res += "\n";
        res += "Gj.snitt.: " + (double)((double)sum / (double)NUM) + "\n";
        res += "Ant. kast for å få den første " + Terning.MAX + "-eren: " + forsteM + "\n";
        res += "Terningverdi det var flest av: " + flest + "\n";
        return res;
    }

    // Utskrift av objektet
    private void print() {
        System.out.println(this);
    }

}
