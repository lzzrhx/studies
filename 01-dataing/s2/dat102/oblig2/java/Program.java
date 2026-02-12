public class Program {
    public static void main(String[] args) {
        oppg1();
        oppg2();
        oppg3();
    }

    // Oppgave 1
    private static void oppg1() {
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" OPPGAVE 1");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();

        // Stack klasse
        System.out.println(" TEST AV STACK KLASSE");
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        StackADT<Integer> stack = new Stack<>(true);
        for (int i = 0; i < 20; i++) { stack.push(i); }
        System.out.println("Peek: " + stack.peek());
        for (int i = 0; i < 25; i++) { stack.pop(); }
        System.out.println("Peek: " + stack.peek());
        System.out.println();

        // Parentes-sjekker klasse
        String parentesString1 = "1234567(((hei hei hei))";
        String parentesString2 = "{ [ () ] }";
        String parentesString3 = "{ [ () }";
        String parentesString4 = "[ ( ) ] }";
        String parentesString5 = "{ [ ( ] ) }";
        String parentesString6 = """
            class HelloWorld {
                public static void main(String[] args) {
                System.out.println("Hello World!");
                }
            }""";
        ParentesSjekker.sjekk(parentesString1);
        ParentesSjekker.sjekk(parentesString2);
        ParentesSjekker.sjekk(parentesString3);
        ParentesSjekker.sjekk(parentesString4);
        ParentesSjekker.sjekk(parentesString5);
        ParentesSjekker.sjekk(parentesString6);
    }

    // Oppgave 2
    private static void oppg2() {
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" OPPGAVE 2");
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

    // Oppgave 3
    private static void oppg3() {
    }
}
