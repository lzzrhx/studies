import java.util.Scanner;

public class OppgaveB5 {
    public static void main(String args[]) {
       
        // Lag nytt Scanner-objekt
        Scanner in = new Scanner(System.in);
        
        // Start en løkke for å gjennomføre 10 innlesinger
        for (int i = 1; i <= 10; i++) {
            boolean ugyldig;
            do {

                // Les inn heltall fra brukeren
                ugyldig = false;
                System.out.print("(" + i + ") Skriv inn oppnådd poengsum (heltall, 0 - 100): ");
                int poeng = in.nextInt();

                // TODO:Håndtering av innlesing av feil datatype (annet enn int)

                // Skriv ut feilmelding hvis poengsummen er utenfor verdiområdet
                if (poeng > 100 || poeng < 0) {
                    ugyldig = true;
                    System.out.println("ERR! Ugyldig verdi.");
                }
                // Skriv ut karakter som tilsvarer poengsum
                else {
                    String karakter;
                    if (poeng > 82) {
                        karakter = "A";
                    } else if (poeng > 66) {
                        karakter = "B";
                    } else if (poeng > 50) {
                        karakter = "C";
                    } else if (poeng > 33) {
                        karakter = "D";
                    } else if (poeng > 16) {
                        karakter = "E";
                    } else {
                        karakter = "F";
                    }
                    System.out.println("(" + i + ") " + poeng + " poeng gir karakter " + karakter + ".\n");
                }
            
            // Gjenta innlesing hvis pengsummen er en ugyldig
            } while (ugyldig);
        }

        // Avslutt Scanner-objektets tastatur-innlesing
        in.close();
    }
}
