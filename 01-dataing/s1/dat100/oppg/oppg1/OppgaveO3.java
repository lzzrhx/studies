import java.util.Scanner;

public class OppgaveO3 {
    public static void main(String args[]) {
    
        // Lag nytt Scanner-objekt
        Scanner inn = new Scanner(System.in);
        
        // Les heltall fra bruker
        // Tallet må være positivt og ikke over 20 for å unngå å overstige kapasiteten til long datatypen
        // max verdi for long er 2^63 - 1
        // 2^63 - 1 = 9223372036854775807
        //      20! = 2432902008176640000
        //      21! = 51090942171709440000
        long tall;
        do {
            System.out.print("Skriv inn positivt heltall (1-20) for å beregne fakultet: ");
            tall = inn.nextLong();
            if (tall < 1 || tall > 20) { System.out.println("ERR! Verdien må være mellom 1 og 20."); }
        } while (tall < 1 || tall > 20);
        inn.close();
        
        // Skriv ut svar
        System.out.println(tall + "! = " + fakultet(tall));
        System.out.println(tall + "! = " + fakultetRekursiv(tall) + " (rekursiv metode)");
    }

    // Metode for å finne fakultet av tall
    private static long fakultet(long n) {
        for (long i = 1, j = n; i < j; n *= i, i++);
        return n;
    }

    // Rekursiv metode hentet fra eksempelkode for rekursiv fakultet i Java boken
    private static long fakultetRekursiv(long n) {
        if (n < 2) {
            return 1;
        } else {
            return n * fakultetRekursiv(n - 1);
        }
    }
}
