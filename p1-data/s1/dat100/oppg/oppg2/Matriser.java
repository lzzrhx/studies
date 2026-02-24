package no.hvl.dat100.matriser;

public class Matriser {

    // a)
    public static void skrivUt(int[][] matrise) {
        System.out.println(tilStreng(matrise));
    }

    // b)
    public static String tilStreng(int[][] matrise) {
        String resultat = "";
        for (int[] rad: matrise) {
            for (int n: rad) {
                resultat += n + " ";
            }
            resultat += "\n";
        }
        return resultat;
    }

    // c)
    public static int[][] skaler(int tall, int[][] matrise) {
        int[][] resultat = new int[matrise.length][matrise[0].length];
        for (int i = 0; i < matrise.length; i++) {
            for (int j = 0; j < matrise[i].length; j++) {
                resultat[i][j] = matrise[i][j] * tall;
            }
        }
        return resultat;
    }

    // d)
    public static boolean erLik(int[][] a, int[][] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i].length != b[i].length) {
                return false;
            }
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // e)
    public static int[][] speile(int[][] matrise) {
        int[][] resultat = new int[matrise[0].length][matrise.length];
        for (int i = 0; i < matrise.length; i++) {
            for (int j = 0; j < matrise[i].length; j++) {
                resultat[j][i] = matrise[i][j];
            }
        }
        return resultat;
    }

    // f)
    public static int[][] multipliser(int[][] a, int[][] b) {
        int[][] resultat = new int[a.length][b[0].length];
        if (a[0].length == b.length) {
            for (int i = 0; i < resultat.length; i++) {
                for (int j = 0; j < resultat[i].length; j++) {
                    resultat[i][j] = 0;
                    for (int k = 0; k < a[i].length; k++) {
                        resultat[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
        }
        //else { throw new Exception("Kan ikke multiplisere matriser med forksjellig antall rad og kolonner"); }
        return resultat;
    }
}
