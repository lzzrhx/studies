import java.util.Scanner;

public class OppgaveO2 {
    public static void main(String args[]) {
       
        // Lag nytt Scanner-objekt
        Scanner inn = new Scanner(System.in);
        
        // Start en løkke for å gjennomføre 10 innlesinger
        for (int i = 1; i <= 10; i++) {
            
            // Start do-while løkke for innlesing av poengsum og beregning av karakter
            boolean ugyldig;
            do {

                // Nullstill ugyldig variabelen og les innputt fra brukeren
                ugyldig = false;
                System.out.print("(" + i + ") Skriv inn oppnådd poengsum (heltall, 0 - 100): ");
                String innString = inn.nextLine();

                // Prøv å lese innputt fra bruker som heltall, kast unntak hvis det ikke er et heltall 
                try {
                
                    // Prøv å konverter innputt stringen til integer
                    int poeng = Integer.parseInt(innString);

                    // Skriv ut feilmelding hvis poengsummen er ugyldig (negativ eller over 100)
                    if (poeng > 100 || poeng < 0) {
                        ugyldig = true;
                        System.out.println("ERR! Ugyldig verdi.");
                    }

                    // Skriv ut karakter som tilsvarer poengsum
                    else {
                        String karakter;
                        if (poeng >= 90) {
                            karakter = "A";
                        } else if (poeng >= 80) {
                            karakter = "B";
                        } else if (poeng >= 60) {
                            karakter = "C";
                        } else if (poeng >= 50) {
                            karakter = "D";
                        } else if (poeng >= 40) {
                            karakter = "E";
                        } else {
                            karakter = "F";
                        }
                        System.out.println("(" + i + ") " + poeng + " poeng gir karakter " + karakter + ".\n");
                    }
                
                // Fang unntak og gi feilmelding hvis inntastet verdi ikke er heltall
                } catch (NumberFormatException e) {
                    ugyldig = true;
                    System.out.println("ERR! Ugyldig datatype.");
                }
                
            // Gjenta innlesing hvis pengsummen er en ugyldig
            } while (ugyldig);
        }

        // Avslutt innlesing fra tastaturet
        inn.close();
    }
}
