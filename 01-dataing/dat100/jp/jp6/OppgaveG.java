public class OppgaveG {
    public static void main(String[] args) {
        double[][] tab = {
            {1.4,1.7,1.9,2.0},
            {5.4,7.8,9.8,7.9,3.0},
            {-1.7,-1.7,-2.8}
        };

        // a)
        skrivUt(tab);

        // b)
        System.out.println(tab.length); // Dette gir 3 fordi tabellen tab inneholder 3 elementer
    
        // c)
        System.out.println(tab[0].length); // Dette gir 4 fordi den første nøstede tabellen inneholder 4 elementer
        System.out.println(tab[1].length); // Dette gir 5 fordi den første nøstede tabellen inneholder 5 elementer
        System.out.println(tab[2].length); // Dette gir 3 fordi den første nøstede tabellen inneholder 3 elementer

        // d)
        System.out.println(finnes(tab, 9.7));
        System.out.println(finnes(tab, 9.9));

        // e)
        tab = new double[][]{ tab[2], tab[1], tab[0] };
        skrivUt(tab);
    }

    public static void skrivUt(double[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void skrivUtAlt(double[][] tab) {
        for (double[] subtab: tab) {
            for (double n: subtab) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }


    public static boolean finnes(double[][] tab, double limit) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j] > limit) {
                    return true;
                }
            }
        }
        return false;
    }

}
