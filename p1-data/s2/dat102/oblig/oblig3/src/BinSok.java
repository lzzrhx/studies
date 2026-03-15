package src;

public class BinSok {
    // Rekursivt binærsøk
    public static <T extends Comparable<T>> int rekursivt(T[] tab, T elem) { return rekursivt(tab, elem, 0, tab.length-1); }
    private static <T extends Comparable<T>> int rekursivt(T[] tab, T elem, int v, int h) {
        // Basistilfelle der ingen resultat funnet etter å ha søkt gjennom hele tabellen
        if (v > h) { return 0;  }
        // Oprett indeks m i midten av venstre og høyre indeks
        int m = (v+h) / 2;
        // Sammenlign elementet ved indeks m med elementet som det søkes etter
        int comp = elem.compareTo(tab[m]);
        // Hvis elementet er funnet returner 1 + antall naboelementer med samme verdi
        if (comp == 0) { return 1 + antLikeNaboElementer(tab, m); }
        // Hvis elementet som søkes etter er lavere enn midterste element settes høyre indeks til m-1 for å søke i venstre del av tabellen ved neste metodekall
        if (comp < 0) { h = m-1; }
        // Hvis elementet som søkes etter er høyere enn midterste element settes venstre indeks til m+1 for å søke i høyre del av tabellen ved neste metodekall
        else { v = m+1; }
        // Hvis elementet som søkes etter enda ikke er funnet fortsetter søket med rekursivt metodekall
        return rekursivt(tab, elem, v, h);
    }

    // Iterativt binærsøk
    public static <T extends Comparable<T>> int iterativt(T[] tab, T elem) { return iterativt(tab, elem, 0, tab.length - 1); }
    private static <T extends Comparable<T>> int iterativt(T[] tab, T elem, int v, int h) {
        // Variablene m og comp deklareres før løkken slik at samme variabler kan gjenbrukes i alle iterasjon for å minske kjøretid
        int m, comp;
        // Avbryt søk hvis venstre indeks er høyere enn høyre indeks (ugyldig)
        while (v <= h) {
            // Sett indeks m til midten av venstre og høyre indeks
            m = (v+h) / 2;
            // Sammenlign elementet ved indeks m med elementet som det søkes etter
            comp = elem.compareTo(tab[m]);
            // Hvis elementet er funnet returner 1 + antall naboelementer med samme verdi
            if (comp == 0) { return 1 + antLikeNaboElementer(tab, m); }
            // Hvis elementet som søkes etter er lavere enn midterste element settes høyre indeks til m-1 for å søke i venstre del av tabellen i neste iterasjon
            if (comp < 0) { h = m-1; } 
            // Hvis elementet som søkes etter er høyere enn midterste element settes venstre indeks til m+1 for å søke i høyre del av tabellen i neste iterasjon
            else { v= m+1; }
        }
        return 0;
    }

    // Tell antall naboelementer med lik verdi som ved gitt indeks
    public static <T> int antLikeNaboElementer(T[] tab, int pos) {
        int i;
        int n = 0;
        // Tell antall like naboelementer i tabellen til venstre for gitt indeks
        for (i = pos; i > 0 && tab[i-1].equals(tab[pos]); n++, i--);
        // Tell antall like naboelementer i tabellen til høyre for gitt indeks
        for (i = pos; i < tab.length-1 && tab[i+1].equals(tab[pos]); n++, i++);
        return n;
    }
}
