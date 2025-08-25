package kap5;
import java.util.Scanner;

public class SekvensieltSok {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Sekvensielt søk:  ");
        System.out.println(" - - - - - - - - - ");

        // Liste over tall
        double[] tall = {3.69, -2.3, 5.0, 3.1, 7.75, 1.4};
        System.out.println("Liste av tall:");
        for (int i = 0; i < tall.length; i++) {
            System.out.print(tall[i] + " ");
        }
        System.out.print("\n");
        
        // Motta søketall fra bruker
        System.out.print("Søk etter: ");
        double leterEtter = in.nextDouble();
        
        // Utfør søk
        boolean funnet = false;
        int i = 0;
        while (!funnet && i < tall.length) {
            if (tall[i] == leterEtter) {
                funnet = true;
            } else {
                i++;
            }
        }
        
        // Vis resultat
        System.out.print("Resultat: " + leterEtter);
        if (funnet) {
            System.out.println(" funnet! :)");
        } else {
            System.out.println(" ikke funnet! :(");
        }
        
        // Avslutt input
        in.close();
    }
}
