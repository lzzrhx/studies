import java.util.Scanner;
public class OppgaveB1 {
    public static void main(String[] args) {
        System.out.println("* * * OppgaveB1 * * *");
        System.out.println("Analyse av temperaturer");
        System.out.println("- - - - - - - - - - - -");
        System.out.println("Skriv inn temperaturene:");
        final int NUM_DAGER = 7;
        double[] temps = new double[NUM_DAGER];
        double sum = 0.0;
        double max = 0.0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < NUM_DAGER; i++) {
            System.out.print((i+1) + ". dag: ");
            temps[i] = scanner.nextDouble();
            max = temps[i] > max ? temps[i] : max;
            sum += temps[i];
        }
        scanner.close();
        System.out.println();
        System.out.println("Gjennomsnittstemperaturen var " + (sum / NUM_DAGER)  + " grader.");
        System.out.println("Maksimum for denne uken var " + max + " grader.");
    }
}
