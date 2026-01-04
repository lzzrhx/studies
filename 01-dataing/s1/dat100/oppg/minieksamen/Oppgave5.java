///////////////////////////////////////////////////////////////////////////////
// OPPGAVE 5
///////////////////////////////////////////////////////////////////////////////

// Del f)
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
import java.util.Scanner;

public class Oppgave5 {
  
  // Entry-point for programmet
  public static void main(String[] args) {
    Bestilling bestilling = opprettOgSkrivUtNyBestilling();
  }

  // Opprett og skriv ut ny bestilling
  private static Bestilling opprettOgSkrivUtNyBestilling() {
    Bestilling bestilling = opprettNyBestilling();
    bestilling.skrivUt();
    return bestilling;
  }

  // Opprett ny bestilling
  private static Bestilling opprettNyBestilling() {
    Bestilling bestilling = null;
    System.out.println("Opprett ny bestilling:");
    System.out.println("Tast 1 for å opprette ny SnarestMulig bestilling.");
    System.out.println("Tast 2 for å opprette ny Tidspunkt bestilling.");
    Scanner scanner = new Scanner(System.in);
    boolean gyldig = false;
    do {
      // Les innputt fra bruker
      String input = readInput(scanner, "Valg: ");
      // Behandle innputt
      try {
        // Prøv å konvertere innputt til heltall (kaster feilmelding hvis innputt ikke er heltall)
        int valg = Integer.parseInt(input);
        // Sjekk om tall er innenfor gitt ramme
        if (valg < 1 || valg > 2) {
          throw new Exception("Ugyldig tall inntastet");
        }
        // Opprett ny Bestilling
        else {
          int kontaktnummer = Integer.parseInt(readInput(scanner, "Kontaktnummer: "));
          String kundenavn = readInput(scanner, "Kundenavn: ");
          String adresse = readInput(scanner, "Adresse: ");
          // Opprett og skriv ut ny Tidspunkt bestilling
          if (valg == 2) {
            String dato = readInput(scanner, "Dato: ");
            String tidspunkt = readInput(scanner, "Tidspunkt: ");
            bestilling = new Tidspunkt(kontaktnummer, kundenavn, adresse, dato, tidspunkt);
            gyldig = true;
          // Opprett og skriv ut ny SnarestMulig bestilling
          } else {
            int maxtid = Integer.parseInt(readInput(scanner, "Max tid: "));
            bestilling = new SnarestMulig(kontaktnummer, kundenavn, adresse, maxtid);
            gyldig = true;
          }
        }
      // Fang og skriv ut feilmelding
      } catch (Exception e) {
        System.out.println("ERR! " + (e.getMessage() != null ? e.getMessage() : "Ugyldig datatype inntastet") + "!");
      }
    // Gjenta inntasting hvis innputt ikke er gyldig
    } while (!gyldig);
    // Avslutt scanner
    scanner.close();
    return bestilling;
  }
  
  // Motta innputt fra bruker
  private static String readInput(Scanner scanner, String message) {
      System.out.print(message);
      return scanner.nextLine();
  }
  
}

