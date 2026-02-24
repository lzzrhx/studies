import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class OppgaveO1 {
    public static void main(String args[]) {
        
        // Lag nytt Scanner-objekt
        Scanner inn = new Scanner(System.in);

        // Start do-while løkke for innlesing av bruttolønn og beregning av trinnskatt
        boolean ugyldig;
        do {

            // Nullstill ugyldig variabelen og les innputt fra bruker
            ugyldig = false;
            System.out.print(" Skriv inn bruttolønn i kroner (heltall): ");
            String innString = inn.nextLine();
            
            // Prøv å lese innputt fra bruker som heltall, kast unntak hvis det ikke er et heltall 
            try {
                
                // Formater innputt, fjern mellomrom, komma og punktum "123.000" -> "123000"
                int brutto = Integer.parseInt(innString.replaceAll("[\\s\\.,]", ""));

                // Skriv ut feilmelding hvis verdien er ugyldig (negativ)
                if (brutto < 0) {
                    ugyldig = true;
                    System.out.println(" ERR! Ugyldig verdi.");
                }

                // Beregn skatt for den gitte bruttolønnen
                else {
                    
                    // Oppsett av formatering for tall
                    DecimalFormat df = new DecimalFormat("###,###,###,##0.00");
                    DecimalFormatSymbols dfSymbol = new DecimalFormatSymbols();
                    dfSymbol.setGroupingSeparator(' ');
                    dfSymbol.setDecimalSeparator(',');
                    df.setDecimalFormatSymbols(dfSymbol);

                    // Oppsett av trinnverdier
                    double[] prosent = {1.7, 4.0, 13.7, 16.7, 17.7 };
                    int[] trinn = { 217_400, 306_050, 697_150, 942_400, 1_410_750 };
                    
                    // Start løkke med beregning for alle trinn
                    double skatt = 0.0;
                    for (int i = 0; i < trinn.length; i++) {
                        if (brutto > trinn[i]) {
                            int bruttotrinn = (i < trinn.length - 1) ? (int)Math.min(trinn[i+1] - trinn[i], brutto - trinn[i]) : brutto - trinn[i];
                            double trinnskatt = (double)bruttotrinn * prosent[i] * 0.01f;
                            skatt += trinnskatt;
                            System.out.println(" - - - - - - - - - - - - - -");
                            System.out.println("  Beregning for trinn " + (i+1) + " (" + prosent[i] + "%):");
                            System.out.println("   Brutto: " + df.format(bruttotrinn) + " kr");
                            System.out.println("   Trinnskatt: " + df.format(trinnskatt) + " kr");
                        }
                    }

                    // Skriv ut resultat
                    System.out.println(" - - - - - - - - - - - - - -");
                    System.out.println(" En bruttolønn på " + df.format(brutto) + " kr gir trinnskatt " + df.format(skatt) + " kr.");        
                }

            // Fang unntak og gi feilmelding hvis inntastet verdi ikke er heltall
            } catch (NumberFormatException e) {
                ugyldig = true;
                System.out.println(" ERR! Ugyldig datatype.");
            }

        // Gjenta innlesing hvis verdi er ugyldig
        } while (ugyldig);

        // Avslutt innlesing fra tastaturet
        inn.close();
    }
}
