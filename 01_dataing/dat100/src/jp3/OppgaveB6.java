import java.util.Scanner;
import java.text.DecimalFormat;

public class OppgaveB6 {
    public static void main(String args[]) {
        
        // Lag nytt Scanner-objekt
        Scanner in = new Scanner(System.in);

        boolean ugyldig;
        do {

            // Les inn heltall fra brukeren
            ugyldig = false;
            System.out.print("Skriv inn bruttolønn i kroner (heltall): ");
            long brutto = in.nextLong();

            // TODO:Håndtering av innlesing av feil datatype (annet enn heltall)

            // Skriv ut feilmelding hvis verdien er ugyldig
            if (brutto < 0) {
                ugyldig = true;
                System.out.println("ERR! Ugyldig verdi.");
            }
            // Finn trinnskattprosent som tilsvarer bruttolønn
            else {
                double skattProsent;
                if (brutto > 1_350_000) {
                    skattProsent = 17.6;
                } else if (brutto > 937_900) {
                    skattProsent = 16.6;
                } else if (brutto > 670_000) {
                    skattProsent = 13.6;
                } else if (brutto > 292_850) {
                    skattProsent = 4.0;
                } else if (brutto > 208_050) {
                    skattProsent = 1.7;
                } else {
                    skattProsent = 0.0;
                }
                // Beregn trinnskatt
                double trinnskatt = (double)brutto * (skattProsent * 0.01);

                // Skriv ut resultat
                DecimalFormat df = new DecimalFormat("###,###,###,###");
                System.out.println("En bruttolønn på " + df.format(brutto) + " kr gir trinnskatt " + df.format(Math.round(trinnskatt)) + " kr (" + skattProsent + "%).");
            }
        
        // Gjenta innlesing hvis verdi er ugyldig
        } while (ugyldig);
    }
}
