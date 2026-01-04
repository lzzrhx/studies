package kap7;
import static javax.swing.JOptionPane.showInputDialog;

public class TryCatchEksempel {
    public static void main(String[] args) {
        lesPositivtHeltall();
    }

    private static int lesPositivtHeltall() {
        int tall = 0;
        boolean ok;
        String feilmelding = "";
        do {
            ok = true;
            String tallTxt = showInputDialog(feilmelding+ "Gi positivt heltall:");
            try {
                tall = Integer.parseInt(tallTxt);
            }
            catch (NumberFormatException e) {
                ok = false;
                feilmelding = "Ulovlig verdi! \n";
            }
        } while (!ok);
        return tall;
    }
}
