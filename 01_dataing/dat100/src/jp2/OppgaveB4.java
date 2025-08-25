import java.util.Scanner;

public class OppgaveB4 {
    public static void main(String args[]) {
        
        Scanner in = new Scanner(System.in);
        System.out.print("Pris: ");
        int pris = in.nextInt();
        System.out.print("Beløp: ");
        int belop = in.nextInt();
        in.close();

        int total = belop - pris; 
        int tiere = total / 10;
        int enere = total % 10;

        System.out.println("Vekslepenger: " + tiere + " tiere og " + enere + " enere.");

    }
}
