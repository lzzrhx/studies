import java.util.Scanner;
import java.text.DecimalFormat;

public class OppgaveO1 {
    public static void main(String args[]) {
        
        // Lag nytt Scanner-objekt
        Scanner inn = new Scanner(System.in);

        // Start do-while løkke for innlesing av bruttolønn og beregning av trinnskatt
        boolean ugyldig;
        do {

            // Nullstill ugyldig variabelen og les inn innputt fra brukeren
            ugyldig = false;
            System.out.print("Skriv inn bruttolønn i kroner (heltall): ");
            String innString = inn.nextLine();
            
            // Prøv å lese innputt fra bruker som heltall, kast unntak hvis det ikke er et heltall 
            try {
                
                // Formater innputt, fjern mellomrom, komma og punktum "123.000" -> "123000"
                long brutto = Long.parseLong(innString.replaceAll("[\\s\\.,]", ""));

                // Skriv ut feilmelding hvis verdien er ugyldig (negativ)
                if (brutto < 0) {
                    ugyldig = true;
                    System.out.println("ERR! Ugyldig verdi.");
                }

                // Finn trinnskattprosent som tilsvarer bruttolønn
                else {
                    double skattProsent;
                    if (brutto > 1_410_750) {
                        skattProsent = 17.7;
                    } else if (brutto > 942_400) {
                        skattProsent = 16.7;
                    } else if (brutto > 697_150) {
                        skattProsent = 13.7;
                    } else if (brutto > 306_050) {
                        skattProsent = 4.0;
                    } else if (brutto > 217_400) {
                        skattProsent = 1.7;
                    } else {
                        skattProsent = 0.0;
                    }

                    // Beregn trinnskatt
                    double trinnskatt = (double)brutto * (skattProsent * 0.01);

                    // Skriv ut formatert resultat
                    DecimalFormat df = new DecimalFormat("###,###,###,###");
                    System.out.println("En bruttolønn på " + df.format(brutto) + " kr gir trinnskatt " + df.format(Math.round(trinnskatt)) + " kr (" + skattProsent + "%).");        
                }

            // Fang unntak og gi feilmelding hvis inntastet verdi ikke er heltall
            } catch (NumberFormatException e) {
                ugyldig = true;
                System.out.println("ERR! Ugyldig datatype.");
            }

        // Gjenta innlesing hvis verdi er ugyldig
        } while (ugyldig);

        // Avslutt innlesing fra tastaturet
        inn.close();
    }
}
