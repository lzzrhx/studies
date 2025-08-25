package kap5;

public class SorteringKontroll {
    
    public static void main(String[] args) {
        System.out.println(" Kontroll av sortering:  ");
        System.out.println(" - - - - - - - - - - - - ");

        // Liste over tall
        double[] tall = {3.69, -2.3, 5.0, 3.1, 7.75, 1.4}; // Usortert versjon
        //double[] tall = {-2.3, 1.4, 3.1, 3.69, 5.0, 7.75}; // Sortert versjon
        System.out.println("Liste av tall:");
        for (int i = 0; i < tall.length; i++) {
            System.out.print(tall[i] + " ");
        }
        System.out.print("\n");

        // Utfør kontroll
        boolean sortert = true;
        int i = 1;
        while (sortert && i < tall.length) {
            if (tall[i-1] <= tall[i]) {
                i++;
            } else {
                sortert = false;
            }
        }
        
        // Vis resultat
        System.out.print("Resultat: ");
        if (sortert) {
            System.out.println(" Tallene er sortert! :)");
        } else {
            System.out.println(" Tallene er ikke sortert! :(");
        }

    }
}
