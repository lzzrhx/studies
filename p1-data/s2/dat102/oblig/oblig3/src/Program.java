package src;

import java.util.Set;
import java.util.HashSet;
import java.util.Locale;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMANY); // For formatering av tall i printf(...)
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" DAT102 - OBLIGATORISK OPPGAVE 3");
        System.out.println("--------------------------------------------------------------------------------");
        uke10oppg4f();
        uke11oppg4();
    }

    // Uke 10 - Opggave 4f
    private static void uke10oppg4f() {
        System.out.println();
        System.out.println("Uke 10 - Oppgave 4f");
        System.out.println(" - - - - - - - - - ");
        Person a = new Person("a", "basketball", "yoga", "sykling");
        Person b = new Person("b", "yoga", "dataspill");
        Person c = new Person("c", "sykling", "basketball");
        float abMatch = Person.match(a, b);
        float acMatch = Person.match(a, c);
        float bcMatch = Person.match(b, c);
        System.out.printf("Person.match(a, b) = %.2f%n", abMatch);
        System.out.printf("Person.match(a, c) = %.2f%n", acMatch);
        System.out.printf("Person.match(b, c) = %.2f%n", bcMatch);
        System.out.printf("Person a og Person c har best match.%n");
    }

    // Uke 11 - Oppgave 4
    private static void uke11oppg4() {
        System.out.println();
        System.out.println("Uke 11 - Oppgave 4");
        System.out.println(" - - - - - - - - - ");
       
        // Variabler
        int n  = 100_000;
        int n2 = 10_000;
        int d  = 999_999;
        long start;

        // Oppsett av tabell og mengde med tilfeldige tall
        System.out.printf("Deklarerer mengden \"Set<Integer> set = HashSet<Integer>(%d)\" og tabellen \"Integer[] tab = new Integer[%d]\"%n", n, n);
        Lfsr lfsr = new Lfsr(1312);
        Integer[] tab = new Integer[n];
        Set<Integer> set = new HashSet<Integer>(n);
        System.out.printf("Fyller mengden og tabellen med %,d heltal av tilfeldig verdi mellom 0 og %,d%n", n, d);
        for (int i = 0; i < n; i++) {
            tab[i] = lfsr.make32(true, d);
            while (!set.add(lfsr.make32(true, d)));
        }
        System.out.printf("Tabell med %,d elementer og mengde med %,d elementer ble generert.%n", tab.length, set.size());
        
        // Oppsett av tabell med tall som skal søkes etter
        System.out.println();
        System.out.printf("Genererer ny tabell \"Integer[] tall = new Integer[%d]\" med %,d heltall av tilfeldig verdi mellom 0 og %,d.%n", n2, n2, d);
        Integer[] tall = new Integer[n2];
        lfsr.seed(6969);
        for (int i = 0; i < n2; i++) { tall[i] = lfsr.make32(true, d); }
        System.out.printf("Tabell med %,d elementer ble generert.%n", tall.length);
        
        // Sorter tabellen
        System.out.println();
        System.out.printf("Sorterer Integer tabellen \"tab\".%n");
        Arrays.sort(tab);
        System.out.printf("Sortering gjennomført.%n");
        
        // Søk i HashSet etter tall
        System.out.println();
        System.out.printf("Søker i HashSet mengden \"set\" etter alle tallene fra tabellen \"tall\".%n");
        int[] antSet = new int[n2];
        start = System.currentTimeMillis();
        for (int i = 0; i < n2; i++) { antSet[i] = set.contains(tall[i]) ? 1 : 0; }
        System.out.printf("Søk gjennomført etter %d ms.%n", System.currentTimeMillis() - start);
        
        // Søk i tabell etter tall (rekursivt)
        System.out.println();
        System.out.printf("Søker med rekursivt binærsøk i Integer tabellen \"tab\" etter alle tallene fra tabellen \"tall\".%n");
        int[] antTabBin = new int[n2];
        start = System.currentTimeMillis();
        for (int i = 0; i < n2; i++) { antTabBin[i] = BinSok.rekursivt(tab, tall[i]); }
        System.out.printf("Søk gjennomført etter %d ms.%n", System.currentTimeMillis() - start);
        
        // Søk i tabell etter tall (iterativt)
        System.out.println();
        System.out.printf("Søker med iterativt binærsøk i Integer tabellen \"tab\" etter alle tallene fra tabellen \"tall\".%n");
        int[] antTabIt = new int[n2];
        start = System.currentTimeMillis();
        for (int i = 0; i < n2; i++) { antTabIt[i] = BinSok.iterativt(tab, tall[i]); }
        System.out.printf("Søk gjennomført etter %d ms.%n", System.currentTimeMillis() - start);
    }


}
