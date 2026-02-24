// Løsning med færre linjer
public class OppgaveO1Alt {
    public static void main(String args[]) {
        int[] brutto = { 217_400, 217_500, 306_150, 697_250, 942_500, 1_410_850 };
        for (int i = 0; i < brutto.length; trinnskatt(brutto[i]), i++);
    }
    private static void trinnskatt(int brutto) {
        int[][] trinn = { {17, 40, 137, 167, 177 }, { 217_400, 306_050, 697_150, 942_400, 1_410_750 } };
        double skatt = 0.0;
        for (int i = 0; i < trinn[0].length; skatt += (brutto > trinn[1][i]) ? (( (i < trinn[0].length - 1) ? Math.min(trinn[1][i+1] - trinn[1][i], brutto - trinn[1][i]) : (double)(brutto - trinn[1][i]) ) * (double)trinn[0][i] * 0.001) : 0.0, i++);
        System.out.println(" En bruttolønn på " + brutto + " kr gir trinnskatt " + skatt + " kr.");
    }
}
