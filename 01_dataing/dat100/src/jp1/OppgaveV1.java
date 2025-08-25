import java.util.Scanner;

public class OppgaveV1 {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("ERR! Feil antall argumenter (" + args.length + "). 2 argumenter forventet.");
            System.out.println("Kjør programmet med kommandoen: java OppgaveV1 <radius> <høyde>");
        } else {
            double r = Double.parseDouble(args[0]);
            double h = Double.parseDouble(args[1]);
            System.out.println(" Beregn volum av en sylinder:  ");
            System.out.println(" - - - - - - - - - - - - - - - ");
            System.out.println("Radius = " + r);
            System.out.println("Høyde = " + h);
            System.out.println("Volum = " + sylinderVolum(r, h));
        }
    }

    private static double sylinderVolum(double r, double h) {
        return Math.PI * r * r * h;
    }
}
