package no.hvl.dat100.tabeller;

public class Tabeller {

    // a)
    public static void skrivUt(int[] tabell) {
        System.out.println(tilStreng(tabell));
    }

    // b)
    public static String tilStreng(int[] tabell) {
        String result = "[";
        for (int i = 0; i < tabell.length; i++) {
            result += i > 0 ? "," + tabell[i] : tabell[i];
        }
        return result + "]";
    }

    // c)
    public static int summer(int[] tabell) {
        int result = 0;
        for (int i = 0; i < tabell.length; i++) {
            result += tabell[i];
        }
        return result;
    }

    // d)
    public static boolean finnesTall(int[] tabell, int tall) {
        for (int i = 0; i < tabell.length; i++) {
            if (tabell[i] == tall) {
                return true;
            }
        }
        return false;
    }

    // e)
    public static int posisjonTall(int[] tabell, int tall) {
        for (int i = 0; i < tabell.length; i++) {
            if (tabell[i] == tall) {
                return i;
            }
        }
        return -1;
    }

    // f)
    public static int[] reverser(int[] tabell) {
        int[] result = new int[tabell.length];
        for (int i = 0; i < tabell.length; i++) {
            result[tabell.length - 1 - i] = tabell[i];
        }
        return result;
    }

    // g)
    public static boolean erSortert(int[] tabell) {
        for (int i = 0; i < tabell.length; i++) {
            if (i > 0 && tabell[i] < tabell[i-1]) {
                return false;
            }
        }
        return true;
    }

    // h)
    public static int[] settSammen(int[] tabell1, int[] tabell2) {
        int[] result = new int[tabell1.length + tabell2.length];
        for (int i = 0; i < result.length; i++) {
            if (i < tabell1.length) {
                result[i] = tabell1[i];
            } else {
                result[i] = tabell2[i - tabell1.length];
            }
        }
        return result;
    }
}
