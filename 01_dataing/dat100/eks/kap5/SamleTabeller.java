package kap5;

public class SamleTabeller {
    
    public static void main(String[] args) {
        System.out.println(" Slå sammen to tabeller:  ");
        System.out.println(" - - - - - - - - - - - - - - - - - ");
        int[] tall1 = {2, 40, 3};
        int[] tall2 = {13, 7, 8, 29};
        int[] tall3 = samleTabeller(tall1, tall2);
        printTallListe("Tabell 1", tall1);
        printTallListe("Tabell 2", tall2);
        printTallListe("Samlet tabell", tall3);
    }
    
    private static void printTallListe(String tittel, int[] tall) {
        System.out.println(tittel + ":");
        for (int i = 0; i < tall.length; i++) {
            System.out.print(tall[i] + " ");
        }
        System.out.print("\n");
    }

    private static int[] samleTabeller(int[] tabA, int[] tabB) {
        int nyLengde = tabA.length + tabB.length;
        int[] nyTab = new int[nyLengde];
        for (int i = 0; i < tabA.length; i++) {
            nyTab[i] = tabA[i];
        }
        for (int i = 0; i < tabB.length; i++) {
            nyTab[tabA.length + i] = tabB[i];
        }
        return nyTab;
    }
}
