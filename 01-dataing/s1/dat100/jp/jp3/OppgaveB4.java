import java.util.Scanner;
public class OppgaveB4 {
    public static void main(String args[]) {
        // Lag nytt Scanner-objekt
        Scanner in = new Scanner(System.in);
                
        // Les inn heltall fra brukeren
        System.out.println("Program for å regne ut x^n");
        System.out.print("Skriv inn x: ");
        double x = in.nextDouble();
        System.out.print("Skriv inn n: ");
        double n = in.nextDouble();
        double pow1 = Math.pow(x,n);
        double pow2 = pow(x,n);
        System.out.println("Math.pow() x^n = " + pow1);
        System.out.println("pow()      x^n = " + pow2);
        
        // Avslutt Scanner-objektets tastatur-innlesing
        in.close();
    }

    // Regn ut eksponent (x^n)
    private static double pow(double x, double n) {
        double resultat = 1.0;
        for (int i = 0; i < n; i++) {
            resultat *= x;
        }
        return resultat;
    }
}
