import java.util.ArrayList;

public class Konto {
    private static ArrayList<Konto> kontoer = new ArrayList<Konto>();
    private static int num = 0;

    int nr;
    double saldo = 0.0;

    Konto() {
        Konto.num++;
        this.nr = Konto.num;
        kontoer.add(this);
        System.out.println("Ny konto opprettet.");
        print();
    }

    public static double saldoAll() {
        double sum = 0.0;
        for (Konto konto : kontoer) {
            sum += konto.saldo;
        }
        return sum;
    }

    public void print() {
        System.out.println(toString());
    }

    public String toString() {
        return "Kontonr: " + nr + "\n" + "Saldo: " + saldo + " kr";
    }

    public double saldo() {
        return saldo;
    }

    public void innskudd(double belop) {
        saldo += belop;
        System.out.println("Innskudd på " + belop + " kr gjennomført.");
        System.out.println("Ny saldo for konto " + nr + " er: " + saldo + " kr.");
    }

    public void uttak(double belop) {
        saldo -= belop;
        System.out.println("Uttak på " + belop + " kr gjennomført.");
        System.out.println("Ny saldo for konto " + nr + " er: " + saldo + " kr.");
    }

}
