import java.util.Scanner;

public class OppgaveV1 {
    public static void main(String args[]) {
        
        // Les inn tre heltall fra brukeren
        Scanner in = new Scanner(System.in);
        System.out.println("Skriv inn tre heltall.");
        int[] tall = new int[3];
        System.out.print("1: ");
        tall[0] = in.nextInt();
        System.out.print("2: ");
        tall[1] = in.nextInt();
        System.out.print("3: ");
        tall[2] = in.nextInt();
        in.close();

        sorterIf(tall);
        sorterIfElse(tall);

    }

    // Sorter tallene med if-setninger
    private static void sorterIf(int[] t) {
        int[] r = new int[3];

        // Minste tall
        if (t[0] <= t[1] && t[0] <= t[2]) { r[0] = t[0]; }
        if (t[1] <= t[0] && t[1] <= t[2]) { r[0] = t[1]; }
        if (t[2] <= t[0] && t[2] <= t[1]) { r[0] = t[2]; }

        // Mellomste tall
        if ((t[0] <= t[1] && t[0] >= t[2]) || (t[0] >= t[1] && t[0] <= t[2])) { r[1] = t[0]; }
        if ((t[1] <= t[0] && t[1] >= t[2]) || (t[1] >= t[0] && t[1] <= t[2])) { r[1] = t[1]; }
        if ((t[2] <= t[0] && t[2] >= t[1]) || (t[2] >= t[0] && t[2] <= t[1])) { r[1] = t[2]; }

        // Største tall
        if (t[0] >= t[1] && t[0] >= t[2]) { r[2] = t[0]; }
        if (t[1] >= t[0] && t[1] >= t[2]) { r[2] = t[1]; }
        if (t[2] >= t[0] && t[2] >= t[1]) { r[2] = t[2]; }

        // Skriv ut resultat
        System.out.println("(#1) Tallene i sortert rekkefølge: " + r[0] + ", " + r[1] + ", " + r[2]);
    }
    
    // Sorter tallene med if-then-else setninger
    private static void sorterIfElse(int[] t) {
        int[] r = new int[3];

        // Minste tall
        if (t[0] <= t[1] && t[0] <= t[2]) { r[0] = t[0]; }
        else if (t[1] <= t[0] && t[1] <= t[2]) { r[0] = t[1]; }
        else { r[0] = t[2]; }

        // Mellomste tall
        if ((t[0] <= t[1] && t[0] >= t[2]) || (t[0] >= t[1] && t[0] <= t[2])) { r[1] = t[0]; }
        else if ((t[1] <= t[0] && t[1] >= t[2]) || (t[1] >= t[0] && t[1] <= t[2])) { r[1] = t[1]; }
        else { r[1] = t[2]; }

        // Største tall
        if (t[0] >= t[1] && t[0] >= t[2]) { r[2] = t[0]; }
        else if (t[1] >= t[0] && t[1] >= t[2]) { r[2] = t[1]; }
        else { r[2] = t[2]; }

        // Skriv ut resultat
        System.out.println("(#2) Tallene i sortert rekkefølge: " + r[0] + ", " + r[1] + ", " + r[2]);
    }
}
