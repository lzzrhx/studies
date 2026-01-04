public class OppgaveG1 {
    public static void main(String[] args) {
        
        System.out.println("OppgaveG1");

        // a)
        int[] tab = { 1, 3, 4, 7, 9, 10 };
        
        // b)
        System.out.println();
        System.out.println("b)");
        System.out.print(" tab[2]: ");
        System.out.print(tab[2]);
        
        // c)
        tab[2] = 7;

        // d)
        System.out.println("\n");
        System.out.println("d)");
        System.out.print(" tab: ");
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }

        // e)
        System.out.println("\n");
        System.out.println("e)");
        System.out.print(" skrivUt(tab): ");
        skrivUt(tab);

        // f)
        System.out.println("\n");
        System.out.println("f)");
        System.out.print(" skrivUtModifisert(tab): ");
        skrivUtModifisert(tab);

        // g)
        System.out.println("\n");
        System.out.println("g)");
        for (int i = 1; i <= 10; i++) {
            System.out.println(" finnes(   tab, " + i + "): " + finnes(tab, i));
            System.out.println(" finnesAlt(tab, " + i + "): " + finnesAlt(tab, i));
        }
    }

    public static void skrivUt(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
    }
    
    public static void skrivUtModifisert(int[] tab) {
        for (int n : tab) {
            System.out.print(n + " ");
        }
    }
    
    public static boolean finnes(int[] tab, int n) {
        boolean funnet = false;
        int i = 0;
        while (i < tab.length && !funnet) {
            funnet = tab[i] == n;
            i++;
        }
        return funnet;
    }

    public static boolean finnesAlt(int[] tab, int n) {
        boolean funnet = false;
        int i = 0;
        while (!(funnet = tab[i] == n) && (i++ + 1 < tab.length));
        return funnet;
    }
    
}
