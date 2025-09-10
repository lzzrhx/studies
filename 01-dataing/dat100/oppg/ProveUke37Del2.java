import java.util.Scanner;

public class ProveUke37Del2 {
    public static void main(String[] args) {
        oppg1a(33);
        oppg1b(4);
        oppg1c(55);
        oppg2();
        oppg3();
        oppg4b(66, -3, 588);
        oppg5b(1.5);
    }

    private static void oppg1a(int a){
        System.out.println("Verdien er " + (a == 0 ? "lik" : a < 0 ? "mindre enn" : "større enn") + " 0.");
    }

    private static void oppg1b(int a) {
        System.out.println(a + " er " + (5 <= a && a <= 8 ? "innenfor" : "utenfor") + " intervallet.");
    }

    private static void oppg1c(int n) {
        String svar = switch (n) {
            case 0 -> "null";
            case 1 -> "en";
            case 2 -> "to";
            case 3 -> "tre";
            case 4 -> "fire";
            default -> "ulovlig verdi";
        };
    }

    private static void oppg2() {
        for(int i = 2; i <= 6; i++) {
            System.out.println("10 / " + i + " = " + (10 / i));
        }
    }

    private static void oppg3() {
        Scanner inn = new Scanner(System.in);
        int sum = 0;
        int antall = 0;
        int tall = 0;
        do {
            System.out.println("Skriv inn heltall (avslutt med 0):");
            tall = inn.nextInt();
            sum += tall;
            if (tall != 0) { antall++; }
        } while (tall != 0);
        System.out.println("Antall tall: " + antall);
        System.out.println("Sum: " + sum);
        inn.close();
    }

    private static int oppg4a(int a, int b, int c) {
        return min(a, min(b, c));
    }

    private static int min(int a, int b) {
        return b < a ? b : a;
    }

    private static void oppg4b(int a, int b, int c){
        System.out.println("Det minste tallet av " + a + ", " + b + " og " + c + " er " + oppg4a(a, b, c) + ".");
    }

    private static double oppg5a(double r) {
        return Math.PI * r * r;
    }

    private static void oppg5b(double r) {
        System.out.println("Arealet av en sirkel med radius " + r + " er " + oppg5a(r) + ".");
    }

}
