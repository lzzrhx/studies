package src;

public class Soking<T> {
    
    public static <T> boolean sokUsortertTabell(T[] tabell, T element) {
        for (int i = 0; i < tabell.length; i++) {
            if (tabell[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean sokUsortertLenke(Node<T> start, T element) {
        Node<T> node = start;
        while (node != null) {
            if ((node.data).equals(element)) {
                return true;
            }
            node = node.neste;
        }
        return false;
    }

    public static <T extends Comparable<T>> boolean sekvensieltSokSortertTabell(T[] tab, T element) {
        for (int i = 0; i < tab.length; i++) {
            if (tab[i].compareTo(element) >= 0) {
                return tab[i].equals(element);
            }
        }
        return false;
    }

    private static <T extends Comparable<T>> boolean binaertSokRekursiv(T[] tab, T elem, int v, int h) {
        int m = (v+h)/2;
        int comp = elem.compareTo(tab[m]);
        if (comp == 0) {
            return true;
        } else if (v > h) {
            return false;
        }
        return binaertSokRekursiv(tab, elem, comp < 0 ? v : m+1, comp < 0 ? m-1 : h);
    }

    private static <T extends Comparable<T>> boolean binaertSokIterativ(T[] tab, T elem) {
        int v = 0;
        int h = tab.length-1;
        while (v <= h) {
            int m = (v+h)/2;
            // TODO: ... 
        }
        return false;
    }

}
