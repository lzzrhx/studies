public class Program {
    public static void main(String[] args) {
        int[] nTab = new int[] { 10, 100, 1_000, 10_000, 100_000}; 
        long[] i64nTab = new long[] { 10_000_000, 100_000_000, 1_000_000_000};
        System.out.println();

        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println(" OPPGAVE 3 ");
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - ");
        
        // Oppgave 3b)
        System.out.println();
        System.out.println("Oppgave 3b:");
        for (int n : nTab) {
            print(n,oppg3b(n));
        }
        
        // Oppgave 3c)
        System.out.println();
        System.out.println("Oppgave 3c:");
        for (int n : nTab) {
            print(n,oppg3c(n));
        }
        
        // Oppgave 3e)
        System.out.println();
        System.out.println("Oppgave 3e:");
        for (int n : nTab) {
            print(n,oppg3e(n));
        }
        
        // Oppgave 3g)
        System.out.println();
        System.out.println("Oppgave 3g:");
        for (long n : i64nTab) {
            //print(n,oppg3g(20, n));
            int ant = 20;
            long res = 0L;
            for (int i = 0; i < ant; i++) {
                long start = System.currentTimeMillis();
                long k = 0;
                for (long j = 1; j <= n; j++) {
                    k = k + 5;
                }
                res += System.currentTimeMillis() - start;
            }
            System.out.printf("n = %d  -->  %.1f ms%n", n, (double)res / (double)ant);
        }
        
        System.out.println();
    }

    private static void print(long n, double ms) {
        System.out.printf("n = %d  -->  %.1f ms%n", n, ms);
    }
    
    private static void print(int n, int c) {
        System.out.printf("n = %d  -->  %d%n", n, c);
    }

    private static int oppg3b(int n) {
        int c = 2;                        // c brukes for å telle antall tilordninger
        int sum = 0;                      // c += 1
        for (int i = n; i > 1; i = i/2) { // c += 1
            sum = sum + i;
            c += 2;                       // c += 2 for hver iterasjon av løkken ("i = i/2" & "sum = sum + i")
        }
        return c;
    }

    private static int oppg3c(int n) {
        int c = 0;                               // c brukes for å telle antall tilordninger
        int sum = 0;                             // c += 1
        for (int i = 1; i <= n; i++) {           // c += 1
            c += 2;                              // c += 2 for hver iterasjon av ytre løkke ("i++" & "int j = 1")
            for (int j = 1; j <= n; j = j * 2) {
                sum += i * j;
                c += 2;                          // c += 2 for hver iterasjon av indre løkke ("j = j * 2" & "sum += i * j")
            }
        }
        return c;
    }

    private static int oppg3e(int n) {
        int[] tab = new int[n];
        for (int i = 0; i < n; i++) {
            tab[i] = i;
        }
        // boolean harDuplikat( ... )
        // v = indeks for venstre tall i sammenligning
        // h = indeks for høyre tall i sammenligning
        // if (tab[v] == tab[h]) return true
        int c = 0; // c brukes for å telle antall sammenligninger
        for (int v = 0; v <= n - 2; v++) {
            for (int h = v + 1; h <= n - 1; h++) {
                c++; // c += 1
                if (tab[v] == tab[h]) {
                    return c; // return true her (to like tall funnet)
                }
            }
        }
        return c; // return false her (ingen like tall funnet)
    }

    private static double oppg3g(int ant, long n) {
        long res = 0L;
        for (int i = 0; i < ant; i++) {
            long start = System.currentTimeMillis();
            long k = 0;
            for (long j = 1; j <= n; j++) {
                k = k + 5;
            }
            res += System.currentTimeMillis() - start;
        }
        return (double)res / (double)ant;
    }
}
