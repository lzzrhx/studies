import java.util.Scanner;

public class OppgaveB1B2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" Beregn volum av en sylinder:  ");
        System.out.println(" - - - - - - - - - - - - - - - ");
        System.out.print("Radius = ");
        double r = in.nextDouble();
        System.out.print("Høyde = ");
        double h = in.nextDouble();
        System.out.println("Volum = " + sylinderVolum(r, h));
        in.close();
    }

    private static double sylinderVolum(double r, double h) {
        return Math.PI * r * r * h;
    }
}
