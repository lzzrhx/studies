package kap5;

public class PlukkSortering {
    
    public static void main(String[] args) {
        System.out.println(" Plukksortering med hjelpetabell:  ");
        System.out.println(" - - - - - - - - - - - - - - - - - ");

        // Liste over tall
        int[] tall = {7, 2, 1, 4};
        System.out.println("Liste av tall: ");
        printTallListe(tall);

        // Utfør sortering
        int[] nyeTall = new int[tall.length];
        for (int tallNr = 0; tallNr < tall.length; tallNr++) {
            int minPos = 0;
            for (int posNr = 1; posNr < tall.length; posNr++) {
                if (tall[posNr] < tall[minPos]) {
                    minPos = posNr;
                }
            }
            nyeTall[tallNr] = tall[minPos];
            tall[minPos] = Integer.MAX_VALUE;
        }
        tall = nyeTall;

        // Vis resultat
        System.out.println("Sortert resultat: ");
        printTallListe(tall);
    }

    private static void printTallListe(int[] tall) {
        for (int i = 0; i < tall.length; i++) {
            System.out.print(tall[i] + " ");
        }
        System.out.print("\n");
    }
}
