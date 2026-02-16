package src;

import java.util.Arrays;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

// Entry-point for programmet
public class Program {
    public static void main(String[] args) {
        oppg6_1();
        oppg6_2();
        oppg6_3();
        oppg7_1();
        oppg7_2();
    }

    // Uke 6, Oppgave 1
    private static void oppg6_1() {
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" UKE 6, OPPGAVE 1");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();

        // Parentes-sjekker klasse
        ParentesSjekker.sjekk("1234567{(((hei hei hei))}", true);
        ParentesSjekker.sjekk("{[{[{[]}]}]}", true);
        ParentesSjekker.sjekk("{[{]}]}", true);
    }

    // Uke 6, Oppgave 2
    private static void oppg6_2() {
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" UKE 6, OPPGAVE 2");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
       
        // 2a)
        System.out.println(" a)");
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.printf("S_n = S_{n-1} + n, S_1 = 1%nS_{100} = %d%nS_{100} gjennomfører %d kall på s(n) funksjonen.%nn = 100 -> 100 funksjonskall.%nDette kan uttrykkes som O(n) i O-notasjon.%n", s(100), sAntKall(100));

        // 2b)
        System.out.println();
        System.out.println(" b)");
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.printf("isPalindrome(\"abba\") = %b%n", isPalindrome("abba"));
        System.out.printf("isPalindrome(\"regninger\") = %b%n", isPalindrome("regninger"));
        System.out.printf("isPalindrome(\"hoyskole\") = %b%n", isPalindrome("hoyskole"));
        System.out.printf("isPalindrome(\"katt\") = %b%n", isPalindrome("katt"));
        System.out.printf("isPalindrome(\"i\") = %b%n", isPalindrome("i"));

        // 2c)
        System.out.println();
        System.out.println(" c)");
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        for (int n = 0; n <= 20; n++ ) {
            System.out.printf("fibonacciRek(%d) = %d (antall kall: %d)%n", n, fibonacciRek(n), fibonacciRekAntKall(n));
        }
        System.out.printf("%nAntall funksjonskall for fibonacci(n) er lik antall kall for fibonacci(n-1) + antall kall for fibonacci(n-2).%nMed andre ord en (nesten) dobbel økning i kjøretid for hver økning av n. I O-notasjon blir dette O(n^2).%n");
        
        // 2d)
        System.out.println();
        System.out.println(" d)");
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        for (int n = 0; n <= 20; n++ ) {
            System.out.printf("fibonacci(%d) = %d (antall interasjoner i løkke: %d)%n", n, fibonacci(n), Math.max(n, 0));
        }
        System.out.printf("%nAntall ganger løkken kjøres er er n-1. I O-notasjon blir dette O(n).%n");
    }

    private static int s(int n) {
        return n == 1 ? 1 : s(n-1) + n;
    }
    
    private static int sAntKall(int n) {
        return n == 1 ? 1 : sAntKall(n-1) + 1;
    }

    private static int fibonacciRek(int n) {
        return n <= 1 ? n : fibonacciRek(n-1) + fibonacciRek(n-2);
    }

    private static int fibonacciRekAntKall(int n) {
        return 1 + ((n == 0 || n == 1) ? 0 : fibonacciRekAntKall(n-1) + fibonacciRekAntKall(n-2));
    }

    private static int fibonacci(int n) {
        int sumOlder = 0;
        int sumOld = 1;
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = sum + sumOlder;
            sumOlder = sumOld;
            sumOld = sum;
        }
        return sum;
    }

    private static boolean isPalindrome(String s) {
        int n = s.length() / 2;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // Uke 6, Oppgave 3
    private static void oppg6_3() {
        System.out.println();
        int sel = 0;
        int window_width = 800;
        int window_height = 600;
        String txt = "<- FORRIGE FIGUR / NESTE FIGUR ->";
        SetTraceLogLevel(4);
        InitWindow(window_width, window_height, "Uke 6, Oppgave 3");
        SetTargetFPS(60);
        while (!WindowShouldClose()) {
            BeginDrawing();
            ClearBackground(DARKGRAY);
            if (IsKeyPressed(KEY_LEFT)) { sel = (sel - 1) < 0 ? 2 : (sel - 1); }
            if (IsKeyPressed(KEY_RIGHT)) { sel = (sel + 1) % 3; }
            switch (sel) {
                case 0:
                    fig0(window_width, window_height, 20, 200, LIGHTGRAY);
                    break;
                case 1:
                    fig1((window_width - 400) / 2, (window_height - 400) / 2, 4, 400, LIGHTGRAY);
                    break;
                case 2:
                    fig2((window_width - 400) / 2, (window_height - 400) / 2, 4, 400, LIGHTGRAY);
                    break;
            }
            String fig_txt = "FIGUR " + (sel+1);
            DrawText(fig_txt, (window_width - MeasureText(fig_txt, 20)) / 2, 40, 20, WHITE);
            DrawText(txt, (window_width - MeasureText(txt, 20)) / 2, window_height - 50, 20, WHITE);
            DrawFPS(2, 2);
            EndDrawing();
        }
        CloseWindow();
        System.out.println();
    }

    private static void fig0(int window_width, int window_height, int level, int size, Color color) {
        DrawRectangleLines((window_width - size) / 2, (window_height - size) / 2, size, size, color);
        if (level > 0) {
            fig0(window_width, window_height, level-1, size + 10, color);
        }
    }
    
    private static void fig1(int x, int y, int level, int size, Color color) {
        DrawRectangleLines(x, y, size, size, color);
        DrawRectangleLines(x, y, size/2, size/2, color);
        DrawRectangleLines(x+size/2, y+size/2, size/2, size/2, color);
        if (level > 0) {
            fig1(x, y, level-1, (int)Math.round(size/2), color);
            fig1(x+size/2, y+size/2, level-1, size/2, color);
        }
    }

    private static void fig2(int x, int y, int level, int size, Color color) {
        DrawTriangleLines(new Vector2().x(x).y(y+size), new Vector2().x(x+size/2).y(y+size), new Vector2().x(x+size/4).y(y+size/2), color);
        DrawTriangleLines(new Vector2().x(x+size/2).y(y+size), new Vector2().x(x+size).y(y+size), new Vector2().x(x+size*3/4).y(y+size/2), color);
        DrawTriangleLines(new Vector2().x(x+size/4).y(y+size/2), new Vector2().x(x+size*3/4).y(y+size/2), new Vector2().x(x+size/2).y(y), color);
        if (level > 0) {
            fig2(x, y+size/2, level-1, size/2, color);
            fig2(x+size/2, y+size/2, level-1, size/2, color);
            fig2(x+size/4, y, level-1, size/2, color);
        }
    }

    // Uke 7, Oppgave 1
    private static void oppg7_1() {
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" UKE 7, OPPGAVE 1");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();

        int n = 80_000;
        int s = 1337;
        Lfsr lfsr = new Lfsr(s);
        Integer[] tab_unsorted = new Integer[n];
        System.out.printf("Lager tabell med %,d tilfeldige heltall (Integer klasse) ved bruk av 32-bit LFSR fra seed-verdi %d.%n", n, s);
        for (int i = 0; i < n; i++) { tab_unsorted[i] = lfsr.make32(); }
        Integer[] tab;
        long start;

        // Insertion (fra soh1961 github)
        tab = Arrays.copyOf(tab_unsorted, n);
        start = System.currentTimeMillis();
        System.out.printf("Kjører insertion sort (fra soh1961 github) på tabellen.");
        Sort.insertion(tab);
        System.out.printf(" Insertion sort gjennomført etter %d ms.%n", System.currentTimeMillis() - start);
        
        // Insertion (modifisert versjon)
        tab = Arrays.copyOf(tab_unsorted, n);
        start = System.currentTimeMillis();
        System.out.printf("Kjører insertion sort (modifisert versjon) på tabellen.");
        Sort.insertion(tab);
        System.out.printf(" Insertion sort gjennomført etter %d ms.%n", System.currentTimeMillis() - start);
    }
    
    // Uke 7, Oppgave 2
    private static void oppg7_2() {
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" UKE 7, OPPGAVE 2");
        System.out.println("--------------------------------------------------------------------------------");
        sort(32_000, true);
        sort(64_000, true);
        sort(128_000, true);
        sort(128_000, false);
    }

    private static void sort(int n, boolean rand) {
        int[] tab_unsorted = new int[n];
        if (rand) {
            int s = 1312;
            Lfsr lfsr = new Lfsr(s);
            System.out.printf("%nLager tabell med %,d tilfeldige heltall ved bruk av 32-bit LFSR fra seed-verdi %d.%n", n, s);
            for (int i = 0; i < n; i++) { tab_unsorted[i] = lfsr.make32(); }
        } else {
            System.out.printf("%nLager tabell med %,d heltall satt til den samme verdien.%n", n);
            for (int i = 0; i < n; i++) { tab_unsorted[i] = 67; }
        }
        int[] tab;
        long start;

        // Bubble - Best: n / Avg: n^2 / Worst: n^2
        tab = Arrays.copyOf(tab_unsorted, n);
        start = System.currentTimeMillis();
        System.out.printf("Kjører bubble sort på tabellen.");
        SortInt.bubble(tab);
        System.out.printf(" Bubble sort gjennomført etter %d ms.%n", System.currentTimeMillis() - start);
        
        // Selection - Best: n^2 / Avg: n^2 / Worst: n^2
        tab = Arrays.copyOf(tab_unsorted, n);
        start = System.currentTimeMillis();
        System.out.printf("Kjører selection sort på tabellen.");
        SortInt.selection(tab);
        System.out.printf(" Selection sort gjennomført etter %d ms.%n", System.currentTimeMillis() - start);

        // Insertion - Best: n / Avg: n^2 / Worst: n^2
        tab = Arrays.copyOf(tab_unsorted, n);
        start = System.currentTimeMillis();
        System.out.printf("Kjører insertion sort på tabellen.");
        SortInt.insertion(tab);
        System.out.printf(" Insertion sort gjennomført etter %d ms.%n", System.currentTimeMillis() - start);

        // Merge - Best: n log n / Avg: n log n / Worst: n log n
        tab = Arrays.copyOf(tab_unsorted, n);
        start = System.currentTimeMillis();
        System.out.printf("Kjører merge sort på tabellen.");
        SortInt.merge(tab);
        System.out.printf(" Merge sort gjennomført etter %d ms.%n", System.currentTimeMillis() - start);
    
        // Heap - Best: n log n / Avg: n log n / Worst: n log n
        tab = Arrays.copyOf(tab_unsorted, n);
        start = System.currentTimeMillis();
        System.out.printf("Kjører heapsort på tabellen.");
        SortInt.heap(tab);
        System.out.printf(" Heapsort gjennomført etter %d ms.%n", System.currentTimeMillis() - start);
        
        // Quick (Hoare) - Best: n log n / Avg: n log n / Worst: n^2
        tab = Arrays.copyOf(tab_unsorted, n);
        start = System.currentTimeMillis();
        System.out.printf("Kjører quicksort (Hoare) på tabellen.");
        SortInt.quick_hoare(tab);
        System.out.printf(" Quicksort gjennomført etter %d ms.%n", System.currentTimeMillis() - start);
        
        // Quick (Dutch national flag) - Best: n log n / Avg: n log n / Worst: n^2
        tab = Arrays.copyOf(tab_unsorted, n);
        start = System.currentTimeMillis();
        System.out.printf("Kjører quicksort (Dutch national flag) på tabellen.");
        SortInt.quick_dutch_flag(tab);
        System.out.printf(" Quicksort gjennomført etter %d ms.%n", System.currentTimeMillis() - start);

        // Shell (Shellsortering)
        tab = Arrays.copyOf(tab_unsorted, n);
        start = System.currentTimeMillis();
        System.out.printf("Kjører shellsort (Ciura) på tabellen.");
        SortInt.shell(tab);
        System.out.printf(" Shellsort gjennomført etter %d ms.%n", System.currentTimeMillis() - start);
        
        // Shell (Shellsortering)
        tab = Arrays.copyOf(tab_unsorted, n);
        start = System.currentTimeMillis();
        System.out.printf("Kjører shellsort (Rhoads) på tabellen.");
        SortInt.shell(tab, 1);
        System.out.printf(" Shellsort gjennomført etter %d ms.%n", System.currentTimeMillis() - start);

        // Counting - Best: - / Avg: n+r / Worst: n+r
        tab = Arrays.copyOf(tab_unsorted, n);
        start = System.currentTimeMillis();
        System.out.printf("Kjører counting sort på tabellen.");
        SortInt.counting(tab);
        System.out.printf(" Counting sort gjennomført etter %d ms.%n", System.currentTimeMillis() - start);
    }
}
