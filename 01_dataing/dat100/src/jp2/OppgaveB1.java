import java.util.Scanner;

public class OppgaveB1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("År: ");
        int a = in.nextInt();
        System.out.print("Måned (0-12): ");
        int m = in.nextInt();
        System.out.print("Dag (0-31): ");
        int d = in.nextInt();
        in.close();
        System.out.println("Dato: " + d + "." + m + "." + a);
    }
}
